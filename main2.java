package Main;

import java.util.Arrays;
import java.util.Scanner;

public class main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String[] customer =new String[Integer.parseInt(a)];
		customer=sc.nextLine().split(" ");
		int count=0;
		
		Arrays.sort(customer);
		
		for (int i = 0; i < customer.length-1; i++) {
			if (customer[i].equals(customer[(i+1)])) {			
				count++;
			}
		}
		System.out.println(count);
	}
}
