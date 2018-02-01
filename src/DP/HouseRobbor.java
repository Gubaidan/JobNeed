package DP;

import javax.xml.ws.RespectBinding;

public class HouseRobbor {
	private static long res[];
	
	private static long fib(int n){
		if (n <= 1) return 1;
		if (res[n] >= 0){
			return res[n];
		}
		res[n] = fib(n - 1) + fib(n - 2);
		return res[n];
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		res = new long[1001];
		for(int i = 0; i < 1001; i++){
			res[i] = -1;
		}
		long i = fib(1000);
		long time = System.currentTimeMillis() - start;
		System.out.println("time:"+time+"ms," + i);

	}

}
