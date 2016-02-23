import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class AlgorithmicCrush {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		String str = sc.nextLine();
		String s[] = str.split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		
		BigInteger maxSum = BigInteger.ZERO;
		
		BigInteger arr[] = new BigInteger[n];
		Arrays.fill(arr,BigInteger.ZERO);
		
		for (int i = 0; i < m; i++) {
			str = sc.nextLine();
			s = str.split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int k = Integer.parseInt(s[2]);
			
			for (int j = a; j <= b; j++) {
				arr[j-1] = arr[j-1].add(new BigInteger(k+""));
				if(arr[j-1].compareTo(maxSum) > 0) {
					maxSum = arr[j-1];
				}	
			}		
		}
		
		System.out.println(maxSum);
	}
}
