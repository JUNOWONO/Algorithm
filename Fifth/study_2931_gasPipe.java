package Fifth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class study_2931_gasPipe {
	static char[][] map;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static Pair StartPoint;
	static int count;
	public static void main(String[] args) throws IOException {
		//https://www.acmicpc.net/problem/2931
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArr =  br.readLine().split(" ");
		Queue<Pair> q1 = new LinkedList<Pair>();
		Queue<Pair> q2 = new LinkedList<Pair>();
		ArrayList<Pair> list1 = new ArrayList<Pair>();
		ArrayList<Pair> list2 = new ArrayList<Pair>();
		int r = Integer.parseInt(strArr[0]);
		int c = Integer.parseInt(strArr[1]);
		map = new char[r+2][c+2];
		for(int i = 1; i < r+1; i++){
			String str = br.readLine();
			for(int j = 1; j < c+1; j++){
				map[i][j] =  str.charAt(j-1);
				if(map[i][j] == 'M') q1.add(new Pair(i,j,'0',0));
				if(map[i][j] == 'Z') q2.add(new Pair(i,j,'0',0));
				if(map[i][j] != '.') {
					if(map[i][j] == '+') count++;
					count++;
				}
			}
		}
		Pair pair = q1.poll();
		moveOnce(pair.x, pair.y, q1);
		pair = q2.poll();
		moveOnce(pair.x, pair.y, q2);
		pair = q1.peek();
		StartPoint = new Pair(pair.x, pair.y, pair.pipe, pair.from);
		
		solve(q1,list1);
		solve(q2,list2);
		
		printResult(list1, list2);		
	}
	static void moveOnce(int x_, int y_, Queue<Pair> q1){
		for(int i = 0; i < 4; i++){
				int x = x_ + dx[i];
				int y = y_ + dy[i];
				if( i == 1){ //오른쪽으로
					if(map[x][y] == '-' || map[x][y] == '+'){
						q1.add(new Pair(x,y,map[x][y],i));
					}else if( map[x][y] == '3' ){
						q1.add(new Pair(x,y,map[x][y],i));
					}else if(map[x][y] == '4'){
						q1.add(new Pair(x,y,map[x][y],i));
					}
				}else if(i == 0){ //밑으로 
					if(map[x][y] == '|' || map[x][y] == '+' ){
						q1.add(new Pair(x,y,map[x][y],i));
					}else if(map[x][y] == '2' ){
						q1.add(new Pair(x,y,map[x][y],i));
					}else if(map[x][y] == '3'){
						q1.add(new Pair(x,y,map[x][y],i));
					}
				}else if(i == 3){ // 왼쪽으로
					if(map[x][y] == '-' || map[x][y] == '+'){
						q1.add(new Pair(x,y,map[x][y],i));
					}else if(map[x][y] == '1'){
						q1.add(new Pair(x,y,map[x][y],i));
					}else if(map[x][y] == '2'){
						q1.add(new Pair(x,y,map[x][y],i));
					}
				}else if(i == 2){ //위로
					if(map[x][y] == '|' || map[x][y] == '+' ){
						q1.add(new Pair(x,y,map[x][y],i));
					}else if(map[x][y] == '1'){
						q1.add(new Pair(x,y,map[x][y],i));
					}else if( map[x][y] == '4'){
						q1.add(new Pair(x,y,map[x][y],i));
					}
				}
		}
	}
	static void solve(Queue<Pair> q1, ArrayList<Pair> list1){
		while(!q1.isEmpty()){
				Pair p = q1.poll();
				int x = p.x, y = p.y, pipe = p.pipe, from = p.from;
				//System.out.println(p.x+ "," + p.y + "," + p.pipe + "," + p.from );
				if(map[x][y] == '.'){
					list1.add(new Pair(x,y,map[x][y], from)); //경로 따라 왔는는데 '.'이면 pipe는 그대로, from도 그대로
				}
				if(from == 0){ //밑으로
					if(pipe == '|' || pipe == '+'){
						q1.add(new Pair(x+1,y,map[x+1][y],0));
					}else if(pipe == '2'){ 
						q1.add(new Pair(x,y+1,map[x][y+1],1)); //오른쪽으로
					}else if(pipe == '3'){
						q1.add(new Pair(x,y-1,map[x][y-1],3)); //왼쪽으로
					}
				}else if(from == 1){ //오른쪽으로
					if(pipe == '-' || pipe == '+'){
						q1.add(new Pair(x,y+1,map[x][y+1],1));
					}else if(pipe == '3'){ 
						q1.add(new Pair(x-1,y,map[x-1][y],2)); //위로
					}else if(pipe == '4'){
						q1.add(new Pair(x+1,y,map[x+1][y],0)); //밑으로
					}
				} else if(from == 2){ //위로
					if(pipe == '|' || pipe == '+'){
						q1.add(new Pair(x-1,y,map[x-1][y],2));
					}else if(pipe == '1'){ 
						q1.add(new Pair(x,y+1,map[x][y+1],1)); //오른쪽으로
					}else if(pipe == '4'){
						q1.add(new Pair(x,y-1,map[x][y-1],3)); //왼쪽으로
					}
				}else if(from == 3){ //왼쪽으로
					if(pipe == '-' || pipe == '+'){
						q1.add(new Pair(x,y-1,map[x][y-1],3));
					}else if(pipe == '1'){ 
						q1.add(new Pair(x+1,y,map[x+1][y],0)); //밑으로
					}else if(pipe == '2'){
						q1.add(new Pair(x-1,y,map[x-1][y],2)); //위로
					}
				}
			}
	}
	static boolean checkPlus(Queue<Pair> q){
		boolean check = false;
		int countPath = 1;
		while(!q.isEmpty()){
				Pair p = q.poll();
				int x = p.x, y = p.y, pipe = p.pipe, from = p.from;
				//System.out.println(p.x+ "," + p.y + "," + p.pipe + "," + p.from );
				countPath++;
				if(map[x][y] == 'Z'){
					check = true;
				}
				if(from == 0){ //밑으로
					if(pipe == '|' || pipe == '+'){
						q.add(new Pair(x+1,y,map[x+1][y],0));
					}else if(pipe == '2'){ 
						q.add(new Pair(x,y+1,map[x][y+1],1)); //오른쪽으로
					}else if(pipe == '3'){
						q.add(new Pair(x,y-1,map[x][y-1],3)); //왼쪽으로
					}
				}else if(from == 1){ //오른쪽으로
					if(pipe == '-' || pipe == '+'){
						q.add(new Pair(x,y+1,map[x][y+1],1));
					}else if(pipe == '3'){ 
						q.add(new Pair(x-1,y,map[x-1][y],2)); //위로
					}else if(pipe == '4'){
						q.add(new Pair(x+1,y,map[x+1][y],0)); //밑으로
					}
				} else if(from == 2){ //위로
					if(pipe == '|' || pipe == '+'){
						q.add(new Pair(x-1,y,map[x-1][y],2));
					}else if(pipe == '1'){ 
						q.add(new Pair(x,y+1,map[x][y+1],1)); //오른쪽으로
					}else if(pipe == '4'){
						q.add(new Pair(x,y-1,map[x][y-1],3)); //왼쪽으로
					}
				}else if(from == 3){ //왼쪽으로
					if(pipe == '-' || pipe == '+'){
						q.add(new Pair(x,y-1,map[x][y-1],3));
					}else if(pipe == '1'){ 
						q.add(new Pair(x+1,y,map[x+1][y],0)); //밑으로
					}else if(pipe == '2'){
						q.add(new Pair(x-1,y,map[x-1][y],2)); //위로
					}
				}
			}
		//System.out.println(count + ", " + countPath);
		if(countPath != count) check = false;
		return check;
	}
	static void printResult(ArrayList<Pair> list1, ArrayList<Pair> list2){
		char result = '0';
		int resultX = 0;
		int resultY = 0;
		for(Pair p1 : list1){
			for (Pair p2 : list2){
				if(p1.x == p2.x && p1.y == p2.y){
					
					resultX = p1.x;
					resultY = p1.y;
					if(p1.from == 0){
						if(p2.from == 1){
							result = '3';
						}else if(p2.from == 2){
							result = '|';
						}else if(p2.from == 3){
							result = '2';
						}
					}else if(p1.from == 1){
						if(p2.from == 0){
							result = '3';
						}else if(p2.from == 2){
							result = '4';
						}else if(p2.from == 3){
							result = '-';
						}
					}else if(p1.from == 2){
						if(p2.from == 0){
							result = '|';
						}else if(p2.from == 1){
							result = '4';
						}else if(p2.from == 3){
							result = '1';
						}
					}else if(p1.from == 3){
						if(p2.from == 0){
							result = '2';
						}else if(p2.from == 1){
							result = '-';
						}else if(p2.from == 2){
							result = '1';
						}
					}
					break;
				}
			}
		}
		map[resultX][resultY] = result;
		count++;
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(StartPoint);
		if(checkPlus(q) != true){ // 결과 넣었을 때 목적지 까지 갈 수 없으면
			result = '+';
		}
		System.out.println(resultX + " " + resultY + " " + result);
	}
	
}
class Pair{
	int x, y, from;
	char pipe;
	public Pair(int a, int b, char p, int f){
		x = a; y  =b;  pipe = p; from = f;//pipe 0,1,2,3 각 밑으로, 오른쪽으로, 위로, 왼쪽으로
	}
}
