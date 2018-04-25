import java.util.Scanner;

public class PokemonApp {
	
	private final static String LINE_BREAK = "\n––––––––––––––––––––––––––––––––––––––––\n";

	public static void main(String[] args) {

		final PokemonZoo zoo = new PokemonZoo();
		final Scanner scanner = new Scanner(System.in);

		zoo.addPokemon(new Bulbasaur("Bob", 15));
		zoo.addPokemon(new Bulbasaur("Fred", 10));
		zoo.addPokemon(new Bulbasaur("Bob", 3));
		zoo.addPokemon(new Bulbasaur("Zarg", 1));

		
		System.out.println("Welcome to the PokeZoo!");
		System.out.println();
		System.out.println("Here are the pokemon in the zoo:");
		zoo.displayAll("Pokemon");
		System.out.println(LINE_BREAK);
		System.out.println("What would you like to do?");
		
		while(true) {
			System.out.println("1: Display pokemon");
			System.out.println("2: Check stats");
			System.out.println("3: Rename");
			System.out.println("4: Train"); //battle another pokemon
			System.out.println("5: Feed");
			System.out.println("6: Send to Pokecenter");
			
			loop: while (true) {
				String choice = scanner.nextLine();
				System.out.println();
				switch (choice) {
					case "1": {
						System.out.println("What would you like to display?");
						System.out.println("1: All pokemon");
						System.out.println("2: All Domesticated pokemon");
						System.out.println("3: All Wild pokemon");
						System.out.println("4: All Bulbasaur (and evolutions)");
						System.out.println("5: All Squirtle (and evolutions)");
						System.out.println("6: All Charmander (and evolutions)");
						System.out.println("7: All Rattata");
	
						loop2: while (true) {
							String choice2 = scanner.nextLine();
							System.out.println();
							switch(choice2) {
							case "1":
								zoo.displayAll("Pokemon");
								break loop2;
							case "2":
								zoo.displayAll("Domesticated");
								break loop2;
							case "3":
								zoo.displayAll("Wild");
								break loop2;
							case "4":
								zoo.displayAll("Bulbasaur");
								break loop2;
							case "5":
								zoo.displayAll("Squirtle");
								break loop2;
							case "6":
								zoo.displayAll("Charmander");
								break loop2;
							case "7":
								zoo.displayAll("Rattata");
								break loop2;
							default:
								System.out.println("Please choose 1–7: ");
							}
						}
						
						break loop;
					}
					case "2": {
						System.out.println("Which pokemon's stats would you like to check?");
						choosePokemon(zoo, scanner).displayInfo();
						break loop;
					}
					case "3": {
						System.out.println("Which pokemon would you like to rename?");
						Pokemon pokemon = choosePokemon(zoo, scanner);
						if (pokemon instanceof Domesticated) {
							System.out.println("What should " + pokemon.getNickname() + "'s new name be?");
							String newName = scanner.nextLine();
							System.out.println();
							pokemon.rename(newName);
						}
						else {
							System.out.println("Sorry, you can only rename domesticated pokemon.");
						}
						break loop;
					}
					case "4": {
						System.out.println("Which pokemon would you like to train?");
						Pokemon pokemon = choosePokemon(zoo, scanner);
					}
					case "5": {
						System.out.println("Which pokemon would you like to feed?");
						Pokemon pokemon = choosePokemon(zoo, scanner);
					}
					case "6": {
						System.out.println("Which pokemon would you like to send to the Pokecenter?");
						Pokemon pokemon = choosePokemon(zoo, scanner);
					}
					default: {
						System.out.print("Please enter 1–6: ");
					}
				}
			}
			
			zoo.tick();
			
			System.out.println(LINE_BREAK);
			System.out.println("What would you like to do next?");
		}

	}
	
	private static Pokemon choosePokemon(PokemonZoo zoo, Scanner scanner) {
		zoo.displayAllWithNumbers("Pokemon");
		
		int choice = 0;
		while (true) {
			try {
				choice = Integer.parseInt(scanner.nextLine());
				if (choice >= 1 && choice <= zoo.getNumPokemon()) {
					break;
				}
			}
			catch (Exception e) { }
			System.out.print("Please choose 1–" + zoo.getNumPokemon() + ": ");
		}
		System.out.println();
		
		return zoo.getPokemon(choice - 1);
	}

}
