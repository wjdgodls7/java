package sort;

import java.util.Arrays;

public class Main {

	public static void main(String[] arg) {
		int x = 2;
		int y = 5;
		int z = 2;

		int[] arr = {5,6,2,4,8,3,6};
		int[] arr2 = new int[(y-x)+1]; 
		int count = 0;

				for(int i=(x-1); i<y; i++) {	
			arr2[count] = arr[i];
			count++;
		}

		Arrays.sort(arr2);
		System.out.println(arr2[z-1]);

	}
}
