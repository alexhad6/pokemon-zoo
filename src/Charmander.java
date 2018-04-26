public final class Charmander extends Domesticated implements Fire{

	public Charmander(String nickname, int level) {
		super("Charmander", nickname, 24, 18.7, Const.FIRE, level, new int[] {39, 52, 43, 60, 50, 65}, Const.TACKLE, EMBER);
	}
	
	public void tick() {
		while(getExperience() >= experienceAtLevel(getLevel())) {
			levelUp();
			
			if (getLevel() >= 16) {
				evolve("Charmeleon", 43, 41.9, Const.FIRE, new int[] {58, 64, 58, 80, 65, 80}, EMBER, FIRE_FANG);
			}
			
			if (getLevel() >= 36) {
				evolve("Charizard", 67, 199.5, Const.FIRE, new int[] {78, 84, 78, 109, 85, 100}, Const.PETAL_BLIZZARD, Const.SOLAR_BEAM);
			}
		}
	}

}