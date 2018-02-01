package Wangyi;

import java.util.Scanner;


public class hu {
	private static int[][] res;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String[] start = scan.nextLine().split(" ");
			String[] end = scan.nextLine().split(" ");
			String rc = scan.nextLine();
			int row = Integer.parseInt(rc.split(" ")[0]);
			int col = Integer.parseInt(rc.split(" ")[1]);
			int map[][] = new int[row][col];
			res = new int[row][col];
			for(int i = 0; i < row ; i++) {
				for (int j = 0; j < col; j++) {
					res[i][j] = -1;
				}
			}
			for(int i = 0; i < row ; i++) {
				String[] tem = scan.nextLine().split(" ");
				for (int j = 0; j < col; j++) {
					map[i][j] = Integer.parseInt(tem[j]);
				}
			}
			int x1 = Integer.parseInt(start[0]);
			int y1 = Integer.parseInt(start[1]);
			int x2 = Integer.parseInt(end[0]);
			int y2 = Integer.parseInt(end[1]);
			int s = solve(x1,y1,chechSrt(start[2]),x2,y2,chechSrt(end[2]),map);
			System.out.println(s);
			
		}
	}
	
	public static int solve(int x1,int y1, int startF,int x2, int y2,int endF,int[][] map ) {

		int row = map.length;
		int col = map[0].length;
		if(x1 == x2 && y1 == y2 && startF == endF) return 0;
		if(x1 < 0 || x1 >= row || y1 < 0 || y1 >= col) return Integer.MAX_VALUE;
		if(map[x1][y1] == 1) return Integer.MAX_VALUE;
		if(res[x1][y1] >= 0) return res[x1][y1];
		int res1 = 0,res2 = 0;
		if(startF == 1) res1 = solve(x1 + 1, y1, startF, x2, y2, endF, map) + 1;
		if(startF == 2) res1 = solve(x1 - 1, y1, startF, x2, y2, endF, map) + 1;
		if(startF == 3) res1 = solve(x1, y1 + 1, startF, x2, y2, endF, map) + 1;
		if(startF == 4) res1 = solve(x1, y1 - 1, startF, x2, y2, endF, map) + 1;
		int ff = (startF + 1) % 4;
		res2 = solve(x1, y1, ff, x2, y2, endF, map) + 2;
		res[x1][y1] = Math.min(res1, res2);
		
		return res[x1][y1];
		
	}
	
	private static int chechSrt(String s) {
		if(s.equals("EAST")) return 1;
		if(s.equals("WEST")) return 2;
		if(s.equals("SOUTH")) return 3;
		if(s.equals("NORTH")) return 4;
		return 0;
	}

}
