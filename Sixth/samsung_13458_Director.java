package Sixth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class samsung_13458_Director {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// https://www.acmicpc.net/problem/13458
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		int[] numOfStu = new int[N+2];
		for(int i = 0; i < N; i ++){
			numOfStu[i+1] = Integer.parseInt(str[i]);
		}
		str = br.readLine().split(" ");
		int B = Integer.parseInt(str[0]);
		int C = Integer.parseInt(str[1]);
		long count = N;
		for(int i = 1; i < N+1; i ++){
			numOfStu[i] = numOfStu[i] - B;
			if(numOfStu[i] < 1) continue;
			if(numOfStu[i] % C == 0){
				count += numOfStu[i]/C;
			}else{
				count += numOfStu[i] / C + 1; 
			}
		}
		System.out.println(count);
	}
}
