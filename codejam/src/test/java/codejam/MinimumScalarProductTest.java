package codejam;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinimumScalarProductTest {

	@Test
	public void treatInputWithSameValues() {
		MinimumScalarProduct msp = new MinimumScalarProduct();
		short output = msp.treatInput("2 2", "2 2");
		assertEquals(8, output);
	}

	@Test
	public void treatInputWithDifferentValues() {
		MinimumScalarProduct msp = new MinimumScalarProduct();
		short output = msp.treatInput("2 3", "2 3");
		assertEquals(12, output);
	}

	@Test
	public void treatInputWithDifferentValuesOutOfOrder() {
		MinimumScalarProduct msp = new MinimumScalarProduct();
		short output = msp.treatInput("1 3 -5", "-2 4 1");
		assertEquals(-25, output);
	}

	@Test
	public void treatMultipeLinesInput() {
		StringBuffer input = new StringBuffer();
		input.append("2\n");
		input.append("3\n");
		input.append("1 3 -5\n");
		input.append("-2 4 1\n");
		input.append("5\n");
		input.append("1 2 3 4 5\n");
		input.append("1 0 1 0 1\n");
		String output = (new MinimumScalarProduct()).parseInput(input.toString());

		StringBuffer expectedOutput = new StringBuffer();
		expectedOutput.append("Case #1: -25\n");
		expectedOutput.append("Case #2: 6\n");
		
		assertEquals(expectedOutput.toString(), output);
	}

}
