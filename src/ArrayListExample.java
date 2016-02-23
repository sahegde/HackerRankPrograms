import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListExample {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = Integer.parseInt(sc.nextLine());
		
		List<List<Integer>> l = new ArrayList<List<Integer>>();
		
		for (int i = 0; i < n; i++) {
			String str[] = sc.nextLine().split(" ");
			int d = Integer.parseInt(str[0]);
			
			List<Integer> sl = new ArrayList<Integer>();
			for (int j = 0; j < d; j++) {			
				sl.add(Integer.parseInt(str[j+1]));
			}
			l.add(sl);
		}
		
		int q = Integer.parseInt(sc.nextLine());
		List<String> res = new ArrayList<String>();
		
		for (int i = 0; i < q; i++) {
			String str[] = sc.nextLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			
			try {
				res.add((l.get(x-1)).get(y-1)+"");
			}catch(IndexOutOfBoundsException e) {
				res.add("ERROR!");
			}
		}
		
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}
}
