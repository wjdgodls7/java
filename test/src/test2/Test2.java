package test2;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int num = sc.nextInt();

			if (num%2==0) { 
				System.out.println("홀수를 입력해주세요");
			}else {
				for (int i=0;i<num;i++){
					for (int j=0; j<num;j++){
						if (i<=num/2){//위쪽
							if (i+j<=num/2-1) {
								System.out.print(" ");
							}
							else if(j-i>=num/2+1) {
								System.out.print(" ");
							}
							else {
								System.out.print("*");
							}
						}
						else{ //아래쪽
							if (i-j>=num/2+1) {
								System.out.print(" ");
							}	
							else if (i+j>=num/2*3+1){
								System.out.print(" ");
							}
							else {
								System.out.print("*");
							}
						}
					}
					System.out.println();
				}
				break;	
			}
		}
	}
}
