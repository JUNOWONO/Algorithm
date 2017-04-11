package Fifth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class study_2163_chocoCut {

	public static void main(String[] args) throws IOException {
		//https://www.acmicpc.net/problem/2163
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int[] dp = new int[n*m+2];
		dp[2] = 1;
		for(int i = 3; i < n*m+1; i ++){
			dp[i] = dp[i-1] + 1;
		}
		System.out.println(dp[n*m]);
	}	

}
