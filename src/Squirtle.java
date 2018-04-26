
public final class Squirtle extends Domesticated {

	public Squirtle(String nickname, int level) {
		super("Squirtle", nickname, 20, 19.8, Const.WATER, level, new int[] {44, 48, 65, 50, 64, 43}, Const.TACKLE, VINE_WHIP);
	}
	
	public void tick() {
		while(getExperience() >= experienceAtLevel(getLevel())) {
			levelUp();
			
			if (getLevel() >= 16) {
				evolve("Wartotle", 39, 49.6, Const.WATER, new int[] {59, 63, 80, 65, 80, 58}, VINE_WHIP, RAZOR_LEAF);
			}
			
			if (getLevel() >= 36) {
				evolve("Blastoise", 63, 188.5, Const.WATER, new int[] {79, 83, 100, 85, 105, 78}, Const.PETAL_BLIZZARD, Const.SOLAR_BEAM);
			}
		}
	}

}
