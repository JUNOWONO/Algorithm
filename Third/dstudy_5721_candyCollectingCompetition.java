package Third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class dstudy_5721_candyCollectingCompetition {

	static int M,N;
	static int[][] map;
	static int[] dp; //index행에서 나올 수 있는 최대값.
	static ArrayList<Integer> resultList = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
		// https://www.acmicpc.net/problem/5721
		//한칸을 고르면 좌우 한칸과 위아래 줄의 캔디가 사라진다. 고를 수 있는 캔디가 없을 때 까지 진행.
		//고를 수 있는 캔디의 최대 개수 구하기.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String[] inputArr = br.readLine().split(" ");
			M = Integer.parseInt(inputArr[0]);
			N = Integer.parseInt(inputArr[1]);
			if(M == 0 && N ==0){ //인풋이 0 0 이면 종료
				break;
			}
			inputArr = null;
			map = new int[M+2][N+2];
			for(int i = 1; i < M+1; i++){
				inputArr = br.readLine().split(" ");
				for(int j = 1; j < N+1; j++){
					map[i][j] = Integer.parseInt(inputArr[j-1]);
				}
			}
			int[] row = new int[M+2];
			
			//각 행에서의 최대값 구하기
			int tmpDp[];
			for(int i = 1; i < M+1; i++){
				if(N < 3){
					if(N == 1){
						row[i] = map[i][1];
					}else{ //N==2
						row[i] = Math.max(map[i][1], map[i][2]);
					}
				}
				else{ //N이 3이상일때
					tmpDp = new int[N+2]; //index까지의 최대값
					tmpDp[1] = map[i][1];
					tmpDp[2] = Math.max(map[i][1], map[i][2]);
					for(int j = 3; j < N+1; j++){
						tmpDp[j] = Math.max(tmpDp[j-2] + map[i][j], tmpDp[j-1]);
					}
					row[i] = tmpDp[N];
					//System.out.println(tmpDp[N]);
				}
			}
			int[] dp = new int[M+2]; //index행까지의 최대값
			if(M < 3){
				if(M == 1){
					dp[M] = row[1];
				}else{ //M==2
					dp[M] = Math.max(row[1], row[2]);
				}
				resultList.add(dp[M]);
			}
			else{ // M이 3이상일때
				dp[1] = row[1];
				dp[2] = Math.max(row[1], row[2]);
				for(int i = 3; i < M+1; i++){
					dp[i] = Math.max(dp[i-2] + row[i], dp[i-1]);
				}
				resultList.add(dp[M]);
				//System.out.println(dp[M]);
			}
		}
		
		for(int a : resultList){
			System.out.println(a);
		}
	}
}
