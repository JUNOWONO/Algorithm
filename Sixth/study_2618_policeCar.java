package Sixth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class study_2618_policeCar {
	static int N;
	static int W;
	static PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
	static SimplePair[] wArr ;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// https://www.acmicpc.net/problem/2618
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		W = Integer.parseInt(br.readLine());
		wArr = new SimplePair[1010];
		String[] str;
		for(int i = 1; i < W+1; i ++){
			str = br.readLine().split(" ");
			wArr[i] = new SimplePair(Integer.parseInt(str[0]), Integer.parseInt(str[1])); 
		}
		pq.add(new Pair(1,1,N,N,0,0));
		int[] dp = new int[1010];
		int[] w_c = new int[1010];
		Arrays.fill(dp, Integer.MAX_VALUE);
		while(!pq.isEmpty()){
			Pair car = pq.poll();
			int count = car.count; //사건 처리한 개수
			int dis = car.dis;
			//if(dp[count] < dis) continue; //이전에 기록된 dis보다 크면 continue;
			if(count == W) continue;
			int x1 = car.x1;
			int y1 = car.y1;
			int x2 = car.x2;
			int y2 = car.y2;
			//if(x1 < 1 || x1 > N || y1 < 1 || y1 > N || x2 < 1 || x2 > N || y2 < 1 || y2 > N ) continue;
			//System.out.println("car1 :" + x1 + "," + y1 + " car2 :" + x2 + "," + y2 + " dis:" + dis + " count:" + count);
			//if(count == W) continue;
			int nextCount = count+1;
			SimplePair w = wArr[nextCount];
			int wX = w.x;
			int wY = w.y;
			int nextDis1 = dis + Math.abs(wX-x1) + Math.abs(wY-y1);
			int nextDis2 = dis + Math.abs(wX-x2) + Math.abs(wY-y2);
			if(dp[nextCount] >= nextDis1){
				pq.add(new Pair(wX,wY,x2,y2,nextDis1,nextCount));
				dp[count+1] = nextDis1;
				w_c[nextCount] = 1; 
			}
			if(dp[nextCount] >= nextDis2){
				pq.add(new Pair(x1,y1,wX,wY,nextDis2,nextCount));
				dp[count+1] = nextDis2;
				w_c[nextCount] = 2;
			}
		}
		System.out.println(dp[W]);
		for(int i = 1; i < W+1; i ++){
			System.out.println(w_c[i]);
		}
		
	}
	
	static class Pair implements Comparable<Pair>{
		int x1,y1,x2,y2,dis,count;
		public Pair(int a1, int b1,int a2, int b2, int d,int c){
			x1 = a1;
			y1 = b1;
			x2 = a2;
			y2 = b2;
			count = c;
			dis = d;
		}
		@Override
		public int compareTo(Pair o) {
			return this.dis > o.dis ? -1 : 1;
		}
	}
	static class SimplePair{
		int x,y;
		public SimplePair(int a, int b){
			x= a; y= b;
		}
	}
}
