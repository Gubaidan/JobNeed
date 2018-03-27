package CP_1;

import java.util.*;

public class TwoKindCoins {
	public static int[] map;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){ 
			String string = scan.nextLine();
			String string = scan.nextLine();
			int n1 = Integer.parseInt(string.split(" ")[0]);
			int n2 = Integer.parseInt(string.split(" ")[1]);
			int m = Integer.parseInt(string.split(" ")[2]);
			int[] nums1 = new int[n1];
			int[] nums2 = new int[n2];
			String string1 = scan.nextLine();
			String [] data1 = string1.split(" ");
			for(int i = 0;i < n1;i++){
				nums1[i] = Integer.parseInt(data1[i]);
			}
			String string2 = scan.nextLine();
			String [] data2 = string2.split(" ");
			for(int i = 0;i < n2;i++){
				nums2[i] = Integer.parseInt(data2[i]);
			}
			map = new int[m + 1];
			for(int j = 0; j < m + 1; j++){
				map[j] = -1;
			}
			int r = search(0 ,0 ,nums1,nums2,m);
			System.out.println(r % 1000000007);
		}

	}
	
	public static int search(int idx1, int idx2, int[] nums1,int[] nums2,int amount) {
		if(amount < 0) return 0;
		if(idx1 >= nums1.length && idx2 >= nums1.length) return 0;
		if(amount == 0) return 1;
//		if(map[amount] >= 0) return map[amount];
		int res1 = 0,res2 = 0,res3 = 0,res4 = 0,res5 = 0;
		if(idx1 >= nums1.length && idx2 < nums2.length ){
			res2 = search(idx1, idx2 + 1, nums1, nums2, amount - nums2[idx2]); // 1* nums2[i]
			res3 = search(idx1, idx2 + 1, nums1, nums2, amount); // 1* nums2[i]
		}else if (idx1 < nums1.length && idx2 >= nums2.length) {
			res1 = search(idx1, idx2, nums1, nums2, amount - nums1[idx1]); //n*nums1[i]
			res2 = search(idx1 + 1, idx2, nums1, nums2, amount); //n*nums1[i]
			res3 = search(idx1 + 1, idx2, nums1, nums2, amount - nums1[idx1]); //n*nums1[i]
		}else if (idx1 < nums1.length && idx2 < nums2.length){
			res1 = search(idx1, idx2, nums1, nums2, amount - nums1[idx1]); //n*nums1[i]
			res2 = search(idx1, idx2 + 1, nums1, nums2, amount - nums2[idx2]); // 1* nums2[i]
			res3 = search(idx1 + 1, idx2 + 1, nums1, nums2, amount);
			res4 = search(idx1 + 1, idx2 + 1, nums1, nums2, amount - nums1[idx1] - nums2[idx2]);
			res5 = search(idx1, idx2 + 1, nums1, nums2, amount - nums1[idx1] - nums2[idx2]);
		}
		map[amount] = res1 + res2 + res3 + res4 + res5;
		return map[amount];
	}
}
//public int change(int amount, int[] coins1, int[] coins2) {
//int[][] dp = new int[coins1.length+coins2.length+1][amount+1];
//dp[0][0] = 1;
//
//for (int i = 1; i <= coins1.length && i <= coins2.length; i++) {
//	for(int k = 1;)
//    dp[i][0] = 1;
//    for (int j = 1; j <= amount; j++) {
//        dp[i][j] = dp[i-1][j] + (j >= coins[i-1] ? dp[i][j-coins[i-1]] : 0);
//    }
//}
//return dp[coins.length][amount];
//}