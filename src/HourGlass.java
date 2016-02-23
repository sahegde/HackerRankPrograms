import java.util.Arrays;
import java.util.Scanner;

public class HourGlass {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int a[][] = new int[6][6];
		
		for (int i = 0; i < 6; i++) {
			String str[] = sc.nextLine().split(" ");
			for (int j = 0; j < 6; j++) {
				a[i][j] = Integer.parseInt(str[j]);
			}
		}

		int maxSum = Integer.MIN_VALUE;
		int adj[][] = {{-1,-1},{-1,0},{-1,1},{1,-1},{1,0},{1,1},{0,0}};
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j < 5; j++) {
				int sum = 0;
				for (int k = 0; k < adj.length; k++) {
					sum = sum + a[i+adj[k][0]][j+adj[k][1]];
				}
				
				if(sum > maxSum) {
					maxSum = sum;
				}
			}
		}
		
		System.out.println(maxSum);
	}
}
