package Seventh;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class study_codeground_mirror {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// https://www.codeground.org/practice/practiceProbView.do?probId=12
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		Queue<Pair> q = new LinkedList<Pair>();
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		for(int c = 0; c < testCase; c++){
			
			int t = sc.nextInt();
			int count = 0;
			char[][] map = new char[t+2][t+2];
			boolean[][] visited = new boolean[t+2][t+2];
			for(int i = 1; i< t+1; i++){
				char[] arr = sc.next().toCharArray();
				for(int j = 1; j < t+1; j++){
					map[i][j] = arr[j-1];
				}
			}
			q.add(new Pair(1,0,0));
			while(!q.isEmpty()){
				Pair p = q.poll();
				int x = p.x;
				int y = p.y;
				int dir = p.dir;
			
				x += dx[dir];
				y += dy[dir];
				if(x == 0 || x == t+1 || y == 0 || y == t+1) {
					break;
				}
				if(map[x][y] == '2' ){
					if(dir == 0) dir = 1;
					else if(dir == 1) dir = 0;
					else if(dir == 2) dir = 3;
					else if(dir == 3) dir = 2;
				}else if(map[x][y] == '1'){
					if(dir == 0) dir = 3;
					else if(dir == 1) dir = 2;
					else if(dir == 2) dir = 1;
					else if(dir == 3) dir = 0;
				}

				if((map[x][y] == '1' || map[x][y] == '2' ) && visited[x][y] == false){
					count++;
					visited[x][y] = true;
				}
				q.add(new Pair(x,y,dir));				
			}
			
			System.out.println("Case #");
			System.out.println(count);
		}
		
	}
	static class Pair{
		int x, y, dir;
		public Pair(int X, int Y, int D){
			x = X; y = Y; dir = D;
		}
	}
}
