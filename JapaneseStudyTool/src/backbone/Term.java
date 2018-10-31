package backbone;

public class Term {
	public String term;
	public String description;
	public String[] tags;
	public String[] keyTranslation;
	public int type = 0; //type 0 - regular, type 1 - optional PoS in expression, type 2 - PoS of expression
	//change that for tags
	public Term(String s, String d, String... t) {
		term = s;
		description = d;
		tags = t; 
	}
	
	public Term(String s, String d, int ty, String... t) {
		term = s;
		description = d;
		tags = t; 
		type = ty;
	}
	
	public String toString() {
		return term + "\n" + description + "\n\nTags: " + String.join(", ", tags);
	}
	
	
}
