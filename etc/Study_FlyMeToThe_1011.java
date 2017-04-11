import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Study_FlyMeToThe_1011 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] input =  new int[n+2];
		String[] str;
		int a= 0,b = 0;
		for(int i = 1; i < n+1; i ++){
			str = br.readLine().split(" ");
			a = Integer.parseInt(str[0]);
			b = Integer.parseInt(str[1]);
			input[i] = b-a;
		}
		
		for(int i = 1; i < n+1; i ++){
			System.out.println(move(input[i]));
		}
	
	}
	public static int move(int dis){
		if(dis == 1) return 1;
		int i = 1;
		float d2 = (float) Math.sqrt(dis);
		while(true){
			if((float)i >= d2){
				break;
			}
			i++;
		}
		if((float)i == d2) return i*2-1;
		else{
			if(Math.sqrt(i*i - dis) > Math.sqrt(i-1)) return i*2-2;
			else return i*2 -1;
		}
		
	}
	
		

}
