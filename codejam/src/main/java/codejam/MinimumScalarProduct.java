package codejam;

import java.util.Arrays;
import java.util.Collections;

public class MinimumScalarProduct {

	public short calculate(short[] array1, short[] array2) {
		short result = 0;
		
		Arrays.sort(array1);

		for (int i = 0; i < array1.length; i++) {
			result += (array1[i] * array2[i]);
		}

		return result;
	}

}
