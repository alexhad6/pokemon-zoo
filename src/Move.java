public final class Move {
	
	private final String name;
	private final double accuracy;
	private final Type type;
	private final int category;
	private final int power;
	
	Move(final String name, final double accuracy, final Type type, final int category, final int power) {
		this.name = name;
		this.accuracy = accuracy;
		this.type = type;
		this.category = category;
		this.power = power;
	}
	
	public String getName() {
		return name;
	}
	
	public Type getType() {
		return type;
	}
	
	public int getPower() {
		return power;
	}
	
	public int getCategory() {
		return category;
	}
	
	public double getAccuracy() {
		return accuracy;
	}
}