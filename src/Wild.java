public abstract class Wild extends Pokemon {

	final int baseXP;
	final int EV;
	final int EVType;

	public Wild(final String name, final int height, final double weight, final Type type, final int level, final int[] baseStats, final Move move1, final Move move2, final int baseXP, final int EV, final int EVType) {
		super(name, name, height, weight, type, level, baseStats, move1, move2);

		this.baseXP = baseXP;
		this.EV = EV;
		this.EVType = EVType;
	}

	public int getBaseXP() {
		return baseXP;
	}

	public int getEV() {
		return EV;
	}

	public int getEVType() {
		return EVType;
	}

	public final String toString() {
		return getName() + " Lv" + getLevel();
	}

}