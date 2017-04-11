package Sixth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class study_2174_robotSimulation {

	public static void main(String[] args) throws IOException {
		// https://www.acmicpc.net/problem/2174
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int A = Integer.parseInt(str[0]); 
		int B = Integer.parseInt(str[1]);
		str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]); //로봇 수
		int M = Integer.parseInt(str[1]); //명령 수
		Pair[] roboArr = new Pair[N+2];
		String resultStr = null;
		int crashFrom = 0, crashInto = 0;
		for(int i = 1; i < N+1; i ++){ //로봇 위치 및 방향 세팅
			str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			int dir = 0;
			if(str[2].equals("E")) dir = 1;
			else if(str[2].equals("S")) dir = 2;
			else if(str[2].equals("W")) dir = 3;
			else if(str[2].equals("N")) dir = 4;
			roboArr[i] = new Pair(x,y,dir);
		}
		
		for(int i = 1; i < M+1; i ++){ //명령
			str = br.readLine().split(" ");
			int roboNum = Integer.parseInt(str[0]);
			int count = Integer.parseInt(str[2]); // 명령 반복 횟수
			int roboDir = roboArr[roboNum].dir;
			
			if(str[1].equals("F")){
				if(roboDir == 1){
					for(int r = 1; r < N +1; r++){
						if(r == roboNum) continue;
						if(roboArr[r].y == roboArr[roboNum].y 
								&& roboArr[r].x >=  roboArr[roboNum].x 
								&& roboArr[r].x <= roboArr[roboNum].x + count){
							crashFrom = roboNum;
							if(crashInto != 0){
								if(roboArr[crashInto].x > roboArr[r].x){ //새로 부딪히는 놈이 더 가까이 있으면
									crashInto = r;
								}
							}else{
								crashInto = r;
							}
						}
					}
					roboArr[roboNum].x += count;
				}else if(roboDir == 2){
					for(int r = 1; r < N +1; r++){
						if(r == roboNum) continue;
						if(roboArr[r].x == roboArr[roboNum].x 
								&& roboArr[r].y <=  roboArr[roboNum].y 
								&& roboArr[r].y >= roboArr[roboNum].y - count){
							crashFrom = roboNum;
							if(crashInto != 0){
								if(roboArr[crashInto].y < roboArr[r].y){ //새로 부딪히는 놈이 더 가까이 있으면
									crashInto = r;
								}
							}else{
								crashInto = r;
							}
						}
					}
					roboArr[roboNum].y -= count;
					
				}else if(roboDir == 3){
					for(int r = 1; r < N +1; r++){
						if(r == roboNum) continue;
						if(roboArr[r].y == roboArr[roboNum].y 
								&& roboArr[r].x <=  roboArr[roboNum].x 
								&& roboArr[r].x >= roboArr[roboNum].x - count){
							crashFrom = roboNum;
							if(crashInto != 0){
								if(roboArr[crashInto].x < roboArr[r].x){ //새로 부딪히는 놈이 더 가까이 있으면
									crashInto = r;
								}
							}else{
								crashInto = r;
							}
						}
					}
					roboArr[roboNum].x -= count;
					
				}else if(roboDir == 4){
					for(int r = 1; r < N +1; r++){
						if(r == roboNum) continue;
						if(roboArr[r].x == roboArr[roboNum].x 
								&& roboArr[r].y >=  roboArr[roboNum].y 
								&& roboArr[r].y <= roboArr[roboNum].y + count){
							crashFrom = roboNum;
							if(crashInto != 0){
								if(roboArr[crashInto].y > roboArr[r].y){ //새로 부딪히는 놈이 더 가까이 있으면
									crashInto = r;
								}
							}else{
								crashInto = r;
							}
						}
					}
					roboArr[roboNum].y += count;
				}
			}else{ //좌 우 회전 명령인 경우
				if(str[1].equals("L")){
					for(int c = 0; c < count; c++){
						roboDir =  roboDir -1;
						if(roboDir < 1) roboDir = 4;
					}
				}else if(str[1].equals("R")){
					for(int c = 0; c < count; c++){
						roboDir =  roboDir +1;
						if(roboDir > 4) roboDir = 1;
					}
				}
				roboArr[roboNum].dir = roboDir;
			}
			//범위를 벗어나는 경우
			if(roboArr[roboNum].x < 1 || roboArr[roboNum].x > A || roboArr[roboNum].y < 1 || roboArr[roboNum].y > B){
				crashFrom = roboNum;
				break;
			}
			if(crashFrom != 0) break;
		}
		if(crashFrom != 0){
			if(crashInto != 0){
				resultStr = "Robot " + crashFrom + " crashes into robot " + crashInto; 
			}else{
				resultStr = "Robot " + crashFrom + " crashes into the wall"; 
			}
		}else{
			resultStr = "OK";
		}
		System.out.println(resultStr);
		
	}
	static class Pair {
		int x, y, dir;
		public Pair(int a, int b, int d){
			x = a; y = b; dir = d;
		}
	}

}
