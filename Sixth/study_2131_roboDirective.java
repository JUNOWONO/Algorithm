package Sixth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
public class study_2131_roboDirective {
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// https://www.acmicpc.net/problem/2131 //케익배달  풀어보기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int roboX = 0, roboY = 0, roboDir = 1;
		Pair[] pArr = new Pair[N+2];
		int totalScanCount = 0;
		for(int i = 0; i < N; i ++){ //search locations for scan
			String directive = br.readLine();
			if(directive.equals("Forward")){
				if(roboDir == 1) roboY++;
				else if(roboDir == 2) roboX++;
				else if(roboDir == 3) roboY--;
				else if(roboDir == 4) roboX--;
			}else if(directive.equals("Turn Left")){
				roboDir--;
				if(roboDir == 0) roboDir = 4;
			}else if(directive.equals("Turn Right")){
				roboDir++;
				if(roboDir == 5) roboDir = 1;
			}else if(directive.equals("Scan")){
				if(roboDir == 1)pArr[totalScanCount] = new Pair(roboX,roboY+1,0,0,0);
				else if(roboDir == 2)pArr[totalScanCount] = new Pair(roboX+1, roboY,0,0,0);
				else if(roboDir == 3)pArr[totalScanCount] = new Pair(roboX,roboY-1,0,0,0);
				else if(roboDir == 4)pArr[totalScanCount] = new Pair(roboX-1,roboY,0,0,0);
				totalScanCount++;
			}
		}
		PriorityQueue<Pair> newRoboQ = new PriorityQueue<Pair>();
		newRoboQ.add(new Pair(0,0,0,totalScanCount,1));
		int resultCount = Integer.MAX_VALUE;
		int[][] dp = new int[5][N+2]; //i개 남았을 떄 count 최소값
		for(int i = 1; i < 5; i ++){
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		while(!newRoboQ.isEmpty()){
			Pair newRobo = newRoboQ.poll();
			int count = newRobo.count;
			int leftScanCount = newRobo.leftScanCount;
			int dir = newRobo.dir;
			if(dp[dir][leftScanCount] <= count) continue;
			dp[dir][leftScanCount] = Math.min(dp[dir][leftScanCount], count);
			if(leftScanCount == 0) continue;
			
			int x = newRobo.x;
			int y = newRobo.y;
			//System.out.println(x+","+y+" count :"+count +" leftCount :"+ leftScanCount);
			
			Pair scanPair = pArr[totalScanCount - leftScanCount];
			int scanX = scanPair.x;
			int scanY = scanPair.y;
			for(int i = 0; i < 4; i++){
				int X = scanX + dx[i];
				int Y = scanY + dy[i];
				int nextCount = count;
				int nextDir = (i+2)%4+1;
				if(X == x && Y == y){//스캔가능  위치에 있으면
					nextCount++;
					newRoboQ.add(new Pair(X,Y,nextCount,leftScanCount-1,nextDir));
				}else if(X == x){
					nextCount+=2;
					newRoboQ.add(new Pair(x,Y,nextCount,leftScanCount-1,nextDir));
				}else if(Y == x){
					nextCount+=2;
					newRoboQ.add(new Pair(X,y,nextCount,leftScanCount-1,nextDir));
				}else{
					nextCount+=3;
					newRoboQ.add(new Pair(X,Y,nextCount,leftScanCount-1,nextDir));
				}
			}
			
		}
		for(int i = 1; i < 5; i ++){
			resultCount = Math.min(dp[i][0], resultCount);
		}
		System.out.println(resultCount);
		
	}
	static class Pair implements Comparable<Pair>{
		int x,y,count,leftScanCount,dir;
		public Pair(int a, int b, int c, int l, int d){
			x = a; y = b;count = c;leftScanCount = l; dir = d;
		}
		@Override
		public int compareTo(Pair o) {
			return this.count < o.count ? -1:1;
		}
	}
}
