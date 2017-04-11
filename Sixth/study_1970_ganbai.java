package Sixth;

import java.util.Arrays;
import java.util.Scanner;

public class study_1970_ganbai {
	static int[][] dp;
	static int[] brand;
	public static void main(String[] args) {
		// https://www.acmicpc.net/problem/1970
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dp = new int[N+2][N+2];
		brand = new int[N+2];
		for(int i = 1; i < N+1;  i++){
			brand[i] = sc.nextInt();
		}
		
		for(int i = 0; i < N+1; i++){
			Arrays.fill(dp[i], -1);
		}
		System.out.println(solve(1,N));
	}
	
	static int solve(int left, int right){
		if(left > right) return 0; //����
		if(dp[left][right] != -1) return dp[left][right]; //������ ���� ������ Ȱ��
		
		int tmp = 0;
		tmp = Math.max(tmp,solve(left+1, right)); 
		for(int i = left+1; i < right+1; i++){ //���� ������� �ΰ��� �˻�
			if(brand[left] == brand[i]){ //start�� i��°�� ��Ī�� �Ǹ�
				tmp = Math.max(tmp, 1 + solve(left+1, i-1) + solve(i+1, right)); //i�����ϰ� �κ����� ������ ����
			}
		}
		
		dp[left][right] = tmp;
		return tmp;
	}

}
