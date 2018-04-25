
public final class Bulbasaur extends Pokemon implements Domesticated {
	
	public Bulbasaur(String nickname, int level) {
		super("Bulbasaur", nickname, 28, 15.2, Constants.GRASS, Constants.POISON, level, 0, new int[] {45, 49, 49, 65, 65, 45}, Constants.TACKLE, Constants.VINE_WHIP);
	}
	
	public void train() {
		
	}
	
	public void tick() {
		
		while(getExperience() >= experienceAtLevel(getLevel())) {
			levelUp();
			
			if (getLevel() >= 16) {
				evolve("Ivysaur", 39, 28.7, Constants.GRASS, Constants.POISON, new int[] {60, 62, 63, 80, 80, 60}, Constants.VINE_WHIP, Constants.RAZOR_LEAF);
			}
			
			if (getLevel() >= 32) {
				evolve("Venusaur", 79, 220.5, Constants.GRASS, Constants.POISON, new int[] {80, 82, 83, 100, 100, 80}, Constants.PETAL_BLIZZARD, Constants.SOLAR_BEAM);
			}
		}
	}

}