package codejam;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class MinimumScalarProduct {

	private long[] convertStringToLong(String array[]) {
		long longArray[] = new long[array.length];
		for (int i = 0; i < array.length; i++) {
			longArray[i] = Long.parseLong(array[i]);
		}
		return longArray;
	}

	public long calculate(String input1, String input2) {
		long[] array1 = this.convertStringToLong(input1.split(" "));
		long[] array2 = this.convertStringToLong(input2.split(" "));

		long result = 0;

		Arrays.sort(array1);
		Arrays.sort(array2);
		
		int n = array1.length;

		for (int i = 0; i < array1.length; i++) {
			result += (array1[i] * array2[(n - 1) - i]);
		}

		return result;
	}

	public StringBuilder parseInput(StringBuilder input) {
		String[] lines = input.toString().split("\n");
		int caseNumber = 1;

		StringBuilder output = new StringBuilder();

		for (int i = 1; i < lines.length; i = i + 3) {
			long result = this.calculate(lines[i + 1], lines[i + 2]);
			output.append("Case #").append(caseNumber).append(": ").append(result).append("\n");
			caseNumber++;
		}

		return output;
	}

	public void parseFile(String fileName) {
		Path path = Paths.get(fileName);
		StringBuilder input = new StringBuilder();

		try (Scanner scanner = new Scanner(path)) {
			while (scanner.hasNextLine()) {
				input.append(scanner.nextLine()).append("\n");
			}

			String output = this.parseInput(input).toString();
			String out = fileName.replaceAll(".in", ".out");

			writeLargerTextFile(out, output);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void writeLargerTextFile(String aFileName, String content) throws IOException {
		Path path = Paths.get(aFileName);
		try (BufferedWriter writer = Files.newBufferedWriter(path)) {
			writer.write(content);
		}
	}
	
}
