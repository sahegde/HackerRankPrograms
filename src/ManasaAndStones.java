
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class ManasaAndStones {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int t = Integer.parseInt(sc.nextLine());
		List<StringBuilder> l = new ArrayList<StringBuilder>();
		
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(sc.nextLine());
			int a = Integer.parseInt(sc.nextLine());
			int b = Integer.parseInt(sc.nextLine());
			
			int m = n-1;
			String str[] = new String[(int)Math.pow(2, m)];
			for (int j = 0; j < (int)Math.pow(2, m); j++) {
				int temp = j;
				StringBuilder s = new StringBuilder();
				int counter = m;
				while(counter > 0) {
					s.append(temp%2);
					temp = temp / 2;
					counter--;
				}
				s.reverse();
				str[j] = s.toString();
			}
			
			TreeSet<Integer> h = new TreeSet<Integer>();
			for (int j = 0; j < str.length; j++) {
				int sum = 0;
				for (int j2 = 0; j2 < m; j2++) {
					if(str[j].charAt(j2) == '0') {
						sum += a;
					}else {
						sum += b;
					}
				}
				if(!h.contains(sum)) {
					h.add(sum);
				}
			}
			
			StringBuilder res = new StringBuilder();
			Iterator<Integer> it = h.iterator();
			while(it.hasNext()) {
				res.append(it.next()+" ");
			}
			l.add(res);
		}
		
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));
		}
	}
}
