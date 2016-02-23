import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {
	
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		Stack<String> opStack = new Stack<String>();
		Stack<Integer> countStack = new Stack<Integer>();
		
		Stack<Character> s1 = new Stack<Character>();
		Stack<Character> s2 = new Stack<Character>();
		List<Character> res = new ArrayList<Character>();
		
		int q = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < q; i++) {
			String []str = sc.nextLine().split(" ");
			int choice = Integer.parseInt(str[0]);
			switch(choice) {
				case 1: 
					String val = str[1];
					opStack.push("s1");
					countStack.push(val.length());
					for (int j = 0; j < val.length(); j++) {
						s1.push(val.charAt(j));
					}
					break;
					
				case 2:
					int k = Integer.parseInt(str[1]);
					opStack.push("s2");
					countStack.push(k);
					for (int j = 0; j < k; j++) {
						Character value = s1.pop();
						s2.push(value);
					}
					break;
					
				case 3:
					int pos = Integer.parseInt(str[1]);
					res.add(s1.elementAt(pos-1));
					break;
					
				case 4:
					String undoChoice = opStack.pop();
					Integer undoCount = countStack.pop();
					if(undoChoice.equals("s1")) {
						while(!s1.isEmpty() && undoCount > 0) {
							s1.pop();
							undoCount--;
						}
					}else if(undoChoice.equals("s2")) {
						while(!s2.isEmpty() && undoCount > 0) {
							Character value = s2.pop();
							s1.push(value);	
							undoCount--;
						}
					}
					break;
			}
		}
		
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}
}
