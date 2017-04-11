package Fourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class study_4781_CandyShop {

	public static void main(String[] args) throws IOException {
		// https://www.acmicpc.net/problem/4781
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			int n; //사탕 종류 수
			int m; //보유 금액
			String[] str = br.readLine().split(" ");
			n = Integer.parseInt(str[0]);
			m = (int)(Float.parseFloat(str[1])*100);
			//System.out.println(n + ","  + m);
			if(n == 0){
				break;
			}
			int[] cal = new int[n+2];
			int[] pri = new int[n+2];
			for(int i = 1; i < n+1; i ++){
				str = br.readLine().split(" ");
				cal[i] = Integer.parseInt(str[0]);
				pri[i] = (int)(Float.parseFloat(str[1])*100);
			}
			int[] dp = new int[m+2];
			for(int i = 1; i < n+1; i ++){  //모든 항목에 대해서
				for(int j = pri[i]; j < m+1; j ++){ 
					dp[j] = Math.max(dp[j], dp[j-pri[i]] + cal[i]);
				}
			}
			System.out.println(dp[m]);
		}
	}

}
