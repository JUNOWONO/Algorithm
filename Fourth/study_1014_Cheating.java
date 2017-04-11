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
						map[i][j] = 1; //���� �� �ִ� �ڸ���
						maxSeatNum++;
					}else{
						map[i][j] = 0; //���� �� ���� �ڸ�
					}
				}
			}
			//���⼭ ���� �ٽ� 1.1~10.10�� ��带 1~100���� ��ȣ �ޱ��. 
			int[][] nodeNum = new int[11][11];
			for(int i = 1; i < n; i++){
				for(int j = 1; j < m+1; j++){
					nodeNum[i][j] = (i-1)*10+(j-1);
				}
			}
			for(int i = 1; i < n; i++){
				for(int j = 1; j < m+1; j++){
					if(map[i][j] == 1){ // i,j�� ������ ���ʰ� �Ǵ� ��θ� 1ǥ��
						graph[i][j+1] = 1; graph[i+1][j+1] = 1; graph[i-1][j+1] = 1;
						graph[i][j-1] = 1; graph[i+1][j-1] = 1; graph[i-1][j-1] = 1;
					}
				}
			}
			int count = 0;
			for(int i = 1; i < n; i++){ //1�������� //�̺� ��Ī + ��� ������ �ּ� cost�� �и���Ű��!
				for(int j = 1; j < m+1; j++){ // j�� ������ 
					if(graph[i][j] != 1 && matching[i][j] == 0){ //i���� j�� ���� ��ΰ� �ְ� && ��Ī���� �ʾ����� 
						matching[i][j] = i; //��Ī�Ѵ�
						count++;
					}
					else if(graph[i][j] == 1 && matching[i][j] != 0){ // i����j�� ���� ��ΰ� �ְ�&& �̹� ��Ī�Ǿ� ������
						boolean flag = false;
						for(int k = 1; k < m+1; k++ ){ //���� ��Ī�� �ٸ��� ��Ī�� �� �ִ��� ã�ƺ��� 
							int lastMatching = matching[i][j];
							if(graph[lastMatching][k] == 1 && matching[lastMatching][k] == 0){ //lastMatching���� j�� ���� ��ΰ� �ְ� && ��Ī���� �ʾ����� 
								matching[lastMatching][k] = lastMatching;
								flag = true;
							}
						}
						if(flag == true){ // ���� ���� ���Ӱ� ��Ī�Ǹ� 
							matching[i][j] = i; //���ο� ��Ī�� �����Ų��.
							count++;
						}else{ //���� ���� ������ ��Ī�� ���� ������
							//���ο� ���� ��Ī�� ���� �ʴ´�. 
						}
					}
				}
			}
			System.out.println(count);
			
		}//�׽�Ʈ ���̽� ����
	}

}
