package CP_1;

import java.util.ArrayList;  
import java.util.List;  
import java.util.Stack;  
  
public class Calculator {  
  
    /** 
     * @param args 
     */  
    public static void main(String[] args) throws Exception {  
        List<String>houzhuishi = houzhui("1 22");  
        //List<String>houzhuishi = houzhui("(600+(30000-1))/(2+1)+3*2");  
        //Double a = Calucate.recursiveCalStr("6+(3-1)/(2+1)+3*2");  
        System.out.println(calcResult(houzhuishi));  
    }  
  
    public static double calcResult(List<String> houzhishi) throws Exception{  
        Stack<Double> charStack = new Stack<Double>();  
        for (String str : houzhishi) {  
            if (getHuHao().contains(str)) {  
                Double data1 = charStack.pop();  
                Double data2 = charStack.pop();  
                charStack.push(cal(str.charAt(0),data2,data1));  
            } else {  
                charStack.push(Double.valueOf(str));  
            }  
        }  
        return charStack.peek();  
    }  
    public static List<String> getHuHao() {  
        List<String> huhao = new ArrayList<String>(0);  
        huhao.add("+");  
        huhao.add("-");  
        huhao.add("*");  
        huhao.add("/");  
        huhao.add("(");  
        huhao.add(")");  
        huhao.add("#");  
        return huhao;  
    }  
    public static Double cal(char c,double a,double b) throws Exception{  
        switch(c){  
        case '+':  
            return a+b;  
        case '-':  
            return a-b;  
        case '*':  
            return a*b;  
        case '/':  
            return a/b;  
        default:  
            throw new Exception("XX");    
        }  
    }  
      
    public static List<String> houzhui(String val) {  
        List<String> result = new ArrayList<String>();  
        Stack<String> charStack = new Stack<String>();  
        charStack.push("#");  
        val = val + "#";  
        int[][] dir = {  
                {1,1,0,0,0,1,1},  
                {1,1,0,0,0,1,1},  
                {1,1,1,1,0,1,1},  
                {1,1,1,1,0,1,1},  
                {0,0,0,0,0,2,-1},  
                {1,1,1,1,-1,1,1},  
                {0,0,0,0,0,-1,2},  
                };  
        List<String> test = new ArrayList<String>();  
        StringBuilder temp = new StringBuilder();  
        for(int i = 0 ,length = val.length(); i < length ; i++) {  
            String chr = String.valueOf(val.charAt(i));  
            if (getHuHao().contains(chr) ) {  
                if (temp.length() > 0) {  
                    test.add(temp.toString());  
                }  
                test.add(chr);  
                temp.delete(0, temp.length());  
            } else {  
                temp.append(chr);  
            }  
        }  
          
        for (int i = 0 ,size = test.size(); i < size ; i++) {  
            String str = test.get(i);  
            try {  
                Double.valueOf(str);  
                result.add(str);  
            } catch (NumberFormatException e) {  
                int x = getHuHao().indexOf(str);  
                int y = getHuHao().indexOf(charStack.peek());  
                if (dir[y][x] == 0) {  
                    charStack.push(str);  
                } else if (dir[y][x] == 1) {  
                    result.add(charStack.pop());  
                    i --;  
                } else if (dir[y][x] == 2 && (x == 5 && y == 4 )) {  
                    charStack.pop();  
                } else if (dir[y][x] == 2 && (x == 6 && y == 6 )) {  
                    break;  
                } else {  
                    break;  
                }  
            }  
        }  
        return result;  
    }  
}  