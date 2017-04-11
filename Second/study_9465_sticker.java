package Second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class study_9465_sticker {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int testNum = Integer.parseInt(br.readLine());
		for(int i = 1; i < testNum+1; i ++){
			int n = Integer.parseInt(br.readLine());
			int[][] map =new int[3][n+2]; //[1,2][n번째]
			int[][] dp = new int[4][n+2]; //[1/2][n번째]
			int tmp = 1;
			int tmp2 = 0;
			String[] str = br.readLine().split(" ");
			for(int j = 1; j < 2*n+1; j++){
				map[tmp][j - tmp2] = Integer.parseInt(str[j-1- tmp2]);
				if(j == n) {
					tmp++;
					tmp2 = n;
					str = br.readLine().split(" ");
				}
			}
			dp[1][1] = map[1][1];
			dp[2][1] = map[2][1];
			for(int k = 1; k < n; k++){
				dp[1][k+1] = Math.max(dp[2][k], dp[2][k-1]) + map[1][k+1];
				dp[2][k+1] = Math.max(dp[1][k], dp[1][k-1]) + map[2][k+1];
			}
			System.out.println(Math.max(dp[1][n], dp[2][n]));
			
		}
		
	}
	
}
