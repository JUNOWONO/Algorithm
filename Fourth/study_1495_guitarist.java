package Fourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class study_1495_guitarist {
	static int n; // 곡의 개수
	static int s,m;// 시작볼륨/ 맥스볼륨
	static int[] v; //조절 가능한 볼륨 리스트, i번쨰 곡을 연주하기 전에 바꿀 수 있는 볼륨
	static int p; // 현재 볼륨
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		//https://www.acmicpc.net/problem/1495
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		s = Integer.parseInt(str[1]);
		m = Integer.parseInt(str[2]);
		v = new int[n+1];
		str = null;
		str = br.readLine().split(" ");
		for(int i = 0; i < n; i++){
			v[i] = Integer.parseInt(str[i]);
		}
		//Input end
		dp = new int[n+1][m+1];
		dp[0][s] = 1; 
		for(int i = 0; i < n; i++){ // i번 곡 까지
 			for(int j = 0; j < m+1; j++){ // 볼륭j가 나올 수 있는지
 				if(dp[i][j] == 0){} // i까지에서 j를 못만들면 패스
 				else{ //j를 만들 수 있으면
 					if(j  >= v[i]) dp[i+1][j-v[i]] = 1; //i+1까지에서 j-v[i]를 만들 수 있음
 					if(j <= m - v[i]) dp[i+1][j+v[i]] = 1; // j+v[i]를 만들 수 있음
 				}
			}
		}
		boolean flag = false;
		for(int i = m; i > -1; i--){
			if(dp[n][i] == 1){
				flag = true;
				System.out.println(i);
				break;
			}
		}
		if(flag == false)System.out.println(-1);
		
		
	}

}
