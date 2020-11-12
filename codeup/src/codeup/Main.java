package codeup;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) { //static void main 

		Scanner sc = new Scanner(System.in);
		String result = sc.nextLine();

		result = result.replaceAll("[^0-9a-z-_.]" ,"");
		result = result.replaceAll("[\\.]+", "\\.");
		result = result.replaceAll("^[\\.][\\.]$","");

		if(result.length()>=16) {
			result = result.substring(0,15);
		}
		result = result.replaceAll("[\\.]$", "");
		if(result.equals("")) {
			result = "a";
		}

		if(result.length()<3) {
			for(int i=0; i<2; i++) { 
				result += result.charAt(result.length()-1);
			}
			result = result.substring(0,3);
		}
		
		System.out.println(result);
	}

}

