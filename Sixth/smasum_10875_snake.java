package Sixth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class smasum_10875_snake {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//https://www.acmicpc.net/problem/10875
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		Input[] input = new Input[N+2];
		String[] str;
		for(int i = 0; i<N;i++){
			str = br.readLine().split(" ");
			char c = str[1].charAt(0);
			if(c == 'R'){ //R이면 dir 은 0, L이면 dir 은 1
				input[i] = new Input(Integer.parseInt(str[0]), 0);
			}else{
				input[i] = new Input(Integer.parseInt(str[0]), 1);
			}
		}
		System.out.println(play(input, L, N));
	}
	
	static long play(Input[] in, int border, int n){
		Line[] lines = new Line[3005];
		int[] dx = {0, 1, 0, -1}; // 0=R 1=D 2=L 3=U
		int[] dy = {1, 0, -1, 0};
		int lineIndex = 1;
		long t = 0;
		int x = 0, y = 0;
		int dir = 0;
		long deadTime = 0;
		
		for(int i = 0; i < n+1; i++){
			int newX = 0, newY = 0;
			int turnTime = 0, turnDir = 0;
			if(i == n){
				if(dir == 0){
					newY = border+1;
					turnTime = border+1 - y;
				}else if(dir == 2){
					newY = -border-1;
					turnTime = y - (-border -1);
				}else if(dir == 1){
					newX = border+1;
					turnTime = border+1 - x;
				}else if(dir == 3){
					newX = -border -1;
					turnTime = x - (-border -1);
				}
				lineIndex--;
			}
			else{
				turnTime = in[i].t;
				turnDir = in[i].dir;
				newX = x+dx[dir]*turnTime;
				newY = y+dy[dir]*turnTime;
			}
			t += turnTime;
			
			if(dir == 0){ 
				lines[lineIndex] = new Line(y,newY,x,x);
				if(newY > border) deadTime =  t - (newY - border) +1;
			}else if(dir == 1){ 
				lines[lineIndex] = new Line(y,y,newX,x);
				if(newX > border) deadTime =  t - (newX - border) +1;
			}else if(dir == 2){ 
				lines[lineIndex] = new Line(newY,y,x,x);
				if(newY < -border) deadTime =  t - (-border-newY) +1;
			}else{ 
				lines[lineIndex] = new Line(y,y,x,newX);
				if(newX < -border) deadTime =  t - (-border - newX) +1;
			}
			
			for(int j = 1; j < lineIndex-1; j ++){ //몸에 부딪히는지 체크
				int newTop = lines[lineIndex].top , 	newBottom = lines[lineIndex].bottom;
				int newLeft = lines[lineIndex].left, 	newRight = lines[lineIndex].right;
				int oldTop = lines[j].top, 				oldBottom = lines[j].bottom;
				int oldLeft = lines[j].left, 			oldRight = lines[j].right;
				
				if(newTop  > oldBottom || newBottom < oldTop) continue;
				if(newRight < oldLeft || newLeft > oldRight) continue;
				
				if(dir == 0){
					if(deadTime == 0) deadTime = t - (newRight - oldLeft);
					else deadTime = Math.min(t - (newRight - oldLeft), deadTime) ;
				}else if(dir == 2){
					if(deadTime == 0) deadTime = t - (oldRight - newLeft);
					else deadTime = Math.min(t - (oldRight - newLeft),deadTime);
				}else if(dir == 1){
					if(deadTime == 0) deadTime = t - (newBottom- oldTop);
					else deadTime = Math.min(t - (newBottom - oldTop),deadTime);
				}else{ //dir = 3
					if(deadTime == 0) deadTime = t - (oldBottom - newTop);
					else deadTime = Math.min(t - (oldBottom - newTop),deadTime);
				}
			}
			if(deadTime != 0) return deadTime;
			if(turnDir == 0){ //Turn Right
				dir ++;
				if(dir == 4) dir = 0;
			}else{ //Turn Left
				dir--;
				if(dir == -1) dir = 3;
			}
			x = newX;
			y = newY;
			lineIndex++;
		}
		return deadTime;
	}
	
	static class Line{
		int left, right, bottom, top;
		Line(int l, int r, int b, int t){
			right = r; bottom = b; left = l; top = t;
		}
	}
	static class Input{
		int t;
		int dir;
		Input(int time, int direction){
			t = time; dir = direction;
		}
	}

}
