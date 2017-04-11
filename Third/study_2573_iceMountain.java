package Third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class study_2573_iceMountain {
	static int n, m;
	static int[][] map;
	static int[][] visited;
	static int numOfIce = 0;
	static Queue<Pair> q = new LinkedList<Pair>();
	public static void main(String[] args) throws IOException {
		// https://www.acmicpc.net/problem/2573
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		map = new int[n+2][m+2];
		str = null;
		//System.out.println(n + "," + m);
		for(int i = 0; i < n; i++){
			str = br.readLine().split(" ");
			for(int j = 0; j < m; j++){
				map[i][j] = Integer.parseInt(str[j]);
				if(map[i][j] != 0) {
					numOfIce ++;
				}
				//System.out.println(map[i][j]);
			}
		}
		int count = 0;
		while(true){
			count ++;
			visited = new int[n+2][m+2];
			for(int i = 1; i < n-1; i++){
				for(int j = 1; j < m-1; j++){
					if(map[i][j] != 0  ){
						int c = 0;
						if(map[i+1][j] == 0 && visited[i+1][j] == 0) c++;
						if(map[i][j+1] == 0 && visited[i][j+1] == 0) c++;
						if(map[i-1][j] == 0 && visited[i-1][j] == 0) c++;
						if(map[i][j-1] == 0 && visited[i][j-1] == 0) c++;
						
						int tmp = map[i][j] - c;
						if(tmp < 1 ){ 
							numOfIce--;
							map[i][j] = 0;	
						}
						else{
							map[i][j] = tmp;
						}
						visited[i][j] = 1;
					
						
					}
				}
			}
//			for(int i = 0; i < n; i++){
//				System.out.println();
//				for(int j = 0; j < m; j++){
//					System.out.print(map[i][j] + " ");
//				}
//			}
			boolean tmpFlag = false;
			for(int i = 1; i < n-1; i++){ //처음 만나는거 하나만 시작점으로 잡기
				for(int j = 1; j < m-1; j++){
					if(map[i][j] != 0){
						q.add(new Pair(i,j));
						tmpFlag = true;
						break;
					} 
				}
				if(tmpFlag == true) break;
			}
			if(tmpFlag == false) { //0이 아닌게 하나도 없을 때!
				count = 0;
				break;
			}
			int iceCount = 0;
			visited = new int[n+2][m+2];
//			System.out.println();
			while(!q.isEmpty()){
				Pair pair = q.poll();
				int x = pair.x;
				int y = pair.y;
//				System.out.println(x + ", "+y);
				if(visited[x][y] == 0) iceCount++;
				visited[x][y] = 1;
				
				if(map[x+1][y] != 0  && visited[x+1][y] == 0) q.add(new Pair(x+1, y));
				if(map[x][y+1] != 0  && visited[x][y+1] == 0) q.add(new Pair(x, y+1));
				if(map[x-1][y] != 0  && visited[x-1][y] == 0) q.add(new Pair(x-1, y));
				if(map[x][y-1] != 0  && visited[x][y-1] == 0) q.add(new Pair(x, y-1));
			}
//			System.out.println();
//			System.out.println(iceCount);
//			System.out.println(numOfIce);
			if(iceCount != numOfIce){
				break;
			}
			
		}
		
		System.out.println(count);
	}
	static class Pair{
		int x,y;
		Pair(int x_, int y_){
			x = x_; y = y_;
		}
	}

}
