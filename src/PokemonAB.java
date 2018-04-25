
import java.util.Random;

public class PokemonAB {
	Random r;
	private int hunger;
	private int thirst;
	int level;
	int evol;
	private int boredom;
	private int fatigue;
	private int heat;
	private boolean sick;
	private boolean immune;
	private int sickLevel;
	String[] name;
	private int evolnum;

	public Pokemon() {
		hunger = 30;
		r = new Random();
		thirst = 30;
		level = 0;
		heat = 50;
		boredom = 30;
		fatigue = 30;
		name = new String[10];
		name[0] = "Bulbasaur";
		name[1] = "Ivysaur";
		name[2] = "Venusaur";
		name[3] = "Charmander";
		name[4] = "Charmeleon";
		name[5] = "Charizard";
		name[6] = "Squirtle";
		name[7] = "Wartortle";
		name[8] = "Blastoise";
		sick = false;
		evol = 0;
		evolnum = 3 * r.nextInt(3);
	}

	public void getStats() {
		if (level >= 10) {
			System.out.println(name[evolnum] + " Stats:");
			System.out.println("Level: " + level);
			System.out.println("Hunger: " + hunger);
			System.out.println("Thirst: " + thirst);
			System.out.println("Boredom: " + boredom);
			System.out.println("Fatigue: " + fatigue);
			System.out.println("Sicklevel (out of 3): " + sickLevel);
		} else {
			System.out.println("Egg Stats:");
			System.out.println("Level: " + level);
			System.out.println("Heat: " + heat);
		}
	}

	public void tick() {
		if(level<10) {
		heat = heat + r.nextInt(20) - 10;
		}
		if (boredom <= 70 && hunger <= 70 && thirst <= 70 && fatigue <= 80 && sick == false && heat > 40 && heat < 60) {
			level++;
		}
		if (level >= 10) {
			heat = 50;
			hunger += 5;
			thirst += 5;
			if (sick == true) {
				sick();
			} else if (immune != true && r.nextInt(20) >= 13) {
				sick = true;
				sickLevel++;
			}
			else if(immune == true) {
				immune = false;
			}
		}

	}

	public void evolve() {
		System.out.println("What?");
		if (evol == 0) {
			System.out.println("The egg is hatching!");
			System.out.println("Congratualtions your egg \nhatched into a " + name[evolnum].toUpperCase() + "!");
		} else {
			System.out.println(name[evolnum].toUpperCase() + " is evolving!");
			System.out.println("Congratualtions your " + name[evolnum].toUpperCase());
			evolnum++;
			System.out.println("hatched into a " + name[evolnum].toUpperCase() + "!");
		}

		evol++;
	}

	public void lim() {
		if (fatigue > 100) {
			fatigue = 100;
		}
		if (fatigue < 0) {
			fatigue = 0;
		}
		if (boredom > 100) {
			boredom = 100;
		}
		if (boredom < 0) {
			boredom = 0;
		}
		if (thirst > 100) {
			thirst = 100;
		}
		if (thirst < 0) {
			thirst = 0;
		}
		if (hunger > 100) {
			hunger = 100;
		}
		if (hunger < 0) {
			hunger = 0;
		}
		if (heat > 70) {
			heat = 70;
		}
		if (heat < 30) {
			heat = 30;
		}
	}

	public void needs() {
		if (level >= 10) {
			System.out.println("Press t to train, f to feed, w to give water, p to play, n to nap");
			if (sick == true) {
				System.out.println("and m to give medicine");
			}
		} else {
			System.out.println("Press h to warm your egg, or c to cool it");
		}
	}

	public void act(String action) {
		if (level >= 10) {
			if (action.equals("t")) {
				train();
			} else if (action.equals("f")) {
				feed();
			} else if (action.equals("w")) {
				water();
			} else if (action.equals("p")) {
				play();
			} else if (action.equals("n")) {
				nap();
			} else if (sick == true && action.equals("m")) {
				med();
			} else {

			}
		} else {
			if (action.equals("h")) {
				heat();
			} else if (action.equals("c")) {
				cool();
			}
		}
	}

	public void sick() {
		fatigue += 15;
		thirst += 10;
		boredom += 10;
		sickLevel++;
	}

	public void train() {
		if (sick == false) {
			hunger += 20;
			thirst += 20;
			fatigue += 40;
			level += 5 + r.nextInt(5);
		}
	}

	public void feed() {
		hunger -= 40;
		thirst += 5;
	}

	public void water() {
		hunger += 5;
		thirst -= 40;
	}

	public void play() {
		fatigue += 20;
		if (sick == false) {
			boredom -= 40;
		} else {
			boredom -= 20;
		}
	}

	public void nap() {
		fatigue -= 40;
		if (sick == true) {
			fatigue += 10;
		}
		hunger += 10;
		thirst += 10;
	}

	public void med() {
		if (r.nextInt(20) >= 10) {
			sick = false;
			sickLevel = 0;
			immune = true;
		}
	}

	public void heat() {
		heat += 10;
	}

	public void cool() {
		heat -= 10;
	}
	public int getSmaller(int x, int y) {
		int min = (x > y) ? y : x;
		return min;
	}
	public boolean alive() {
		if (hunger == 100 || thirst == 100 || boredom == 100 || fatigue == 100 || sickLevel == 4 || level == 100) {
			return false;
		}
		if (level < 10 && heat == 30 || heat == 70) {
			return false;
		} else {
			return true;
		}
	}
}
