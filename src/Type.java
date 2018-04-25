
public class Type {

	private final String name;
	private final String[] superEffective;
	private final String[] notVeryEffective;

	public Type(String name, String[] superEffective, String[] notVeryEffective) {
		this.name = name;
		this.superEffective = superEffective;
		this.notVeryEffective = notVeryEffective;
	}

	public String getName() {
		return name;
	}

	public double effectiveness(Type type) {
		for (String superEffectiveType : superEffective) {
			if (superEffectiveType.equals(type.name)) {
				return 2;
			}
		}

		for (String notVeryEffectiveType : notVeryEffective) {
			if (notVeryEffectiveType.equals(type.name)) {
				return 0.5;
			}
		}

		return 1;
	}

}