package Sixth;

import java.util.Scanner;

public class study_1019_pageCount {

	public static void main(String[] args) {
		//https://www.acmicpc.net/problem/1019
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] result = new int[11];
		
		//�� �ڸ��� ���� ���ϴ� ������� ���� (1���ڸ� 10�� �ڸ� 100�� �ڸ�..)
		//10~39 �� �� �ڸ��� ���� (3-1)+1
		//1350 ~8739 �� �� �ڸ����� 873-135 +1 �� 
		//1�� ����� *1; 10���ڸ��� *10; 100�� �ڸ��� *1000;
		//�� ���� ���ڸ����� 0���� �����ָ� ��

		
//		1350 /10 -> 135 1���ڸ� (135+1) *1
//		135 / 10 -> 13 10���ڸ� (13+1) * 10
//		13 -> 1 100���ڸ� (1+1)*100
//		//1 -> 0 1000�� �ڸ� <-�̰Ŵ� ���� (0+1)*1000 
		int start = 1;
		int end = n;
		while(start <= end){
			//start�� ���� 0����
			//end�� ���� 9����
			
		}
	}
}
