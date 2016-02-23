import java.util.*;

public class StringSplit {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		String str[] = s.split("[ !,?.\\_'@]");
		int n = str.length;
		
		System.out.println(n);
		for (int i = 0; i < n; i++) {
			if(str[i].matches("[A-Za-z]+"))
				System.out.println(str[i]);
		}
		scan.close();
	}
}
