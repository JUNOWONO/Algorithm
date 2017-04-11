package Third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class study_1890_Jump {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// https://www.acmicpc.net/problem/1890
		//���������� ������ �Ʒ���, ĭ�� ���� ���� �̵��� �� �ִ� ĭ�� ��. 0�� ������
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n+1][n+1];
		long[][] visited = new long [n+1][n+1];
		for(int i =0; i < n; i++){
			String[] str = br.readLine().split(" ");
			for(int j = 0; j < n; j++){
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		visited[0][0] = 1; //������
		for(int i =0; i < n; i++){
			for(int j = 0; j < n; j++){
				int val = map[i][j];
				if(map[i][j] == 0) { //���� �����ϰų� ������
				}
				else{
					if(i + val < n) visited[i+map[i][j]][j] += visited[i][j];
					if(j + val < n) visited[i][j+map[i][j]] += visited[i][j];
				}
			}
		}
		
		System.out.println(visited[n-1][n-1]);
	}
}
