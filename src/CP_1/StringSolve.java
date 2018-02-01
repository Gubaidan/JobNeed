package CP_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;
//字符串全排列 包含重复
public class StringSolve {
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();

        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(),new String() ,0, res);
            Collections.sort(res);
        }
 
        return res;
    }
 
    private static void PermutationHelper(char[] cs, String driven,int i, ArrayList<String> list) {
        if(i == cs.length - 1) { //解空间的一个叶节点
            list.add(new String(driven)); //找到一个解
        } else {
            for(int j = 0; j < cs.length; j++) {
                if(driven.indexOf(cs[j]) != -1) continue;
                    driven += String.valueOf(cs[j]);
                    PermutationHelper(cs, driven,i + 1, list);
                    driven.substring(0,driven.length() - 1); //复位
                
            }
        }
    }



	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			String string = scanner.nextLine();
			ArrayList<String> rArrayList = Permutation(string);	
			for (String s:rArrayList) {
				System.out.println(s);
			}
		}

	}

}
