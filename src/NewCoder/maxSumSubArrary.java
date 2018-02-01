package NewCoder;

public class maxSumSubArrary {
	private static int[] map ;

	public static void main(String[] args) {
		int[] array = {1, -2 , 3, 10, -4, 7, 2, -5};
		map = new int[array.length];
		for(int i = 0; i < array.length; i++){
            map[i] = -1;
        }
        System.out.println(search(array.length - 1,array));

	}
	

    
    public static int search(int idx, int[] nums){
        if(idx < 0) return 0;
        if(map[idx] >= 0) return map[idx];
        map[idx] = Math.max(search(idx - 1,nums),search(idx - 1,nums) + nums[idx]);
        return map[idx];
    }

}
