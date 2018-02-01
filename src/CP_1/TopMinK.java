package CP_1;


public class TopMinK {

	public static void main(String[] args) {
		int [] nums = new int[]{4,5,1,6,2,7,3,8};
		int k = 4;
		for(int i = k / 2; i >= 0; i--){
			adjustMaxSort(nums, i, k - 1);
		}
		int temp;
		for(int j = k; j < nums.length; j++){
			if(nums[0] > nums[j]){
				temp = nums[0];
				nums[0] = nums[j];
				nums[j] = temp;
				adjustMaxSort(nums, 0, k - 1);
			}	
		}
		
		for(int c = 0; c < k; c++)
			System.out.println(nums[c] + " ");

	}
	
	public static void adjustMaxSort(int[] nums, int pos, int length) {
		int temp,child;
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
