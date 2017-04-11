package Fourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class study_1613_history {
	static int[][] map;
	public static void main(String[] args) throws IOException {
		//https://www.acmicpc.net/problem/1613
		int n, k;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		k = Integer.parseInt(str[1]);
		map = new int[n+2][n+2];
		for(int i = 0; i < k; i ++){
			str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			map[x][y] = -1; //x -> y
			map[y][x] = 1; // y -> x
		}
		for(int kk = 1; kk < n+1; kk++){
			for(int x = 1; x < n+1; x++){
				for(int y = 1; y < n+1; y++){
					if(map[x][kk] != 0 && map[x][kk] == map[kk][y]){
						map[x][y] = map[x][kk];
					}
				}
			}
		}
		
		int s = Integer.parseInt(br.readLine());
		for(int i = 0; i < s; i ++){
			str = br.readLine().split(" ");
			System.out.print(map[Integer.parseInt(str[0])][Integer.parseInt(str[1])]+"\n");
		}
	}

}
