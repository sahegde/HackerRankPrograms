import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SparseArrays {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int n = Integer.parseInt(sc.nextLine());
		Map<String,Integer> map = new HashMap<String,Integer>();
		
		for (int i = 0; i < n; i++) {
			String str = sc.nextLine();
			if(map.containsKey(str)) {
				int size = map.get(str);
				size += 1;
				map.put(str, size);
			}else {
				map.put(str,1);
			}
		}
		
		int q = Integer.parseInt(sc.nextLine());
		int res[] = new int[q];
		for (int i = 0; i < q; i++) {
			String str = sc.nextLine();
			if(map.containsKey(str)) {
				res[i] = map.get(str);
			}else {
				res[i] = 0;
			}
		}
		
		for (int i = 0; i < q; i++) {
			System.out.println(res[i]);
		}
	}
}
