package poke.view;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import poke.controller.Controller;

public class PokePanel extends JPanel
{
	private Controller app;
	
	private SpringLayout layout;

	
	public PokePanel(Controller app)
	{
		super();
		
		setupPanel();
		setupListeners();
		setupLayout();
	}
	
	
	
	
	private void setupPanel()
	{
	
	this.setLayout(layout);
		
	
	}
	
	private void setupListeners()
	{
		
		
	}
	
	private void setupLayout()
	{
		
		
	}
}