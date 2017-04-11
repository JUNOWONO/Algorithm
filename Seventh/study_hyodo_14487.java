package Seventh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class study_hyodo_14487 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// https://www.acmicpc.net/problem/14487
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int max  = 0;
		String[] arr = br.readLine().split(" ");
		int sum = 0;
		for(int i = 0 ; i < n; i ++){
			int tmp = Integer.parseInt(arr[i]);
			sum += tmp;
			if(tmp > max) max = tmp;
		}
		sum -= max;
		System.out.println(sum);

	}

}
