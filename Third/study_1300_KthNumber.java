package Third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class study_1300_KthNumber {
	static int n;
	static int k;
//	static int[][] arr;
	static int answer;
	static int NN;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// https://www.acmicpc.net/problem/1300
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
//		arr = new int[n+1][n+1];
//		
//		for(int i = 1; i < n+1; i++){
//			for(int j = 1; j < n+1; j++){
//				if(i > 31622) i = 31622; //10^4.5
//				if(j > 31622) j = 31622;
//				arr[i][j] = i*j;
//			}
//		}
		if(n>10000) NN = 1000000000;
		else
			NN = n*n;
		binarySearch(1, NN, NN/2);
		//System.out.println(NN + ", " + NN/2);
		System.out.println(answer);
		
	}
	
	static void binarySearch(int left, int right, int X){ 
		int belowX, belowX_1; //X이하, X-1 이하의 수
		int l=left,r=right,x=X;
		
		while(r >= l){
			//System.out.println(l + ", " + r + ", " + x);
			belowX = 0;
			belowX_1 = 0;
			for(int i = 1; i < n+1; i++){
				belowX += Math.min(x/i, n);
				belowX_1 += Math.min((x-1)/i, n);
			}
			//System.out.println(belowX + ", " + belowX_1  );
			if(belowX_1 < k && belowX >= k){
				answer = x;
				break;
			}
			else{
				if(belowX_1 >= k) { //왼쪽 반
					//binarySearch(left, X-1, (left-(X-1))/2);
					
//					if(belowX_1 == k){
//						answer = x-1;
//						break;
//					}
					r = x-1;
					x = (r-l)/2;
				}
				else if(belowX < k){//오른쪽 반
					//binarySearch(X+1, right, ((X+1)+right)/2);
					l = x+1;
					x = (l+r)/2;
				}
			}
		}
		return;
	}

}
