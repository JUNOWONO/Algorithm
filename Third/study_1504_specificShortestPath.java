package Third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class study_1504_specificShortestPath {

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
		int required1, required2;
		int sum1 = 0;
		int sum2 = 0;
		
		inputStringArray = br.readLine().split(" ");
		numOfVertex = Integer.parseInt(inputStringArray[0]);
		numOfEdge = Integer.parseInt(inputStringArray[1]);
		vertexBegin = 1;
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
		inputStringArray = br.readLine().split(" ");
		required1 = Integer.parseInt(inputStringArray[0]);
		required2 = Integer.parseInt(inputStringArray[1]);
		//------------------------//
		//-------------------------//
		
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
		//System.out.println(result[required1]);
		if(result[required1] == Integer.MAX_VALUE){
			System.out.println(-1);
			return;
		}
		else {
			sum1 += result[required1];
			sum2 += result[required2];
			System.out.println("1���� �ι���"+result[required2]);
		}
		//System.out.println("ù��Ŭ"+sum);
		
		Arrays.fill(result, Integer.MAX_VALUE);
		result[required1] = 0;
		q.add(new Vertex(0, required1)); //ť�� ���������� ����
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
		if(result[required2] == Integer.MAX_VALUE){
			System.out.println(-1);
			return;
		}
		else {
			sum1 += result[required2];
			sum2 += result[numOfVertex];
			System.out.println("ù��°���� ��"+result[numOfVertex]);
		}
		//System.out.println("�ι��� ��Ŭ"+sum);
		
		Arrays.fill(result, Integer.MAX_VALUE);
		result[required2] = 0;
		q.add(new Vertex(0, required2)); //ť�� ���������� ����
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
		if(result[numOfVertex] == Integer.MAX_VALUE){
			System.out.println(-1);
			return;
		}
		else {
			sum1 += result[numOfVertex];
			sum2 += result[required1];
			System.out.println("�ι������� ù����"+result[required1]);
		}
		
		int max = 0;
		if(sum1 < sum2) max = sum2;
		else max = sum1;
		//result ���
//		for(int i = 1; i < numOfVertex+1; i ++){
//			if(result[i] == Integer.MAX_VALUE) System.out.println("INF");
//			else System.out.println(result[i]);
//		}
		System.out.println(sum1 + "," + sum2);
		System.out.println(max);
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
