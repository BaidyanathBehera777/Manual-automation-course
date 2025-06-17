package string;

public class stringpallimdrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "madam";
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
	}
        System.out.println(reversed);
        if (str.equals(reversed)) {
            System.out.println(str + " is a palindrome.");
        } else {
            System.out.println(str + " is not a palindrome.");

	}
	}
	
}
	
	
