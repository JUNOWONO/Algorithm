import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class study2_1260_DFS_BFS {
	static int n; //������ ����
	static int m; //������ ����
	static int v; //Ž���� ������ ������ ��ȣ
	static int[][] adjArr; //�������
	static String[] strArr; //�Է°� ����
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

		for(int i = 0; i < m; i++){ //������� �����
			strArr = br.readLine().split(" ");
			adjArr[Integer.parseInt(strArr[0])][Integer.parseInt(strArr[1])] = 1;
			adjArr[Integer.parseInt(strArr[1])][Integer.parseInt(strArr[0])] = 1;
		}
		
		//DFS
		visited[v] = 1;
		q.offer(v); //ť�� ���� ���� ����
		DFS(v);
		System.out.println();
		
		//BFS
		Arrays.fill(visited, 0); //visited 0���� �ʱ�ȭ
		visited[v] = 1; //ù ���� �ڵ����� �湮
		q.offer(v); //ť�� ���� ���� ����
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


