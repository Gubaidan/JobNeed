package CP_1;

public class Jump_1or2 {

	public static void main(String[] args) {
		System.out.println(search(10));

	}
	
	public static int search(int n){
		if(n <= 0) return 0;
		if(n == 1) return 1;
		if(n == 2) return 2;
		if(n == 2) return 2;
		if(n == 2) return 2;
		if(n == 2) return 2;
		return search(n - 1) + search(n - 2);
	}
	
    public static int JumpFloor(int target) {
        if (target < 0){
            return 0;
        }
        if (target == 1){
            return 1;
        }
        if (target == 2){
            return 2;
        }
        
        int result = 0;
        int x1 = 1, x2 = 2;
        
        for (int i = 2; i < target; i++){
            result = x1 + x2;
            x1 = x2;
            x2 = result;
        }
        return result;
    }

}
