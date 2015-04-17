package codejam;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MilkshakesTest {

	@Test
	public void getBatchesForThreeClientsAndFiveFlavors() {
		String output = (new Milkshakes()).getBatches();
		assertEquals("Case #1: 1 0 0 0 0", output);
	}
	
	@Test
	public void getBatchesForTwoClientsOneFlavorOneMalted() {
		String output = (new Milkshakes()).getBatches();
		assertEquals("Case #1: IMPOSSIBLE", output);
	}

}
