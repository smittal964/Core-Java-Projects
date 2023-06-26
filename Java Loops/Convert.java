package programs;

import java.util.Scanner;

public class Convert {

	public static void main(String[] args) {
		int userInput;
		int remainder;
		String answer = "";
		String realAnswer = "";

		Scanner in = new Scanner(System.in);

		System.out.print("Enter decimal number: ");
		userInput = in.nextInt();

		if (userInput == 0) {
			System.out.println("Octal value: " + '0');
		} else {
			while (userInput > 0) {
				remainder = userInput % 8;
				userInput = userInput / 8;

				answer = answer + Integer.toString(remainder);
				realAnswer = Support.reverseString(answer);
			}
			System.out.print("Octal value: " + realAnswer);
		}

		in.close();
	}

}
