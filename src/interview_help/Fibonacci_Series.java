package interview_help;

import java.util.Scanner;

import org.testng.annotations.Test;

/**
 * @author Dinesh Kumar Reddy 
 * About Test : - In Fibonacci series, next number is
 *         the sum of previous two numbers for example 0, 1, 1, 2, 3, 5, 8, 13,
 *         21, 34, 55 etc. The first two numbers of Fibonacci series are 0 and 1.
 * 
 *         My note : - There are many ways to write Fibonacci series program
 *         below are few examples
 */
public class Fibonacci_Series {
	// ********* i know example03 you can remember this method is enough 
		@Test(priority = 3)
		public void Fibonacci_Example03() {
			// Another method
			int febCount = 15;
			int[] feb = new int[febCount];
			feb[0] = 0;
			feb[1] = 1;
			for (int i = 2; i < febCount; i++) {
				feb[i] = feb[i - 1] + feb[i - 2];
			}

			for (int i = 0; i < febCount; i++) {
				System.out.print(feb[i] + " ");
			}
		}
		
	@Test(priority = 1)
	public void Fibonacci_Example01() {
		int n, a = 0, b = 0, c = 1;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter value of n:");
		// enter the value for example 5 it will display 5 Fibonacci series
		// values. or enter 50 etc...
		n = s.nextInt();
		System.out.println("Fibonacci Series:");
		for (int i = 1; i <= n; i++) {
			a = b;
			b = c;
			c = a + b;
			System.out.println(a + " ");
		}
	}

	@Test(priority = 2)
	public void Fibonacci_Example02() {
		// same as like above just reference names are changed
		
			int i, no, first = 0, second = 1, next;
			Scanner s = new Scanner(System.in);
			System.out.println("Enter number of terms for Series: ");
			no = s.nextInt();
			first = 0;
			second = 1;
			System.out.println("Fibonacci series are: ");
			for (i = 0; i < no; i++) {
				System.out.println(first);
				next = first + second;
				first = second;
				second = next;
			
		}
	}


	//////////// ************** From Java Point WebSite **************////////////
	/**
	 * There are two ways to write the Fibonacci series program in java:
	 *  	1. •Fibonacci Series without using recursion
	 *  	2. • Fibonacci Series using recursion 
	 */
	@Test(priority = 4)
	public void Fibonacci_Example04() {
		// Fibonacci Series without using recursion
		int n1 = 0, n2 = 1, n3, i, count = 10;
		System.out.print(n1 + " " + n2);// printing 0 and 1

		for (i = 2; i < count; ++i)
			// loop starts from 2 because 0 and 1 are already printed
		{
			n3 = n1 + n2;
			System.out.print(" " + n3);
			n1 = n2;
			n2 = n3;
		}

	}
	
	@Test(priority = 5)
	public void Fibonacci_Example05() {
		//Fibonacci Series using recursion
		  //********** write this program in separate class you can get the idea  
		
	/*	static int n1=0,n2=1,n3=0;    
		 static void printFibonacci(int count){    
		    if(count>0){    
		         n3 = n1 + n2;    
		         n1 = n2;    
		         n2 = n3;    
		         System.out.print(" "+n3);   
		         printFibonacci(count-1);    
		     }    
		 }    
		 public static void main(String args[]){    
		  int count=10;    
		  System.out.print(n1+" "+n2);//printing 0 and 1    
		  printFibonacci(count-2);//n-2 because 2 numbers are already printed   
		 }  
		*/
		
	}
	
}
