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
			result += (Short.parseShort(array1[i]) * Short.parseShort(array2[i]));
		}

		return result;
	}

	public StringBuffer parseInput(StringBuffer input) {
		String[] s = input.toString().split("\n");
		int caseNumber = 1;

		StringBuffer output = new StringBuffer();

		for (int i = 1; i < s.length; i = i + 3) {
			short result = this.calculate(s[i + 1], s[i + 2]);

			output.append("Case #").append(caseNumber).append(": ").append(result).append("\n");
			caseNumber++;
		}

		return output;
	}

}
