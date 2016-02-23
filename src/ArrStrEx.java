import java.util.Scanner;

public class ArrStrEx {
	static Scanner sc = new Scanner(System.in);
	static int [][]a;
	
	private static String count(int n,int x) {
		int r[] = new int[n];
		a = new int[n+1][n];
		for (int i = 0; i < n; i++) {
			r[i] = Integer.parseInt(sc.nextLine());
		}
		
		for (int j = 1; j < a.length; j++) {
			for (int k = 0; k < a[0].length; k++) {
				a[j][k] = 0;
			}
		}
		
		for (int j = 1; j < a.length; j++) {
			for (int k = 0; k < a[0].length; k++) {
				if((k+1) <= j) {
					a[j][k] = a[j-1][k] + r[j-1];
					if(a[j][k] == x) {
						//System.out.println("j = "+j+" k = "+k);
						return "YES";
					}
				}
			}
		}
		
		return "NO";
	}
	
	public static void main(String[] args) {
		int t = Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < t; i++) {
			String str[] = sc.nextLine().split(" ");
			int n = Integer.parseInt(str[0]);
			int x = Integer.parseInt(str[1]);
			
			System.out.println(count(n,x));
			/*for (int j = 1; j < a.length; j++) {
				for (int k = 0; k < a[0].length; k++) {
					System.out.print(a[j][k] + " ");
				}
				System.out.println();
			}*/
		}
		
	}
}
