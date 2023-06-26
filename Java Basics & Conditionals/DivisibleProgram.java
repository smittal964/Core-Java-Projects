import java.util.Scanner;

public class DivisibleProgram {

	public static void main(String[] args) {
		int firstNum;
		int secondNum;
		int remainder;
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter an integer: ");
		firstNum = in.nextInt();
		
		System.out.print("\nEnter a second integer: ");
		secondNum = in.nextInt();
		
		remainder = firstNum % secondNum;
		
		System.out.print("\nRemainder: " + remainder);
		
		if(remainder == 0) {
			System.out.println("\n" + firstNum + " is divisible by " + secondNum);
		}else
			System.out.println("\n" + firstNum + " is NOT divisible by " + secondNum);

		in.close();
	
	}//main

}//DivisbleProgram
