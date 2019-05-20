package textDataRead;

import java.util.Scanner;

public class ScannerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your name");
		String name = scan.nextLine();
		System.out.println(name);

		System.out.println("Enter your city");
		String city = scan.next();
		System.out.println(city);

		//phone number 
		System.out.println("Enter your phone number");
		long phno = scan.nextLong();
		System.out.println(phno);

		//enter a char
		System.out.println("Enter a charecter");
		char c = scan.next().charAt(1);
		System.out.println(c);

		// eNTER A LOGICAL VALUE
		System.out.println("Enter a logical value");
		boolean b = scan.nextBoolean();
		System.out.println(b);

	}

}
