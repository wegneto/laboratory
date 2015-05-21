package codejam;

import java.util.ArrayList;

public class AlienLanguage {

	private String[] getPossibilities(String testCase) {
		String string = testCase;
		String[] tokens = new String[3];
		int index = 0;

		for (int i = 0; i < string.length(); i++) {
			String c = Character.toString(string.charAt(i));

			if (c.equals("(")) {
				int closing = string.indexOf(")", i);
				tokens[index] = string.substring(i + 1, closing);
				i = closing;
			} else {
				tokens[index] = c;
			}

			System.out.println(tokens[index]);

			index++;
		}

		ArrayList<String> possibilities = new ArrayList<String>();

		for (int i = 0; i < tokens.length; i++) {
			String text = "";
			for (int j = 0; j < tokens[i].length(); j++) {
				System.out.println(tokens[j].charAt(j));
			}

		}

		return tokens;
	}

	public String evaluate(ArrayList<String> dictionary, String testCase) {
		int match = 0;

		if (dictionary.contains(testCase)) {
			match++;
		}

		return "Case #1: " + match;
	}

	public static void main(String[] args) {
		new AlienLanguage().getPossibilities("(ab)(bc)(ca)");
	}

}
