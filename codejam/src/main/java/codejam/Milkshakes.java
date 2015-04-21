package codejam;

public class Milkshakes {

	public String getBatches(int numFlavors, int numCustomers, int[][] customerFlavors) {
		int[] result = new int[numFlavors];
		boolean[] satisfied = new boolean[numCustomers];
		boolean possible = true;
		boolean redo = true;

		while (redo && possible) {
			redo = false;
			for (int customer = 0; customer < numCustomers; customer++) {
				for (int cf = 0; cf < customerFlavors[customer].length; cf++) {
					int flavor = customerFlavors[customer][cf] - 1;
					int malted = customerFlavors[customer][++cf];

					if (result[flavor] == 0 && malted == 1) {
						result[flavor] = malted;
						redo = true;
					}

					satisfied[customer] = (result[flavor] == malted);
				}
			}

			if (!redo) {
				for (int i = 0; i < satisfied.length; i++) {
					possible = (possible && satisfied[i]);
				}
			}

		}

		StringBuilder output = new StringBuilder();
		output.append("Case #1: ");
		if (possible) {
			for (int i = 0; i < result.length; i++) {
				output.append(result[i] != -1 ? result[i] : 0).append(" ");
			}

		} else {
			output.append("IMPOSSIBLE");
		}

		return output.toString();
	}

}
