package codejam;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class StoreCreditTest {

	@Test
	public void firstTest() {
		int amountOfCredit = 100;
		int[] priceList = { 5, 75, 25 };

		String output = (new StoreCredit()).calculate(amountOfCredit, priceList);
		assertEquals("2 3", output);
	}

	@Test
	public void secondTest() {
		int amountOfCredit = 200;
		int[] priceList = { 150, 24, 79, 50, 88, 345, 3 };

		String output = (new StoreCredit()).calculate(amountOfCredit, priceList);
		assertEquals("1 4", output);
	}

	@Test
	public void thirdTest() {
		int amountOfCredit = 8;
		int[] priceList = { 2, 1, 9, 4, 4, 56, 90, 3 };

		String output = (new StoreCredit()).calculate(amountOfCredit, priceList);
		assertEquals("4 5", output);
	}

	@Test
	public void fourthTest() {
		StringBuilder expected = new StringBuilder();
		expected.append("Case #1: 2 3\n");
		expected.append("Case #2: 1 4\n");
		expected.append("Case #3: 4 5\n");

		try {
			URL resourceUrl = getClass().getResource("/store-credit-input.in");
			Path resourcePath = Paths.get(resourceUrl.toURI());
			String output = (new StoreCredit()).getOutput(resourcePath.toString());

			assertEquals(expected.toString(), output);
		} catch (URISyntaxException e) {
			fail();
		}

	}

}
