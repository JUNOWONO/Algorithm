import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;


public class Dijkstra {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] input;
		input = in.readLine().split(" ");
		int numOfNode = Integer.parseInt(input[0]);
		int numOfEdge = Integer.parseInt(input[1]);
		int startNode = Integer.parseInt(in.readLine());;
		int[] dist = new int[numOfNode+1];
		boolean[] visit = new boolean[numOfNode+1];
		HashMap<Integer, HashMap<Integer, Integer>> adMap = new HashMap<Integer,HashMap<Integer, Integer>>();
		//키값이 시작노드, 두번째 키값이 도착노드, 벨류가 엣지 가중치
		ArrayList<Integer> arriveNodes  = new ArrayList<Integer>();
		
		for(int i =1; i <= numOfEdge; i++){
			input = in.readLine().split(" ");
			int u = Integer.parseInt(input[0]);
			int v = Integer.parseInt(input[1]);
			int val = Integer.parseInt(input[2]);
			if(adMap.get(u) == null) {
				adMap.put(u, new HashMap<Integer,Integer>());
			}
			if(adMap.get(u).get(v) == null) {
				adMap.get(u).put(v, val); 
			} else{
				if(adMap.get(u).get(v) > val) adMap.get(u).put(v, val);
			}
			arriveNodes.add(v);
		}
		for(int i = 1; i <= numOfNode; i++){
			dist[i] = -1;
			//for(int j = 1; j <= numOfNode; j++) System.out.print(adMap.get(i).get(j));
			//System.out.println();
		}
		dist[startNode] = 0;
		PriorityQueue<Integer> nodeQueue = new PriorityQueue<>();
		
		while(true){
			if(!nodeQueue.isEmpty()){
				
				startNode = nodeQueue.poll();
			}
			
			for(int i : arriveNodes){
				if(adMap.get(startNode).get(i) != null){
					if(dist[i] == -1){
						dist[i] = dist[startNode] + adMap.get(startNode).get(i);
					}
					else{
						if(dist[i] > dist[startNode] + adMap.get(startNode).get(i)){
							dist[i] = dist[startNode] + adMap.get(startNode).get(i);
						}
					}
					if(visit[startNode] == false){
						nodeQueue.add(i);
						visit[i] = true;
					}
				}
			}
			
			//for(int j = 1; j <= numOfNode; j++) System.out.print(dist[j]);
			//System.out.println();
			
			if(nodeQueue.isEmpty()){
				break;
			}
		}
		for(int j = 1; j <= numOfNode; j++) {
			if(dist[j] == -1) System.out.println("INF");
			else System.out.println(dist[j]);
		}
	}

}
