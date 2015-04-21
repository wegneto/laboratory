package codejam;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MilkshakesTest {

	@Test
	public void oneClientOneFlavorUnmalted() {
		String output = (new Milkshakes()).getBatches(1, 1, new int[][] { { 1, 0 } });
		assertEquals("Case #1: 0 ", output);
	}

	@Test
	public void oneClientOneFlavorMalted() {
		String output = (new Milkshakes()).getBatches(1, 1, new int[][] { { 1, 1 } });
		assertEquals("Case #1: 1 ", output);
	}

	@Test
	public void twoClientsOneFlavorUnmalted() {
		String output = (new Milkshakes()).getBatches(1, 2, new int[][] { { 1, 0 }, { 1, 0 } });
		assertEquals("Case #1: 0 ", output);
	}
	
	@Test
	public void twoClientsOneFlavorMalted() {
		String output = (new Milkshakes()).getBatches(1, 2, new int[][] { { 1, 1 }, { 1, 1 } });
		assertEquals("Case #1: 1 ", output);
	}
	
	@Test
	public void twoClientsOneFlavorLastMalted() {
		String output = (new Milkshakes()).getBatches(1, 2, new int[][] { { 1, 0 }, { 1, 1 } });
		assertEquals("Case #1: IMPOSSIBLE", output);
	}
	
	@Test
	public void twoClientsOneFlavorFirstMalted() {
		String output = (new Milkshakes()).getBatches(1, 2, new int[][] { { 1, 1 }, { 1, 0 } });
		assertEquals("Case #1: IMPOSSIBLE", output);
	}
	
	@Test
	public void twoClientsOneFlavorTwice() {
		String output = (new Milkshakes()).getBatches(1, 2, new int[][] { { 1, 0, 1, 1 }, { 1, 0 } });
		assertEquals("Case #1: IMPOSSIBLE", output);
	}

}
