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
		return (6/5)*Math.pow(level, 3) - 15*Math.pow(level, 2) + 100*level - 140;
	}

	public final void feed() {
		hunger = 0;
		System.out.println(getNickname() + " ate and is now happy and full.");
	}

	public void train(Wild opponent) {
		System.out.println("A wild " + opponent.getName() + " appeared!");
		boolean won = Pokemon.battle(this, opponent);

		opponent.restoreHP();

		System.out.println();

		if (won) {
			System.out.println(getNickname() + " won!");

			int XPGain = (int) Math.floor((opponent.getBaseXP() * opponent.getLevel()) / 7.0);
			experience += XPGain;
			System.out.println(getNickname() + " gained " + XPGain + " experience! [" + (experienceAtLevel(getLevel() + 1) - experience) + " to until level " + (getLevel() + 1) + ".]");

			int stat = opponent.getEVType();
			int inc = opponent.getEV();

			if (totalEVs() < 510 + inc && getEV(stat) < 255 + inc) {
				increaseEV(stat, inc);
			}
		}
		else {
			System.out.println(getNickname() + " fainted...");
			System.out.println();
			System.out.println(getNickname() + " was rushed to the Pokecenter and is all better now!");
			restoreHP();
		}
	}

	public void practice(Domesticated opponent) {
		boolean won = Pokemon.battle(this, opponent);

		restoreHP();
		opponent.restoreHP();

		if (won) {
			System.out.println(getNickname() + " won!");
		}
		else {
			System.out.println(getNickname() + " lost. Try again next time!");
		}
	}

	public void tick() {
		hunger += Const.rand.nextInt(6);

		if (hunger > 25) {
			System.out.println(getNickname() + " is a little hungry.");
		}
		else if (hunger > 50) {
			System.out.println(getNickname() + " is getting hungry.");
		}
		else if (hunger > 75) {
			System.out.println(getNickname() + " is getting very hungry.");
		}
		else if (hunger > 100) {
			System.out.println(getNickname() + " fainted due to hunger!");
			System.out.println();
			System.out.println(getNickname() + " was rushed to the Pokecenter and is all better now! Please remember to feed your Pokemon!");
			hunger = 0;
		}
	}

	public final String toString() {
		return getNickname() + "  (" + getName() + ") Lv" + getLevel() + " [HP " + showHP() + "]";
	}
}