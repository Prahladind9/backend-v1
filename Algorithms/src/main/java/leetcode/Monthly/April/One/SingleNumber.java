package leetcode.Monthly.April.One;

public class SingleNumber {

	public static void main(String[] args) {
		System.out.println(singleNumber(new int[] { 2, 3, 3, 1, 1 }));
//		bitwise();
//		System.out.println(3 ^ 1);
	}

	public static int singleNumber(int[] nums) {

		if (nums.length == 1) {
			return nums[0];
		}

		int x = 0;
		for (int a : nums) {
			System.out.println("x " + x + " a " + a);
			System.out.println(x ^ a);
			x = x ^ a;
		}
		return x;

	}

	public static void bitwise() {
		// Initial values
		int a = 5;
		int b = 7;

		// bitwise and
		// 0101 & 0111=0101 = 5
		System.out.println("a&b = " + (a & b));

		// bitwise or
		// 0101 | 0111=0111 = 7
		System.out.println("a|b = " + (a | b));

		// bitwise xor
		// 0101 ^ 0111=0010 = 2
		System.out.println("a^b = " + (a ^ b));

		// bitwise and
		// ~0101=1010
		// will give 2's complement of 1010 = -6
		System.out.println("~a = " + ~a);

		// can also be combined with
		// assignment operator to provide shorthand
		// assignment
		// a=a&b
		a &= b;
		System.out.println("a= " + a);
	}
}
