import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class MergingCommunities {
	static Scanner sc = new Scanner(System.in);
	
	static class community {
		int size;
		int head;
		int person;
		
		public community(int size,int head,int person) {
			this.size = size;
			this.head = head;
			this.person = person;
		}
	}
	
	private static void makeCommunities(List<community> l,int n) {
		for (int i = 1; i <= n; i++) {
			community c = new community(1,-1,i);
			l.add(c);
		}
	}
	
	private static int find(List<community> l,int item) {	
		int i = item-1;
		while((l.get(i)).head != -1) {
			i = (l.get(i)).head;
		}
		
		return i;
	}
	
	private static void union(List<community> l,int item1,int item2) {	
		int a = find(l,item1);
		int b = find(l,item2);
		
		(l.get(a)).head = (l.get(b)).person;
		(l.get(a)).size += (l.get(b)).size;
		(l.get(b)).size = (l.get(a)).size;
	}

   class Node {
	  public  int frequency; // the frequency of this tree
	  public  char data;
	  public  Node left, right;
   }

	void decode(String str ,Node root){
		
		if(root == null || str.length() <= 0)
			return;
		Node temp = root;
        for (int i = 0; i < str.length(); i++) {
        	if(temp.left == null && temp.right == null) {
        		System.out.print(temp.data);
        		temp = root;
        	}
        	if(str.charAt(i) == '1') {
				temp = temp.right;
			}else if(str.charAt(i) == '0') {
				temp = temp.left;
			}
		}

       
    }
	
	public static void main(String[] args) {
		List<Integer> res = new ArrayList<Integer>();
		String data[] = sc.nextLine().split(" ");
		int n = Integer.parseInt(data[0]);
		List<community> l = new ArrayList<community>();
		makeCommunities(l,n);
			
		int q = Integer.parseInt(data[1]);
		
		for (int i = 0; i < q; i++) {
			String str[] = sc.nextLine().split(" ");
			if(str[0].equals("Q")) {
				int val = Integer.parseInt(str[1]);
				res.add(l.get(val-1).size);
			}else if(str[0].equals("M")) {
				int a = Integer.parseInt(str[1]);
				int b = Integer.parseInt(str[2]);
				union(l,a,b);
			}
		}
		
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}
}
