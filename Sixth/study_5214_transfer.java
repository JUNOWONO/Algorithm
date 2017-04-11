package Sixth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class study_5214_transfer {

	public static void main(String[] args) throws IOException {
		// https://www.acmicpc.net/problem/5214
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);
		int M = Integer.parseInt(str[2]);
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
		for(int i = 0; i < N+M+2; i++){ 
			adjList.add( new ArrayList<Integer>());
		}		
		for(int i = 1; i < M+1; i++){
			str = br.readLine().split(" ");
			for(int j = 0; j < K; j++){
				adjList.get(Integer.parseInt(str[j])).add(N+i);
				adjList.get(N+i).add(Integer.parseInt(str[j]));
			}
//			for(int j = 0; j < K; j++){
//				for(int k = 0; k < K; k++){
//					if(j == k) continue;
//					adjList.get(Integer.parseInt(str[j])).add(Integer.parseInt(str[k]));
//					adjList.get(Integer.parseInt(str[k])).add(Integer.parseInt(str[j]));
//				}
//			}
		}
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(1,1));
		int count = 0;
		int[] visited =  new int[N+M+2];
		//Arrays.fill(visited, Integer.MAX_VALUE);
		while(!q.isEmpty()){
			Pair pair = q.poll();
			int a = pair.a;
			int c = pair.count;
			//System.out.println(a + "," + count);
			if(a == N) {
				count = c;
				break;
			}
			for(int x : adjList.get(a)){ //a에서 갈 수 있는 모든 점 x
				if(visited[x] == 0) {
					q.add(new Pair(x, c+1));
					visited[x] = 1;
				}
			}
		}
		if(count == 0)System.out.println(-1);
		else System.out.println(count/2 +1);
		
	}
	static class Pair{
		int a, count;
		public Pair(int x, int y){
			a = x; count  = y;
		}
	}

}
