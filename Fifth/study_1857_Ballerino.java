package Fifth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class study_1857_Ballerino {
	
	public static void main(String[] args) throws IOException {
		//https://www.acmicpc.net/problem/1857
		PriorityQueue<Pair> q = new PriorityQueue<Pair>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArr = br.readLine().split(" ");
		int n = Integer.parseInt(strArr[0]);
		int m = Integer.parseInt(strArr[1]);
		int[][] map = new int [n+2][m+2];
		long[][] visited = new long [n+2][m+2];
		Pair endPoint = null;
		for(int i = 1; i < n+1; i ++){
			strArr = br.readLine().split(" ");
			for(int j = 1; j < m+1; j++){
				map[i][j] = Integer.parseInt(strArr[j-1]);
				if(map[i][j] == 3){ //add Starting Point
					q.add(new Pair(i,j,0));
				}else if(map[i][j] == 4){
					endPoint = new Pair(i,j,0);
				}
			}
		}
		for(int i = 1; i < n+1; i ++){
			Arrays.fill(visited[i], Integer.MAX_VALUE);
		}
		if(!q.isEmpty()) visited[q.peek().x][q.peek().y] = 0;
		int[] dx = {1,1, -1,-1, 2,2, -2,-2};
		int[] dy = {2,-2, 2,-2, 1,-1, 1,-1};
		long min = Integer.MAX_VALUE;
		long count = 0;
		while(!q.isEmpty()){
			Pair p = q.poll();
			int x = p.x, y = p.y;
			long c = p.c;
			if(c > min) continue;
			//System.out.println(x + "," + y + ","+c);
			if(map[x][y] == 4){
				System.out.println(x + "," + y + ","+c);
				min = Math.min(min, c); 
				count++;
				continue;
			}
			
			for(int i = 0; i < 8; i ++){
				int curX = x + dx[i];
				int curY = y + dy[i];
				long curC = c;
				if(curX > n || curX < 1 || curY > m || curY < 1) continue;
				visited[endPoint.x][endPoint.y] = Integer.MAX_VALUE;
				if(map[curX][curY] != 2){
					if(map[curX][curY] == 0) curC++;
					if(visited[curX][curY] > curC){
						visited[curX][curY] = curC;
						if(c != curC) map[curX][curY] = 1;
						q.add(new Pair(curX,curY,curC));
					}
				}
			}
		}
		if(min == Integer.MAX_VALUE){
			System.out.println(-1);
		}else{
			if(min == 0){
				System.out.println(0);
				System.out.println(1);
			}else{
				System.out.println(min);
				System.out.println(count);
			}
		}
	}
	static class Pair implements Comparable<Pair>{
		int x,y;
		long c;
		public Pair(int a, int b, long c_){
			x = a;
			y = b;
			c = c_;
		}
		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.c <= o.c ? -1 : 1 ;
		}
	}
}
