public abstract class Domesticated extends Pokemon {

	private double experience;
	private int hunger;

	public Domesticated(final String name, final String nickname, final int height, final double weight, final Type type, final int level, final int[] baseStats, final Move move1, final Move move2) {
		super(name, nickname, height, weight, type, level, baseStats, move1, move2);
		experience = experienceAtLevel(getLevel());
		hunger = 0;
	}

	public final double getExperience() {
		return experience;
	}

	public final double experienceAtLevel(final int level) {
		return 1.2 * Math.pow(level, 3) - 15*Math.pow(level, 2) + 100 * level - 140;
	}

	public final void feed() {
		hunger = 0;
	}

	public void train(Wild opponent) {
		System.out.println("A wild " + opponent.getName() + " appeared!");
		int won = Pokemon.battle(this, opponent);

		opponent.restoreHP();

		if (won != 2) {
			System.out.println();
		}

		if (won == 1) {
			System.out.println(getNickname() + " won!");

			int XPGain = (int) Math.floor((opponent.getBaseXP() * opponent.getLevel()) / 7.0);
			experience += XPGain;
			System.out.print(getNickname() + " gained " + XPGain + " experience points!");

			int stat = opponent.getEVType();
			int inc = opponent.getEV();
			if (totalEVs() < 510 + inc && getEV(stat) < 255 + inc) {
				increaseEV(stat, inc);
			}

			if (leveledUp()) {
				System.out.println();
				System.out.println();
				levelTick();
			}
			else {
				System.out.println(" [" + (int) (experienceAtLevel(getLevel() + 1) - experience) + " until level " + (getLevel() + 1) + "]");
			}
		}
		else if (won == 0) {
			System.out.println(getNickname() + " fainted...");
			System.out.println();
			System.out.println(getNickname() + " was rushed to the Pokecenter and is all better now!");
			restoreHP();
		}
	}

	public void practice(Domesticated opponent) {
		int won = Pokemon.battle(this, opponent);

		restoreHP();
		opponent.restoreHP();

		if (won != 2) {
			System.out.println();
		}

		if (won == 1) {
			System.out.println(getNickname() + " won!");
		}
		else if (won == 0) {
			System.out.println(getNickname() + " lost. Try again next time!");
		}
	}

	public final void tick() {
		hunger += Const.rand.nextInt(6);
		if (hunger >= 50 && hunger < 75) {
			System.out.println();
			System.out.println(getNickname() + " is getting hungry.");
		}
		else if (hunger >= 75 && hunger < 100) {
			System.out.println();
			System.out.println(getNickname() + " is very hungry.");
		}
		else if (hunger >= 100) {
			System.out.println();
			System.out.println("\n"+getNickname() + " fainted due to hunger!");
			System.out.println();
			System.out.println(getNickname() + " was rushed to the Pokecenter and is all better now! Please remember to feed your Pokemon!");
			hunger = 0;
		}
	}

	public boolean leveledUp() {
		return (getExperience() >= experienceAtLevel(getLevel() + 1)) && (getLevel() < 100);
	}

	public abstract void levelTick();

	public final String toString() {
		return getNickname() + "  (" + getName() + ") Lv" + getLevel() + " [HP " + showHP() + "]";
	}
}