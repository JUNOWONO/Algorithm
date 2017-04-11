package Fifth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class study_13460_escapeMiro {

	public static void main(String[] args) throws IOException {
		//https://www.acmicpc.net/problem/13460
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		
		Pair balls = null;
		balls = new Pair(0,0,0,0,1,0);
		int ox = 0,oy = 0;
		char[][] map = new char[n+3][m+3];
		for(int i = 1; i < n+1; i++){
			char[] arr = br.readLine().toCharArray();
			for(int j = 1; j < m+1; j++){
				map[i][j] = arr[j-1];
				if(map[i][j] == 'R'){
					balls.rx = i;
					balls.ry = j;
					map[i][j] = '.';
				}else if(map[i][j] == 'B'){
					balls.bx = i;
					balls.by = j;
					map[i][j] = '.';
				}else if(map[i][j] == 'O'){
					ox = i;
					oy = j;
					map[i][j] = '.';
				}
			}
		}
		int result = 0;
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		int[][][][][] visited =  new int[n+2][m+2][n+2][m+2][5];
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(balls);
		q.add(new Pair(balls.rx,balls.ry,balls.bx,balls.by,1,1));
		q.add(new Pair(balls.rx,balls.ry,balls.bx,balls.by,1,2));
		q.add(new Pair(balls.rx,balls.ry,balls.bx,balls.by,1,3));
		while(!q.isEmpty()){
			Pair p = q.poll();
			int rx = p.rx, ry = p.ry, bx = p.bx, by = p.by, count = p.count, dir = p.dir;
			if(visited[rx][ry][bx][by][dir] == 1) continue;
			visited[rx][ry][bx][by][dir] = 1;
			if((result > 0 && result < 11) || count>10 )break;
			
			int x1=rx,y1=ry,x2=bx,y2=by;
			int r=0,b=0;
			while(true){
				int nextRx = x1+dx[dir];
				int nextRy = y1+dy[dir];
				int nextBx = x2+dx[dir];
				int nextBy = y2+dy[dir];
				//빨간색공이 앞에 있는 경우
				if((dir == 0 && y1 > y2) || (dir == 1 && x1 > x2) || (dir == 2 && y1 < y2) || (dir == 3 && x1 < x2)){
					if(nextRx==ox && nextRy == oy ) {
						result = count;
						r++;
						x1 = n+1;
						y1 = m+1;
					}
					if(nextBx==ox && nextBy == oy){
						result = 0;
						b = -1;
						break;
					}
					if(map[nextRx][nextRy] != '.') r++;
					if(r == 0) {
						x1 = nextRx;
						y1 = nextRy;
					}
					
					if(map[nextBx][nextBy] != '.' || (nextBx == x1 && nextBy == y1) ) b++;
					if(b == 0){
						x2 = nextBx;
						y2 = nextBy;
					}
					
					if(r > 0 && b > 0) break;
				}else{ //파란공이 앞에 있는 경우
					if(nextBx==ox && nextBy == oy){
						result = 0;
						b = -1;
						break;
					}
					if(nextRx==ox && nextRy == oy) {
						result = count;
						r++;
						x1 = n+1;
						y1 = m+1;
					}
					if(map[nextBx][nextBy] != '.') b++;
					if(b == 0){
						x2 = nextBx;
						y2 = nextBy;
					}
					if(map[nextRx][nextRy] != '.' || (nextRx == x2 && nextRy == y2)) r++;
					if(r == 0){
						x1 = nextRx;
						y1 = nextRy;
					}
				}
				if(r > 0 && b > 0) break; //두 공이 모두 멈춘경우
			}
			if(b == -1) continue; //파란공이 탈출한경우
			if(result == 0 ){
				count++;
				for(int i = 0; i < 4; i ++){
					if(dir != i) q.add(new Pair(x1,y1,x2,y2,count,i));
				}
				
				
			}
		}
		
		if(result == 0 ) result = -1;
		System.out.println(result);
	}

	static class Pair{
		int rx, ry, bx, by, count, dir;
		public Pair(int ra, int rb, int ba, int bb, int c, int d){
			rx = ra; ry = rb; bx = ba; by = bb; count = c; dir = d;
		}
	}
}
