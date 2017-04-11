package Second;

import java.util.Scanner;

public class study_1699_ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int boundary = (int) (Math.sqrt(n)+1);
		int[] dp = new int[n+2];
		int[] sq = new int[n+2];
		for( int i = 0; i < boundary+1; i++) {
			sq[i] = i*i;
		}
		for( int i = 1; i < n+1; i++) {
			dp[i] = i;
		}
		//System.out.println(boundary);
		for( int i = 2; i < n+1; i++){
			for(int j = 1; sq[j]< i+1; j++){
				//System.out.println(j + "," + sq[j]);
				if(dp[i] > dp[i-sq[j]] +1){
					dp[i] = dp[i-sq[j]] +1;
				}
				//System.out.println(dp[i]);
			}
		}
		System.out.println(dp[n]);
	}

}
