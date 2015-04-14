package codejam;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class MinimumScalarProductTest {
	
	@Test
	public void test1() {
		short[] array1 = {1,1};
		short[] array2 = {1,1};
		MinimumScalarProduct msp = new MinimumScalarProduct();
		short result = msp.calculate(array1, array2);
		assertEquals(2, result);
	}

}
