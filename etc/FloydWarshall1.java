import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class FloydWarshall1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//https://www.acmicpc.net/problem/1389
		//�÷��̵� �ͼ� - �ִܰŸ�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = new String[2];
		int n; //��� ��
		int l; //��ũ ��
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
		for(int i = 1; i < l+1; i++){ //��������Ʈ ���� �� ��Ī �����ִ°� �߿�!
			in = br.readLine().split(" ");
			ad[Integer.parseInt(in[0])][Integer.parseInt(in[1])]  = 1;
			ad[Integer.parseInt(in[1])][Integer.parseInt(in[0])]  = 1;
			
		}
		
		
			//��� ����� �ɺ� ���������� ���ϰ� �� �߿��� ���� ���� ����� ���
		for(int k = 1; k < n+1; k++){ //���İ� ���� �������� Ž��
			for(int i = 1; i < n+1; i++){ //��� i ���� j��
				for(int j = 1; j < n+1; j++){
					if(ad[i][j] > ad[i][k] + ad[k][j]) //�湮 ���� �ʾҰų� �� ���� ��ΰ� ������ ��ü
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
