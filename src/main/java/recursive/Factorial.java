package recursive;

/**
 * 階層
 *
 */
public class Factorial {

	public static void main(String[] args) {
		
		System.out.println(recursive(10));
		System.out.println(nonrecursive(10));
	}
	
	public static int recursive(int n) {
		// termination
		if(n == 0) {
			return 1;
		} else {
			return n*recursive(n-1);
		}
		
	}
	
	public static int nonrecursive(int n) {
		int result = 1;
		
		while(n != 0) {
			result *= n;
			n--;
		}
		
		return result;
	}
}
