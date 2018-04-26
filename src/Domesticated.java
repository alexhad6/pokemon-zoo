public abstract class Domesticated extends Pokemon {
	
	private double experience;
	private int hunger;
	
	public Domesticated(final String name, final String nickname, final int height, final double weight, final Type type, final int level, final int[] baseStats, final Move move1, final Move move2) {
		super(name, nickname, height, weight, type, level, baseStats, move1, move2);
		experience = experienceAtLevel(getLevel());
		hunger = 100;
	}
	
	public final double getExperience() {
		return experience;
	}
	
	public final void feed() {

	}
	
	public final double experienceAtLevel(final int level) {
		return (6/5)*Math.pow(level, 3) - 15*Math.pow(level, 2) + 100*level - 140;
	}


	public void train(Wild opponent) {
		boolean won = Pokemon.battle(this, opponent);
		
		if (won) {
			int experience = opponent.getBaseXP();
		}
		
	}
	
	public void pokecenter() {
		
	}
	
	public final String toString() {
		return getNickname() + "  [" + getName() + " Lv" + getLevel() + "]";
	}
}