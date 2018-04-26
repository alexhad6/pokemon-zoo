import java.util.ArrayList;
import java.util.Collections;

public final class PokemonZoo {

	private final ArrayList<Pokemon> domesticated = new ArrayList<>();
	private final ArrayList<Pokemon> wild = new ArrayList<>();

	public void tick() {
		sortByName(domesticated);
		sortByName(wild);
	}

	public void addPokemon(final Pokemon pokemon) {
		if (pokemon instanceof Domesticated) {
			domesticated.add(pokemon);
			sortByName(domesticated);
		}
		else {
			wild.add(pokemon);
			sortByName(wild);
		}
	}

	public void removePokemon(final Pokemon pokemon) {
		if (pokemon instanceof Domesticated) {
			domesticated.remove(pokemon);
		}
		else {
			wild.remove(pokemon);
		}
	}

	public void displayAllDomesticated() {
		for (Pokemon pokemon : domesticated) {
			System.out.println(pokemon);
		}
	}

	public void displayDomesticatedWithNumbers() {
		for (int i = 0; i < domesticated.size(); i++) {
			System.out.println((i + 1) + ": " + domesticated.get(i));
		}
	}

	public Pokemon getDomesticated(int i) {
		return domesticated.get(i);
	}

	public Wild getRandWild() {
		return (Wild) wild.get(Const.rand.nextInt(wild.size()));
	}

	public int numDomesticated() {
		return domesticated.size();
	}

	public void displayAllRattata() {
		for (Pokemon pokemon : wild) {
			if (pokemon instanceof Rattata) {
				System.out.println(pokemon);
			}
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