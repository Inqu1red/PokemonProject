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
import java.awt.Label;
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
	
	private JCheckBox evolveBox;
	
	private JTextArea typesArea;
	private JScrollPane typePane;
	
	private JLabel nameLabel;
	private JLabel numberLabel;
	private JLabel healthLabel;
	
	private JButton updateButton;
	
	private JPanel fieldPanel;
	
	private JLabel imageLabel;
	private ImageIcon icon;
	private JComboBox<String> pokedexSelector;
	
	
	public PokePanel(Controller app)
	{
		super();
		this.app = app;
		
		this.layout = new SpringLayout();
		this.nameField = new JTextField("Name");
		this.numberField = new JTextField("Number");
		this.healthField = new JTextField("Health");
		
		this.evolveBox = new JCheckBox("Pokemon Can evolve", false);
		this.typesArea = new JTextArea(20, 20);
		this.typePane = new JScrollPane();
		
		this.nameLabel = new JLabel("Pokemon Name:");
		this.numberLabel = new JLabel("Pokedex #:");
		this.healthLabel = new JLabel("Pokemon Health:");
		
		this.updateButton = new JButton("Update Pokemon");
		
		this.fieldPanel = new JPanel(new GridLayout(0, 2));
		
		this.imageLabel = new JLabel("PlaceHolder");
		this.icon = new ImageIcon();
		this.pokedexSelector = new JComboBox<String>();
		
		
		
		setupPanel();
		setupListeners();
		setupLayout();
	}
	
	
	
	
	private void setupPanel()
	{
	
	this.setBackground(Color.MAGENTA);
	this.setLayout(layout);
	
	this.setPreferredSize(new Dimension(1024, 768));
	
	this.fieldPanel.add(nameLabel);
	this.fieldPanel.add(nameField);
	
	this.fieldPanel.add(numberLabel);
	this.fieldPanel.add(numberField);
	
	this.fieldPanel.add(healthLabel);
	this.fieldPanel.add(healthField);
	
	this.fieldPanel.add(evolveBox);
	this.fieldPanel.add(typePane);
	this.fieldPanel.add(updateButton);
	
	
	typePane.setViewportView(typesArea);
	typesArea.setEditable(false);
	numberField.setEditable(false);
	
	typePane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	typePane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	
	
	imageLabel.setVerticalTextPosition(JLabel.BOTTOM);
	imageLabel.setHorizontalTextPosition(Label.CENTER);
	
	this.add(fieldPanel);
	this.add(imageLabel);
	this.add(pokedexSelector);
	
	updateDisplay("");
	
	}
	
	private void setupListeners()
	{
		
		updateButton.addActionListener(click -> collectInput());
	}
	
	
	private void updateDisplay(String name)
	{
		
		String path = "/poke/view/images";		
		String defaultName = "Rowlet";
		String extension = ".png";
		
		try
		{
			icon = new ImageIcon(getClass().getResource(path + name + extension));
		}
		catch(NullPointerException missingFile)
		{
			icon = new ImageIcon(getClass().getResource(path + defaultName + extension) );
		}
		
	
	}
	
	
	private void collectInput()
	{
		String name = nameField.getText();
		String health = healthField.getText();
		boolean canEvolve = evolveBox.isSelected();
		int selectedPokemonIndex = pokedexSelector.getSelectedIndex();
		
		if(app.validateNumber(health))
		{
			int healthValue = Integer.parseInt(health);
			
			app.updateCurrentPokemon(name, selectedPokemonIndex, healthValue, canEvolve);
			
			
		}
		
	}
	
	private void setupLayout()
	{
		layout.putConstraint(SpringLayout.WEST, fieldPanel, -350, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.EAST, fieldPanel, -25, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.NORTH, fieldPanel, 25, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, fieldPanel, -25, SpringLayout.SOUTH, this);
		
		layout.putConstraint(SpringLayout.NORTH, imageLabel, 150, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, imageLabel, 150, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, imageLabel, -100, SpringLayout.WEST, fieldPanel);
		
		layout.putConstraint(SpringLayout.WEST, pokedexSelector, 150, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, pokedexSelector, -150, SpringLayout.WEST, fieldPanel);
		layout.putConstraint(SpringLayout.SOUTH, pokedexSelector, -150, SpringLayout.SOUTH, this);
		
		
	}
}