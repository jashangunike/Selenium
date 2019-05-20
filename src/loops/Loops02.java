package loops;

public class Loops02 {

	public static void main(String[] args) {
		// While loop - it repeates the block of statements while condition is
		// true

		System.out.println("To print 1 to 10 numbers using while loop");
		int i = 1;
		while (i <= 10) {
			System.out.println(i);
			i++;
		}

		System.out.println("to print 10 to 1 numbers using while loop");

		int k = 10;
		while (k >= 1) {
			System.out.println(k);
			k--;
		}

		System.out.println("to print 10 to 1 numbers without 5,6 using while loop");

		int g = 10;
		while (g >= 1) {
			if ((g!=5) && (g!=6)){
			System.out.println(g);
		}
			g--;
		}
		
		
	}}


