package loops;

/**
 * @author Dinesh Reddy
 *
 */
public class Loops01 {

	public static void main(String[] args) {

		System.out.println("  To print 1 to 10 numbers  ");
		for (int i = 1; i <= 10; i++) {
			// System.out.println("Printing 1 to 10 numbers");
			System.out.println(i);
		}

		System.out.println("   To print 10 to 1 number   ");
		for (int j = 10; j >= 1; j--) {
			if (j != 5) {
				System.out.println(j);
			}
		}

		System.out.println("  To print 1 to 5 numbers without 2 and 4  ");
		for (int k = 1; k <= 5; k++) {
			if ((k != 2) && (k != 4)) {
				System.out.println(k);
			}
		}

	}

}
