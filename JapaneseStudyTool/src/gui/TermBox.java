package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;

import backbone.Term;

public class TermBox extends JTextArea{
	public boolean added;
	public Term term;
	
	public TermBox(Term t) {
		setLineWrap(true);
		setWrapStyleWord(true);
		setColumns(1200/getColumnWidth());
		term = t;
		added = false;
		setText(term.toString());
		//setPreferredSize(new Dimension(300,50));
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
		setBorder(new BevelBorder(BevelBorder.RAISED,Color.WHITE,Color.GRAY));
		setVisible(true);
		
	}
	
	public TermBox(Term t, int w, int h) {
		setLineWrap(true);
		setWrapStyleWord(true);
		setColumns(1200/getColumnWidth());
		term = t;
		added = false;
		setText(term.toString());
		//setPreferredSize(new Dimension(w,h));
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
		setBorder(new BevelBorder(BevelBorder.RAISED,Color.WHITE, Color.RED, Color.BLUE, Color.GREEN));
		setVisible(true);
	}
}
