import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class study_2156_grapeWine {

	public static void main(String[] args) throws IOException {
		// https://www.acmicpc.net/problem/2156 포도주 문제
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] dp;
		int[] wine = new int[n+1];
		dp = new int[n+1][3]; // [n번째][x]// x는 자기포함 연속으로 마신 수
		for(int i = 1; i < n+1; i++){
			wine[i] = Integer.parseInt(br.readLine());
		}
		if(n == 1) { System.out.print(wine[1]); return;}
		else if( n == 2) { System.out.print(wine[1] + wine[2]); return;}
		dp[1][0] = 0;
		dp[1][1] = wine[1];
		dp[2][0] = wine[1];
		dp[2][1] = wine[2];
		dp[2][2] = wine[1] + wine[2];
		
		for(int i = 3; i < n+1; i++){
			dp[i][0] = max(dp[i-1][1], dp[i-1][2], dp[i-1][0]);
			dp[i][1] = dp[i-1][0] + wine[i];
			dp[i][2] = dp[i-1][1] + wine[i];
		}
		System.out.println(max(dp[n][0], dp[n][1], dp[n][2]));
	}

	static int max(int a, int b){
		if(a > b) return a;
		else return b;
	}
	static int max(int a, int b, int c){
		if(a > b) {
			if(a > c) return a;
			else return c;
		}
		else {
			if(b > c) return b;
			else return c;
		}
	}
}
