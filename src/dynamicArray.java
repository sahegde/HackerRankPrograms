import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class dynamicArray {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		String str[] = sc.nextLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int q = Integer.parseInt(str[1]);
		
		Map<Integer,List<Integer>> map = new LinkedHashMap<Integer, List<Integer>>();
		
		List<Integer> res = new ArrayList<Integer>();
		
		int lastans = 0;
		
		for (int i = 0; i < q; i++) {
			str = sc.nextLine().split(" ");
			
			int choice = Integer.parseInt(str[0]);
			int x = Integer.parseInt(str[1]);
			int y = Integer.parseInt(str[2]);
			switch(choice) {
				case 1:
					int seq = ((x ^ lastans) % n);
					if(map.containsKey(seq)) {
						List<Integer> l = map.get(seq);	
						l.add(y);
						map.put(seq,l);
					}else {
						List<Integer> l = new ArrayList<Integer>();
						l.add(y);
						map.put(seq,l);
					}
					break;
					
				case 2:
					seq = ((x ^ lastans) % n);
					int size = (map.get(seq)).size();
					int ele	 = (map.get(seq)).get(y % size);
					res.add(ele);
					lastans = ele;
					break;
			}
		}
		
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}
}
