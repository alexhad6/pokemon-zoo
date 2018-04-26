
public final class Pikachu extends Domesticated{
	
	public Pikachu(String nickname, int level) {
		super("Pikachu", nickname, 16, 13.2, Const.ELECTRIC, level, new int[] {35, 55, 40, 50, 50, 90}, Const.TACKLE, VINE_WHIP);
	}
	
	public void tick() {
		while(getExperience() >= experienceAtLevel(getLevel())) {
			levelUp();
			
			if (getLevel() >= 34) {
				evolve("Raichu", 31, 66.1, Const.ELECTRIC, new int[] {60, 90, 55, 90, 80, 110}, VINE_WHIP, RAZOR_LEAF);
			}
		}
	}

}