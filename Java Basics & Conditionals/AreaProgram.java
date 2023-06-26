import java.util.Scanner;

public class AreaProgram {

	public static void main(String[] args) {
		double triBase;
		double triHeight;
		double triArea;
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter base: ");
		triBase = in.nextDouble();
		
		System.out.print("\nEnter height: ");
		triHeight = in.nextDouble();
		
		triArea = 0.5 * (triBase * triHeight);
		
		System.out.print("\nArea is: " + triArea);
		
		in.close();

	}

}
