package Wangyi;

import java.util.Scanner;

public class Main {

	private static String[][] map;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String string = scan.nextLine();
			int m = Integer.parseInt(string.split(" ")[0]);
			int n = Integer.parseInt(string.split(" ")[1]);
			String[][] nums = new String[m][n];
			String[] data;
			String string2;
			for (int i = 0; i < m; i++) {
				string2 = scan.nextLine();
				data = string2.split(" ");
				for (int j = 0; j < n; j++) {
					nums[i][j] = data[j];
				}
			}

			string = scan.nextLine();
			int k = Integer.parseInt(string);
			int[][] xy = new int[k][4];
			map = new String[k][5];
			for (int i = 0; i < k; i++) {
				string2 = scan.nextLine();
				data = string2.split(" ");
				for (int j = 0; j < 4; j++) {
					map[i][4] = "";
					xy[i][j] = Integer.parseInt(data[j]);
				}
			}
			for (int q = 0; q < k; q++) {
				solve(nums, q, xy[q][0], xy[q][1], xy[q][2], xy[q][3]);
			}
		}

	}

	public static boolean check(int x1, int y1, int x2, int y2) {
		for (int i = 0; i < map.length; i++) {
			if("".equals(map[i][4])) continue;
			if (x1 <= Integer.parseInt(map[i][0]) && x2 >= Integer.parseInt(map[i][2])
					&& y1 <= Integer.parseInt(map[i][1]) && y2 >= Integer.parseInt(map[i][3])) {
				if("NaN".equals(map[i][4])) {
					System.out.println("NaN");
					break;
				}
				System.out.println(map[i][4]);
				return true;
			}
		}
		return false;
	}

	public static void solve(String[][] nums, int idx, int x1, int y1, int x2, int y2) {
		if (check(x1, y1, x2, y2)) return;
		boolean N = false,Y = false;
		long res = 0;
		for (int i = x1 - 1; i < x2 && (!N || !Y); i++) {
			for (int k = y1 - 1; k < y2 && (!N || !Y); k++) {
				if (!Y && "+inf".equals(nums[i][k])) {
					Y = true;
				} else if (!N && "-inf".equals(nums[i][k])) {
					N = true;
				} else if (!N && !Y) {
					res += Long.parseLong(nums[i][k]);
				} else {
					continue;
				}
			}
		}
		String ress = "";
		if (N && Y) {
			ress = "NaN";
		} else if (!N && !Y) {
			ress = String.valueOf(res);
		} else {
			if (Y) {
				ress = "+inf";
			}
			if (N) {
				ress = "-inf";
			}
		}
		map[idx][0] = String.valueOf(x1);
		map[idx][1] = String.valueOf(y1);
		map[idx][2] = String.valueOf(x2);
		map[idx][3] = String.valueOf(y2);
		map[idx][4] = String.valueOf(ress);
		System.out.println(ress);
	}
}