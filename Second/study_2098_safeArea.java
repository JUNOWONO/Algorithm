package Second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class study_2098_safeArea {
	static int[][] tmpMap;
	static int count = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n+2][n+2];
		tmpMap = new int[n+2][n+2];
		Queue<Pair> q = new LinkedList<Pair>();
		int max = 0;
		int highest = 0;
		
		for(int i = 1; i < n+1; i ++){
			String[] str = br.readLine().split(" ");
			for(int j = 1; j < n+1; j++){
				map[i][j] = Integer.parseInt(str[j-1]);
				if(map[i][j] > highest) highest = map[i][j];
			}
		}
		
		for(int i = 0; i < highest; i ++){
			for(int j = 1; j < n+1; j++){ //copy
				tmpMap[j] = map[j].clone();
			}
			count = 0;
			for(int j = 1; j < n+1; j++){
				for(int k = 1; k < n+1; k++){
					if(tmpMap[j][k] < i+1){
						tmpMap[j][k] = 0; //침수되면 0;
					} 
					else{
						q.add(new Pair(j, k));
						count ++;
					}
				}
			}
			//System.out.print(count + ", ");
			while(!q.isEmpty()){
				Pair p = q.poll();
				int x = p.x;
				int y = p.y;
				dfs(x,y);
			}
			//System.out.println(count);
			if(count > max) max = count;
		}
		
		System.out.println(max);
	}
	
	static void dfs(int x, int y){
		tmpMap[x][y]  = -1; 
		if(tmpMap[x+1][y] > 0){ //방문은 -1, 침수는 0
			count --;
			tmpMap[x+1][y] = -1;
			dfs(x+1, y);
		}
		if(tmpMap[x][y+1] > 0){ //방문은 -1, 침수는 0
			count --;
			tmpMap[x][y+1] = -1;
			dfs(x, y+1);
		}
		if(tmpMap[x-1][y] > 0){ //방문은 -1, 침수는 0
			count --;
			tmpMap[x-1][y] = -1;
			dfs(x-1, y);
		}
		if(tmpMap[x][y-1] > 0){ //방문은 -1, 침수는 0
			count --;
			tmpMap[x][y-1] = -1;
			dfs(x, y-1);
		}
	}
	
	
	
	static class Pair{
		int x,y;
		Pair(int a, int b){
			x = a;
			y = b;
		}
	}
}
