package Fourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class study_1100_whiteBlock {
	static int n;
	static int[][] map;
	static Stack<Integer>[] stArrLeftToRight;
	static Stack<Integer>[] stArrRightToLeft;
	static Stack<Integer>[] stArrTopToBottom;
	static Stack<Integer>[] stArrBottomToTop;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String[] str;
		map = new int[n+2][n+2];
		for(int i = 1; i < n+1; i++){
			str = br.readLine().split(" ");
			for(int j = 1; j < n+1; j++){
				map[i][j] = Integer.parseInt(str[j-1]);
			}
		}
		stArrLeftToRight = new Stack[n*n+2]; //왼쪽으로 기울임
		stArrRightToLeft = new Stack[n*n+2]; //오른쪽으로 기울임
		stArrTopToBottom = new Stack[n*n+2]; //위로 기울임
		stArrBottomToTop = new Stack[n*n+2]; //아래로 기울임
		for(int i = 1; i < n+1; i++){
			stArrLeftToRight[i] = new Stack<Integer>();
			stArrRightToLeft[i] = new Stack<Integer>();
			stArrTopToBottom[i] = new Stack<Integer>();
			stArrBottomToTop[i] = new Stack<Integer>();
		}
		for(int i = 1; i < n+1; i++){
			for(int j = 1; j < n+1; j++){
				stArrLeftToRight[i].push(map[i][j]);
				stArrRightToLeft[i].push(map[i][n-j+1]);
				stArrTopToBottom[j].push(map[i][j]);
				stArrBottomToTop[j].push(map[n-i+1][j]);
			}
		}
		for(int i = 0; i < 5; i ++){ //5번 실행ㅇ
			Stack<Integer> tmpStack;
			for(int j = 1; j < n+1; j++){ //모든 라인에 대해서
				int tmp;
				tmpStack = new Stack<Integer>();
				while(!stArrLeftToRight[j].isEmpty()){
					 tmp = stArrLeftToRight[j].pop();
					 if(stArrLeftToRight[j].isEmpty()) continue;
					 if(tmp == stArrLeftToRight[j].peek()){
						stArrLeftToRight[j].pop();
						tmpStack.push(tmp*2);
					 }else{
						 stArrLeftToRight[j].pop();
					 }
				}
				while(!tmpStack.isEmpty()){
					stArrRightToLeft[j].push(tmpStack.pop());
				}
				tmpStack = new Stack<Integer>();
				while(!stArrRightToLeft[j].isEmpty()){
					 tmp = stArrRightToLeft[j].pop();
					 if(stArrRightToLeft[j].isEmpty()) continue;
					 if(tmp == stArrRightToLeft[j].peek()){
						 stArrRightToLeft[j].pop();
						tmpStack.push(tmp*2);
					 }else{
						 stArrRightToLeft[j].pop();
					 }
				}
				while(!tmpStack.isEmpty()){
					stArrTopToBottom[j].push(tmpStack.pop());
				}
				tmpStack = new Stack<Integer>();
				while(!stArrTopToBottom[j].isEmpty()){
					 tmp = stArrTopToBottom[j].pop();
					 if(stArrTopToBottom[j].isEmpty()) continue;
					 if(tmp == stArrTopToBottom[j].peek()){
						 stArrTopToBottom[j].pop();
						tmpStack.push(tmp*2);
					 }else{
						 stArrTopToBottom[j].pop();
					 }
				}
				while(!tmpStack.isEmpty()){
					stArrLeftToRight[j].push(tmpStack.pop());
				}
				tmpStack = new Stack<Integer>();
				while(!stArrBottomToTop[j].isEmpty()){
					 tmp = stArrBottomToTop[j].pop();
					 if(stArrBottomToTop[j].isEmpty()) continue;
					 if(tmp == stArrBottomToTop[j].peek()){
						 stArrBottomToTop[j].pop();
						tmpStack.push(tmp*2);
					 }else{
						 stArrBottomToTop[j].pop();
					 }
				}
				while(!tmpStack.isEmpty()){
					stArrBottomToTop[j].push(tmpStack.pop());
				}
			}
		}
	int max = 0;
	for(int i = 1; i < 5; i ++){
		if( stArrLeftToRight[i].size()>0 && stArrLeftToRight[i].peek() > max) max = stArrLeftToRight[i].pop();
		if( stArrRightToLeft[i].size()>0 &&stArrRightToLeft[i].peek() > max) max = stArrRightToLeft[i].pop();
		if( stArrTopToBottom[i].size()>0 &&stArrTopToBottom[i].peek() > max) max = stArrTopToBottom[i].pop();
		if( stArrBottomToTop[i].size()>0 &&stArrBottomToTop[i].peek() > max) max = stArrBottomToTop[i].pop();
	}
	
	System.out.println(max);

		
		
	}


}
