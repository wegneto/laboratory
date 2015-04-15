package codejam;

import java.util.Arrays;
import java.util.Collections;

public class MinimumScalarProduct {

	public short calculate(String input1, String input2) {
		String[] array1 = input1.split(" ");
		String[] array2 = input2.split(" ");

		short result = 0;

		Arrays.sort(array1);
		Arrays.sort(array2, Collections.reverseOrder());

		for (int i = 0; i < array1.length; i++) {
			result += (Integer.parseInt(array1[i]) * Integer.parseInt(array2[i]));
		}

		return result;
	}

	public StringBuilder parseInput(StringBuilder input) {
		String[] s = input.toString().split("\n");
		int caseNumber = 1;

		StringBuilder output = new StringBuilder();

		for (int i = 1; i < s.length; i = i + 3) {
			int result = this.calculate(s[i + 1], s[i + 2]);

			output.append("Case #").append(caseNumber).append(": ").append(result).append("\n");
			caseNumber++;
		}

		return output;
	}

}
