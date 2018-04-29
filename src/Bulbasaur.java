public final class Bulbasaur extends Domesticated implements Grass {

	public Bulbasaur(String nickname, int level) {
		super("Bulbasaur", nickname, 28, 15.2, Const.GRASS, level, new int[] {45, 49, 49, 65, 65, 45}, Const.TACKLE, VINE_WHIP);
	}

	public void levelTick() {
		while (leveledUp()) {
			levelUp();

			if (getLevel() >= 16 && getName() != "Ivysaur") {
				evolve("Ivysaur", 39, 28.7, new int[] {60, 62, 63, 80, 80, 60}, VINE_WHIP, RAZOR_LEAF);
			}
			if (getLevel() >= 32 && getName() != "Venusaur") {
				evolve("Venusaur", 79, 220.5, new int[] {80, 82, 83, 100, 100, 80}, PETAL_BLIZZARD, SOLAR_BEAM);
			}
		}
	}

}