package Seventh;

import java.util.Scanner;

public class study_codeGround_freelancer {

	public static void main(String args[]) throws Exception	{
		
		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();        
		for(test_case = 1; test_case <= T; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오. 기본 제공된 코드를 수정 또는 삭제하고 본인이 코드를 사용하셔도 됩니다.
        
			int numOfWeeks = sc.nextInt();
			int[] P = new int[numOfWeeks+2];
			int[] Q = new int[numOfWeeks+2];
			for(int i = 1; i < numOfWeeks+1;  i++){
				P[i] = sc.nextInt();
			}
        

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			
		}
	}
}
