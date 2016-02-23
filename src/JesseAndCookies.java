	import java.util.PriorityQueue;
	import java.util.Scanner;
	
	public class JesseAndCookies {
		static Scanner sc = new Scanner(System.in);
		public static void main(String[] args) {
			String []str = sc.nextLine().split(" ");
			int n = Integer.parseInt(str[0]);
			int k = Integer.parseInt(str[1]);
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
			
			str = sc.nextLine().split(" ");
			for (int i = 0; i < str.length; i++) {
				pq.add(Integer.parseInt(str[i]));
			}
	
			int count = 0;
			while(pq.peek() < k && pq.size() > 1) {
				int sweetness = (1 * pq.remove()) + (2 * pq.remove());
				pq.add(sweetness);
				count++;
			}
	
			if(pq.peek() < k) {
				System.out.println(-1);
			}else {
				System.out.println(count);
			}
		}
	}
