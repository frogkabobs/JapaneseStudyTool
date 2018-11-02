package backbone;

public class Flashcard extends Term {
	public TermsList terms;
	
	public Flashcard(TermsList tl, String s, String d, String... t) {
		super(s,d,t);
		terms = tl;
	}
	
	public Flashcard(Term tt, String s, String d, String... t) {
		super(s,d,t);
		terms = new TermsList(tt);
	}
	
	public Flashcard(String s, String d, String... t) {
		super(s,d,t);
		terms = new TermsList();
	}
	
	public void add(Term... t) {
		terms.add(t);
	}

}
