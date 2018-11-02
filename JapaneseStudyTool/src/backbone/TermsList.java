package backbone;

import java.io.Serializable;
import java.util.Comparator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;

public class TermsList implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SortedList<Term> terms;
	public ObservableList<Term> baseList;
	
	public TermsList(Term... t) {
		baseList = FXCollections.observableArrayList(t);
		terms = new SortedList<>(baseList, (u,v) -> Comparator.comparing(String::toString).compare(u.term, v.term));
	}
	
	public TermsList(SortedList<Term> t) {
		terms = t;
	}
	
	public void sort(Comparator c) {
		terms.setComparator(c);
	}
	
	public void add(Term... t) {
		baseList.addAll(t);
	}

}
