import java.util.*;
public class _1212_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int [] array = new int[4];
		boolean ok=true;
		for(int i=1;i<=4;i++) {
			System.out.printf("The #%d dice: %d\n",i,array[i-1] = dice());
		}
			
		

	}
	public static int dice() {
		return((int)(Math.random()*6+1));
	}

}
