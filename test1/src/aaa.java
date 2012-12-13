import java.math.BigInteger;
import java.util.Stack;
import java.util.Vector;

public class aaa {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] a = { 10, 2, 5, 1, 8, 20 };
		int x = triangle(a);
        
		System.out.println(x);
}

	  public static int triangle ( int[] A ) {
		  
	      int len = A.length;
	      
	      if (len < 3) {
	          return 0;
	      }
	      
	      for (int a = 0; a < len; a++) {
	    	    for (int b = a + 1; b < len; b++) {
	    	        for (int c = b + 1; c < len; c++) {
	    	            if (isTriangle(A[a], A[b], A[c])) {
	    	            	return 1;
	    	            }
	    	        }
	    	    }
	    	}
	      
	      return 0;
	  }
	  
	  public static boolean isTriangle( int a, int b, int c ) {
	      if (a + b <= c) {
	          return false;
	      }
	      if (a + c <= b) {
	          return false;
	      }
	      if (c + b <= a) {
	          return false;
	      }
	      return true;
	  }
	
}
