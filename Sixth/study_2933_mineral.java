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
			q.add( R - Integer.parseInt(str[i-1]) + 1); //���� ������ ���� 1�� �ٲ�
		}
		// -Input end-
		
		int dir = 1;
		while(!q.isEmpty()){ //���� ����
			clQ = new LinkedList<Pair>(); //Ŭ������ üũ�� ť
			boolean isSafe = true;
			int h = q.poll();
			if(dir == 1){ //�ަU���� �����U����
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
				if(!isSafe){ //������ ������ �ƴϸ�
					clusterDrop(); //Ŭ������ ��ĭ ����
				}
			}else{ //�����ʿ��� ��������
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
			//���� ��ȯ
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
			tmpQ.add(new Pair(x,y)); //���Ͽ� ť
			if(x == R){ //�ٴڱ��� �̾��� ������
				isSafe = true; // ������ ����
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
				if(edgeVisited[y] != 1){ // �ٴڿ� �򸮴� �̳׶��� ��� üũ 
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
