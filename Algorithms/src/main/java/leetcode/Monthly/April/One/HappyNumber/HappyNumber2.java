package leetcode.Monthly.April.One.HappyNumber;

import java.util.HashSet;

public class HappyNumber2 {

	public static void main(String[] args) {
		HappyNumber2 happyNumber2 = new HappyNumber2();
		System.out.println(happyNumber2.isHappy(19));
	}
	
	private int getNextHappy(int n) {
		int sum = 0;
		while(n!=0) {
			sum = sum + ((n % 10) * (n % 10));
			n = n / 10;
		}
		return sum;
	}
	
	public boolean isHappy(int n) {
		System.out.println("------------------isHappy call " + n );
		HashSet<Integer> hashSet = new HashSet();
		while( n != 1){
			if(hashSet.contains(n)){
				return false;
			}
			hashSet.add(n);
			n = getNextHappy(n);
		}
		return true;
    }

	
}
