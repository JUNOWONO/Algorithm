import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Coin {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//2293번 동전1문제, n가지 종류의 동전, 동전 적당히 사용해서 합이 k월이 되도록하는 경우의 수(동전의 갯수는 무한)
		//
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n,k;
		int[] dp; //인덱스 k원을 만드는 데의 경우의 수
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
	    for(int i=0; i<=n-1; i++) //코인 1개~n개 까지 사용할 때에 대해서
	    {
	        for(int j=coin[i]; j<=k ; j++) //바닥 금액 부터 k원 까지 
	        {
	            if(coin[i] <= j)
	            dp[j] += dp[j-coin[i]];
	        }
	    }
		
		
		System.out.println(dp[k]);
	}
	
	
}
