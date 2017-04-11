package Sixth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class study_2933_mineral {
	static int R,C;
	static Queue<Pair> clQ;
	static PriorityQueue<Pair> clMoveQ;
	static char[][] map;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int[][] visited;
	public static void main(String[] args) throws IOException {
		// https://www.acmicpc.net/problem/2933
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		R = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);
		map = new char[R+2][C+2];
		for(int i = 1; i < R+1; i++){
			str = br.readLine().split("");
			for(int j = 1; j < C+1; j++){
				map[i][j] = str[j-1].charAt(0);
			}
		}
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<Integer>();
		str = br.readLine().split(" ");
		for(int i = 1; i < N+1; i++){
			q.add( R - Integer.parseInt(str[i-1]) + 1); //높이 위에서 부터 1로 바꿈
		}
		// -Input end-
		
		int dir = 1;
		while(!q.isEmpty()){ //막대 루프
			clQ = new LinkedList<Pair>(); //클러스터 체크용 큐
			boolean isSafe = true;
			int h = q.poll();
			if(dir == 1){ //왼쪾에서 오른쪾으로
				for(int i = 1; i < C+1; i++){
					if(map[h][i] == 'x'){
						map[h][i] = '.';
						visited = new int[R+2][C+2];
						boolean flagNext = true, flagDown = true;
						if(map[h-1][i] == 'x'){
							clQ.add(new Pair(h-1,i));
							isSafe = isSafe();
							if(visited[h][i+1] == 1) flagNext = false;
							if(visited[h+1][i] == 1) flagDown = false;
							if(!isSafe) break;
						}
						if(map[h][i+1] == 'x' && flagNext){
							visited = new int[R+2][C+2];
							clQ.add(new Pair(h,i+1));
							isSafe = isSafe();
							if(visited[h+1][i] == 1) flagDown = false;
							if(!isSafe) break;
						}
						if(map[h+1][i] == 'x' && flagDown){
							visited = new int[R+2][C+2];
							clQ.add(new Pair(h+1,i));
							isSafe = isSafe();
							if(!isSafe) break;
						}
						break;
					}
				}
				if(!isSafe){ //안전한 구조가 아니면
					clusterDrop(); //클러스터 한칸 낙하
				}
			}else{ //오른쪽에서 왼쪽으로
				for(int i = C; i > 0; i--){
					if(map[h][i] == 'x'){
						map[h][i] = '.';
						visited = new int[R+2][C+2];
						boolean flagNext = true, flagDown = true;
						if(map[h-1][i] == 'x'){
							clQ.add(new Pair(h-1,i));
							isSafe = isSafe();
							if(visited[h][i+1] == 1) flagNext = false;
							if(visited[h+1][i] == 1) flagDown = false;
							if(!isSafe) break;
						}
						if(map[h][i-1] == 'x' && flagNext){
							visited = new int[R+2][C+2];
							clQ.add(new Pair(h,i-1));
							isSafe = isSafe();
							if(visited[h+1][i] == 1) flagDown = false;
							if(!isSafe) break;
						}
						if(map[h+1][i] == 'x' && flagDown){
							visited = new int[R+2][C+2];
							clQ.add(new Pair(h+1,i));
							isSafe = isSafe();
							if(!isSafe) break;
						}
						break;
					}
				}
				if(!isSafe){
					clusterDrop();
				}
			}
			//방향 전환
			if(dir == 1) dir = -1;
			else dir = 1;
		}
		
		for(int i = 1; i < R+1; i++){
			for(int j = 1; j < C+1; j++){
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
	static boolean isSafe(){
		boolean isSafe = false;
		PriorityQueue<Pair> tmpQ = new PriorityQueue<Pair>();
		while(!clQ.isEmpty()){
			Pair p = clQ.poll();
			int x = p.x, y = p.y;
			if(visited[x][y] == 1) continue;
			visited[x][y] = 1;
			tmpQ.add(new Pair(x,y)); //낙하용 큐
			if(x == R){ //바닥까지 이어져 있으면
				isSafe = true; // 안전한 구조
			}
			for(int j = 0; j < 4; j++){
				int nextX = x + dx[j], nextY = y + dy[j];
				if(map[nextX][nextY] == 'x'){
					clQ.add(new Pair(nextX, nextY));
				}
			}
		}
		if(!isSafe) clMoveQ = tmpQ;
		return isSafe;
	}
	
	static void clusterDrop(){
		boolean isSafe = false;
		PriorityQueue<Pair> tmpQ;
		Queue<Pair> edgePairs;
		while(isSafe == false){
			int[] edgeVisited = new int[C+2];
			edgePairs = new LinkedList<Pair>();
			tmpQ = new PriorityQueue<>();
			while(!clMoveQ.isEmpty()){
				Pair p = clMoveQ.poll();
				int x = p.x, y = p.y;
				map[x][y] = '.';
				map[x+1][y] = 'x';
				tmpQ.add(new Pair(x+1,y));
				if(edgeVisited[y] != 1){ // 바닥에 깔리는 미네랄을 모두 체크 
					edgeVisited[y] = 1;
					edgePairs.add(new Pair(x+1,y));
				}
			}
			while(!edgePairs.isEmpty()){
				Pair p = edgePairs.poll();
				if(map[p.x+1][p.y] == 'x' || p.x == R) isSafe = true;
			}
			if(!isSafe) clMoveQ = tmpQ;
		}
	}
	
	static class Pair implements Comparable<Pair>{
		int x, y;
		public Pair(int a, int b){
			x = a; y = b;
		}
		@Override
		public int compareTo(Pair o) {
			return this.x > o.x ? -1:1;
		}
	}
}
