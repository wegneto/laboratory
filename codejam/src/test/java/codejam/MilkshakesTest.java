package codejam;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MilkshakesTest {

	@Test
	public void test1() {
		String output = (new Milkshakes()).getOutput();
		assertEquals("Case #1: 1 0 0 0 0", output);
	}

}
