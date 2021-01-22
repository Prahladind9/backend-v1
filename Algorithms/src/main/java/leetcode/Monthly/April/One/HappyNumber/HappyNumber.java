package leetcode.Monthly.April.One.HappyNumber;

public class HappyNumber {

	public static void main(String[] args) {
		System.out.println(isHappy(100));
	}
	
	public static boolean isHappy(int n) {

		System.out.println("------------------isHappy call " + n );
		int a = 0;
		for(; n!=0;) {			
			a = a + (n % 10 * n % 10);
			n = n / 10;
			System.out.println("a " + a + " n " + n + " " + n % 10);
		}
		
		if(a ==1) {
			System.out.println("response --------- " + true);
			 return true;
		}
		else {
			System.out.println("response --------- " + true);
			return  false | isHappy(a);
		}
		
    }
	
	
}
