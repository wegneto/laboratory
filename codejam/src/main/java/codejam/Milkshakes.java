package codejam;

public class Milkshakes {

	public String getBatches(int numFlavors, int numCustomers, int[][] customerFlavors) {
		int[] result = new int[numFlavors];

		for (int customer = 0; customer < numCustomers; customer++) {
			for (int flavor = 0; flavor < numFlavors; flavor++) {
				for (int i = 0; i < customerFlavors[customer].length; i = i + 2) {
					if (customerFlavors[customer][i] == (flavor + 1)) {
						result[flavor] = customerFlavors[customer][i + 1];
					}
				}
			}
		}

		StringBuilder output = new StringBuilder();
		for (int i = 0; i < result.length; i++) {
			output.append(result[i]).append(" ");
		}

		return "Case #1: " + output.toString();
	}
}
