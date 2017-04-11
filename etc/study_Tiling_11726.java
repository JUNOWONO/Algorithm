import java.util.Scanner;


public class study_Tiling_11726 {

	public static void main(String[] args) {
		//11727¹ø
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n == 1) {
			System.out.println(1);
			return;
		} 
		int[] dp = new int[n+1];
		dp[1] = 1;
		dp[2] = 3;
		for(int i = 3; i < n+1; i++){
			dp[i] = dp[i-2]*2 + dp[i-1];
			dp[i] = dp[i] % 10007; 
		}
		System.out.println(dp[n]);
		
		
		
		/* 11726¹ø
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n == 1) {
			System.out.println(1);
			return;
		} 
		int[] dp = new int[n+1];
		dp[1] = 1;
		dp[2] = 2;
		//dp[3] = 3;
		// 1 2 3 5 8...
		for(int i = 3; i < n+1; i++){
			dp[i] = dp[i-2] + dp[i-1];
			dp[i] = dp[i] % 10007; 
		}
		System.out.println(dp[n]);
		*/
	}

}
