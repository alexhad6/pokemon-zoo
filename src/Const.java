import java.util.Random;
import java.util.Scanner;

public class Const {
	
	public static final Random rand = new Random();
	public static final Scanner scan = new Scanner(System.in);
	
	public static final int HP = 0, ATK = 1, DEF = 2, SPA = 3, SPD = 4, SPE = 5;

	public static final Type NORMAL = new Type("Normal", new String[0], new String[0]);
	public static final Type FIRE = new Type("Fire", new String[] {"Grass"}, new String[] {"Fire", "Water", "Dragon"});
	public static final Type WATER = new Type("Water", new String[] {"Fire"}, new String[] {"Water", "Grass", "Dragon"});
	//TODO: electric and psychic need work
	public static final Type ELECTRIC = new Type("Electric", new String[] {"Grass"}, new String[] {"Fire", "Water", "Dragon"});
	public static final Type PSYCHIC = new Type("Psychic", new String[] {"Grass"}, new String[] {"Fire", "Water", "Dragon"});
	public static final Type GRASS = new Type("Grass", new String[] {"Water"}, new String[] {"Fire", "Grass", "Poison", "Dragon"});
	public static final Type POISON = new Type("Poison", new String[] {"Grass"}, new String[] {"Poison"});
	public static final Type DRAGON = new Type("Dragon", new String[] {"Dragon"}, new String[0]);
	public static final Type DARK = new Type("Dark", new String[] {"Dark"}, new String[0]);

	public static final Nature[] NATURES = { new Nature("Lonely", ATK, DEF), new Nature("Brave", ATK, SPE),
		new Nature("Adamant", ATK, SPA), new Nature("Naughty", ATK, SPD), new Nature("Bold", DEF, ATK),
		new Nature("Relaxed", DEF, SPE), new Nature("Impish", DEF, SPA), new Nature("Lax", DEF, SPD),
		new Nature("Timid", SPE, ATK), new Nature("Hasty", SPE, DEF), new Nature("Jolly", SPE, SPA),
		new Nature("Naive", SPE, SPD), new Nature("Modest", SPA, ATK), new Nature("Mild", SPA, DEF),
		new Nature("Quiet", SPA, SPE), new Nature("Rash", SPA, DEF), new Nature("Calm", SPD, ATK),
		new Nature("Gentle", SPD, DEF), new Nature("Sassy", SPD, SPE), new Nature("Careful", SPD, ATK) };

	public static final int PHYSICAL = 0, SPECIAL = 1;
	public static final Move TACKLE = new Move("Tackle", 1.00, NORMAL, PHYSICAL, 40);
	
	public static final Move BITE = new Move("Bite", 1.00, DARK, PHYSICAL, 60);
	
	public static final Move PETAL_BLIZZARD = new Move("Petal Blizzard", 1.00, GRASS, PHYSICAL, 90);
	public static final Move SOLAR_BEAM = new Move("Solar Beam", 1.00, GRASS, SPECIAL, 120);
	
	public static final Move DRAGON_CLAW = new Move("Dragon Claw", 1.00, DRAGON, PHYSICAL, 80);
	public static final Move FLARE_BLITZ = new Move("Flare Blitz", 1.00, FIRE, PHYSICAL, 120);
	
	public static final Move PSYCHO_CUT = new Move("Psycho Cut", 1.00, PSYCHIC, PHYSICAL, 70);
	public static final Move FUTURE_SIGHT = new Move("Future Sight", 1.00, PSYCHIC, SPECIAL, 120);

}