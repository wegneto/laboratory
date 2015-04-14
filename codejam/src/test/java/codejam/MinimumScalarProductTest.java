package codejam;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinimumScalarProductTest {

	@Test
	public void test1() {
		MinimumScalarProduct msp = new MinimumScalarProduct();
		short result = msp.calculate(new short[] { 1, 1 }, new short[] { 1, 1 });
		assertEquals(2, result);
	}

	@Test
	public void test2() {
		MinimumScalarProduct msp = new MinimumScalarProduct();
		short result = msp.calculate(new short[] { 1, 2 }, new short[] { 2, 1 });
		assertEquals(4, result);
	}

	@Test
	public void test3() {
		MinimumScalarProduct msp = new MinimumScalarProduct();
		short result = msp.calculate(new short[] { 1, 3, -5 }, new short[] { -2, 4, 1 });
		assertEquals(-25, result);
	}

}
