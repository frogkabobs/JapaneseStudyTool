package gui;

import java.awt.Checkbox;
import java.awt.Color;

import javax.swing.JPanel;



public class TermBoxWrapper extends JPanel {
	TermBox termBox;
	Checkbox checkBox; //change to javafx
	
	public TermBoxWrapper(TermBox tb, Checkbox cb) {
		termBox =  tb;
		checkBox = cb;
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
		if(cb!= null) add(checkBox);
		add(tb);
		setVisible(true);
	}
	
	public TermBoxWrapper(TermBox tb) {
		this(tb,null);
	}
}
