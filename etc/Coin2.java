import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Coin2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//2294번 동전2문제, 동전의 개수가 최소가 되도록
		//
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n,k;
		int[] dp; 
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
	    for(int i=0; i<=n-1; i++) 
	    {
	        for(int j=coin[i]; j<=k ; j++) 
	        {
	            if(coin[i] <= j)
	            dp[j] += dp[j-coin[i]];
	        }
	    }
		
		
		System.out.println(dp[k]);
	}
}
