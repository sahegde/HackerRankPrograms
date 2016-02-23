import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

class Node {
	int data;
	Node left;
	Node right;
	
	public Node(int data) {
		this.data = data;
	}
}

public class swapNodes {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int n = Integer.parseInt(sc.nextLine());
		Node root = new Node(1);
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		
		while(!q.isEmpty()) {
			String str[] = sc.nextLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			
			Node temp = q.remove();
			if(a == -1) {
				temp.left = null;
			}else {
				temp.left = new Node(a);
				q.add(temp.left);
			}

			if(b == -1) {
				temp.right = null;
			}else {
				temp.right = new Node(b);
				q.add(temp.right);
			}
			
			
		}
		
		//System.out.println("Before swap");
		//inorder(root);
		
		int t = Integer.parseInt(sc.nextLine());
		List<StringBuilder> results = new ArrayList<StringBuilder>();
		for (int i = 0; i < t; i++) {
			int k = Integer.parseInt(sc.nextLine());
			performSwap(root,k);
			StringBuilder res = new StringBuilder();
			inorder(root,res);
			results.add(res);
		}
		
		for (int i = 0; i < results.size(); i++) {
			System.out.println(results.get(i).toString());
		}
	}
	
	private static void performSwap(Node root, int k) {
		int height = findHeight(root,1,1);
		//System.out.println("Height is "+height);
		for (int i = k; i < height;i = i+k) {
			root = swap(root,1,i);
		}
	}
	
	private static int findHeight(Node root,int currentNodeHeight, int maxDepth) {
		if(root != null) {
			if(currentNodeHeight > maxDepth) {
				maxDepth = currentNodeHeight;
			}
			maxDepth = findHeight(root.left,currentNodeHeight+1,maxDepth);
			maxDepth = findHeight(root.right,currentNodeHeight+1,maxDepth);
		}
		return maxDepth;
	}
	
	private static void findTopView(Node root, Map<Integer,Integer> map,int angle) {
		if(root != null) {
			findTopView(root.left,map,angle-1);
			findTopView(root.right, map,angle+1);
			if(!map.containsKey(angle)) {
				map.put(angle, root.data);
			}
		}
	}
	
	void top_view(Node root)
	{
	  TreeMap<Integer, Integer> map = new TreeMap<Integer,Integer>();
	  findTopView(root, map, 0);
	  
	  Set<Map.Entry<Integer, Integer>> set = map.entrySet();
	  Iterator<Map.Entry<Integer, Integer>> it = set.iterator();
	  while(it.hasNext()) {
		  System.out.println(it.next().getValue()+" ");
	  }
	}
	
	private static Node swap(Node root, int depth, int k) {
		if(root != null) {		
			if(depth == k) {
				Node temp = root.left;
				root.left = root.right;
				root.right = temp;
			}
			swap(root.left,depth+1,k);
			swap(root.right,depth+1,k);
		}
		return root;
	}
	
	private static void inorder(Node root,StringBuilder str) {
		if(root != null) {
			inorder(root.left,str);
			str.append(root.data+" ");
			inorder(root.right,str);
		}
	}
}
