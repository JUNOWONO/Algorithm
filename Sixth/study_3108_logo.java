package Sixth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class study_3108_logo {
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// https://www.acmicpc.net/problem/3108
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		int newLeft=0, newTop=0, newBottom=0, newRight=0;
		int oldLeft=0, oldTop=0, oldBottom=0, oldRight=0;
		ArrayList<Pair> oldList = new ArrayList<Pair>();
		//boolean checkZeroPoint = false;
		int[] arr = new int[1001];
		oldList.add(new Pair(0,0,0,0));
		arr[0] = 0;
		for(int i = 1 ; i < n+1; i ++){
			String[] strArr = br.readLine().split(" ");
			int x1=0,y1=0,x2=0,y2=0;
			arr[i] = i;
			for(int j = 0; j < n; j++){
				x1 = Integer.parseInt(strArr[0]);
				y1 = Integer.parseInt(strArr[1]);
				x2 = Integer.parseInt(strArr[2]);
				y2 = Integer.parseInt(strArr[3]);
			}
			if(x1 < x2) {
				newTop = x1;
				newBottom = x2;
			}
			else {
				newTop = x2;
				newBottom = x1;
			}
			if(y1 < y2){
				newLeft = y1;
				newRight = y2;
			}
			else {
				newLeft = y2;
				newRight = y1;
			}
//			if(checkZeroPoint == false){
//				if((newLeft == 0 || newRight == 0)&& newTop <= 0 && newBottom >= 0){
//					count--;
//					checkZeroPoint = true;
//				}else if((newTop == 0 || newBottom == 0)&& newLeft <= 0 && newRight >= 0){
//					count--;
//					checkZeroPoint = true;
//				}
//			}
			//boolean isSeparate = true;
			for(int k = 0; k < oldList.size(); k++){
				Pair oldPair = oldList.get(k);
				oldTop = oldPair.top; oldLeft = oldPair.left; oldRight = oldPair.right; oldBottom = oldPair.bottom;
	
				//System.out.println(oldLeft+","+oldTop+","+oldRight+","+oldBottom+"_"+newLeft+","+newTop+","+newRight+","+newBottom);
				if((newRight < oldLeft || newLeft > oldRight)){ //좌우가 범위 밖
					continue;
				}else{
					if((newBottom < oldTop || newTop > oldBottom)){// 상하가 범위 밖
						continue;
					}else{
						//완전히 내부에 포함
						if((newTop > oldTop && newBottom < oldBottom && newLeft > oldLeft && newRight < oldRight)){
							continue;
						}else if((newTop < oldTop && newBottom > oldBottom && newLeft < oldLeft && newRight > oldRight)){
							continue;
						}else{
							//이전꺼랑 겹친다. 하나라도 겹치는게 있으면 카운트 증가 안시킴
							//System.out.println("겹친다");
							if(arr[i] == i){ // 처음 바뀌는 거면 
								arr[i] = arr[k];
							}else{ 
								arr[k] = arr[i];
							}
							
							//count--;
							//isSeparate = false;
							
						}
					}
				}
			}
			//if(isSeparate == true) count++;
			//System.out.println(count);
			oldList.add(new Pair(newLeft,newRight,newTop,newBottom));
		}
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for(int i = 0; i < n+1; i++){
			q.add(arr[i]);
		}
		int last = -1;
		int now = 0;
		while(!q.isEmpty()){
			now = q.poll();
			if(now != last){
				count++;
			}
			last = now;
		}
		count--;
		//count--;
//		for(int i = 0; i < n; i++){
//			System.out.print(arr[i]);
//		}
//		System.out.println();
		System.out.println(count);
	}
	 
	static class Pair{
		int left,right, top, bottom;
		public Pair(int l, int r,int t,int b){
			left = l; right = r; top = t; bottom = b; 
		}
	}
}
