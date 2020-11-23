package Main;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int b = Integer.parseInt(sc.nextLine());
		int[][] arr = new int[b][3];		
		int[][] result = {{1,0,0,0,0},{2,0,0,0,0},{3,0,0,0,0}};
		int count=0;

		for (int i = 0; i < arr.length; i++) {
			String[] input = sc.nextLine().split(" ");

			for (int j = 0; j < input.length; j++) {
				arr[i][j]=Integer.parseInt(input[j]);
				result[j][4] = +result[j][4]+arr[i][j];
				if(arr[i][j]==3) {
					result[j][3]=result[j][3]+1;
				}
				if(arr[i][j]==2) {
					result[j][2]=result[j][2]+1;
				}
				if(arr[i][j]==1) {
					result[j][1]=result[j][1]+1;
				}
			}

		}

		Arrays.sort(result, new Comparator<int[]>() {
		
			public int compare(int[] num0, int[] num1) {
	
				if(num0[4] > num1[4]) {
					return -1;
				}
			
				else if(num0[4] == num1[4]) {
					return 0;

				}else {
					return 1;
				}
			}
		});
		
		count = 0;
		int max = result[0][4];
		for (int i = 0; i < result.length; i++) {
			if (max == result[i][4]) {
				count++;
			}
		}
		
		int[][] result1 =new int[count][];
		count = 0;
		
		for (int[] maxnum : result) {
			if(maxnum[4]==max) {
				result1[count]=maxnum;
				count++;
			}
		}
		count=0;		

		Arrays.sort(result1, new Comparator<int[]>() {

			public int compare(int[] num0, int[] num1) {

				if(num0[3] > num1[3]) {
					return -1;
				}
			
				else if(num0[3] == num1[3]) {
					return 0;
		
				}else {
					return 1;
				}
			}
		});

		max = result[0][3];
		for (int i = 0; i < result.length; i++) {
			if (max == result[i][3]) {
				count++;
			}
		}
		
		result1 =new int[count][];
		count = 0;
		
		for (int[] maxnum : result) {
			if(maxnum[3]==max) {
				result1[count]=maxnum;
				count++;
			}
		}
		count=0;
					
		if (result1.length==1) {
			System.out.println(result1[0][0]+" "+result1[0][4]);	
		}else {
			System.out.println(0 +" "+ result[0][4]);
		}
			
	}
}