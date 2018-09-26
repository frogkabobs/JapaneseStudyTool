package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

import backbone.Term;
import backbone.TermsList;
import javafx.scene.control.ListView;


@SuppressWarnings("serial")
public class SearchPanel extends JPanel{
	private JScrollPane scroll;
	private JPanel viewport;
	private static  int max = 20;
	final TermsList terms;
	//ListView<Term> visibleTerms;
	public TermsList visibleTerms;
	private int height,width;
	
	
	
	public SearchPanel(int w, int h,TermsList t) {
		terms = t;
		visibleTerms = new TermsList(t.terms);
		viewport = new JPanel();
		height = h;
		width = w;
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
		for(Term term : t.terms) {
			viewport.add(new TermButton(term));
			count++;
			if(count > max) {
				vpHeight += 55;
				viewport.setPreferredSize(new Dimension(w-20,vpHeight));
				max+=2;
			}
		}
		
		
		setVisible(true);
	}
	
	public void refresh() {
		viewport.removeAll();
		int count = 0;
		int vpHeight = height-30;
		for(Term term : visibleTerms.terms) {
			viewport.add(new TermButton(term));
			count++;
			if(count > max) {
				vpHeight += 55;
				viewport.setPreferredSize(new Dimension(width-20,vpHeight));
				max+=2;
			}
		}
		viewport.revalidate();
		viewport.repaint();
	}
}
