package Seventh;

import java.util.Scanner;

public class study_codeGround_freelancer {

	public static void main(String args[]) throws Exception	{
		
		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();        
		for(test_case = 1; test_case <= T; test_case++) {
			// �� �κп��� �˰��� ���α׷��� �ۼ��Ͻʽÿ�. �⺻ ������ �ڵ带 ���� �Ǵ� �����ϰ� ������ �ڵ带 ����ϼŵ� �˴ϴ�.
        
			int numOfWeeks = sc.nextInt();
			int[] P = new int[numOfWeeks+2];
			int[] Q = new int[numOfWeeks+2];
			for(int i = 1; i < numOfWeeks+1;  i++){
				P[i] = sc.nextInt();
			}
        

			// �� �κп��� ������ ����Ͻʽÿ�.
			System.out.println("Case #" + test_case);
			
		}
	}
}
