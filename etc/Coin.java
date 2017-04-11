import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Coin {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//2293�� ����1����, n���� ������ ����, ���� ������ ����ؼ� ���� k���� �ǵ����ϴ� ����� ��(������ ������ ����)
		//
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n,k;
		int[] dp; //�ε��� k���� ����� ���� ����� ��
		int[] coin;
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		k = Integer.parseInt(input[1]);
		dp = new int[k+1];
		coin = new int[n+1];
		
		for(int i=0; i<n; i++){
			coin[i] = Integer.parseInt(br.readLine());
		}
		for(int i=0; i<k+1; i++){
			dp[i] = 0;
		}
		
		dp[0] = 1;
	    for(int i=0; i<=n-1; i++) //���� 1��~n�� ���� ����� ���� ���ؼ�
	    {
	        for(int j=coin[i]; j<=k ; j++) //�ٴ� �ݾ� ���� k�� ���� 
	        {
	            if(coin[i] <= j)
	            dp[j] += dp[j-coin[i]];
	        }
	    }
		
		
		System.out.println(dp[k]);
	}
	
	
}
