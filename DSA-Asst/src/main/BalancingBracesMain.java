package main;
import java.util.Scanner;
import service.BalancingBraces;

public class BalancingBracesMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the String containing braces: ");
		
		String inputString = scanner.next();
		BalancingBraces bb = new BalancingBraces();
		
		boolean isBalanced = bb.isStringBalanced(inputString);
		
		if(isBalanced) {
			System.out.println("The entered String has Balanced Brackets"); //([[{}]])
		}
		else {
			System.out.println("The entered Strings do not contain Balanced Brackets"); //([[{}]]))
		}
		scanner.close();
	}

}
