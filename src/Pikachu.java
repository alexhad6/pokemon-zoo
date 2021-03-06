public final class Pikachu extends Domesticated implements Electric {

	public Pikachu(String nickname, int level) {
		super("Pikachu", nickname, 16, 13.2, Const.ELECTRIC, level, new int[] {35, 55, 40, 50, 50, 90}, Const.TACKLE, SPARK);
	}

	public void levelTick() {
		while (leveledUp()) {
			if (getLevel() + 1 >= 34 && getName() != "Raichu") {
				evolve("Raichu", 31, 66.1, new int[] {60, 90, 55, 90, 80, 110}, SPARK, THUNDERBOLT);
			}

			System.out.println();
			levelUp();
		}
	}

}