import java.util.Scanner;
import java.util.Stack;

public class BalancedParenthesis {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = Integer.parseInt(sc.nextLine());
		String res[] = new String[n];
		for (int i = 0; i < n; i++) {
			String str = sc.nextLine();
			Stack<Character> stack = new Stack<Character>();
			
			boolean isSeqValid = true;
			outer : for (int j = 0; j < str.length(); j++) {
				Character ch = str.charAt(j);
				if(ch == '{' || ch == '[' || ch == '(') {
					stack.push(ch);
				}else {
					switch(ch) {
						case '}':
							if(!stack.isEmpty() && stack.peek().equals('{')) {
								stack.pop();
							}else {
								isSeqValid = false;
								break outer;
							}
							break;
							
						case ')':
							if(!stack.isEmpty() && stack.peek().equals('(')) {
								stack.pop();
							}else {
								isSeqValid = false;
								break outer;
							}
							break;
							
						case ']':
							if(!stack.isEmpty() && stack.peek().equals('[')) {
								stack.pop();
							}else {
								isSeqValid = false;
								break outer;
							}
							break;
					}
				}
			}			
			
			if(isSeqValid && stack.isEmpty()) {
				res[i] = "YES";
			}else {
				res[i] = "NO";
			}
		}
		
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}
}
