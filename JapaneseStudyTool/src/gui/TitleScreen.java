package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TitleScreen extends JPanel{

	public JButton termSearch;
	public JButton flashcards;
	int height;
	int width;
	
	public TitleScreen(int w, int h) {
		width = w;
		height = h;
		setLayout(null);
		setPreferredSize(new Dimension(w,h));
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
		termSearch = new JButton("Term Seach");
		flashcards = new JButton("Flashcards");
		termSearch.setBounds(w/2-200, h/2, 400, 50);
		flashcards.setBounds(w/2-200, h/2+75, 400, 50);
		add(termSearch);
		add(flashcards);
		termSearch.setVisible(true);
		flashcards.setVisible(true);
		setVisible(true);
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 50));
		FontMetrics metrics = g.getFontMetrics();
	    String text = "Japanese Study Tool";
	    g.drawString(text, (width - metrics.stringWidth(text)) / 2, ((height - metrics.getHeight()) / 2) + metrics.getAscent() - 200);
	}

}
