package codejam;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReverseWords {

	public String reverse(String input) {
		String[] inputArray = input.split(" ");

		if (inputArray.length == 1) {
			return input;
		} else {
			StringBuilder output = new StringBuilder();
			for (int i = inputArray.length - 1; i >= 0; i--) {
				output.append(i != inputArray.length - 1 ? " " : "");
				output.append(inputArray[i]);
			}
			return output.toString();
		}
	}
	
	public String getOutput(String fileName) {
		Path path = Paths.get(fileName);
		StringBuilder output = new StringBuilder();

		try (Scanner scanner = new Scanner(path)) {
			int numberOfCases = scanner.nextInt();
			scanner.nextLine();

			for (int testCase = 1; testCase <= numberOfCases; testCase++) {
				String sentence = scanner.nextLine();
				
				output.append("Case #").append(testCase).append(": ");
				output.append(reverse(sentence));
				output.append("\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return output.toString();
	}

}
