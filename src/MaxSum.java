import java.util.Arrays;

public class MaxSum {
	public static void main(String[] args) {
		int a[] = {-1,-2,-5,-5,18};
		int sumArr[] = Arrays.copyOf(a, a.length);
		
		int maxSumTillNow = sumArr[0];
		
		for (int i = 1; i < a.length; i++) {
			if(a[i] + sumArr[i-1] > a[i]) {
				sumArr[i] = a[i] + sumArr[i-1];
			}else {
				sumArr[i] = a[i];
			}
			if(sumArr[i] > maxSumTillNow) {
				maxSumTillNow = sumArr[i];
			}
		}
		
		System.out.println(maxSumTillNow);
	}
}
