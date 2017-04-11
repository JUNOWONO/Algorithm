package Fourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class study_2805_woodCutting {
	static int n,m; //나무의 수, 최소 가져갈 나무의 길이
	static int[] heightList;
	static ArrayList<Long> list = new ArrayList<>();
	static long maxH = 0;
	public static void main(String[] args) throws IOException {
		// https://www.acmicpc.net/problem/2805
		input();
		solve(0, maxH+1);
		long max = 0;
		for(long a : list){
			if(a > max) max = a;
		}
		System.out.println(max);
	}
	public static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		heightList = new int[n+2];
		str = null;
		str = br.readLine().split(" ");
		for(int i = 1; i < n+1; i++){
			heightList[i]  = Integer.parseInt(str[i-1]);
			if(heightList[i]>maxH) maxH = heightList[i];
		}
	}
	public static void solve(long left, long right){
		if(left >= right-1) return;
		int sum = 0;
		long mid = (left+right)/2;
		for(int i = 1; i < n+1; i++){
			if(heightList[i]>mid) sum += heightList[i] - mid;
		}
		//테스트
		//System.out.println(left + "," + right + " > "+ mid + ", " + sum);
		if(sum < m){
			solve(left, mid);
		}
		else if( sum >= m){
			list.add(mid);
			solve(mid, right);
		}
	}
}
