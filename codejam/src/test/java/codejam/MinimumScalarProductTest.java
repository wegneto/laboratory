package codejam;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;

public class MinimumScalarProductTest {

	@Test
	public void calculateSimplestInput() {
		MinimumScalarProduct msp = new MinimumScalarProduct();
		long output = msp.calculate("1 1", "1 1");
		assertEquals(2, output);
	}
	
	@Test
	public void calculateInputWithDifferentNumbers() {
		MinimumScalarProduct msp = new MinimumScalarProduct();
		long output = msp.calculate("1 2", "3 4");
		assertEquals(10, output);
	}

	@Test
	public void calculateInputWithNegativeNumbers() {
		MinimumScalarProduct msp = new MinimumScalarProduct();
		long output = msp.calculate("1 3 -5", "-2 4 1");
		assertEquals(-25, output);
	}
	
	@Test
	public void calculateInputWithTwoNegativeNumbers() {
		MinimumScalarProduct msp = new MinimumScalarProduct();
		long output = msp.calculate("-5 3 1", "-2 -4 1");
		assertEquals(-19, output);
	}

	@Test
	public void treatMultipleLinesInput() {
		StringBuilder input = new StringBuilder();
		input.append("2\n");
		input.append("3\n");
		input.append("1 3 -5\n");
		input.append("-2 4 1\n");
		input.append("5\n");
		input.append("1 2 3 4 5\n");
		input.append("1 0 1 0 1\n");
		StringBuilder output = (new MinimumScalarProduct()).parseInput(input);

		StringBuilder expectedOutput = new StringBuilder();
		expectedOutput.append("Case #1: -25\n");
		expectedOutput.append("Case #2: 6\n");

		assertEquals(expectedOutput.toString(), output.toString());
	}

	@Test
	public void parseSmallDataset() {
		try {
			parseFile("/A-small-practice.in");
		} catch (URISyntaxException e) {
			Assert.fail();
		}
	}

	@Test
	public void parseBigDataset() {
		try {
			parseFile("/A-large-practice.in");
		} catch (URISyntaxException e) {
			Assert.fail();
		}
	}

	private void parseFile(String fileName) throws URISyntaxException {
		URL resourceUrl = getClass().getResource(fileName);
		Path resourcePath = Paths.get(resourceUrl.toURI());
		
		long startTime = System.currentTimeMillis();
		(new MinimumScalarProduct()).parseFile(resourcePath.toString());
		long endTime = System.currentTimeMillis();
		
		long totalTime = endTime - startTime;
		
		assertTrue(totalTime < 180000);
	}
	
}
