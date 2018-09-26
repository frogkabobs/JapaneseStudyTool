package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;


@SuppressWarnings("serial")
public class SearchPanel extends JPanel{
	private JScrollPane scroll;
	private JPanel viewport;
	private static  int max = 20;
	
	public SearchPanel(int w, int h,TermButton... t) {
		viewport = new JPanel();
		
		scroll = new JScrollPane(viewport);
		scroll.setPreferredSize(new Dimension(w,h-20));
		setPreferredSize(new Dimension(w, h));
		setBackground(Color.BLACK);
		setForeground(Color.GRAY);
		//setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
		
		viewport.setPreferredSize(new Dimension(w-20,h-30));
		viewport.setBackground(Color.BLACK);
		viewport.setFocusable(false);
		
		add(scroll);
		
		int count = 0;
		int vpHeight = h-30;
		for(TermButton term : t) {
			viewport.add(term);
			count++;
			if(count > max) {
				vpHeight += 55;
				viewport.setPreferredSize(new Dimension(w-20,vpHeight));
				max+=2;
			}
		}
		
		
		setVisible(true);
	}
}
