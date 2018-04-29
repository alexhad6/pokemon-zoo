import java.util.ArrayList;
import java.util.Collections;

public final class PokemonZoo {

	private final ArrayList<Pokemon> domesticated = new ArrayList<>();
	private final ArrayList<Pokemon> rattata = new ArrayList<>();
	private final ArrayList<Pokemon> jigglypuff = new ArrayList<>();
	private final ArrayList<Pokemon> mewtwo = new ArrayList<>();

	public void tick() {
		sortByName(domesticated);
		sortByName(rattata);
		sortByName(jigglypuff);
		sortByName(mewtwo);

		for (Pokemon pokemon : domesticated) {
			Domesticated dPokemon = (Domesticated) pokemon;
			dPokemon.tick();
		}
	}

	public void addPokemon(final Pokemon pokemon) {
		if (pokemon instanceof Domesticated) {
			domesticated.add(pokemon);
			sortByName(domesticated);
		}
		else if (pokemon instanceof Rattata) {
			rattata.add(pokemon);
			sortByName(rattata);
		}
		else if (pokemon instanceof Jigglypuff) {
			jigglypuff.add(pokemon);
			sortByName(jigglypuff);
		}
		else if (pokemon instanceof Mewtwo) {
			mewtwo.add(pokemon);
			sortByName(mewtwo);
		}
	}

	public void removePokemon(final Pokemon pokemon) {
		if (pokemon instanceof Domesticated) {
			domesticated.remove(pokemon);
		}
		else if (pokemon instanceof Rattata) {
			rattata.remove(pokemon);
		}
		else if (pokemon instanceof Jigglypuff) {
			jigglypuff.remove(pokemon);
		}
		else if (pokemon instanceof Mewtwo) {
			mewtwo.remove(pokemon);
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

	public Wild getRandWild(Pokemon pokemon) {
		final ArrayList<Pokemon> options = new ArrayList<>();

		if (Math.random() < 0.05) {
			options.add(mewtwo.get(Const.rand.nextInt(mewtwo.size())));
		}

		if (Math.random() < 0.5) {
			for (Pokemon wild : jigglypuff) {
				if (Math.abs(wild.getLevel() - pokemon.getLevel()) < 10) {
					options.add(wild);
				}
			}
		}

		for (Pokemon wild : rattata) {
			if (Math.abs(wild.getLevel() - pokemon.getLevel()) < 10) {
				options.add(wild);
			}
		}

		return (Wild) options.get(Const.rand.nextInt(options.size()));
	}

	public int numDomesticated() {
		return domesticated.size();
	}

	public void displayAllRattata() {
		for (Pokemon pokemon : rattata) {
			System.out.println(pokemon);
		}
	}

	public void displayAllJigglypuff() {
		for (Pokemon pokemon : jigglypuff) {
			System.out.println(pokemon);
		}
	}

	public void displayAllMewtwo() {
		for (Pokemon pokemon : mewtwo) {
			System.out.println(pokemon);
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