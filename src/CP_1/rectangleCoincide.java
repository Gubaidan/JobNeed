package CP_1;

import java.util.Scanner;
import java.util.Collections;;
//矩形重合
public class rectangleCoincide {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int n = scanner.nextInt();
			int x1[] = new int[n];
			int y1[] = new int[n];
			int x2[] = new int[n];
			int y2[] = new int[n];

			for(int i = 0; i<n;i++ ){
				x1[i] = scanner.nextInt();
			}
			for(int i = 0; i<n;i++ ){
				y1[i] = scanner.nextInt();
			}
			for(int i = 0; i<n;i++ ){
				x2[i] = scanner.nextInt();
			}
			for(int i = 0; i<n;i++ ){
				y2[i] = scanner.nextInt();
			}
			dealArray(x1,y1,x2,y2);
		}
	}
	
	public static void dealArray(int[] x1,int[] y1,int[] x2,int[] y2){
		double middleX[] = new double[4];
		double middleY[] = new double[4];
		int n = x1.length;
		int max = 0;
		for(int k = 0; k < n; k++){
			int count = 0;
			for(int j = 0; j < n; j++){
				middleX[0] = x1[k];				
				middleX[1] = x2[k];			
				middleX[2] = x1[j];			
				middleX[3] = x2[j];
				
				middleY[0] = y1[k];
				middleY[1] = y2[k];
				middleY[2] = y1[j];
				middleY[3] = y2[j];
				quickSort(middleX, 0, middleX.length-1);
				quickSort(middleY, 0, middleY.length-1);
				double midX = (middleX[1] + middleX[2])/2.0;
				double midY = (middleY[1] + middleY[2])/2.0;
				if((midX > x1[k] && midX < x2[k]) && (midY > y1[k] && midY < y2[k])){
					if((midX > x1[j] && midX < x2[j]) && (midY > y1[j] && midY < y2[j])){
						count++;
					} 
				}  
			}
			if(count > max) max = count;
		}
		System.out.print(max);
	}
	
	public static void quickSort(double[] array,int lo ,int hi){
	    if(lo>=hi){
	        return ;
	    }
	    //进行第一轮排序获取分割点
	    int index=partition(array,lo,hi);
	    //排序前半部分
	    quickSort(array, lo, index - 1);
	    //排序后半部分
	    quickSort(array,index+1,hi);
	}
	public static int partition(double []array,int lo,int hi){
	    /** 固定的切分方式 */
		double key=array[lo];//选取了基准点
	    while(lo<hi){
	        //从后半部分向前扫描
	        while(array[hi]>=key&&hi>lo){
	            hi--;
	        }
	        array[lo]=array[hi];
	        //从前半部分向后扫描
	        while(array[lo]<=key&&hi>lo){
	            lo++;
	        }
	        array[hi]=array[lo];
	    }
	    array[hi]=key;//最后把基准存入
	    return hi;
	}

}
