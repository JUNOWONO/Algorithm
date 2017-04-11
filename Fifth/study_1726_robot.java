package Fifth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class study_1726_robot {

	public static void main(String[] args) throws IOException {
		// https://www.acmicpc.net/problem/1726
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int m = Integer.parseInt(str[0]);
		int n = Integer.parseInt(str[1]);
		int[][] map = new int[m+2][n+2];
		for(int i = 1 ; i < m+1; i++){
			str = br.readLine().split(" ");
			for(int j = 1; j < n+1; j++){
					map[i][j] = Integer.parseInt(str[j-1]);
			}
		}
		str = br.readLine().split(" ");
		Pair startPoint = new Pair(Integer.parseInt(str[0]),Integer.parseInt(str[1]),Integer.parseInt(str[2]),0);
		str = br.readLine().split(" ");
		Pair endPoint = new Pair(Integer.parseInt(str[0]),Integer.parseInt(str[1]),Integer.parseInt(str[2]),0);
		
		int[][][] visited = new int[m+2][n+2][5];
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(startPoint);
		while(!q.isEmpty()){
			Pair p = q.poll();
			int x = p.x, y = p.y, dir = p.dir, count = p.count;
			if(x < 1 || x > m || y < 1 || y > n) continue;
			if(visited[x][y][dir] == 1 || map[x][y] == 1) continue;
			//System.out.println(x + "," + y + "," + dir + " -- " + count);
			if(x == endPoint.x && y == endPoint.y && dir == endPoint.dir){
				System.out.println(count);
				break;
			}
			visited[x][y][dir] = 1;
			

			if(dir == 1 || dir == 2){	
				q.add(new Pair(x,y,3,count+1));
				q.add(new Pair(x,y,4,count+1));
			}else if(dir == 3 || dir == 4){
				q.add(new Pair(x,y,1,count+1));
				q.add(new Pair(x,y,2,count+1));
			}
			
			if(dir == 1){
				q.add(new Pair(x,y+1,dir,count+1));
				if(map[x][y+1] != 1 && y+1 < n){
					q.add(new Pair(x,y+2,dir,count+1));
					if(map[x][y+2] != 1 && y+2 < n){
						q.add(new Pair(x,y+3,dir,count+1));
					}
				}
			}else if(dir == 3){
				q.add(new Pair(x+1,y,dir,count+1));
				if(map[x+1][y] != 1 && x+1 < m){
					q.add(new Pair(x+2,y,dir,count+1));
					if(map[x+2][y] != 1 && x+2 < m){
						q.add(new Pair(x+3,y,dir,count+1));
					}
				}
			}else if(dir == 2){
				q.add(new Pair(x,y-1,dir,count+1));
				if(map[x][y-1] != 1 && y-2 > 0){
					q.add(new Pair(x,y-2,dir,count+1));
					if(map[x][y-2] != 1 && y-3 > 0){
						q.add(new Pair(x,y-3,dir,count+1));
					}
				}
			}else if(dir == 4){
				q.add(new Pair(x-1,y,dir,count+1));
				if(map[x-1][y] != 1 && x-2 > 0){
					q.add(new Pair(x-2,y,dir,count+1));
					if(map[x-2][y] != 1 && x-3 > 0) {
						q.add(new Pair(x-3,y,dir,count+1));
					}
				}
			}
			
		}
		
	}
	static class Pair {
		int x,y,dir,count;
		public Pair(int a, int b, int d, int c){
			x = a; y = b; dir = d; count = c;
		}
	}
}
