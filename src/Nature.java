public class Nature {
	private final String name;
	private final int incStat, decStat;

	public Nature(String name, int incStat, int decStat) {
		this.name = name;
		this.incStat = incStat;
		this.decStat = decStat;
	}

	public String getName() {
		return name;
	}

	public int getIncStat() {
		return incStat;
	}

	public int getDecStat() {
		return decStat;
	}
}