import java.util.*;
public class _1212_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int [] array = new int[4];//用來保存四顆骰子的點數
		boolean ok=true;//ok為true 代表沒有發生四顆骰子點數全部相同
		for(int i=1;i<=4;i++) 
			System.out.printf("The #%d dice: %d\n",i,array[i-1] = dice());
		sort(array);
		for(int i=0;i<4;i++)
			System.out.printf("The #%d dice: %d\n",i+1,array[i] );
			
		

	}
	public static void sort(int [] a) {
		for(int i=0;i<a.length;i++)
			for(int j=i+1;j<a.length;j++)
				if(a[i]>=a[j]) {
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
					
				
	}
	public static int dice() {//用來模擬丟一顆骰子的副程式。被呼叫就會產生介於1-6的整數並回傳。
		return((int)(Math.random()*6+1));
	}

}
