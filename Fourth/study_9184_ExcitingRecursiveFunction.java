package Fourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class study_9184_ExcitingRecursiveFunction {
	static int a, b, c;
	static int[][][] dp;
	static Queue<Input> q;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		q = new LinkedList<Input>();
		while(true){
			input();
			if(a == -1 && b == -1 && c == -1) break;
			q.add(new Input(a,b,c));
		}
		while(!q.isEmpty()){
			Input input = q.poll();
			a = input.A;
			b = input.B;
			c = input.C;
			System.out.print("w("+a+", "+b+", "+c+") = ");;
			if(a<1 || b <1|| c < 1) System.out.println(1);
			else{
				dp = new int[a+2][b+2][c+2];
				w(a,b,c);
				System.out.println(dp[a][b][c]);
			}
		}
	}
	public static int w(int a, int b, int c){
		if(dp[a][b][c] != 0) return dp[a][b][c];
		else{
			if(a < 1 || b < 1 || c < 1) {
				dp[a][b][c] = 1;
				return 1;
			}
			else if(a > 20 || b > 20 || c > 20) {
				dp[a][b][c] = w(20,20,20);
			}
			else if(a < b && b < c) {
				dp[a][b][c] = w(a,b,c-1) + w(a,b-1,c-1) - w(a,b-1,c);
			}
			else {
				dp[a][b][c] = w(a-1,b,c) + w(a-1,b-1,c) + w(a-1,b,c-1) - w(a-1,b-1,c-1);
			}
		}
		return dp[a][b][c];
	}
	
	public static void input() throws IOException{
		String[] str = br.readLine().split(" ");
		a = Integer.parseInt(str[0]);
		b = Integer.parseInt(str[1]);
		c = Integer.parseInt(str[2]);
	}
	static class Input{
		int A,B,C;
		public Input(int x, int y, int z){
			A = x; B = y; C = z;
		}
	}
}
