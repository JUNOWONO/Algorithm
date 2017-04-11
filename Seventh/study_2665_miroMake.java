package Seventh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class study_2665_miroMake {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// https://www.acmicpc.net/problem/2665
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[][] map = new char[n+2][n+2];
		for(int i = 1; i < n+1; i ++){
			char[] arr = br.readLine().toCharArray();
			for(int j = 1; j < n+1; j++){
				map[i][j] = arr[j-1];
			}
		}
		int result = 0;
		int[][] visited = new int[n+2][n+2];
		for(int i = 1; i < n+1; i ++){
			Arrays.fill(visited[i], Integer.MAX_VALUE);
		}
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		PriorityQueue<Pair> q = new PriorityQueue<Pair>();
		q.add(new Pair(1,1,0));
		while(!q.isEmpty()){
			Pair p = q.poll();
			int x = p.x;
			int y = p.y;
			int c = p.count;
			if(x == n && y == n){
				result = c;
				break;
			}
			if(x == 0 || y == 0 || x == n+1 || y == n+1) continue;
			//System.out.println(x + "," + y + "__" + c);
			
			for(int i = 0; i < 4; i++){
				int newX = x +dx[i];
				int newY = y +dy[i];
				int newC = 0;
				if(map[newX][newY] == '0') newC = c +1;
				else newC = c;
				
				if(visited[newX][newY] <= newC ) continue;
				q.add(new Pair(newX,newY,newC));
				visited[newX][newY] = newC;
			}
		}
		System.out.println(result);
	}
	static class Pair implements Comparable<Pair>{
		int x, y, count;
		public Pair(int X, int Y, int C){
			x = X; y = Y; count = C;
		}
		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.count < o.count ? -1 : 1;
		}
	}

}
