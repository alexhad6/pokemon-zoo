public final class Charmander extends Domesticated implements Fire {

	public Charmander(String nickname, int level) {
		super("Charmander", nickname, 24, 18.7, Const.FIRE, level, new int[] {39, 52, 43, 60, 50, 65}, Const.TACKLE, EMBER);
	}

	public void levelTick() {
		while(leveledUp()) {
			levelUp();

			if (getLevel() >= 16 && getName() != "Charmeleon") {
				evolve("Charmeleon", 43, 41.9, new int[] {58, 64, 58, 80, 65, 80}, EMBER, FIRE_FANG);
			}

			if (getLevel() >= 36 && getName() != "Charizard") {
				evolve("Charizard", 67, 199.5, new int[] {78, 84, 78, 109, 85, 100}, HEAT_WAVE, FLARE_BLITZ);
			}
		}
	}

}