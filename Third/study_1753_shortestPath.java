package Third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class study_1753_shortestPath {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		// ���ͽ�Ʈ�� // https://www.acmicpc.net/problem/1753
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
			adjList[i] = new ArrayList<>(); //i�� ���ؽ����� 
			result[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 1 ; i < numOfEdge+1; i++){
			inputStringArray = br.readLine().split(" ");
			int start = Integer.parseInt(inputStringArray[0]);
			int end = Integer.parseInt(inputStringArray[1]);
			int weight = Integer.parseInt(inputStringArray[2]);
			
			adjList[start].add(new Vertex(weight, end)); //���� ����Ʈ ����� (adjList[start]���� �����ִ� ��� vertex�� add��)
		}
	
		
		result[vertexBegin] = 0; //������������ �������������� ���� 0
		q.add(new Vertex(0, vertexBegin)); //ť�� ���������� ����
		
		while(!q.isEmpty()){
			int curVertexNum = q.poll().vertexNum;
			
			for(Vertex v : adjList[curVertexNum]){ //�������� curVertexNum���� �ϴ� ��������Ʈ �׸� ���ؼ�
				int newDis = result[curVertexNum] + v.getDistance();
				if(result[v.getVertexNum()] > newDis){ //�ִ� �Ÿ� ����
					result[v.getVertexNum()] = newDis;
					q.add(new Vertex(newDis, v.getVertexNum()));
				}
			}
		}
		
		//result ���
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
		public int compareTo(Vertex o) { //distance ��� Asec �������� 
			// TODO Auto-generated method stub
			return distance <= o.getDistance() ? -1 : 1;
		}
		
	}
}
