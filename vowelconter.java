package string;

public class vowelconter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "hello how are you doing today";
        int vowelCount = 0;

        // Convert the string to lowercase to handle both uppercase and lowercase vowels
        input = input.toLowerCase();

        // Loop through each character in the string
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            // Check if the character is a vowel
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowelCount++;
            }
        }

        // Print the total number of vowels
        System.out.println("Total number of vowels: " + vowelCount);{
    }


	}

}
