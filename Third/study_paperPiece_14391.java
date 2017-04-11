package Third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class study_paperPiece_14391 {
	static int[][] map;
	static int n,m;
	static ArrayList<Integer> sumList;
	public static void main(String[] args) throws IOException {
		//https://www.acmicpc.net/problem/14391
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputString = br.readLine().split(" ");
		n = Integer.parseInt(inputString[0]);
		m = Integer.parseInt(inputString[1]);
		map = new int[n+1][m+1];
		sumList = new ArrayList<Integer>();
		sumList.add(0);
		for(int i = 0; i < n; i++){
			String[] input = br.readLine().split("");
			for(int j = 0; j < m; j++){
				//System.out.println(input[j+1]);
				map[i][j] = Integer.parseInt(input[j+1]);
			}
		}
		//4자리 수부터 해결하고 낮은 자리 수로. 0에 유의
		solve(0,n-1,0,m-1,0);
		
		int max = 0;
		for(Integer i : sumList){
			//System.out.println(i);
			if(i > max) max = i;
		}
		//System.out.println(sumList.get(1));
		System.out.println(max);
		
	}
	public static void solve(int N_start, int N_end, int M_start, int M_end, int sumIndex){
		StringBuffer strBff = new StringBuffer();
		int zeroCount = 0;
		boolean flag = false;
		if(n > m){ //세로가 길 경우
			for(int i = M_start; i < M_end+1; i++){
				if(map[N_start][i] != 0){ //값이 0 이 아니면
					if(flag == true){ //이전에 값이 0 이었을 경우
						flag = false;
						if(zeroCount != 0){
							//좁혀진 구간에서 다시 수행
							solve(N_start+1, N_end, i-zeroCount+1, i, sumIndex);
							zeroCount = 0;
						}
					}
					for(int j = N_start; j < N_end+1; j++){
						strBff.append(map[j][i]); //세로로 긴 값 
						map[j][i] = 0;
					}
					sumList.set(sumIndex, sumList.get(sumIndex) + Integer.parseInt(strBff.toString())); // 결과값에 더하기
					strBff = new StringBuffer();
				}
				else{ // 0인 경우 
					zeroCount++;
					flag = true;
					if(i == M_end){
						solve(N_start+1, N_end, i-zeroCount+1, i, sumIndex);
					}
				}
			}
		}
		else if (n < m){ //가로가 긴 경우
			for(int i = N_start; i < N_end+1; i++){
				if(map[i][M_start] != 0){ //값이 0 이 아니면
					if(flag == true){ //이전에 값이 0 이었을 경우
						flag = false;
						if(zeroCount != 0){
							//좁혀진 구간에서 다시 수행
							solve(i-zeroCount+1, i, M_start +1, M_end, sumIndex);
							zeroCount = 0;
						}
					}
					for(int j = M_start; j < M_end+1; j++){
						strBff.append(map[i][j]); //가로 긴 값 
						map[i][j] = 0;
					}
					sumList.set(sumIndex, sumList.get(sumIndex) + Integer.parseInt(strBff.toString())); // 결과값에 더하기
					strBff = new StringBuffer();
				}
				else{ // 0인 경우 ㅓ
					zeroCount++;
					flag = true;
					if(i == N_end){
						solve(i-zeroCount+1, i, M_start +1, M_end, sumIndex);
					}
				}
			}
		}
		else{ // 가로 세로 같은 경우 
			sumList.add(sumList.get(sumIndex));
			solve(N_start, N_end+1, M_start, M_end, sumIndex);
			solve(N_start, N_end, M_start, M_end+1, sumIndex+1);
		}
		
		if(N_start == N_end && M_start == M_end){
			return;
		}
	}
}
