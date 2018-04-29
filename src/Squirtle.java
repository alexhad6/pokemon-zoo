public final class Squirtle extends Domesticated implements Water{

	public Squirtle(String nickname, int level) {
		super("Squirtle", nickname, 20, 19.8, Const.WATER, level, new int[] {44, 48, 65, 50, 64, 43}, Const.TACKLE, WATER_GUN);
	}

	public void levelTick() {
		while(leveledUp()) {
			levelUp();

			if (getLevel() >= 16) {
				evolve("Wartotle", 39, 49.6, new int[] {59, 63, 80, 65, 80, 58}, WATER_GUN, BUBBLE_BEAM);
			}

			if (getLevel() >= 36) {
				evolve("Blastoise", 63, 188.5, new int[] {79, 83, 100, 85, 105, 78}, BUBBLE_BEAM, HYDRO_PUMP);
			}
		}
	}

}