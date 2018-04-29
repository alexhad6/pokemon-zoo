import java.util.Random;
import java.util.Scanner;

public class Const {

	public static final Random rand = new Random();
	public static final Scanner scan = new Scanner(System.in);

	public static final int HP = 0, ATK = 1, DEF = 2, SPA = 3, SPD = 4, SPE = 5;

	public static final Type NORMAL = new Type("Normal", new String[0], new String[0]);
	public static final Type FIRE = new Type("Fire", new String[] {"Grass"}, new String[] {"Fire", "Water"});
	public static final Type WATER = new Type("Water", new String[] {"Fire"}, new String[] {"Water", "Grass"});
	public static final Type GRASS = new Type("Grass", new String[] {"Water"}, new String[] {"Fire", "Grass"});
	public static final Type ELECTRIC = new Type("Electric", new String[] {"Water"}, new String[] {"Grass", "Electric"});
	public static final Type PSYCHIC = new Type("Psychic", new String[0], new String[] {"Psychic"});
	public static final Type DARK = new Type("Dark", new String[] {"Psychic"}, new String[] {"Dark"});

	public static final Nature[] NATURES = { new Nature("Lonely", ATK, DEF), new Nature("Brave", ATK, SPE),
			new Nature("Adamant", ATK, SPA), new Nature("Naughty", ATK, SPD), new Nature("Bold", DEF, ATK),
			new Nature("Relaxed", DEF, SPE), new Nature("Impish", DEF, SPA), new Nature("Lax", DEF, SPD),
			new Nature("Timid", SPE, ATK), new Nature("Hasty", SPE, DEF), new Nature("Jolly", SPE, SPA),
			new Nature("Naive", SPE, SPD), new Nature("Modest", SPA, ATK), new Nature("Mild", SPA, DEF),
			new Nature("Quiet", SPA, SPE), new Nature("Rash", SPA, DEF), new Nature("Calm", SPD, ATK),
			new Nature("Gentle", SPD, DEF), new Nature("Sassy", SPD, SPE), new Nature("Careful", SPD, ATK) };

	public static final int PHYSICAL = 0, SPECIAL = 1;

	public static final Move TACKLE = new Move("Tackle", 1.00, NORMAL, PHYSICAL, 40);
	public static final Move BITE = new Move("Bite", 1.00, Const.DARK, Const.PHYSICAL, 60);

}