package Fourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class study_2225_sumCase {

	public static void main(String[] args) throws IOException {
		// https://www.acmicpc.net/problem/2225
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int k = Integer.parseInt(str[1]);
		int[][] dp = new int[n+2][k+2];

		Arrays.fill(dp[0], 1);
		final int NAMEJI = 1000000000;
		for(int i = 1; i < n+1; i ++){
			for(int j = 1; j < k+1; j++){
				dp[i][j] = (dp[i][j-1]%NAMEJI + dp[i-1][j]%NAMEJI)%NAMEJI;
			}
		}
		System.out.println(dp[n][k]);
		
	}

}
