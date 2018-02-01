package Tecent;

public class Pfood {
	static int max = -1;
	static int[][] map;

	private static boolean getCount(int day, int now, int total, int M) {
		if (day < 1 || now < 1){
			return false;
		}	
		if (day == 1) {
			if (now > max && M == 0) {
				max = total;
				return true;
			}
		} else {
			int next = now % 2 == 0 ? now / 2 : now / 2 + 1;
			for (int i = next; i <= now; i++) {
				 return getCount(day - 1, i, total, M - i);
			}
		}
		return false;
	}

	public static int getMax(int day,int N,int now) {
		if(day > N || now < 0 ) return max;
//		if(now == 0) return 1;
		if(day == N) return now;
		if(map[day][now] >= 0) return map[day][now];
		int next = now % 2 == 0 ? now / 2 : now / 2 + 1;
		map[day][now] = Math.min(getMax(day+1 , N, now), getMax(day , N, now -1) + 1 );
		return map[day][now];
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int n = 4, m = 700;
		map = new int[n + 1][m + 1];
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				map[i][j] = -1;
			}
		}
//		int res = getMax(1 , n, m);
//		for (int i = 0; i <= m; i++) {
//			for (int j = 0; j <= n; j++) {
//				System.out.print(map[j][i]+ " ");
//				if( j == n) System.out.println();
//			}
//		}

		for (int k = m; k > m / 2; k--) {
			if(getCount(n, k, k, m - k)) System.out.println(k);
		}
		long time = System.currentTimeMillis() - start;
		System.out.println("time:" + time + "ms,"+max);

	}

}
