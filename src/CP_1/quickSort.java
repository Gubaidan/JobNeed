package CP_1;

public class quickSort {

	public static void main(String[] args) {
		int [] nums = new int[]{2,3,4,5,6,7,4,7,7,3};
		quickSort(nums, 0, nums.length - 1);
		for(int i:nums)
			System.out.println(i + " ");
	}
	
	public static void quickSort(int[] nums, int low, int high) {
		if(low >= high) return;
		int key = nums[low];
		int l = low,h = high;
		while(l < h){
			while(l < h && key <= nums[h]) h--;
			nums[l] = nums[h];
			while(l < h && key >= nums[l]) l++;
			nums[h] = nums[l];
		}
		nums[h] = key;
		quickSort(nums, low, h - 1);
		quickSort(nums, h + 1, high);
	}
}
