package Third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class study_1707_bipartiteGraph {
		
	static int[][] adj;
	static Queue<Pair> q = new LinkedList();
	static ArrayList<String> resultList = new ArrayList();
	static ArrayList<Integer>[] adjList;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//https://www.acmicpc.net/problem/1707
		//그래프의 정점을 둘로 분할(한 집합에 속한 정점끼리는 인접하지 않음) <-가능한지 판별하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int c = 0; c < n; c++){ //테스트 횟수
			String[] strArr = br.readLine().split(" ");
			int numOfNode = Integer.parseInt(strArr[0]);
			int numOfEdge = Integer.parseInt(strArr[1]);
			adjList = new ArrayList[numOfNode+2];
			for(int j = 1; j < numOfNode+1; j ++){
				adjList[j] = new ArrayList();
			}
			for(int i = 0; i < numOfEdge; i++){
				strArr = br.readLine().split(" ");
				int a = Integer.parseInt(strArr[0]);
				int b= Integer.parseInt(strArr[1]);
				adjList[a].add(b);
				adjList[b].add(a);
			}
			boolean[] visited = new boolean[numOfNode+2];
			int[] groupNum = new int[numOfNode+2];
			boolean yesOrNo = true;
			for(int j = 1; j < numOfNode+1; j ++){
				if(visited[j] == false){
					q.add(new Pair(j, 3)); //방문할 노드 ==j
					visited[j] = true;
					groupNum[j] =3;
					while(!q.isEmpty()){
						Pair p = q.poll();
						for(int node : adjList[p.thisNode]){
							if(visited[node] == false){
								visited[node] = true;
								if(p.lastGroupNum == 2){
									groupNum[node] = 3;
									q.add(new Pair(node, 3));
								}else{
									groupNum[node] = 2;
									q.add(new Pair(node, 2));
								}
							}
							
						}
					}
				}
			}
			for(int j = 1; j < numOfNode+1; j ++){
				//System.out.print(groupNum[j]);
				for(int node : adjList[j]){
					if(groupNum[node] == groupNum[j] && node != j ){
						yesOrNo = false;
					}
				}
			}
			if(yesOrNo == true) resultList.add("YES");
			else resultList.add("NO");
		}
		for(String str : resultList){
			System.out.println(str);
		}
				
	}
	static class Pair{
		int thisNode, lastGroupNum;
		Pair(int a, int b){
			thisNode = a;
			lastGroupNum = b;
		}
	}
	
}
