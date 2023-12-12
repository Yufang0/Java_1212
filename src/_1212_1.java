import java.util.*;
public class _1212_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int [] array = new int[4];//用來保存四顆骰子的點數
		boolean ok=true;//ok為true 代表沒有發生四顆骰子點數全部相同
		do {
			for(int i=0;i<4;i++) 
				System.out.printf("The #%d dice: %d\n",i+1,array[i] = dice());
			sort(array);//將陣列儲存個內容由小到大排序
			for(int i=0;i<4;i++)
				System.out.printf("The #%d dice: %d\n",i+1,array[i] );
			System.out.println("The result is "+(ok=check(array)));//呼叫副程式檢查陣列內容是否倆倆不重複
		}while(!ok);
		

	}
	public static boolean check(int [] a) {
		for(int i=0;i<a.length-1;i++)
			if(a[i]==a[i+1])
				return(true);
		return(false);
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
