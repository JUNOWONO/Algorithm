package Sixth;

import java.util.Scanner;

public class study_1019_pageCount {

	public static void main(String[] args) {
		//https://www.acmicpc.net/problem/1019
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] result = new int[11];
		
		//각 자리의 수를 구하는 방법으로 접근 (1의자리 10의 자리 100의 자리..)
		//10~39 면 각 자리의 수가 (3-1)+1
		//1350 ~8739 면 각 자리수가 873-135 +1 개 
		//1는 결과에 *1; 10의자리는 *10; 100의 자리는 *1000;
		//두 수의 끝자리수만 0으로 맞춰주면 됨

		
//		1350 /10 -> 135 1의자리 (135+1) *1
//		135 / 10 -> 13 10의자리 (13+1) * 10
//		13 -> 1 100의자리 (1+1)*100
//		//1 -> 0 1000의 자리 <-이거는 따로 (0+1)*1000 
		int start = 1;
		int end = n;
		while(start <= end){
			//start의 끝을 0으로
			//end의 끝을 9까지
			
		}
	}
}
