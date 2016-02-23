import java.util.*;

public class Solution {
    
/*
 * Complete the function below.
 */

    static boolean isSwapNeeded(int aOnes, int bOnes, int a, int b) {
        if(aOnes == bOnes) {
        	return b > a;
        }else if(aOnes > bOnes) {
        	return false;
        }else {
        	return true;
        }
    }
    
    static int findOnes(int a) {
    	int count = 0;
    	while(a > 0) {
    		count += (a % 2);
    		a = a / 2;		
    	}
    	return count;
    }
    
    static void swap_array(int[] a) {
        for(int i = 0;i < a.length;i++) {
            for(int j = 0; j < a.length - 1;j++) {
                if(isSwapNeeded(findOnes(a[j]),findOnes(a[j+1]),a[j],a[j+1])) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
             }
        }
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int _a_size = 0;
        _a_size = Integer.parseInt(in.nextLine());
        int[] _a = new int[_a_size];
        int _a_item;
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(in.nextLine());
            _a[_a_i] = _a_item;
        }
        
        swap_array(_a);
        System.out.println(Arrays.toString(_a));
        in.close();
    }
}