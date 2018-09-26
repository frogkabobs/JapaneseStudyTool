package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;

import backbone.Term;

public class TermButton extends JTextArea{
	public boolean added;
	public Term term;
	
	public TermButton(Term t) {
		setLineWrap(true);
		setColumns(1200/getColumnWidth());
		term = t;
		added = false;
		setText(term.term + "\n" + term.description + "\n\nTags: " + String.join(",", term.tags));
		//setPreferredSize(new Dimension(300,50));
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
		setBorder(new BevelBorder(BevelBorder.RAISED,Color.WHITE,Color.GRAY));
		setVisible(true);
		
	}
	
	public TermButton(Term t, int w, int h) {
		setLineWrap(true);
		setColumns(1200/getColumnWidth());
		term = t;
		added = false;
		setText(term.term + "\n" + term.description + "\n\nTags: " + String.join(",", term.tags));
		//setPreferredSize(new Dimension(w,h));
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
		setBorder(new BevelBorder(BevelBorder.RAISED,Color.WHITE, Color.RED, Color.BLUE, Color.GREEN));
		setVisible(true);
	}
}
