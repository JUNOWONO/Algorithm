package Sixth;

import java.util.Scanner;

public class study_9663_NQueen {
	static int n;
	static int count;
	static int[] lastColumnPosition;
	public static void main(String[] args) {
		//https://www.acmicpc.net/problem/9663
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		count = 0;
		lastColumnPosition = new int[n+2];
		solve(1);
		System.out.println(count);
	}
	
	static void solve(int n_th_Q){
		if(n_th_Q == n+1){
			count++;
			return;
		}
		for(int i = 1; i < n+1; i++){ // 각 컬럼에 대해서 
			boolean flag = true;
			for(int j = 1; j < n_th_Q; j++){ //지난 퀸들의 인덱스
				if( i == lastColumnPosition[j] || 
					i == lastColumnPosition[j] + n_th_Q - j ||
					i == lastColumnPosition[j] - n_th_Q + j) 
				{ flag = false; }
			}
			if(flag  == false) continue;
			lastColumnPosition[n_th_Q] = i;
			solve(n_th_Q + 1);
		}
	}
	
}
