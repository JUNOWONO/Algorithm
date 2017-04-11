import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class study2_1260_DFS_BFS {
	static int n; //정점의 개수
	static int m; //간선의 개수
	static int v; //탐색을 시작한 정점의 번호
	static int[][] adjArr; //인접행렬
	static String[] strArr; //입력값 저장
	static Queue<Integer> q = new LinkedList<Integer>();
	//static ArrayList<Integer> list = new ArrayList<Integer>();
	static int[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		strArr = br.readLine().split(" ");
		n = Integer.parseInt(strArr[0]);
		m = Integer.parseInt(strArr[1]);
		v = Integer.parseInt(strArr[2]);
		adjArr = new int[n+1][n+1];
		visited = new int[n+1];

		for(int i = 0; i < m; i++){ //인접행렬 만들기
			strArr = br.readLine().split(" ");
			adjArr[Integer.parseInt(strArr[0])][Integer.parseInt(strArr[1])] = 1;
			adjArr[Integer.parseInt(strArr[1])][Integer.parseInt(strArr[0])] = 1;
		}
		
		//DFS
		visited[v] = 1;
		q.offer(v); //큐에 시작 정점 삽입
		DFS(v);
		System.out.println();
		
		//BFS
		Arrays.fill(visited, 0); //visited 0으로 초기화
		visited[v] = 1; //첫 노드는 자동으로 방문
		q.offer(v); //큐에 시작 정점 삽입
		System.out.print(v);
		BFS();
		System.out.println();
	}
	
	public static void DFS(int v){
		int vertex = 0;
		if(!q.isEmpty()){
			vertex = q.poll();
			System.out.print(vertex);
		}
		for(int i = 1; i < n+1; i++) {
			if(adjArr[vertex][i] == 1 && visited[i] != 1) {
			q.offer(i); //
			visited[i] = 1;
			System.out.print(" ");
			DFS(i);
			}
		}
	}
	
	public static void BFS(){
		int vertex;
		while(true){
			if(!q.isEmpty()) {
				vertex = q.poll().intValue();
			}
			else break;
			for(int i = 1; i < n+1; i++) {
				if(adjArr[vertex][i] == 1 && visited[i] != 1) {
					System.out.print(" " + i);
					visited[i] = 1;
					q.offer(i);
				}
			}
		}
	}
	
}


