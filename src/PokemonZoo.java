import java.util.ArrayList;
import java.util.Collections;

public final class PokemonZoo {
	
	private final ArrayList<Pokemon> allPokemon = new ArrayList<>();
	
	public void tick() {
		sortByName(allPokemon);
	}
	
	public void addPokemon (final Pokemon pokemon) {
		allPokemon.add(pokemon);
		sortByName(allPokemon);
	}
	
	public void removePokemon (final Pokemon pokemon) {
		allPokemon.remove(pokemon);
		sortByName(allPokemon);
	}
	
	public int getNumPokemon() {
		return allPokemon.size();
	}
	
	public Pokemon getPokemon(int i) {
		return allPokemon.get(i);
	}
	
	public void displayAll(String category) {
		displayAll(category, false);
	}
	
	public void displayAllWithNumbers(String category) {
		displayAll(category, true);
	}
		
	private void displayAll(String category, Boolean numbers) {
		boolean none = true;
		String noneMessage = "";
		
		for (int i = 0; i < allPokemon.size(); i++) {
			Pokemon pokemon = allPokemon.get(i);
			boolean inCategory;
			
			switch (category) {
				case "Pokemon":
					inCategory = true;
					noneMessage = "No Pokemon to display.";
					break;
				case "Domesticated":
					inCategory = pokemon instanceof Domesticated;
					noneMessage = "No domesticated Pokemon to display.";
					break;
				case "Wild":
					inCategory = pokemon instanceof Wild;
					noneMessage = "No wild Pokemon to display.";
					break;
				case "Bulbasaur":
					inCategory = pokemon instanceof Bulbasaur;
					noneMessage = "No Bulbasaur (or evolutions) to display.";
					break;
				case "Squirtle":
					inCategory = pokemon instanceof Squirtle;
					noneMessage = "No Squirtle (or evolutions) to display.";
					break;
				case "Charmander":
					inCategory = pokemon instanceof Charmander;
					noneMessage = "No Charmander (or evolutions) to display.";
					break;
				case "Rattata":
					inCategory = pokemon instanceof Rattata;
					noneMessage = "No Rattata (or evolutions) to display.";
					break;
				default:
					inCategory = false;
					noneMessage = "Invalid category.";
			}
			
			if (inCategory) {
				System.out.println((numbers ? ((i + 1) + ": ") : "") + pokemon);
				none = false;
			}
		}
		
		if (none) {
			System.out.println(noneMessage);
		}
	}
	
	private void sortByName(final ArrayList<Pokemon> pokemon) {
		for (int i = 0; i < pokemon.size(); i++) {
			for (int j = i + 1; j < pokemon.size(); j++) {
				if (pokemon.get(j).getNickname().compareTo(pokemon.get(i).getNickname()) < 0) {
					Collections.swap(pokemon, i, j);
				}
				else if (pokemon.get(j).getNickname().compareTo(pokemon.get(i).getNickname()) == 0) {
					if (pokemon.get(j).getLevel() < pokemon.get(i).getLevel()) {
						Collections.swap(pokemon, i, j);
					}
				}
			}
		}
	}
	
}
