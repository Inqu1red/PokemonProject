package poke.controller;


import java.util.ArrayList;

import javax.swing.JOptionPane;

import poke.view.PokeFrame;
import poke.view.*;
import poke.model.monsters.*;



public class Controller
{
	
	private PokeFrame window;
	ArrayList<Pokemon> pokedex = new ArrayList<Pokemon>();
	
	String dataFile = "";
	
	public Controller()
	{
		this.pokedex = new ArrayList<Pokemon>();
		this.dataFile = new String("save.pokemon");
		createPokedex();
		this.window = new PokeFrame(this);
		
	}
	
	public void start()
	{
		ArrayList<Pokemon> saved = IOController.loadData(dataFile, window);
		
		if (saved != null && saved.size() > 0)
		{
			this.pokedex = saved;
			
		}
	}
	
	public void save()
	{
		IOController.saveData(dataFile, pokedex, window);
	}
	
	public Pokemon pokedex()
	{
		Pokemon poke = null;
		
		
		createPokedex();
		
		
		return poke;
	}
	
	public void updateCurrentPokemon(String name, int index ,int health, boolean evolve)
	{
		Pokemon current = pokedex.get(index);
		current.setName(name);
		current.setHealth(health);
		current.setCanEvolve(evolve);
	}
	
	
	public String [] buildPokedexText()
	{
		String [] pokemonNames = new String [pokedex.size()];
		
		for(int index = 0; index < pokemonNames.length; index++)
		{
			pokemonNames[index] = index + ": " + pokedex.get(index).getClass().getSimpleName();
			
		}
		
		
		return pokemonNames;
	}
	
	public String [] getPokemonData(int index)
	{
		String [] data = new String [5];
		
		
		Pokemon current = pokedex.get(index);
		
		data[0] = current.getName();
		
		data[1] = current.isCanEvolve() + "";
		
		data[2] = current.getHealth() + "";
		
		data[3] = current.getPokedexNumber() + "";
		
		
		String types = "Pokemon Types \n \n";
		
		for (String type : current.getTypes())
		{
			types += type + "\n";
			
		}
		
		data[4] = types;
		
		
		return data;
	}
	
	
	private void createPokedex()
	{
		pokedex.add(new Gengar());
		pokedex.add(new Lucario());
		pokedex.add(new Sprigatito());
		pokedex.add(new Rowlet());
		pokedex.add(new Pichu());
		pokedex.add(new Gengar(120, "Sean124"));
		pokedex.add(new Rowlet("little guy"));
		pokedex.add(new Sprigatito(940, "Grass Cat"));
		pokedex.add(new Pichu("Small rodent"));
		pokedex.add(new Lucario(345, "Big Guy"));
	}

	
	public boolean validateNumber(String text)
	{
		boolean isValid = false;
		
		try
		{
			Integer.parseInt(text);
			isValid = true;
		}
		catch(NumberFormatException error)
		{
			JOptionPane.showMessageDialog(window, "Use a valid number");
		}
		
		return isValid;
	}
	
	
	
}
