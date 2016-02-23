import java.util.Arrays;
import java.util.Scanner;

public class CavityMap {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = Integer.parseInt(sc.nextLine());
		char a[][] = new char[n][n];

		for (int i = 0; i < n	; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < n; j++) {
				a[i][j] = str.charAt(j);
			}
		}

		int adj[][] = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
		
		for (int i = 1; i < n-1; i++) {
			for (int j = 1; j < n-1; j++) {
				boolean markX = true;
				for (int k = 0; k < adj.length; k++) {
					if(a[i+adj[k][0]][j+adj[k][1]] == 'X') {
						markX = false;
						break;
					}
					if(a[i][j] <= a[i+adj[k][0]][j+adj[k][1]]) {
						markX = false;
					}
				}
				if(markX == true) {
					a[i][j] = 'X';
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}
}
