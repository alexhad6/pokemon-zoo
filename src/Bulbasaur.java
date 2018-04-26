
public final class Bulbasaur extends Domesticated implements Grass {
	
	public Bulbasaur(String nickname, int level) {
		super("Bulbasaur", nickname, 28, 15.2, Const.GRASS, level, new int[] {45, 49, 49, 65, 65, 45}, Const.TACKLE, VINE_WHIP);
	}
	
	public void tick() {
		while(getExperience() >= experienceAtLevel(getLevel())) {
			levelUp();
			
			if (getLevel() >= 16) {
				evolve("Ivysaur", 39, 28.7, Const.GRASS, new int[] {60, 62, 63, 80, 80, 60}, VINE_WHIP, RAZOR_LEAF);
			}
			
			if (getLevel() >= 32) {
				evolve("Venusaur", 79, 220.5, Const.GRASS, new int[] {80, 82, 83, 100, 100, 80}, Const.PETAL_BLIZZARD, Const.SOLAR_BEAM);
			}
		}
	}

}