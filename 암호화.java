package main;

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int b = Integer.parseInt(sc.nextLine());
		String[] a = sc.nextLine().split("");
		int[] d = new int[a.length];
		String[] aa = new String[a.length];

		for (int j = 0; j < a.length; j++) {
			d[j] =(int)a[j].charAt(0)-64;
		
		}
		for (int i = 0; i < d.length; i++) {
			if(d[i]-(3*(i+1)+b)<=0) {
				System.out.print((char)(d[i]-(3*(i+1)+b)+25+65));
			}else {System.out.print((char)(d[i]-(3*(i+1)+b)+1+63));}
		
		}
	}
}