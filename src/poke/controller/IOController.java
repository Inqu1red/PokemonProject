package poke.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

import poke.model.monsters.Pokemon;
import poke.view.PokeFrame;

import java.util.ArrayList;
import javax.swing.JOptionPane;





public class IOController
{

	public static ArrayList<Pokemon> loadData(String dataFile, PokeFrame frame)
	{
	ArrayList<Pokemon> pokeList = null;
	
	try(FileInputStream fileStream = new FileInputStream(dataFile);
			ObjectInputStream inputStream = new ObjectInputStream(fileStream))
	{
		ArrayList<Pokemon> saved = (ArrayList<Pokemon>) inputStream.readObject();
		pokeList = saved;
		
	}
	catch(IOException fileError )
	{
		JOptionPane.showMessageDialog(frame, fileError.getMessage(), "Bad File", JOptionPane.ERROR_MESSAGE);
	}
	catch(ClassNotFoundException classError)
	{
		JOptionPane.showMessageDialog(frame, classError.getMessage(), "Wrong Type", JOptionPane.ERROR_MESSAGE);
	}
	
	
	
	return pokeList;
	}
	
	
	
	public static void saveData(String dataFile, ArrayList<Pokemon> pokemonList, PokeFrame frame)
	{
		
	try (FileOutputStream fileStream = new FileOutputStream(dataFile);
			ObjectOutputStream objectStream = new ObjectOutputStream(fileStream))
	{
		objectStream.writeObject(pokemonList);
		
	}
	catch (IOException fileError)
	{
		JOptionPane.showMessageDialog(frame, "File save Error", "", JOptionPane.ERROR_MESSAGE);
	}
		
		
		
	}
	
	
	
	
}
