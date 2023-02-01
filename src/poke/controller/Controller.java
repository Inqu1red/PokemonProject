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
	
	
	
	
	
	private void createPokedex()
	{
		pokedex.add(new Gengar());
		pokedex.add(new Lucario());
		pokedex.add(new Sprigatitio());
		pokedex.add(new Rowlet());
		pokedex.add(new Pichu());
		pokedex.add(new Gengar(120, "Sean124"));
		pokedex.add(new Rowlet("little guy"));
		pokedex.add(new Sprigatitio(940, "Grass Cat"));
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
