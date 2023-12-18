//411422259 蕭羽芳
import java.util.Scanner;
public class _1212_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int [] array = new int[4];//用來保存四顆骰子的點數
		boolean ok=true;//ok為true 代表沒有發生四顆骰子點數全部相同
		int x = 0;
		do {
			ok=true;
			
			//line 14-17 列出最原始的骰子結果
			System.out.printf("Your dice:");
			for(int i=0;i<4;i++) 
				System.out.printf(" %d",array[i] = dice());
			System.out.println();
			
			sort(array);//將陣列儲存個內容由小到大排序
			
			/*for(int i=0;i<4;i++)
				System.out.printf("The #%d dice: %d\n",i+1,array[i] );*/
			
			x = check(array); //用check自訂函式，檢查是否須用重骰，並記錄對子的點數為何。
			
			//line27-28 check的定義中，需要重骰就會回傳0，ok需為false
			if(x==0)
				ok=false;
			
			//System.out.println("The result is "+ok);
		}while(!ok);//等同於 while(ok == false)
		
		
		int pointFin;
		//因為在check函式中，如果是豹子，其相同的點數回傳會*10，因此只要會傳值x>6就一定是豹子。
		if(x>6) {
			System.out.println("豹子！");
			pointFin= point(array,(x/10));//如果要算積分的話，回傳值要先/10（我不確定是豹子了還要算積分嗎）
		}
		//其餘結果x應在1-6之間，即可直接用point自訂函式計算積分。
		else {
			pointFin= point(array,x);
			System.out.println("Your point is "+pointFin);
			//如果分數為3，則為鱉十
			if(pointFin == 3)
				System.out.println("鱉十...");
		}
	}
	
	public static int point(int [] a,int x) {
		int ans = 0;
		//計算四顆骰子點數加總
		for(int i=0;i<a.length;i++)
			ans += a[i];
		//減掉對子的點數，如果是雙對子，會取大的算積分(減掉小的)。
		//因為骰子骰完後會從小到大排序，並且check回傳的x值，會是第一個遇到的對子點數，所以不須用多一步去判斷，雙對子兩點數的大小。
		ans -= (x*2);
		return(ans);
	}

	public static int check(int [] a) {
		int count = 0; //計算單個點數重複次數
		int maxc = 0; //紀錄重複次數的最大值
		int num = 0; //紀錄重複次數有最大值的點數
		for(int i=0;i<a.length-1;i++) {
			count = 0;
			for(int j=i+1;j<a.length;j++)
				if(a[i]==a[j])
					count++;
			if(count>maxc) {
				maxc=count;
				num=a[i];
			}
		}
		
		if (maxc == 1) //重複次數最大值為1，表示至少有一個對子。
			return(num); //回傳對子的點數
		else if(maxc==3) //重複次數最大值為3，表示4個點數相同，為豹子。
			return(num*10); //為區分開豹子，特地將此相同的點數乘10後回傳。
		else return(0); //其餘有三個相同點數，或全部不同點數的情況，需重新骰一次，回傳0，在主程式的部分再去判斷。參考line28-29。
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
