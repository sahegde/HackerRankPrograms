import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class maxElement {
	static Scanner sc = new Scanner(System.in);
	
	private static void pushToMaxStack(Stack<Integer> maxStack,int val) {
		if(!maxStack.isEmpty()) {
			if(maxStack.peek() > val) {
				maxStack.push(maxStack.peek());
			}else {
				maxStack.push(val);
			}
		}else {
			maxStack.push(val);
		}
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> maxStack = new Stack<Integer>();
		int n = Integer.parseInt(sc.nextLine());
		List<Integer> res = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i++) {
			String str[] = sc.nextLine().split(" ");
			int choice = Integer.parseInt(str[0]);
			if(choice == 1) {
				int val = Integer.parseInt(str[1]);
				stack.push(val);
				pushToMaxStack(maxStack,val);
			}else if(choice == 2) {
				stack.pop();
				maxStack.pop();
			}else if(choice == 3) {
				res.add(maxStack.peek());
			}
		}
		
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}
}
