package gui;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import backbone.Term;
import backbone.TermsList;


@SuppressWarnings("serial")
public class SearchPanel extends WrapperPanel{
	private SearchBar search;
	private JScrollPane scroll;
	private JPanel viewport;
	private static  int max = 20;
	final TermsList terms;
	//add searchbar in here
	public TermsList visibleTerms;
	public ArrayList<TermBoxWrapper> boxes = new ArrayList<>();
	private int height,width;
	boolean checkboxes; ///get rid of this
	public JButton addToFlashcards;
	
	
	
	public SearchPanel(int w, int h,TermsList t, boolean b) {
		checkboxes = b;
		terms = t;
		visibleTerms = new TermsList(t.terms);
		viewport = new JPanel();
		addToFlashcards = new JButton("Add to falshcards");
		height = h;
		width = w;
		scroll = new JScrollPane(viewport);
		scroll.setPreferredSize(new Dimension(w,h-90));
		setPreferredSize(new Dimension(w, h));
		setBackground(Color.BLACK);
		setForeground(Color.GRAY);
		//setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
		
		viewport.setPreferredSize(new Dimension(w-20,2*h-100)); // fix this
		viewport.setBackground(Color.BLACK);
		viewport.setFocusable(false);
		
		add(search = new SearchBar(w, 20, this));
		add(scroll);
		add(addToFlashcards);
		
		int count = 0;
		int vpHeight = h-100;
		for(Term term : t.terms) {
			TermBoxWrapper tb = new TermBoxWrapper(new TermBox(term), new Checkbox());
			viewport.add(tb);
			boxes.add(tb);
			count++;
			if(count > max) { //fix this whole max thing
				vpHeight += 55;
				viewport.setPreferredSize(new Dimension(w-20,vpHeight));
				max+=2;
			}
		}
		
		
		setVisible(true);
	}
	
	public void refresh() {
		viewport.removeAll();
		boxes.clear();
		int count = 0;
		int vpHeight = height-100;
		for(Term term : visibleTerms.terms) {
			TermBoxWrapper tb = new TermBoxWrapper(new TermBox(term), new Checkbox());
			viewport.add(tb);
			boxes.add(tb);
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
