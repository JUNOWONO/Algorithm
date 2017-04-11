package Fifth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class study_9084_coin {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// https://www.acmicpc.net/problem/9084
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		ArrayList<Integer> ansList = new ArrayList<Integer>();
		for(int c = 1; c < t+1; c++){
			int n = Integer.parseInt(br.readLine());
			int[] coin = new int[n+2];
			String[] str = br.readLine().split(" ");
			for(int i = 1; i < n+1; i ++){
				coin[i] = Integer.parseInt(str[i-1]);
			}
			int m = Integer.parseInt(br.readLine());
			int[] dp = new int[m+2]; //m원까지 n원의 코인을 사용
			dp[0] = 1;
			
			for(int i = 1; i < n+1; i ++){ //i번 코인으로
				for(int j = coin[i]; j < m+1; j++){
					dp[j] += dp[j-coin[i]];
				}
			}
			ansList.add(dp[m]);
			
		}
		
		for(int ans : ansList){
			System.out.println(ans);
		}
	}
}
