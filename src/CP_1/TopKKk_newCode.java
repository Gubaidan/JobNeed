package CP_1;

import java.util.*;
import java.util.Scanner;

public class TopKKk_newCode {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){ 
			String string = scan.nextLine();
			int n = Integer.parseInt(string.split(" ")[0]);
			int k = Integer.parseInt(string.split(" ")[1]);
			long[] nums = new long[n];
			String string2 = scan.nextLine();
			String [] data = string2.split(" ");
			for(int i = 0;i < n;i++){
				nums[i] = Long.parseLong(data[i]);
			}
			solve(nums, k);	
		}

	}
	
	public static void solve(long[] nums,int k) {
		for(int i = k / 2; i >= 0; i--){
			adjustMaxSort(nums, i, k - 1);
		}
		long temp;
		for(int j = k; j < nums.length; j++){
			if(nums[0] > nums[j]){
				temp = nums[0];
				nums[0] = nums[j];
				nums[j] = temp;
				adjustMaxSort(nums, 0, k - 1);
			}	
		}
		
		long[] res = new long[k];
		for(int c = 0; c < k; c++){
			res[c] = nums[c];
		}
		Arrays.sort(res);
		String string = "";
		for(int c = 0; c < k; c++){
			string += String.valueOf(res[c]) + ",";
		}
		System.out.println(string.substring(0,string.length() - 1));
	}
	
	public static void adjustMaxSort(long[] nums, int pos, int length) {
		long temp;
		int child;
		for(temp = nums[pos]; 2 * pos + 1 <= length; pos = child){
			child = 2 * pos + 1;
			if(child < length && nums[child] < nums[child + 1]) child++;
			if(nums[child] > temp){
				nums[pos] = nums[child];
			}else {
				break;
			}
		}
		nums[pos] = temp;
		
	}

}
