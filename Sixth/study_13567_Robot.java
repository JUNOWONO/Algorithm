package Sixth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class study_13567_Robot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int M = Integer.parseInt(str[0]);
		int n = Integer.parseInt(str[1]);
		int roboDir = 1; // 1:동, 2:남, 3:서, 4:북
		int roboX = 0, roboY = 0;
		String resultStr = null;
		for(int i = 1; i < n + 1; i ++){
			str = br.readLine().split(" ");
			String cmd = str[0];
			int d = Integer.parseInt(str[1]);
			
			if(cmd.equals("MOVE")){
				if(roboDir == 1){ //동
					roboX += d;
				}else if(roboDir == 2){ //남
					roboY -= d;
				}else if(roboDir == 3){ //서
					roboX -= d;
				}else if(roboDir == 4){//북
					roboY += d;
				}
			}else{ //커맨드가 "Turn" 인 경우
				if(d == 0){
					roboDir --;
					if(roboDir < 1) roboDir = 4;
				}else if(d == 1){
					roboDir = (roboDir)%4 + 1;
				}
			}
			if(roboX < 0 || roboX > M || roboY < 0 || roboY > M){
				resultStr = "-1";
				break;
			}
		}
		if(resultStr == null){
			resultStr = roboX + " " + roboY;
		}
		System.out.println(resultStr);
	}
	
}
