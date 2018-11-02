package gui;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import backbone.Term;
import javafx.collections.FXCollections;
import javafx.collections.transformation.SortedList;

public class SearchBar extends JTextArea {

	public SearchPanel search;
	
	public SearchBar(int w, int h, SearchPanel sp) {
		// TODO Auto-generated constructor stub
		search = sp;
		setPreferredSize(new Dimension(w, h));
		getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				handleSearchByKey();
				search.refresh();
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				handleSearchByKey();
				search.refresh();
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				handleSearchByKey();
				search.refresh();
			}

			});
		setVisible(true);
	}

	public void handleSearchByKey() {
		String newSearchTerm = getText();
	    // If the number of characters in the text box is less than last time
	    // it must be because the user pressed delete
	    /*if (newSearchTerm.length() < searchTerm.length()) {
	        // Restore the lists original set of entries 
	        // and start from the beginning
	        search.visibleTerms.terms = search.terms.terms;
	    }*/
	     
	    // Break out all of the parts of the search text 
	    // by splitting on white space
	    String[] parts = newSearchTerm.toUpperCase().split(", *");
	 
	    // Filter out the entries that don't contain the entered text
	    ArrayList<Term> subentries = new ArrayList<>();
	    for ( Term entry: search.terms.terms ) {
	        boolean match = true;
	        for ( String part: parts ) {
	            // The entry needs to contain all portions of the
	            // search string *but* in any order
	        	boolean bool = false;
	        	for(String s : entry.tags) bool |= s.toUpperCase().contains(part);
	            if (!bool) {
	                match = false;
	                break;
	            }
	        }
	 
	        if ( match ) {
	            subentries.add(entry);
	        }
	    }
	    search.visibleTerms.terms = new SortedList<Term>(FXCollections.observableArrayList(subentries.toArray(new Term[subentries.size()])),search.terms.terms.getComparator());
	}
	

}
