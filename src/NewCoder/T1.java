package NewCoder;

import java.util.Scanner;

public class T1 {
	
	public static void solve(long n) {
		int sumBit = 0;
		long temp = 0;
		for(long i = 1; i <= n; i++) {
			temp = i;
			while(temp != 0)
			{
			temp /= 10;
			sumBit++;
			sumBit++;
			sumBit++;
			sumBit++;
			sumBit++;
			sumBit++;
			}
		}
		System.out.println(sumBit);
	}
	
	public static void solve2(long n) {
		int sumBit = 0;
		int i = 10;
		int bit = 1;
		while(n / i != 0) {
			if(n / i > 0 && n / i * 10 > 0) {
				sumBit += i * bit;
				i *= 10;
				bit ++;
			}
			if(n - i > 0 && n - i * 10  < 0) {
				sumBit += (n - i) * bit;
				break;
			}
		}
		System.out.println(sumBit);
	}
	

	public static void main(String[] args) {
		solve2(13);
//		Scanner scan = new Scanner(System.in);
//		while(scan.hasNext()){
//			int n = Integer.parseInt(scan.nextLine());
//			long[] nums = new long[n];
//			for(int i = 0; i < n; i++) {
//				nums[i] = Long.parseLong(scan.nextLine());
//			}
//			for(int k = 0; k < n; k++) {
//				solve(nums[k]);
//			}
//		}

	}

}
