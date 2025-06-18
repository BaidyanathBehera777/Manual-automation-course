package string;

import java.util.Scanner;

public class repetativenumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		 System.out.print("Enter a string: ");
	        String input = sc.nextLine();
	        System.out.print("Enter a character to count: ");
	        char targetChar = sc.next().charAt(0);
	        int count = 0;

	        // Loop to count occurrences
	        for (int i = 0; i < input.length(); i++) {
	            if (input.charAt(i) == targetChar) {
	                count++;
	            }
	        }
	        {
	        System.out.println("Character '" + targetChar + "' appears " + count + " times.");
	        sc.close();
	    }
}
	}


