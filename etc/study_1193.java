import java.util.Scanner;


public class study_1193 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		int up = 0;
		int down = 0;
		
		int i = 1;
		int tmp = 0;
		int count = 0;

		int start = 0;
		int end = 0;
		while(true){
			tmp += i;
			i++;
			start += tmp;
			if(tmp >= x ){
				count++;
				break;
			}
			count++;
		}
		end = tmp;
		start = tmp -(i-2);
		
		if(count%2 == 0){ //분자 1에서 증가, 분모 i에서 감소
			up = x - (start-1);
			down = i - up;
		}
		else {
			down = x - (start -1);
			up = i - down;
			
		}
		
		
		
		//System.out.println(count + ", " + i);
		//System.out.println(start + "~" + end);
		System.out.println(up + "/" + down);
	}

}
