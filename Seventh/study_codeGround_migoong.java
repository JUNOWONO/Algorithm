package Seventh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class study_codeGround_migoong {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// https://www.codeground.org/practice/practiceProbView.do?probId=6
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCaseNum = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < testCaseNum; t++){
			int x = 1,y = 1,sum = 1;
			
			String[] str = br.readLine().split(" ");
			int N = Integer.parseInt(str[0]);
			int M = Integer.parseInt(str[1]);
			int[] lineMax = new int[N*2 +2];
			lineMax[1] = 1;
				
			for(int i = 2; i<N+1; i++){
				lineMax[i] = lineMax[i-1] + i;	
			}
			for(int i = N+1; i<N*2; i++){
				lineMax[i] = lineMax[i-1] + N*2 -i;	
			}
			
			char[] arr = br.readLine().toCharArray();
			for(int i = 0; i < M; i ++){
				if(arr[i] == 'R'){
					x++;
				}else if(arr[i] == 'D'){
					y++;
				}else if(arr[i] == 'L'){
					x--;
				}else if(arr[i] == 'U'){
					y--;
				}
				int isOdd = (x+y)%2; //0�̸� ¦��, 1�̸� Ȧ��
				int NthLine = (x+y)-1;
				
				if(isOdd == 0){ //¦���϶� -> ���������� ����
					int gab = y - 1;//y�� 1�̵ɋ����� ��ĭ?
					
					sum += lineMax[NthLine] - gab;
					System.out.println(sum);
				}else{ //Ȧ���϶� -> ���ʾƷ��� ����
					int gab = x - 1; //x�� 1�̵ɶ�����
					sum += lineMax[NthLine] - gab;  
					System.out.println(sum);
				}
				
			}
			System.out.println("Case #" + (t+1));
			System.out.println(sum);
			
			
		}
	}

}
