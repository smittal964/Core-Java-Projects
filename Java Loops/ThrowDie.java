package programs;

import java.util.Random;
import java.util.Scanner;

public class ThrowDie {

	public static void main(String[] args) {
		int numThrows;
		int seedNum;
		int counter = 0;
		int counterTwo;
		int faceVal;

		Scanner in = new Scanner(System.in);

		System.out.print("How many times to throw a die?: ");
		numThrows = in.nextInt();

		System.out.print("Enter seed: ");
		seedNum = in.nextInt();

		Random rand = new Random(seedNum);

		while (counter < numThrows) {

			counterTwo = counter + 1;
			System.out.print("Throw #" + counterTwo);

			faceVal = rand.nextInt(6) + 1;

			if (faceVal == 1) {
				System.out.print("\n...\n");
				System.out.print(".0.\n");
				System.out.print("...\n");
			} else if (faceVal == 2) {
				System.out.print("\n0..\n");
				System.out.print("...\n");
				System.out.print("..0\n");
			} else if (faceVal == 3) {
				System.out.print("\n0..\n");
				System.out.print(".0.\n");
				System.out.print("..0\n");
			} else if (faceVal == 4) {
				System.out.print("\n0.0\n");
				System.out.print("...\n");
				System.out.print("0.0\n");
			} else if (faceVal == 5) {
				System.out.print("\n0.0\n");
				System.out.print(".0.\n");
				System.out.print("0.0\n");
			} else if (faceVal == 6) {
				System.out.print("\n0.0\n");
				System.out.print("0.0\n");
				System.out.print("0.0\n");
			}
			counter++;

		} // while
		in.close();

	}// main

}
