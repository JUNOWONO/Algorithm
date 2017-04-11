import java.util.Scanner;


public class beeHouse_2292 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n==1) {
			System.out.println(1);
			return;
		}
		int count = 0;
		
		int tmp = 0;
		int now = 0;
		int i = 1;
		while(true){
			if(now >= n) break;
			now = 6 * tmp + 1;
			tmp += i;
			i++;
			count ++;
			
		}
		System.out.println(count);
	}

}
