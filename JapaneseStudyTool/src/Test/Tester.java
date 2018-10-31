package Test;

import backbone.Term;
import backbone.TermsList;
import gui.SearchPanel;

public class Tester {

	
	public static SearchPanel sPanel() {
		return new SearchPanel(1265,720, new TermsList(new Term("Nがほしい",
				"Expresses the speaker’s wish for something (N).",
				"Wish", "desire", "want", "self", "[O]Noun", "[F]い-Adjective"), new Term(
				"NにV-てほしい", "Expresses the speaker’s wish or request for someone else (N) to do something (V). Cannot be used for the speaker’s own desires. Negative form of the verb or of ほしい can be used to say that the speaker wants others to not do something. ほしくない is used to criticize others when it is directed at them. んだけど or んだが can be added after ほしい to express a degree of hesitation, making it seem politer and softer.",
				"Wish","desire", "want", "others", "request", "don't", "prohibition","[O]Noun", "[O]Verb", "[O]Verb-て",
				"[F]い-Adjective, [O]negative"), new Term(
				"NがV-てほしい",
				"Expresses the speaker’s wish for an event (NがV) to take place. Use Nに rather than Nが when the object (N) is a person.",
				"Wish", "desire", "want",
				"[O]Noun, [O]Verb, [O]Verb-て", 
				"[F]い-Adjective"),
				new Term("...ほしがる", "Expresses another person's desire for something (...). Formed by replacing ほしい with ほしがる in a typical  ほしい grammar pattern.", "want", "desire", "wish", "others","[F]Verb", "[F]Verb-1"),
				new Term("V-いたい", "Expresses the subject's desire to do something (V).", "want", "desire", "wish", "others", "[O]Verb", "[O]Verb-い", "[F]い-Adjective"),
				new Term("Vまい/V-いまい","Means \"will not or must not do something (V)\". Negative volitional form. Can be used to express the speaker's strong desire not to do something when the speaker is the subject.", "wish", "desire", "want", "prohibition", "don't", "negative", "volitional", "[O]Verb"),
				new Term("V-てはいけない", "Means \"you can't do something (V)\".", "negative", "prohibition", "don't", "[O]Verb-て", "[F]い-Adjective"),
				new Term("V-てください", "Means \"please do something (V)\". Negative て form can be used to as someone to not do something.", "request", "negative", "prohibition", "don't", "[O]Verb-て", "[F]Verb-い")));
	}
}
