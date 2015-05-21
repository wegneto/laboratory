package codejam;

import org.junit.Assert;
import org.junit.Test;

public class AlienLanguageTest {
	
	@Test
	public void firstTest() {
		String[] dictionary = {"abc", "bca", "dac", "dbc", "cba"};
		String testCase = "abc";
		
		String output = (new AlienLanguage()).evaluate(dictionary, testCase);
		Assert.assertEquals("Case #1: 1", output);
	}

}
