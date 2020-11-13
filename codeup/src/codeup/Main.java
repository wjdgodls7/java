package codeup;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) { //static void main 

		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String[] b;
		int c = 0;
		b = a.split("");		

		for (int i = 0; i < b.length; i++) {
			if(b[i].equals("7")){
				c++;
			}
		}
		if(c>=4) {
			System.out.println("LUCKY STRIKE");
			for(int i = 0; i < b.length; i++) {
				Arrays.sort(b,Collections.reverseOrder());
				System.out.print(b[i]);
			}
		}else {System.out.print("UNLUCKY STRIKE");}		
	}


}
