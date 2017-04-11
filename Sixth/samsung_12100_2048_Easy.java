package Sixth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class samsung_12100_2048_Easy {
	static int N;
	static int[][] map;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int max = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// https://www.acmicpc.net/problem/12100
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N+2][N+2];
		String[] str;
		for(int i = 1; i < N+1; i ++){
			str = br.readLine().split(" ");
			for(int j = 1; j < N+1; j ++){
				map[i][j] = Integer.parseInt(str[j-1]);
				if(map[i][j] > max) max = map[i][j];
			}
		}
		play(map,0,0);
		play(map,0,1);
		play(map,0,2);
		play(map,0,3);
		System.out.println(max);
	}
	static void play(int[][] m, int count, int dir){
		int[][] tmpMap = new int[N+2][N+2];
		
		for(int row = 1; row < N+1; row++){ //모든 열 or행에 대해서
			//1. 해당방향으로 다 붙임, 2. 한번만 합침, 3. 빈자리 있으면 벽으로 붙이기
			boolean[] used = new boolean[N+2];
			if(dir == 0){
				tmpMap[row][N] = m[row][N];
				for(int col = N-1; col > 0; col--){
					int value = m[row][col];
					if(value==0) continue;
					int i = col;
					while(i < N){
						if(tmpMap[row][i+1]==0){ //비었으면
							i++;
							continue;
						}else if(tmpMap[row][i+1] == value && used[i+1] == false){ // 합칠 수 있으면
							tmpMap[row][i+1] = 2*value;
							if(tmpMap[row][i+1] > max) max = tmpMap[row][i+1];
							used[i+1] = true;
							i++;
							break;
						}else{
							break;
						}
					}
					if(tmpMap[row][i] == 0) tmpMap[row][i] = value;
				}
			}else if(dir == 2){
				tmpMap[row][1] = m[row][1];
				for(int col = 2; col < N+1; col++){
					int value = m[row][col];
					if(value==0) continue;
					int i = col;
					while(i > 1){
						if(tmpMap[row][i-1]==0){ //비었으면
							i--;
							continue;
						}else if(tmpMap[row][i-1] ==value && used[i-1] == false){ // 같은거
							tmpMap[row][i-1] = 2*value;
							if(tmpMap[row][i-1] > max) max = tmpMap[row][i-1];
							used[i-1] = true;
							i--;
							break;
						}else{
							break;
						}
					}
					if(tmpMap[row][i] == 0) tmpMap[row][i] = value;
				}
			}else if(dir == 1){
				tmpMap[N][row] = m[N][row];
				for(int ro = N-1; ro > 0; ro--){
					int value = m[ro][row];
					if(value==0) continue;
					int i = ro;
					while(i < N){
						if(tmpMap[i+1][row]==0){ //비었으면
							i++;
							continue;
						}else if(tmpMap[i+1][row] == value && used[i+1] == false){ // 같은거
							tmpMap[i+1][row] = 2*value;
							if(tmpMap[i+1][row] > max) max = tmpMap[i+1][row];
							used[i+1] = true;
							i++;
							break;
						}else{
							break;
						}
					}
					if(tmpMap[i][row] == 0) tmpMap[i][row] = value;
				}
			}else if(dir == 3){
				tmpMap[1][row] = m[1][row];
				for(int ro = 2; ro < N+1; ro++){
					int value = m[ro][row];
					if(value==0) continue;
					int i = ro;
					while(i > 1){
						if(tmpMap[i-1][row]==0){ //비었으면
							i--;
							continue;
						}else if(tmpMap[i-1][row] == value && used[i-1] == false){ // 같은거
							tmpMap[i-1][row] = 2*value;
							if(tmpMap[i-1][row] > max) max = tmpMap[i-1][row];
							used[i-1] = true;
							i--;
							break;
						}else{
							break;
						}
					}
					if(tmpMap[i][row] == 0) tmpMap[i][row] = value;
				}
			}
		}
		count++;
		if(count == 5){
			return;
		}
		
		for(int i = 0; i < 4; i ++){
			play(tmpMap,count, i);
		}
	}
}


