package Fifth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class study_10799_ironStick {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		int count = 0;
		char last = '(';
		char now = 0;
		int result = 0;
		int numOfStick = 0;
		for(int i  = 0; i < arr.length; i ++){
			now = arr[i];
			if(now == '('){
				count++;
			}else if(now == ')'){
				count--;
				if(last != '('){
					numOfStick ++; //막대기 수
				}
			}
			if(last == '(' && now == ')'){ //커트 수
				result += count;
			}
			last = now;
		}
		result += numOfStick;
		System.out.println(result);
	}

}
