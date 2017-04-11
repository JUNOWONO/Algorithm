import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class FloydWarshall1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//https://www.acmicpc.net/problem/1389
		//플로이드 와샬 - 최단거리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = new String[2];
		int n; //사람 수
		int l; //링크 수
		int[][] ad;
		int[] result;
		
		in = br.readLine().split(" ");
		n = Integer.parseInt(in[0]);
		l = Integer.parseInt(in[1]);
		result =new int[n+1];
		ad = new int[n+1][n+1];
		for(int i = 1; i < n+1; i++){
			ad[i][i] = 0;
			for(int j = 1; j < n+1; j++){
				ad[i][j] = 500001;
			}
		}
		for(int i = 1; i < l+1; i++){ //인접리스트 만들 때 대칭 시켜주는거 중요!
			in = br.readLine().split(" ");
			ad[Integer.parseInt(in[0])][Integer.parseInt(in[1])]  = 1;
			ad[Integer.parseInt(in[1])][Integer.parseInt(in[0])]  = 1;
			
		}
		
		
			//모든 사람의 케빈 베이컨수를 구하고 그 중에서 가장 작은 사람을 출력
		for(int k = 1; k < n+1; k++){ //거쳐갈 곳을 기준으로 탐색
			for(int i = 1; i < n+1; i++){ //모든 i 에서 j로
				for(int j = 1; j < n+1; j++){
					if(ad[i][j] > ad[i][k] + ad[k][j]) //방문 하지 않았거나 더 빠른 경로가 있으면 대체
						ad[i][j] = ad[i][k] + ad[k][j];
				}
			}
		}
		int answer = 1;
		for(int i = 1; i < n+1; i++){
			for(int j = 1; j < n+1; j++){
				if(ad[i][j] < 500001 )
					result[i] += ad[i][j];
			}
			//System.out.println(result[i]);
			if(result[i] < result[answer])
			answer = i;
		}
		
		System.out.println(answer);
		
		/*
		for(int i = 1; i < l+1; i++){
			for(int j = 1; j < l+1; j++){
				if(ad[i][j] < 1000000 )
					System.out.print(ad[i][j]);
				else System.out.print("X");
			}
			System.out.println();
		}
		*/
	}
}
