package Third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class study_paperPiece_14391 {
	static int[][] map;
	static int n,m;
	static ArrayList<Integer> sumList;
	public static void main(String[] args) throws IOException {
		//https://www.acmicpc.net/problem/14391
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputString = br.readLine().split(" ");
		n = Integer.parseInt(inputString[0]);
		m = Integer.parseInt(inputString[1]);
		map = new int[n+1][m+1];
		sumList = new ArrayList<Integer>();
		sumList.add(0);
		for(int i = 0; i < n; i++){
			String[] input = br.readLine().split("");
			for(int j = 0; j < m; j++){
				//System.out.println(input[j+1]);
				map[i][j] = Integer.parseInt(input[j+1]);
			}
		}
		//4�ڸ� ������ �ذ��ϰ� ���� �ڸ� ����. 0�� ����
		solve(0,n-1,0,m-1,0);
		
		int max = 0;
		for(Integer i : sumList){
			//System.out.println(i);
			if(i > max) max = i;
		}
		//System.out.println(sumList.get(1));
		System.out.println(max);
		
	}
	public static void solve(int N_start, int N_end, int M_start, int M_end, int sumIndex){
		StringBuffer strBff = new StringBuffer();
		int zeroCount = 0;
		boolean flag = false;
		if(n > m){ //���ΰ� �� ���
			for(int i = M_start; i < M_end+1; i++){
				if(map[N_start][i] != 0){ //���� 0 �� �ƴϸ�
					if(flag == true){ //������ ���� 0 �̾��� ���
						flag = false;
						if(zeroCount != 0){
							//������ �������� �ٽ� ����
							solve(N_start+1, N_end, i-zeroCount+1, i, sumIndex);
							zeroCount = 0;
						}
					}
					for(int j = N_start; j < N_end+1; j++){
						strBff.append(map[j][i]); //���η� �� �� 
						map[j][i] = 0;
					}
					sumList.set(sumIndex, sumList.get(sumIndex) + Integer.parseInt(strBff.toString())); // ������� ���ϱ�
					strBff = new StringBuffer();
				}
				else{ // 0�� ��� 
					zeroCount++;
					flag = true;
					if(i == M_end){
						solve(N_start+1, N_end, i-zeroCount+1, i, sumIndex);
					}
				}
			}
		}
		else if (n < m){ //���ΰ� �� ���
			for(int i = N_start; i < N_end+1; i++){
				if(map[i][M_start] != 0){ //���� 0 �� �ƴϸ�
					if(flag == true){ //������ ���� 0 �̾��� ���
						flag = false;
						if(zeroCount != 0){
							//������ �������� �ٽ� ����
							solve(i-zeroCount+1, i, M_start +1, M_end, sumIndex);
							zeroCount = 0;
						}
					}
					for(int j = M_start; j < M_end+1; j++){
						strBff.append(map[i][j]); //���� �� �� 
						map[i][j] = 0;
					}
					sumList.set(sumIndex, sumList.get(sumIndex) + Integer.parseInt(strBff.toString())); // ������� ���ϱ�
					strBff = new StringBuffer();
				}
				else{ // 0�� ��� ��
					zeroCount++;
					flag = true;
					if(i == N_end){
						solve(i-zeroCount+1, i, M_start +1, M_end, sumIndex);
					}
				}
			}
		}
		else{ // ���� ���� ���� ��� 
			sumList.add(sumList.get(sumIndex));
			solve(N_start, N_end+1, M_start, M_end, sumIndex);
			solve(N_start, N_end, M_start, M_end+1, sumIndex+1);
		}
		
		if(N_start == N_end && M_start == M_end){
			return;
		}
	}
}
