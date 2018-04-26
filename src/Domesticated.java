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
			int XPGain = (int) Math.floor((opponent.getBaseXP() * opponent.getLevel()) / 7.0);
			experience += XPGain;
			System.out.println(getNickname() + " gained " + XPGain + " experience! [" + (experienceAtLevel(getLevel() + 1) - experience) + " to until level " + (getLevel() + 1) + ".]");
			
			int stat = opponent.getEVType();
			int inc = opponent.getEV();
			
			if (totalEV() < 510 + inc && totalEV(stat) < 255 + inc) {
				incEV(stat, inc);
			}
		}
	}
	
	public void pokecenter() {
		restoreHP();
	}
	
	public final String toString() {
		return getNickname() + "  [" + getName() + " Lv" + getLevel() + "]";
	}
}