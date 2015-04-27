package codejam;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;


public class ReverseWordsTest {
	
	@Test
	public void test1() {
		String expected = "test a is this";
		String output = (new ReverseWords()).reverse("this is a test");
		
		assertEquals(expected, output);
	}

	@Test
	public void test2() {
		String expected = "foobar";
		String output = (new ReverseWords()).reverse("foobar");
		
		assertEquals(expected, output);
	}
	
	@Test
	public void test3() {
		String expected = "all your base";
		String output = (new ReverseWords()).reverse("base your all");
		
		assertEquals(expected, output);
	}
	
	@Test
	public void fourthTest() {
		StringBuilder expected = new StringBuilder();
		expected.append("Case #1: test a is this\n");
		expected.append("Case #2: foobar\n");
		expected.append("Case #3: base your all\n");

		try {
			URL resourceUrl = getClass().getResource("/reverse-words-input.in");
			Path resourcePath = Paths.get(resourceUrl.toURI());
			String output = (new ReverseWords()).getOutput(resourcePath.toString());

			assertEquals(expected.toString(), output);
		} catch (URISyntaxException e) {
			fail();
		}

	}

}
