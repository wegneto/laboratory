package codejam;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MilkshakesTest {

	@Test
	public void getBatchesForOneClientThatLikeOneFlavorUnmalted() {
		String output = (new Milkshakes()).getBatches(1, 1, new int[][] { { 1, 0 } });
		assertEquals("Case #1: 0 ", output);
	}

	@Test
	public void getBatchesForOneClientThatLikeTwoFlavorsUnmalted() {
		String output = (new Milkshakes()).getBatches(2, 1, new int[][] { { 1, 0, 2, 0 } });
		assertEquals("Case #1: 0 0 ", output);
	}

	@Test
	public void getBatchesForOneClientThatLikeTwoFlavorsOneMaltedBetweenFiveFlavors() {
		String output = (new Milkshakes()).getBatches(5, 1, new int[][] { { 1, 0, 4, 1 } });
		assertEquals("Case #1: 0 0 0 1 0 ", output);
	}

	@Test
	public void getBatchesForTwoClientsThatLikeThreeFlavorsBetweenFiveFlavors() {
		String output = (new Milkshakes()).getBatches(5, 2, new int[][] { { 1, 0 }, { 2, 0, 4, 0 } });
		assertEquals("Case #1: 0 0 0 0 0 ", output);
	}
	
	@Test
	public void getBatchesForTwoClientsThatLikeFourFlavorsOneMaltedBetweenFiveFlavors() {
		String output = (new Milkshakes()).getBatches(5, 2, new int[][] { { 1, 0, 3, 1 }, { 2, 0, 4, 0 } });
		assertEquals("Case #1: 0 0 1 0 0 ", output);
	}

}
