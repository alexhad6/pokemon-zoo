public class Rattata extends Pokemon implements Wild {

	private static final String name = "Rattata";
	private static final double height = 12, weight = 7.7;
	private static final int type = Constants.NORMAL;
	private static final int[] baseStats = {30, 56, 35, 25, 35, 72};
	private static final Move move1 = Constants.TACKLE, move2 = Constants.BITE;

	public Rattata(String nickname, int level) {
		this(nickname, 0, level, 0, new int[] {0, 0, 0, 0, 0, 0});
	}

	public Rattata(String nickname, int experience, int level, int friendship, int[] EV) {
		super(name, nickname, height, weight, type, experience, level, friendship, baseStats, EV, move1, move2);
	}

}