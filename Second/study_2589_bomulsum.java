package Second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class study_2589_bomulsum {
	static char[][] map;
	static int[][] visited;
	static int[][] visitedInit;
	static int l, m;
	static int finalMin = 0;
	static int tmpMin = 0;
	static Pair tmpNode;
	static Queue<Integer> qq = new LinkedList<Integer>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		Queue<Pair> q = new LinkedList<Pair>();
		Queue<Pair> q2 = new LinkedList<Pair>();
		
		String[] str = br.readLine().split(" ");
		l = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		map = new char[l+2][m+2];
		visitedInit = new int[l+2][m+2]; //초기화 데이터 저장용
		visited = new int[l+2][m+2];
		char[] inputArr;
		for(int i = 1; i < l+1; i ++){
			inputArr = br.readLine().toCharArray();
			for(int j = 1; j < m+1; j++){
				map[i][j] = 'L';
				if(inputArr[j-1] == 'L') {
					q.add(new Pair(i,j,0));
				}
				else{
					visitedInit[i][j] = -1;
				}
			}
		}
		for(int i = 0; i < m+2; i ++){ //visitedInit 바깥 테두리 -1으로;
			visitedInit[0][i] = -1;
			visitedInit[l+1][i] = -1;
		}
		for(int i = 0; i < l+2; i ++){
			visitedInit[i][0] = -1;
			visitedInit[i][m+1] = -1;
		}
		
		
		while(!q.isEmpty()){
			Pair pair = q.poll();
			q2.add(pair);
			tmpMin = 0;
			for(int i = 0; i < l+2; i ++)
				visited[i] = visitedInit[i].clone();
			visited[pair.x][pair.y] = -1;
			//System.out.println(pair.x + ", " + pair.y + "-------------");
			while(true){
				int x,y,c;
				Pair p = q2.poll();
				x = p.x;
				y = p.y;
				c = p.c;
				//System.out.println(x + ", " + y);
				tmpMin = c;
//				for(int i = 1; i < l+1; i ++){
//					for(int j = 1; j < m+1; j++){
//						if(visited[i][j] == -1) System.out.print("#");
//						else System.out.print(visited[i][j]);
//					}
//					System.out.println();
//				}
//				System.out.println(tmpMin);
				if(visited[x+1][y] == 0 && map[x+1][y] == 'L'){
					visited[x+1][y] = -1;
					q2.add(new Pair(x+1, y, c+1));
				}
				if(visited[x][y+1] == 0 && map[x][y+1] == 'L'){
					visited[x][y+1] = -1;
					q2.add(new Pair(x, y+1, c+1));
				}
				if(visited[x-1][y] == 0 && map[x-1][y] == 'L'){
					visited[x-1][y] = -1;
					q2.add(new Pair(x-1, y, c+1));
				}
				if(visited[x][y-1] == 0 && map[x][y-1] == 'L'){
					visited[x][y-1] =-1;
					q2.add(new Pair(x, y-1, c+1));
				}
				if(q2.isEmpty()) break;
			}
			finalMin = Math.max(tmpMin, finalMin);
		}
		
		System.out.println(finalMin);
		
	}

	
	
	static class Pair{
		int x, y, c;
		Pair (int a, int b, int count){
			x = a;
			y = b;
			c = count;
		}
	}
	
}
