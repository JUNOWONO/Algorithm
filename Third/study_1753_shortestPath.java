package Third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class study_1753_shortestPath {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		// 다익스트라 // https://www.acmicpc.net/problem/1753
		int numOfVertex = 0;
		int numOfEdge = 0;
		int vertexBegin = 0;
		int[] result = null;
		String[] inputStringArray = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Vertex> q = new PriorityQueue<>();
		ArrayList<Vertex>[] adjList;
		
		inputStringArray = br.readLine().split(" ");
		numOfVertex = Integer.parseInt(inputStringArray[0]);
		numOfEdge = Integer.parseInt(inputStringArray[1]);
		vertexBegin = Integer.parseInt(br.readLine());
		result = new int[numOfVertex+1];
		adjList = new ArrayList[numOfVertex+1];
		
		for(int i = 1 ; i < numOfVertex+1; i++){
			adjList[i] = new ArrayList<>(); //i번 버텍스에서 
			result[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 1 ; i < numOfEdge+1; i++){
			inputStringArray = br.readLine().split(" ");
			int start = Integer.parseInt(inputStringArray[0]);
			int end = Integer.parseInt(inputStringArray[1]);
			int weight = Integer.parseInt(inputStringArray[2]);
			
			adjList[start].add(new Vertex(weight, end)); //인접 리스트 만들기 (adjList[start]에서 갈수있는 모든 vertex를 add함)
		}
	
		
		result[vertexBegin] = 0; //시작정점에서 시작정점으로의 값은 0
		q.add(new Vertex(0, vertexBegin)); //큐에 시작정점을 넣음
		
		while(!q.isEmpty()){
			int curVertexNum = q.poll().vertexNum;
			
			for(Vertex v : adjList[curVertexNum]){ //시작점을 curVertexNum으로 하는 인접리스트 항목에 대해서
				int newDis = result[curVertexNum] + v.getDistance();
				if(result[v.getVertexNum()] > newDis){ //최단 거리 갱신
					result[v.getVertexNum()] = newDis;
					q.add(new Vertex(newDis, v.getVertexNum()));
				}
			}
		}
		
		//result 출력
		for(int i = 1; i < numOfVertex+1; i ++){
			if(result[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(result[i]);
		}
	}
	
	static class Vertex implements Comparable<Vertex>{
		int distance;
		int vertexNum;
		public Vertex(int dis, int vertexNumber){
			distance = dis;
			vertexNum = vertexNumber;
		}
		public int getDistance() {
			return distance;
		}
		public void setDistance(int distance) {
			this.distance = distance;
		}
		public int getVertexNum() {
			return vertexNum;
		}
		public void setVertexNum(int vertexNum) {
			this.vertexNum = vertexNum;
		}
		@Override
		public int compareTo(Vertex o) { //distance 기분 Asec 오름차순 
			// TODO Auto-generated method stub
			return distance <= o.getDistance() ? -1 : 1;
		}
		
	}
}
