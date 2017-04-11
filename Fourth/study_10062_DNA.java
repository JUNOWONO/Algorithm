package Fourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class study_10062_DNA {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// https://www.acmicpc.net/problem/10062
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String str;
		char[][] arr = new char[n+2][];
		for(int i = 1; i < n+1; i++){
			str = br.readLine();
			arr[i] = str.toCharArray();
		}

		Queue<char[]> q = new LinkedList<char[]>();
		for(int i = 1; i < n+1; i++){
			q.add(arr[i].clone());
			while(!q.isEmpty()){
				char[] c = q.poll();
				for(int j = 0; j < c.length; j++){
					if(c[j] == 'A'){
						
					}
				}
			}
		}
	}
}
