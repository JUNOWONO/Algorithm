import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class String_cmd {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		//https://www.acmicpc.net/problem/1032 명령 프롬프트 문자열 패턴 출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n+1];
		int length;
		int[] r;
		char[] c;
		for(int i=0; i<n; i++){
			arr[i] = br.readLine();
		}
		length = arr[0].length();
		r = new int[length];
		c = new char[length];
		for(int i=0; i<length; i++) r[i] = 0;
		
		for(int i=0; i<length; i++){
			for(int j=0; j<n-1; j++){
				if(arr[j].charAt(i) != arr[j+1].charAt(i)){
					r[i] = 1;
					break; //멈추고 다음 문자열 검색
				}
			}
		}
		for(int i=0; i<length; i++){
			if(r[i] == 0) c[i] = arr[0].charAt(i);
			else c[i] = '?';
		}
		System.out.println(c);
		
		
	}

}
