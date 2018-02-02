package CP_1;

import java.util.Scanner;
import java.util.Stack;  

public class Calcutelate {  
    //将算术表达式转换为后缀表达式的函数，结果一字符串的形式返回  
    public static String converToPostfix(String expression)throws Exception{  
        Stack<Character> st=new Stack<>();   //初始化一个运算符栈  
        String postfix=new String();   //用于储存后缀表达式  
        int spaceNum = 0;
        int spaceNum = 0;
        for(int i=0;expression!=null&&i<expression.length();i++){  
            char c=expression.charAt(i);  
            if(' '!=c){  
                //为左括号  
                if(isOpenParent(c)){  
                    st.push(c);  
                }//为右括号  
                else if(isCloseParent(c)){  
                    char ac=st.pop();  
                    while(!isOpenParent(ac)){  
                        postfix=postfix.concat(String.valueOf(ac));  
                        ac=st.pop();  
                    }  
                }//为运算符  
                else  if(isOperator(c)){  
                    //运算栈非空，取出栈顶优先级高的运算符送完后缀表达式  
                    if(!st.empty()){  
                        char ac=st.pop(); 
                        //栈取出的字符优先级比c高  
                        System.out.println("ac:"+ac +","+priority(ac));
                        System.out.println("ac:"+c +","+priority(c));
                        while(!st.isEmpty()&&(priority(ac) >= priority(c))){  
                            postfix=postfix.concat(String.valueOf(ac));  
                            ac=st.pop();  
                        }
                        //栈取出的字符优先级比c低，则将取出的字符重新入栈  
                        if(ac!=' '){  
                            st.push(ac);  
                        }  
                    }st.push(c);    //将c入栈  
                }//为操作数，直接串联到postfix内  
                else {  
                    postfix=postfix.concat(String.valueOf(c));  
                }  
            }else if(' '==c){
            	spaceNum++;
			} 
            
        }//当表达式读完就将算术栈pop出加入postfix  
        if (st.isEmpty() && spaceNum > 0) {
        	return "Error";  
		}else if(st.isEmpty() && spaceNum == 0){
			return "normal";
		}
        while(!st.isEmpty()){  
            postfix=postfix.concat(String.valueOf(st.pop()));  
              
        }  
        return postfix;  
    }  
    //对后缀表达式进行运算的函数  
    public static double numberCalculate(String postfix)throws Exception{  
        Stack st=new Stack<>();//创建一个操作数栈  
        for(int i=0;postfix!=null&&i<postfix.length();i++){  
            char c=postfix.charAt(i);  
            //如果为运算符  
            if(isOperator(c)&&!st.isEmpty()){  
                double d2=Double.valueOf(st.pop().toString());  
                double d1=Double.valueOf(st.pop().toString());  
                double d3=0;  
                if('+'==c){  
                    d3=d1+d2;  
                }  
                if('-'==c){  
                    d3=d1-d2;  
                }  
                if('/'==c){  
                    d3=d1/d2;  
                }  
                if('*'==c){  
                    d3=d1*d2;  
                }  
                if('%'==c){  
                    d3=d1%d2;  
                }  
                if('^'==c){  
                    d3=Math.pow(d1, d2);  
                }  
                //将运算结果压入操作数栈中  
                st.push(d3);  
            }else{//为操作数时直接压入操作数栈  
            st.push(c);}  
        }  
        return (double) st.pop();//返回运算结果  
    }  
    //判断字符为运算符  
    public static boolean isOperator(char c){  
        if('+'==c||'-'==c||'/'==c||'*'==c||'%'==c||'^'==c){  
            return true;  
        }  
        else {  
            return false;  
        }  
    }  
    //判断字符为左括号  
    public static boolean isOpenParent(char c){  
        return c=='(';  
    }  
    //判断字符为右括号  
    public static boolean isCloseParent(char c){  
        return c==')';  
    }  
    //判断算法的优先级  
    public static int priority(char c){   
        if(c=='*'){  
            return 1;  
        }  
        else if(c=='-'||c=='+'){  
            return 1;  
        }  
        else return 0;  
    }  
      
      
  
    public static void main(String[] args) throws Exception {   
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
			String string = scanner.nextLine();
			String postfix =converToPostfix(string);  
	        if(postfix.equals("Error")){
	        	System.out.println("Error");  
	        }else if(postfix.equals("normal")){
	        	System.out.println(string);
	        }else{
	        	System.out.println((int)numberCalculate(postfix) + ",postfix:"+postfix); 
	        }

		}
    }  
  
}