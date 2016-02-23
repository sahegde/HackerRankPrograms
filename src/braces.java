public class braces {
	public static void main(String[] args) {
		String str = ")))(((((";
		StringBuilder s = new StringBuilder();

		int end = 0;
		int start = 0;
		int endBracks = 0;

		for (int i = 0; i < str.length();i++) {
			if(str.charAt(i) == ')') {
				end++;
			}else if(str.charAt(i) == '(') {
				start++;
			}
			
			if(end > start) {
				endBracks++;
				start++;
			}
		}
		
		for (int i = 0; i < endBracks; i++) {
			s.append("(");
		}
		s.append(str);
		for (int i = 0; i < start-end; i++) {
			s.append(")");
		}
		
		System.out.println(s.toString());
	}
}
