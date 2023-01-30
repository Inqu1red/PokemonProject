package poke.view;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import poke.controller.Controller;

public class PokePanel extends JPanel
{
	private Controller app;
	
	private SpringLayout layout;
	
	private JTextField nameField;
	private JTextField healthField;
	private JTextField numberField;
	
	private JCheckBox evolution;
	
	private JTextArea typesArea;
	private JScrollPane typePane;
	
	private JLabel 
	
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