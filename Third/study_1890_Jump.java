package Third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class study_1890_Jump {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// https://www.acmicpc.net/problem/1890
		//왼쪽위에서 오른쪽 아래로, 칸에 적힌 수는 이동할 수 있는 칸의 수. 0이 종착점
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
		visited[0][0] = 1; //시작점
		for(int i =0; i < n; i++){
			for(int j = 0; j < n; j++){
				int val = map[i][j];
				if(map[i][j] == 0) { //정점 도달하거나 넘으면
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
