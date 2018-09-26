package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import backbone.Term;

public class TermButton extends JPanel{
	public boolean added;
	public Term term;
	
	public TermButton(Term t) {
		added = false;
		setPreferredSize(new Dimension(300,50));
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
		setBorder(new BevelBorder(BevelBorder.RAISED,Color.WHITE,Color.GRAY));
		setVisible(true);
		
	}
	
	public TermButton(Term t, int w, int h) {
		added = false;
		setPreferredSize(new Dimension(w,h));
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
		setBorder(new BevelBorder(BevelBorder.RAISED,Color.WHITE, Color.RED, Color.BLUE, Color.GREEN));
		setVisible(true);
	}
}
