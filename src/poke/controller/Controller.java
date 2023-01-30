package poke.controller;


import java.util.ArrayList;


import poke.view.PokeFrame;
import poke.view.*;
import poke.model.*;
import poke.model.monsters.Gengar;
import poke.model.monsters.Lucario;
import poke.model.monsters.Pichu;
import poke.model.monsters.Pokemon;
import poke.model.monsters.Rowlet;
import poke.model.monsters.Sprigatitio;

public class Controller
{
	
	private PokeFrame window;
	ArrayList<Pokemon> pokemonList = new ArrayList<Pokemon>();
	
	String dataFile = "";
	
	public Controller()
	{
		this.window = new PokeFrame(this);
	}
	
	public void start()
	{
		
	}
	
	public Pokemon pokedex()
	{
		Pokemon poke = null;
		
		
		createPokedex();
		
		
		return poke;
	}
	
	
	
	private void createPokedex()
	{
		pokemonList.add(new Gengar());
		pokemonList.add(new Lucario());
		pokemonList.add(new Sprigatitio());
		pokemonList.add(new Rowlet());
		pokemonList.add(new Pichu());
		pokemonList.add(new Gengar(120, "Sean124"));
		pokemonList.add(new Rowlet("little guy"));
		pokemonList.add(new Sprigatitio(940, "Grass Cat"));
		pokemonList.add(new Pichu("Small rodent"));
		pokemonList.add(new Lucario(345, "Big Guy"));
	}
	
}
