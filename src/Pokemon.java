public abstract class Pokemon {

	private String name;
	private String nickname;
	private int height;
	private double weight;
	private final Type type;
	private final Nature nature;
	private int level;

	private int[] baseStats;
	private final int[] IVs;
	private final int[] EVs;
	private int[] stats;
	private int currentHP;

	private Move move1;
	private Move move2;

	public Pokemon(final String name, final String nickname, final int height, final double weight, final Type type, final int level, final int[] baseStats, final Move move1, final Move move2) {
		this.name = name;
		this.nickname = nickname;
		this.height = height;
		this.weight = weight;
		this.type = type;
		this.nature = Const.NATURES[Const.rand.nextInt(20)];
		this.level = level;

		this.baseStats = baseStats;
		IVs = new int[6];
		EVs = new int[] {0, 0, 0, 0, 0, 0};
		for (int stat = 0; stat < 6; stat++) {
			IVs[stat] = Const.rand.nextInt(32);
		}
		stats = calculateTotalStats();
		currentHP = stats[Const.HP];

		this.move1 = move1;
		this.move2 = move2;
	}

	public final String getName() {
		return name;
	}

	public final String getNickname() {
		return nickname;
	}

	public final int getLevel() {
		return level;
	}

	public final int getEV(int stat) {
		return EVs[stat];
	}

	public final int totalEVs() {
		int total = 0;
		for (final int EV : EVs) {
			total += EV;
		}

		return total;
	}

	public final void rename(String newName) {
		System.out.println(nickname + " is now named " + newName + "!");
		nickname = newName;
	}

	public final void increaseEV(int stat, int amount) {
		EVs[stat] += amount;
	}

	public final void restoreHP() {
		currentHP = stats[Const.HP];
	}

	public final String showHP() {
		return currentHP + " / " + stats[Const.HP];
	}

	public final void displayTotalStats() {
		System.out.println("HP:\t " + showHP());
		System.out.println("Attack:\t " + stats[Const.ATK]);
		System.out.println("Defense:\t " + stats[Const.DEF]);
		System.out.println("Sp. Atk:\t " + stats[Const.SPD]);
		System.out.println("Sp. Def:\t " + stats[Const.SPA]);
		System.out.println("Speed:\t " + stats[Const.SPE]);
	}

	public final void displayIncStats(int[] prevStats) {
		System.out.println("HP:\t +" + (stats[Const.HP] - prevStats[Const.HP]) + " => " + stats[Const.HP]);
		System.out.println("Attack:\t +" + (stats[Const.ATK] - prevStats[Const.ATK]) + " => " + stats[Const.ATK]);
		System.out.println("Defense:\t +" + (stats[Const.DEF] - prevStats[Const.DEF]) + " => " + stats[Const.DEF]);
		System.out.println("Sp. Atk:\t +" + (stats[Const.SPD] - prevStats[Const.SPD]) + " => " + stats[Const.SPD]);
		System.out.println("Sp. Def:\t +" + (stats[Const.SPA] - prevStats[Const.SPA]) + " => " + stats[Const.SPA]);
		System.out.println("Speed:\t +" + (stats[Const.SPE] - prevStats[Const.SPE] + " => " + stats[Const.SPE]));
	}

	public final void displayAllInfo() {
		System.out.println(this);
		System.out.println("Height: " + height / 12 + "' " + height % 12 + "\"");
		System.out.println("Weight: " + weight + " lbs");
		System.out.println("Nature: " + nature.getName());
		System.out.println();
		displayTotalStats();
	}

	public final void levelUp() {
		level++;

		int[] prevStats = stats.clone();
		stats = calculateTotalStats();

		System.out.println(nickname + " grew to level " + level + "!");
		System.out.println();
		displayIncStats(prevStats);
	}

	public final void evolve(final String name, final int height, final double weight, final int[] baseStats, final Move move1, final Move move2) {
		System.out.println("Congratulations! " + this.nickname + " evolved into " + name + "!");

		this.name = name;
		this.height = height;
		this.weight = weight;
		this.baseStats = baseStats;
		this.move1 = move1;
		this.move2 = move2;
	}

	private int[] calculateTotalStats() {
		int[] totalStats = new int[6];

		for (int stat = 0; stat < totalStats.length; stat++) {
			int base = (int) Math.floor(((2 * baseStats[stat] + IVs[stat] + Math.floor(EVs[stat] / 4.0)) * level) / 100.0);

			if (stat == Const.HP) {
				totalStats[stat] = base + level + 5;
			}
			else {
				double natureMultiplier;
				if (stat == nature.getIncStat()) {
					natureMultiplier = 1.1;
				}
				else if (stat == nature.getDecStat()) {
					natureMultiplier = 0.9;
				}
				else {
					natureMultiplier = 1;
				}

				totalStats[stat] = (int) Math.floor((base + 5) * natureMultiplier);
			}
		}

		return totalStats;
	}

	private final void attack(final Pokemon opponent, final int moveNum) {
		final Move move = (moveNum == 0 ? move1 : move2);

		if (Math.random() > move.getAccuracy()) {
			System.out.println(nickname + " missed!");
		}
		else {
			final double randomFactor = ((Const.rand.nextInt(16) + 85) / 100.0);
			final double STAB = (move.getType() == type) ? 1.5 : 1;
			final double modifier = randomFactor * STAB * move.getType().effectiveness(opponent.type);

			final int attack = (move.getCategory() == Const.PHYSICAL) ? Const.ATK : Const.SPA;
			final int defense = (move.getCategory() == Const.PHYSICAL) ? Const.DEF : Const.SPD;

			final int damage = (int) Math.floor(((((((2 * level) / 5.0) + 2) * move.getPower() * ((double) stats[attack] / opponent.stats[defense])) + 2) / 50) * modifier);

			System.out.println(nickname + " used " + move.getName() + "! [" + damage + " damage]");
			opponent.currentHP -= damage;

			if (move.getType().effectiveness(opponent.type) == 0.5) {
				System.out.println("It's not very effective...");
			}
			else if (move.getType().effectiveness(opponent.type) == 2) {
				System.out.println("It's super effective!");
			}
		}
	}

	public final static int battle(Pokemon you, Pokemon opponent) {
		int turn = 1;
		int escapes = 0;

		int won = 0;

		battle: while (true) {
			System.out.println();
			System.out.println("—————————— TURN " + turn + " ——————————");
			System.out.println();
			System.out.println(you.nickname + " Lv" + you.level + " [HP " + you.showHP() + "]");
			System.out.println(opponent.nickname + " Lv" + opponent.level + " [HP " + opponent.showHP() + "]");
			System.out.println();
			System.out.println("What will " + you.nickname + " do?");
			System.out.println("1: " + you.move1.getName());
			System.out.println("2: " + you.move2.getName());
			System.out.println("3: Run");

			int moveNum = 0;
			boolean run = false;

			loop: while (true) {
				final String choice = Const.scan.nextLine();
				System.out.println();

				switch (choice) {
					case "1":
						moveNum = 0;
						break loop;
					case "2":
						moveNum = 1;
						break loop;
					case "3":
						int chance = (int) Math.floor(((double) (you.stats[Const.SPE] * 128) / opponent.stats[Const.SPE]) + 30 * escapes) % 256;
						if (Const.rand.nextInt(256) < chance) {
							System.out.println(you.nickname + " ran away!");
							won = 2;
							break battle;
						}
						else {
							System.out.println(you.nickname + " couldn't escape!");
							System.out.println();
							escapes++;
							run = true;
							break loop;
						}
					default:
						System.out.println("Please choose 1–3: ");
					}
			}

			if (run) {
				opponent.attack(you, Const.rand.nextInt(2));
				if (you.currentHP <= 0) {
					you.currentHP = 0;
					break battle;
				}
			}
			else {
				final boolean priority;
				if (you.stats[Const.SPE] > opponent.stats[Const.SPE]) {
					priority = true;
				}
				else if (opponent.stats[Const.SPE] > you.stats[Const.SPE]) {
					priority = false;
				}
				else {
					priority = (Math.random() < 0.5 ? true : false);
				}

				if (priority) {
					you.attack(opponent, moveNum);
					if (opponent.currentHP <= 0) {
						won = 1;
						break battle;
					}

					System.out.println();

					opponent.attack(you, Const.rand.nextInt(2));
					if (you.currentHP <= 0) {
						you.currentHP = 0;
						break battle;
					}
				}
				else {
					opponent.attack(you, Const.rand.nextInt(2));
					if (you.currentHP <= 0) {
						you.currentHP = 0;
						break battle;
					}

					System.out.println();

					you.attack(opponent, moveNum);
					if (opponent.currentHP <= 0) {
						won = 1;
						break battle;
					}
				}
			}

			turn++;
		}

		return won;
	}

}