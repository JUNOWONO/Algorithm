package Seventh;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class study_joonoh_14488 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// https://www.acmicpc.net/problem/14488
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double timeLeftIn =sc.nextDouble();
		long timeLeft =  (long)(timeLeftIn*10000);
		
		ArrayList<Integer> X = new ArrayList<Integer>();
		int result = 1;

		for(int i = 0; i < N; i++){
			X.add(sc.nextInt()*10000);
		}
		int tv = sc.nextInt(); 
		long left = X.get(0) - tv*timeLeft; 
		long right = X.get(0) + tv*timeLeft;
		for(int i = 1 ; i < N; i++){
			int v = sc.nextInt();
			long x = (long)X.get(i);
			long move = v*timeLeft;
			long ll = x - move;
			long rr = x + move;
			
			if(rr < left || ll > right){
				result = 0;
				break;
			}
			left = Math.max(left, ll);
			right = Math.min(right,  rr);
		}
		System.out.println(result);
		
	}

}
