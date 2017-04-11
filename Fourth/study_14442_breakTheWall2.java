package Fourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class study_14442_breakTheWall2 {

	public static void main(String[] args) throws IOException {
		//https://www.acmicpc.net/problem/14442
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n =  Integer.parseInt(str[0]);
		int m =  Integer.parseInt(str[1]);
		int k =  Integer.parseInt(str[2]);
		int[][] map = new int[n+2][m+2];
		int[][][] dp = new int[n+2][m+2][k+2];
		for(int i = 1; i < n+1; i ++){
			str = br.readLine().split("");
			for(int j = 1; j < m+1; j ++){
				map[i][j] = Integer.parseInt(str[j-1]);
			}
		}
		//1개 깬경우 부터 k개 깬 경우까지 다 확인해야 함.
		int[] X = {1,0,-1,0 };
		int[] Y = {0,1,0,-1 };
		int min = Integer.MAX_VALUE;
		for(int i = 1; i < n+1; i ++){
			for(int j = 1; j < m+1; j ++){
				Arrays.fill(dp[i][j],Integer.MAX_VALUE);
			}
		}
		dp[1][1][1] = 1;
		
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(1,1,1,0));
		while(!q.isEmpty()){
			Pair p = q.poll();
			int x = p.x, y = p.y, c = p.c, wall = p.wall;
			//System.out.println("폴 "+x + ", " + y);
			for(int i = 0; i < 4; i++){
				int newX = x + X[i], newY = y + Y[i], newWall = wall, newC = c+1;
				if(newX < 1 || newY < 1 || newX > n || newY > m) continue;
				if(map[newX][newY] == 1) newWall++;
				if(newWall > k) continue;
				//System.out.println("기존 dp값 "+ dp[newX][newY][wall] + "들어올C값 "+(c));
				if(dp[newX][newY][newWall] > newC){
					dp[newX][newY][newWall] = newC;
					q.add(new Pair(newX, newY, newC, newWall));
				}
			}
		}
		for(int i = 1; i < k+1; i++){
			min = Math.min(min, dp[n][m][i]);
		}
		System.out.println(min);
	}
	static class Pair{
		int x, y, c, wall; //c는 카운트, wall은 부순 벽 개수
		public Pair(int x_, int y_, int c_, int wall_){
			x = x_; y = y_; c = c_; wall = wall_;
		}
	}

}
