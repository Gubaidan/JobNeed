package CP_1;
import java.util.Scanner;

public class Main {
 
 public static long PermutationHelper(long M, long N){
  long res = 1;
  for(int i=0;i<N;i++){
   res *= (M-i);
  }
  return res;
 }
 
 public static void main(String args[]) {
  Scanner sc = new Scanner(System.in);
  while(sc.hasNext()){
   long K = Long.parseLong(sc.nextLine());
   String str = sc.nextLine();
   String [] data = str.split(" ");
   long A = Long.parseLong(data[0]);
   long X = Long.parseLong(data[1]);
   long B = Long.parseLong(data[2]);
   long Y = Long.parseLong(data[3]);
   
   long count = 0;
   long a = (K-count*B)/A;
   long mod = (K-count*B)%A;
   long result = 0;
   while(count<=Y){
    if(a>=0 && mod == 0 && a<=X){
     result += PermutationHelper(X, a)*PermutationHelper(Y, count);
    }
    count++;
    mod = (K-count*B)%A;
    a = (K-count*B)/A;
   }
   
   
   System.out.println(result % 1000000007);
  }
 }

}