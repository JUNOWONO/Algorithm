package Fourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class study_colorWeakness_10026 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// https://www.acmicpc.net/problem/10026
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n  = Integer.parseInt(br.readLine());
		int[][] mapNormal = new int[n+2][n+2];
		int[][] mapDisabled = new int[n+2][n+2];
		String[] str;
		for(int i = 1; i < n+1; i ++){
			str = br.readLine().split("");
			for(int j = 1; j < n+1; j++){
				if(str[j-1].equals("R")){
					mapNormal[i][j] = 1; 
					mapDisabled[i][j] = 1;
				}else if(str[j-1].equals("G")){
					mapNormal[i][j] = 2;
					mapDisabled[i][j] = 1;
				}else{
					mapNormal[i][j] = 3;
					mapDisabled[i][j] = 3;
				}
			}
		}
		Queue<Pair> q = new LinkedList<Pair>();
		int count = 0;
		for(int i = 1; i < n+1; i ++){
			for(int j = 1; j < n+1; j++){
				if(mapNormal[i][j] != 0) {
					q.add(new Pair(i,j, mapNormal[i][j]));
					count++;
				}
				while(!q.isEmpty()){
					Pair pa = q.poll();
					int x = pa.x; 
					int y = pa.y;
					int color = pa.z;
					mapNormal[x][y] = 0;
					if(mapNormal[x+1][y] == color){
						mapNormal[x+1][y] = 0;
						q.add(new Pair(x+1,y,color));
					}
					if(mapNormal[x][y+1] == color){
						mapNormal[x][y+1] = 0;
						q.add(new Pair(x,y+1,color));
					}
					if(mapNormal[x-1][y] == color){
						mapNormal[x-1][y] = 0;
						q.add(new Pair(x-1,y,color));
					}
					if(mapNormal[x][y-1] == color){
						mapNormal[x][y-1] = 0;
						q.add(new Pair(x,y-1,color));
					}
				}
				
			}
		}
		System.out.print(count + " ");
		
		count = 0;
		for(int i = 1; i < n+1; i ++){
			for(int j = 1; j < n+1; j++){
				if(mapDisabled[i][j] != 0) {
					q.add(new Pair(i,j, mapDisabled[i][j]));
					count++;
				}
				while(!q.isEmpty()){
					Pair pa = q.poll();
					int x = pa.x; 
					int y = pa.y;
					int color = pa.z;
					mapDisabled[x][y] = 0;
					if(mapDisabled[x+1][y] == color){
						mapDisabled[x+1][y] = 0;
						q.add(new Pair(x+1,y,color));
					}
					if(mapDisabled[x][y+1] == color){
						mapDisabled[x][y+1] = 0;
						q.add(new Pair(x,y+1,color));
					}
					if(mapDisabled[x-1][y] == color){
						mapDisabled[x-1][y] = 0;
						q.add(new Pair(x-1,y,color));
					}
					if(mapDisabled[x][y-1] == color){
						mapDisabled[x][y-1] = 0;
						q.add(new Pair(x,y-1,color));
					}
				}
				
			}
		}
		System.out.println(count);
		

	}
	
	
	static class Pair{
		int x, y, z;
		public Pair(int a, int b, int c){
			x = a; y = b; z= c;
		}
	}

}
