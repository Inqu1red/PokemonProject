package poke.view;

import poke.controller.Controller;
import javax.swing.JFrame;

public class PokeFrame extends JFrame
{
private Controller app;
private PokePanel panel;

public PokeFrame(Controller app)
{
	super();
	this.app = app;
	this.panel = new PokePanel(this.app);
	
	
	setupFrame();
}


private void setupFrame()
{
	this.setContentPane(panel);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setTitle("");
	this.setSize(1024, 768);
	this.setResizable(true);
	
	
	this.setVisible(true);
}



}
