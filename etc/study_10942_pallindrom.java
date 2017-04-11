import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class study_10942_pallindrom {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+3];
		int[][] dp = new int[n+2][n+2];
		String[] str = br.readLine().split(" ");
		Queue<Pair> q = new LinkedList<Pair>();
		for(int i = 1; i < n+1; i ++){
			arr[i] = Integer.parseInt(str[i-1]);
			dp[i][i] = 1;
			q.offer(new Pair(i,i));
		}
		int qn = Integer.parseInt(br.readLine());
		int[] result = new int[qn+1];
		Pair p;
		int x, y;


		for(int l = 1; l < n; l ++) {//숫자 2개 비교
			if(arr[l] == arr[l+1]) {
				dp[l][l+1] = 1;
				q.offer(new Pair(l, l+1));
			}
		}

		for(int l = 1; l < n-1; l ++) {//숫자 3개 비교
			if(arr[l] == arr[l+2]) {
				dp[l][l+2] = 1;
				q.offer(new Pair(l, l+2));
			}
		}
		while(!q.isEmpty()){
			p = q.poll();
			x = p.getX();
			y = p.getY();
			//System.out.println(y);
			if(y < n+1 && arr[x-1] == arr[y+1]){
				dp[x-1][y+1] = 1;
				q.offer(new Pair(x-1, y+1));
			}
		}
		
		/*
		for(int l = 1; l < n+1; l ++) { //4개 비교 부터 
			int tmp = 0;
			for(int r = l; r < n+1; r++) {
				if(dp[l-tmp][l+tmp] == 1 && arr[l-tmp-1] == arr[l+tmp+1]) {
					dp[l-tmp-1][l+tmp+1] = 1;
					q.offer(new Pair(l-tmp-1, l+tmp+1));
					tmp++;
				}
			}
		}
		*/
		
		
		
		for(int l = 1; l < n+1; l ++) { 
			System.out.println();
			for(int r = 1; r < n+1; r++) {
				System.out.print(dp[l][r]+ " ");
			}
		}
		
		
		for(int i = 1; i < qn+1; i++){
			str = br.readLine().split(" ");
			result[i] = dp[Integer.parseInt(str[0])][Integer.parseInt(str[1])];
		}
		for(int i = 1; i < qn+1; i++){
			System.out.println(result[i]);
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
