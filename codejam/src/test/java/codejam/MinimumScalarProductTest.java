package codejam;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.Random;
import java.util.stream.IntStream;

import org.junit.Test;

public class MinimumScalarProductTest {

	@Test
	public void treatInputWithSameValues() {
		MinimumScalarProduct msp = new MinimumScalarProduct();
		short output = msp.calculate("2 2", "2 2");
		assertEquals(8, output);
	}

	@Test
	public void treatInputWithDifferentValues() {
		MinimumScalarProduct msp = new MinimumScalarProduct();
		short output = msp.calculate("2 3", "2 3");
		assertEquals(12, output);
	}

	@Test
	public void treatInputWithDifferentValuesOutOfOrder() {
		MinimumScalarProduct msp = new MinimumScalarProduct();
		short output = msp.calculate("1 3 -5", "-2 4 1");
		assertEquals(-25, output);
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

		StringBuffer expectedOutput = new StringBuffer();
		expectedOutput.append("Case #1: -25\n");
		expectedOutput.append("Case #2: 6\n");

		assertEquals(expectedOutput.toString(), output.toString());
	}

	@Test
	public void parseSmallDataset() {
		Random randomGenerator = new Random();
		IntStream is = randomGenerator.ints(-1000, 1001);
		Iterator<Integer> it = is.iterator();

		StringBuilder input = new StringBuilder();
		input.append("1000\n");

		for (int t = 1; t < 1001; t++) {
			int n = randomGenerator.nextInt(8) + 1;
			input.append(n).append("\n");

			for (int i = 0; i < (n * 2); i++) {
				input.append(it.next()).append(" ");
				if ((i == (n - 1)) || (i == ((n * 2) - 1))) {
					input.append("\n");
				}
			}

		}
		
		StringBuilder output = (new MinimumScalarProduct()).parseInput(input);
		System.out.println(output.toString());
	}
	
	@Test
	public void parseBigDataset() {
		Random randomGenerator = new Random();
		IntStream is = randomGenerator.ints(-100000, 100001);
		Iterator<Integer> it = is.iterator();

		StringBuilder input = new StringBuilder();
		input.append("10\n");

		for (int t = 1; t < 11; t++) {
			int n = randomGenerator.nextInt(800) + 1;
			input.append(n).append("\n");

			for (int i = 0; i < (n * 2); i++) {
				input.append(it.next()).append(" ");
				if ((i == (n - 1)) || (i == ((n * 2) - 1))) {
					input.append("\n");
				}
			}

		}
		
		StringBuilder output = (new MinimumScalarProduct()).parseInput(input);
		System.out.println(output.toString());
	}

}
