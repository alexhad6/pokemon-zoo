public class PokemonApp {

	private final static String LINE_BREAK = "\n––––––––––––––––––––––––––––––––––––––––\n";

	public static void main(String[] args) {

		final PokemonZoo zoo = new PokemonZoo();

<<<<<<< HEAD
		zoo.addPokemon(new Bulbasaur("Bob", 15));
		zoo.addPokemon(new Bulbasaur("Fred", 10));
		zoo.addPokemon(new Bulbasaur("Bob", 3));
		zoo.addPokemon(new Bulbasaur("Zarg", 1));
		//zoo.addPokemon(new Rattata(10));
		zoo.addPokemon(new Mewtwo(30));
		zoo.addPokemon(new Jigglypuff(15));
=======
		zoo.addPokemon(new Bulbasaur("Bulby", 5));
		zoo.addPokemon(new Bulbasaur("Saur", 15));
>>>>>>> 029556e893eee7afcb0a3aba437eebe8ab10acde

		zoo.addPokemon(new Charmander("Char", 7));
		zoo.addPokemon(new Charmander("Blaze", 15));

		zoo.addPokemon(new Squirtle("Squirte", 6));
		zoo.addPokemon(new Squirtle("Bubbles", 15));

		zoo.addPokemon(new Pikachu("Pika", 9));
		zoo.addPokemon(new Pikachu("Zap", 33));

		zoo.addPokemon(new Rattata(1));
		zoo.addPokemon(new Rattata(2));
		zoo.addPokemon(new Rattata(3));
		zoo.addPokemon(new Rattata(5));
		zoo.addPokemon(new Rattata(8));
		zoo.addPokemon(new Rattata(11));
		zoo.addPokemon(new Rattata(16));
		zoo.addPokemon(new Rattata(19));
		zoo.addPokemon(new Rattata(24));
		zoo.addPokemon(new Rattata(31));
		zoo.addPokemon(new Rattata(38));
		zoo.addPokemon(new Rattata(47));

		zoo.addPokemon(new Jigglypuff(6));
		zoo.addPokemon(new Jigglypuff(12));
		zoo.addPokemon(new Jigglypuff(23));
		zoo.addPokemon(new Jigglypuff(27));
		zoo.addPokemon(new Jigglypuff(35));
		zoo.addPokemon(new Jigglypuff(43));
		zoo.addPokemon(new Jigglypuff(52));
		zoo.addPokemon(new Jigglypuff(60));

		zoo.addPokemon(new Mewtwo(70));
		zoo.addPokemon(new Mewtwo(100));

		System.out.println("Welcome to the PokeZoo!");
		System.out.println();
		System.out.println("There so much to do! You can visit parts of the zoo, check a Pokemon's stats, \n"
				+ "rename a Pokemon, train a Pokemon by battle against a wild pokemon, practice \n"
				+ "battling against other domesticated Pokemon, feed a Pokemon to relieve its hunger, \n"
				+ "or send a Pokemon to the Pokecenter to restore its HP.");
		System.out.println(LINE_BREAK);
		System.out.println("What would you like to do?");

		while(true) {
			System.out.println("1: Visit pokemon");
			System.out.println("2: Check stats");
			System.out.println("3: Rename");
			System.out.println("4: Train");
			System.out.println("5: Practice");
			System.out.println("6: Feed");
			System.out.println("7: Send to Pokecenter");

			loop: while (true) {
				String choice = Const.scan.nextLine();
				System.out.println();
				switch (choice) {
					case "1": {
						System.out.println("Which cage would you like to visit?");
						System.out.println("1: Domesticated");
						System.out.println("2: Rattata");
						System.out.println("3: Jigglypuff");
						System.out.println("4: Mewtwo");
	
						loop2: while (true) {
							String choice2 = Const.scan.nextLine();
							System.out.println();
							switch(choice2) {
								case "1":
									zoo.displayAllDomesticated();
									break loop2;
								case "2":
									zoo.displayAllRattata();
									break loop2;
								case "3":
									zoo.displayAllJigglypuff();
									break loop2;
								case "4":
									zoo.displayAllMewtwo();
									break loop2;
								default:
									System.out.println("Please choose 1–4: ");
								}
						}
	
						break loop;
					}
					case "2": {
						System.out.println("Which pokemon's stats would you like to check?");
						choosePokemon(zoo).displayAllInfo();
						break loop;
					}
					case "3": {
						System.out.println("Which pokemon would you like to rename?");
						Pokemon pokemon = choosePokemon(zoo);
						if (pokemon instanceof Domesticated) {
							System.out.println("What should " + pokemon.getNickname() + "'s new name be?");
							String newName = Const.scan.nextLine();
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
						Domesticated pokemon = choosePokemon(zoo);
						System.out.println();
						pokemon.train(zoo.getRandWild(pokemon));
						break loop;
					}
					case "5": {
						System.out.println("Which pokemon would you like to use?");
						Domesticated pokemon = choosePokemon(zoo);
						System.out.println("Which pokemon would you like to practice against?");
						Domesticated opponent = choosePokemon(zoo);
						pokemon.practice(opponent);
	
						break loop;
					}
					case "6": {
						System.out.println("Which pokemon would you like to feed?");
						Domesticated pokemon = choosePokemon(zoo);
						pokemon.feed();
						break loop;
					}
					case "7": {
						System.out.println("Which pokemon would you like to send to the Pokecenter?");
						Domesticated pokemon = choosePokemon(zoo);
						pokemon.restoreHP();
						System.out.println(pokemon.getNickname() + "'s HP was restored!");
						break loop;
					}
					default: {
						System.out.print("Please choose 1–7: ");
					}
				}
			}

			zoo.tick();

			System.out.println(LINE_BREAK);
			System.out.println("What would you like to do next?");
		}

	}

	private static Domesticated choosePokemon(PokemonZoo zoo) {
		zoo.displayDomesticatedWithNumbers();

		int choice = 0;
		while (true) {
			try {
				choice = Integer.parseInt(Const.scan.nextLine());
				if (choice >= 1 && choice <= zoo.numDomesticated()) {
					break;
				}
			}
			catch (Exception e) { }
			System.out.print("Please choose 1–" + zoo.numDomesticated() + ": ");
		}
		System.out.println();

		return (Domesticated) zoo.getDomesticated(choice - 1);
	}

}