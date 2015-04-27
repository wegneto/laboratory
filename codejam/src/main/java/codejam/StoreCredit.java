package codejam;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import codejam.util.FileUtil;

public class StoreCredit {

	public String calculate(int amountOfCredit, int[] priceList) {
		String output = "";
		
		for (int i = 0; i < priceList.length - 1; i++) {
			for (int j = i + 1; j < priceList.length; j++) {
				if (priceList[i] + priceList[j] == amountOfCredit) {
					output = (i + 1) + " " + (j + 1);
				}
			}
		}

		return output;
	}

	public String getOutput(String fileName) {
		Path path = Paths.get(fileName);
		StringBuilder output = new StringBuilder();

		try (Scanner scanner = new Scanner(path)) {
			int numberOfCases = scanner.nextInt();

			for (int testCase = 1; testCase <= numberOfCases; testCase++) {
				int amountOfCredit = scanner.nextInt();
				int numberOfItems = scanner.nextInt();
				int[] priceList = new int[numberOfItems];
				
				for (int i = 0; i < numberOfItems; i++) {
					priceList[i] = scanner.nextInt();
				}
				
				output.append("Case #").append(testCase).append(": ");
				output.append(calculate(amountOfCredit, priceList));
				output.append("\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return output.toString();
	}
	
	public static void main(String[] args) {
		try {
			URL resourceUrl = StoreCredit.class.getResource("/store-credit-large-practice.in");
			Path resourcePath = Paths.get(resourceUrl.toURI());
			
			StoreCredit storeCredit = new StoreCredit();
			String output = storeCredit.getOutput(resourcePath.toString());
			
			String outputFile = resourcePath.toString().replaceAll(".in", ".out");

			FileUtil.writeLargerTextFile(outputFile, output);
		} catch (URISyntaxException e) {
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
