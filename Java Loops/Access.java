package programs;

import java.util.Scanner;

public class Access {

	private static void rotateOneLeft(int[] array) {
		int temp = array[0];
		int i;
		
		for(i = 0; i < array.length - 1; i++) {
			array[i] = array[i+1];
		}
		array[i] = temp;
	}
	
	private static void rotateOneRight(int[] array) {
		int temp = array[array.length-1];
		int i;
		
		for(i = array.length-1; i > 0; i--) {
			array[i] = array[i-1];
		}
		array[i] = temp;
	}
	
	public static void main(String[] args) {
		
		//rotateOneLeft
		int[] array = {1,2,3,4};
	
		rotateOneRight(array);
		rotateOneRight(array);
		//rotateOneLeft(array);
		//rotateOneLeft(array);
		
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		
		//filter
		/*int[] array = {0,1,2,3,4,5,6,7,8,9,10};
		int[] newArray = new int[9];
		int lowerLimit = 1;
		int upperLimit = 8;
		
		if(array == null) {
			throw new IllegalArgumentException();
		}else {
			for(int i = 0; i < array.length; i++) {
				if(array[i] >= lowerLimit && array[i] <= upperLimit) {
					newArray[i] = array[i];
				}
			}
		}
		for(int x = 0; x < newArray.length; x++) {
			System.out.print(newArray[x] + " ");
		}*/
		
		//getInstances
		/*int counter = 0;
		int[] array = {0,1,2,3,4,5};
		int lowerLimit = 1;
		int upperLimit = 5;
		
		if(array.equals(null)) {
			throw new IllegalArgumentException();
		}else {
			for(int i = 0; i < array.length; i++) {
				if(array[i] >= lowerLimit && array[i] <= upperLimit) {
					counter++;
				}
			}
			System.out.println(counter);
		}//else*/
		
		
		//getArrayString
		
		/*String arrayString = "";
		Character separator = ',';
		int[] array = {0,1,2,3,4,5};
		
		if(array == null) {
			throw new IllegalArgumentException();
		}else {
			if(array.length == 0) {
				System.out.println("Invalid");
			}else {
				for(int i = 0; i < array.length; i++) {
					if(i == 0) {
						arrayString = arrayString + array[i];
					}else {
						arrayString = arrayString + separator + array[i];
					}
				}//for
				System.out.println(arrayString);
			}//else
		}//else*/
		

	}// main

}
