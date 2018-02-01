package CP_1;

public class Fib {
	private static long[] map;
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int n = 100;
		map = new long[n + 1];
		for(int i = 0; i < n + 1; i++) map[i] = -1;
		long res = fib(n);
		long end = System.currentTimeMillis() - start;
		System.out.println(res+","+end + "ms");
	}
	
	public static long fib(int n) {
		if(n == 1 || n == 2) return 1;
		if(map[n] >= 0) return map[n];
		map[n] = fib(n - 1) + fib(n - 2);
		return map[n];
	}
	
    public static long JumpFloor(int target) {
        if (target < 0){
            return 0;
        }
        if (target == 1){
            return 1;
        }
        if (target == 2){
            return 2;
        }
        
        long result = 0;
        long x1 = 1, x2 = 2;
        
        for (int i = 2; i < target; i++){
            result = x1 + x2;
            x1 = x2;
            x2 = result;
        }
        return result;
    }

}
