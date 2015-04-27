package codejam;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import codejam.util.FileUtil;

public class Milkshakes {

	public String getBatches(int test, int numFlavors, int numCustomers, int[][] customerFlavors) {
		int[] result = new int[numFlavors];
		boolean[][] satisfied = new boolean[numCustomers][numFlavors];
		boolean possible = true;
		boolean redo = true;

		while (redo) {
			redo = false;
			for (int customer = 0; customer < numCustomers; customer++) {
				for (int cf = 0; cf < customerFlavors[customer].length; cf++) {
					int flavor = customerFlavors[customer][cf] - 1;
					int malted = customerFlavors[customer][++cf];

					if (result[flavor] == 0 && malted == 1) {
						result[flavor] = malted;
						redo = true;
					}

					satisfied[customer][flavor] = (result[flavor] == malted);
				}
			}

			if (!redo) {
				for (int customer = 0; customer < satisfied.length; customer++) {
					boolean temp = false;
					for (int flavor = 0; flavor < satisfied[customer].length; flavor++) {
						temp = temp || satisfied[customer][flavor];
					}
					possible = (possible && temp);
				}
			}

		}

		StringBuilder output = new StringBuilder();
		output.append("Case #").append(test).append(":");
		if (possible) {
			for (int i = 0; i < result.length; i++) {
				output.append(" ");
				output.append(result[i] != -1 ? result[i] : 0);
			}

		} else {
			output.append(" IMPOSSIBLE");
		}

		return output.toString();
	}

	public void parseFile(String fileName) {
		Path path = Paths.get(fileName);
		StringBuilder output = new StringBuilder();

		try (Scanner scanner = new Scanner(path)) {
			int numTest = scanner.nextInt();

			for (int test = 1; test <= numTest; test++) {
				int numFlavor = scanner.nextInt();
				int numCustomer = scanner.nextInt();
				int[][] customerFlavors = new int[numCustomer][];

				for (int customer = 0; customer < numCustomer; customer++) {
					int numCustFlavors = scanner.nextInt() * 2;
					customerFlavors[customer] = new int[numCustFlavors];
					for (int custFlavors = 0; custFlavors < numCustFlavors; custFlavors++) {
						customerFlavors[customer][custFlavors] = scanner.nextInt();
					}
				}
				
				output.append(this.getBatches(test, numFlavor, numCustomer, customerFlavors)).append("\n");
			}

			String out = fileName.replaceAll(".in", ".out");

			FileUtil.writeLargerTextFile(out, output.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
