import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class study_7576_tomato {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m; //����
		int n; //����
		String[] strArr; //input �Է°� ����
		int[][] map;
		int days = 0; //��¥
		int numOfTomato; //�丶�� �� ����
		int tomatoCount = 0; //���� �丶�� ����
		
		Queue<Pair> q = new LinkedList<Pair>();
		strArr = br.readLine().split(" ");
		m = Integer.parseInt(strArr[0]);
		n = Integer.parseInt(strArr[1]);
		map = new int[n+2][m+2];
		numOfTomato = m*n;
		
		strArr = new String[m];
		for(int i = 1; i < n+1; i++){
			strArr = br.readLine().split(" ");
			for( int j = 1; j < m+1; j++){
				int tmp = Integer.parseInt(strArr[j-1]);
				if(tmp == 1) {
					map[i][j] = 1;
					q.offer(new Pair(i,j));
					tomatoCount ++;
				}
				else if(tmp == -1) {
					map[i][j] = -1;
					numOfTomato--;
				}
			}
		}
		
		for(int i = 1; i < n+1; i++){ //�丶�� �ڽ� ���� ���� �� -1�� �ʱ�ȭ
			map[i][m+1] = -1;
			map[i][0] = -1;
		}
		for(int i = 1; i < m+1; i++){
			map[0][i] = -1;
			map[n+1][i] = -1;
		}
		
		Pair p; //��ǥ ����
		int x,y; //����,����
		int qSize; //ť�� ������ (ť�� �ѹ� ��ȯ�Ǹ� days++)

		while(true){
			qSize = q.size();
			if(qSize == 0) {
				System.out.println(-1);
				break;
			}
			for(int i = 0; i < qSize; i++){
				p = q.poll();
				x = p.getX(); 
				y = p.getY(); 
				if(map[x+1][y] == 0){
					map[x+1][y] = 1;
					q.offer(new Pair(x+1,y));
					tomatoCount++;
				}
				if(map[x][y+1] == 0){
					map[x][y+1] = 1;
					q.offer(new Pair(x,y+1));
					tomatoCount++;
				}
				if(map[x][y-1] == 0){
					map[x][y-1] = 1;
					q.offer(new Pair(x,y-1));
					tomatoCount++;
				}
				if(map[x-1][y] == 0){
					map[x-1][y] = 1;
					q.offer(new Pair(x-1,y));
					tomatoCount++;
				}
			}
			days++;
			if(tomatoCount == numOfTomato) {
				System.out.println(days);
				break;
			}
		}
	}
	
	static class Pair{
		int x;
		int y;
		
		public Pair (int a, int b){
			x = a;
			y = b;
		}
		
		public int getX(){
			return x;
		}
		public int getY(){
			return y;
		}
	}
	

}
