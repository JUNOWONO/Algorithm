package Fifth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class study_11052_carpBread {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// https://www.acmicpc.net/problem/11052
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] list = new int[n+2];
		String[] str = br.readLine().split(" ");
		for(int i = 1; i < n+1; i++){
			list[i] = Integer.parseInt(str[i-1]);
		}
		
		int[] dp = new int[n+2]; 
		for(int i = 1; i < n+1; i ++){
			for(int j = 1; j < i+1; j ++){
				dp[i] = Math.max(dp[i-j]+list[j],dp[i] );
			}
		}
		System.out.println(dp[n]);
	}
}
