package poke.controller;


import java.util.ArrayList;

import poke.model.*;

public class Controller
{

	ArrayList<Pokemon> pokemonList = new ArrayList<Pokemon>();
	
	String dataFile = "";
	
	public Controller()
	{
		
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
