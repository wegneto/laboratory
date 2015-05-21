package codejam;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class AlienLanguageTest {

	private ArrayList<String> loadDictionary(String[] words) {
		ArrayList<String> dictionary = new ArrayList<String>();
		for (int i = 0; i < words.length; i++) {
			dictionary.add(words[i]);
		}

		return dictionary;
	}

	@Test
	public void oneWordInTheDictionary() {
		ArrayList<String> dictionary = this.loadDictionary(new String[] { "abc", "bca", "dac", "dbc", "cba" });
		String testCase = "abc";

		String output = (new AlienLanguage()).evaluate(dictionary, testCase);
		Assert.assertEquals("Case #1: 1", output);
	}

	@Test
	public void noWordInTheDictionary() {
		ArrayList<String> dictionary = this.loadDictionary(new String[] { "abc", "bca", "dac", "dbc", "cba" });
		String testCase = "acb";

		String output = (new AlienLanguage()).evaluate(dictionary, testCase);
		Assert.assertEquals("Case #1: 0", output);
	}
	
	@Test
	public void combinationInTheDictionary() {
		ArrayList<String> dictionary = this.loadDictionary(new String[] { "abc", "bca", "dac", "dbc", "cba" });
		String testCase = "(ab)(bc)(ca)";

		String output = (new AlienLanguage()).evaluate(dictionary, testCase);
		Assert.assertEquals("Case #1: 2", output);
	}

}
