package Fourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class study_1495_guitarist {
	static int n; // ���� ����
	static int s,m;// ���ۺ���/ �ƽ�����
	static int[] v; //���� ������ ���� ����Ʈ, i���� ���� �����ϱ� ���� �ٲ� �� �ִ� ����
	static int p; // ���� ����
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
		for(int i = 0; i < n; i++){ // i�� �� ����
 			for(int j = 0; j < m+1; j++){ // ����j�� ���� �� �ִ���
 				if(dp[i][j] == 0){} // i�������� j�� ������� �н�
 				else{ //j�� ���� �� ������
 					if(j  >= v[i]) dp[i+1][j-v[i]] = 1; //i+1�������� j-v[i]�� ���� �� ����
 					if(j <= m - v[i]) dp[i+1][j+v[i]] = 1; // j+v[i]�� ���� �� ����
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
