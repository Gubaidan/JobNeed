package CP_1;

public class recursionBinarySearch {

	public static void main(String[] args) {
		int [] nums = new int[]{2,3,4,5,6,7,8,17,17,32};
		int index = recursionBinarySearch(nums, 4 ,0, nums.length - 1);
		System.out.println(index);
	}
	
	public static int recursionBinarySearch(int[] nums,int key, int low, int high) {
	public static int recursionBinarySearch(int[] nums,int key, int low, int high) {
		if(low > high || key < nums[low] || key > nums[high]) return -1;
		int middle = (low + high) / 2;
		if(nums[middle] > key){
			return recursionBinarySearch(nums, key, low, middle - 1);
		}else if(nums[middle] < key){
			return recursionBinarySearch(nums, key, middle + 1, high);
		}
		return middle;
	}

}
