package codejam;

import java.util.ArrayList;

public class AlienLanguage {

	public String evaluate(ArrayList<String> dictionary, String testCase) {
		int match = 0;
		
		if (dictionary.contains(testCase)) {
			match++;
		}
		
		return "Case #1: " + match;
	}

}
