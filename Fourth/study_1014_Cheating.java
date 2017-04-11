package Fourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class study_1014_Cheating {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//http://blog.naver.com/PostView.nhn?blogId=kks227&logNo=220617896760
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());
		for(int t = 0; t < c; t++){
			String[] str = br.readLine().split(" ");
			int n = Integer.parseInt(str[0]);
			int m = Integer.parseInt(str[1]);
			int[][] map = new int[n+2][m+2];
			int[][] graph = new int[n+2][m+2];
			int[][] matching = new int[n+2][m+2];
			int maxSeatNum = 0;
			for(int i = 1; i < n+1; i++){
				str = br.readLine().split("");
				for(int j = 1; j < m+1; j++){
					if(str[j-1].equals(".")){ 
						map[i][j] = 1; //앉을 수 있는 자리면
						maxSeatNum++;
					}else{
						map[i][j] = 0; //앉을 수 없는 자리
					}
				}
			}
			//여기서 부터 다시 1.1~10.10의 노드를 1~100으로 번호 메기기. 
			int[][] nodeNum = new int[11][11];
			for(int i = 1; i < n; i++){
				for(int j = 1; j < m+1; j++){
					nodeNum[i][j] = (i-1)*10+(j-1);
				}
			}
			for(int i = 1; i < n; i++){
				for(int j = 1; j < m+1; j++){
					if(map[i][j] == 1){ // i,j에 앉으면 못않게 되는 경로를 1표시
						graph[i][j+1] = 1; graph[i+1][j+1] = 1; graph[i-1][j+1] = 1;
						graph[i][j-1] = 1; graph[i+1][j-1] = 1; graph[i-1][j-1] = 1;
					}
				}
			}
			int count = 0;
			for(int i = 1; i < n; i++){ //1번노드부터 //이분 매칭 + 모든 정점을 최소 cost로 분리시키기!
				for(int j = 1; j < m+1; j++){ // j번 노드로의 
					if(graph[i][j] != 1 && matching[i][j] == 0){ //i에서 j로 가는 경로가 있고 && 매칭되지 않았으면 
						matching[i][j] = i; //매칭한다
						count++;
					}
					else if(graph[i][j] == 1 && matching[i][j] != 0){ // i에서j로 가는 경로가 있고&& 이미 매칭되어 있으면
						boolean flag = false;
						for(int k = 1; k < m+1; k++ ){ //기존 매칭이 다르게 매칭될 수 있는지 찾아본다 
							int lastMatching = matching[i][j];
							if(graph[lastMatching][k] == 1 && matching[lastMatching][k] == 0){ //lastMatching에서 j로 가는 경로가 있고 && 매칭되지 않았으면 
								matching[lastMatching][k] = lastMatching;
								flag = true;
							}
						}
						if(flag == true){ // 기존 점이 새롭게 매칭되면 
							matching[i][j] = i; //새로운 매칭을 성사시킨다.
							count++;
						}else{ //기존 점이 새로이 매칭할 곳이 없으면
							//새로운 점은 매칭을 하지 않는다. 
						}
					}
				}
			}
			System.out.println(count);
			
		}//테스트 케이스 루프
	}

}
