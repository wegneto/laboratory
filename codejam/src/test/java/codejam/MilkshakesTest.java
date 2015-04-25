package codejam;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class MilkshakesTest {

	@Test
	public void oneClientOneFlavorUnmalted() {
		String output = (new Milkshakes()).getBatches(1, 1, 1, new int[][] { { 1, 0 } });
		assertEquals("Case #1: 0", output);
	}

	@Test
	public void oneClientOneFlavorMalted() {
		String output = (new Milkshakes()).getBatches(1, 1, 1, new int[][] { { 1, 1 } });
		assertEquals("Case #1: 1", output);
	}

	@Test
	public void twoClientsOneFlavorUnmalted() {
		String output = (new Milkshakes()).getBatches(1, 1, 2, new int[][] { { 1, 0 }, { 1, 0 } });
		assertEquals("Case #1: 0", output);
	}

	@Test
	public void twoClientsOneFlavorMalted() {
		String output = (new Milkshakes()).getBatches(1, 1, 2, new int[][] { { 1, 1 }, { 1, 1 } });
		assertEquals("Case #1: 1", output);
	}

	@Test
	public void twoClientsOneFlavorLastMalted() {
		String output = (new Milkshakes()).getBatches(1, 1, 2, new int[][] { { 1, 0 }, { 1, 1 } });
		assertEquals("Case #1: IMPOSSIBLE", output);
	}

	@Test
	public void twoClientsOneFlavorFirstMalted() {
		String output = (new Milkshakes()).getBatches(1, 1, 2, new int[][] { { 1, 1 }, { 1, 0 } });
		assertEquals("Case #1: IMPOSSIBLE", output);
	}

	@Test
	public void twoClientsOneFlavorTwice() {
		String output = (new Milkshakes()).getBatches(1, 1, 2, new int[][] { { 1, 0, 1, 1 }, { 1, 0 } });
		assertEquals("Case #1: IMPOSSIBLE", output);
	}

	@Test
	public void twoClientsTwoFlavorsUnmalted() {
		String output = (new Milkshakes()).getBatches(1, 2, 2, new int[][] { { 1, 0, 2, 0 }, { 1, 0, 2, 0 } });
		assertEquals("Case #1: 0 0", output);
	}

	@Test
	public void twoClientsTwoFlavorsOneMalted() {
		String output = (new Milkshakes()).getBatches(1, 2, 2, new int[][] { { 1, 1, 2, 0 }, { 1, 0, 2, 0 } });
		assertEquals("Case #1: 1 0", output);
	}

	@Test
	public void twoClientsTwoFlavorsTwoMalted() {
		String output = (new Milkshakes()).getBatches(1, 2, 2, new int[][] { { 1, 1, 2, 1 }, { 1, 0, 2, 0 } });
		assertEquals("Case #1: IMPOSSIBLE", output);
	}

	@Test
	public void twoClientsTwoFlavorsThreeMalted() {
		String output = (new Milkshakes()).getBatches(1, 2, 2, new int[][] { { 1, 1, 2, 1 }, { 1, 1, 2, 0 } });
		assertEquals("Case #1: 1 1", output);
	}

	@Test
	public void twoClientsTwoFlavorsAllMalted() {
		String output = (new Milkshakes()).getBatches(1, 2, 2, new int[][] { { 1, 1, 2, 1 }, { 1, 1, 2, 1 } });
		assertEquals("Case #1: 1 1", output);
	}

	@Test
	public void twoClientsTwoFlavorsOneUnmaltedThreeMalted() {
		String output = (new Milkshakes()).getBatches(1, 2, 2, new int[][] { { 1, 0, 2, 1 }, { 1, 1, 2, 1 } });
		assertEquals("Case #1: 1 1", output);
	}

	@Test
	public void twoClientsTwoFlavorsTwoUnmaltedTwoMalted() {
		String output = (new Milkshakes()).getBatches(1, 2, 2, new int[][] { { 1, 0, 2, 0 }, { 1, 1, 2, 1 } });
		assertEquals("Case #1: IMPOSSIBLE", output);
	}

	@Test
	public void twoClientsTwoFlavorsThreeUnmaltedOneMalted() {
		String output = (new Milkshakes()).getBatches(1, 2, 2, new int[][] { { 1, 0, 2, 0 }, { 1, 0, 2, 1 } });
		assertEquals("Case #1: 0 1", output);
	}

	@Test
	public void threeClientsFiveFlavorsOneMalted() {
		String output = (new Milkshakes()).getBatches(1, 5, 3, new int[][] { { 1, 1 }, { 1, 0, 2, 0 }, { 5, 0 } });
		assertEquals("Case #1: 1 0 0 0 0", output);
	}

	@Test
	public void teste() {
		StringBuilder input = new StringBuilder();
		input.append("5\n");
		input.append("6\n");
		input.append("5 5 1 2 0 1 0 3 0 4 0\n");
		input.append("5 3 0 1 1 5 0 2 0 4 0\n");
		input.append("5 3 0 2 1 4 0 1 0 5 0\n");
		input.append("5 1 1 5 0 4 0 2 0 3 0\n");
		input.append("5 2 0 4 1 3 0 5 0 1 0\n");
		input.append("5 4 1 5 0 3 0 2 0 1 0\n");

		String[] lines = input.toString().split("\n");
		int qtyFlavors = Integer.parseInt(lines[0]);
		int qtyCustomers = Integer.parseInt(lines[1]);
		int[][] customerFlavors = new int[qtyCustomers][];

		for (int customer = 0, l = 2; customer < qtyCustomers; customer++, l++) {
			String[] line = lines[l].split(" ");
			int numCustFlavors = line.length - 1;
			customerFlavors[customer] = new int[numCustFlavors];
			for (int i = 1; i < line.length; i++) {
				customerFlavors[customer][i - 1] = Integer.parseInt(line[i]);
			}
		}
		
		String output = (new Milkshakes()).getBatches(1, qtyFlavors, qtyCustomers, customerFlavors);
		assertEquals("Case #1: 0 0 0 0 0", output);

	}

	@Test
	public void smallPractice() {
		try {
			URL resourceUrl = getClass().getResource("/B-small-practice.in");
			Path resourcePath = Paths.get(resourceUrl.toURI());

			long startTime = System.currentTimeMillis();
			(new Milkshakes()).parseFile(resourcePath.toString());
			long endTime = System.currentTimeMillis();

			long totalTime = endTime - startTime;

			assertTrue(totalTime < 180000);

		} catch (URISyntaxException e) {
			fail();
		}

	}

}
