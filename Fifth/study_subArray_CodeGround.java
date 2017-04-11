package Fifth;

import java.util.Scanner;
import java.io.FileInputStream;

/* ����ϴ� Ŭ�������� Solution �̾�� �ϸ�, ������ Solution.java �� ����� ���� �����մϴ�.
   �̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� ������ �� �� �ֽ��ϴ�. */

class study_subArray_CodeGround {
	static int[] arr;
	static int min;
	static int s;
	static int n;
	public static void main(String args[]) throws Exception	{
		/* �Ʒ� �޼ҵ� ȣ���� ������ ǥ���Է�(Ű����) ��� sample_input.txt ���Ϸ� ���� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�.
		   ���� ������ PC ���� �׽�Ʈ �� ����, �Է°��� sample_input.txt�� ������ �� �� �ڵ带 ù �κп� ����ϸ�,
		   ǥ���Է� ��� sample_input.txt ���Ϸ� ���� �Է°��� �о� �� �� �ֽ��ϴ�.
		   ����, ���� PC���� �Ʒ� �޼ҵ带 ������� �ʰ� ǥ���Է��� ����Ͽ� �׽�Ʈ�ϼŵ� �����մϴ�.
		   ��, Codeground �ý��ۿ��� "�����ϱ�" �� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ�(//) ó�� �ϼž� �մϴ�. */
		//Scanner sc = new Scanner(new FileInputStream("sample_input.txt"));
        
		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;
		
		
		T = sc.nextInt();        
		for(test_case = 1; test_case <= T; test_case++) {
			// �� �κп��� �˰��� ���α׷��� �ۼ��Ͻʽÿ�. �⺻ ������ �ڵ带 ���� �Ǵ� �����ϰ� ������ �ڵ带 ����ϼŵ� �˴ϴ�.
			n = sc.nextInt();
			s = sc.nextInt();
			arr = new int[n+2];
			for(int i =1; i < n+1; i ++){
				arr[i] = sc.nextInt();
			}
			
			min = Integer.MAX_VALUE;
			//sum(1,1);
			int left = 1, right = 1;
			while(true){
				if(left > n-2) break;
				if(right > n) break;
				int sum = 0;
				//System.out.println(left + ", " + right);
				for(int i = left; i < right+1; i++){
					//System.out.println(i);
					sum += arr[i];
				}
				//System.out.println(sum);
				if(sum > s){
					//System.out.println(sum);
					min = Math.min(min, right-left+1);
					left++;
				}else{
					right++;
				}
			}
			
			if(min == Integer.MAX_VALUE) min = 0;
			
			// �� �κп��� ������ ����Ͻʽÿ�.
			System.out.println("#testcase" + test_case);
			System.out.println(min);
		}
	}
//	static void sum(int left, int right){
//		if(left > right || right > n || left < 1) return;
//
//		int sum = 0;
//		for(int i = left; i < right+1; i++){
//			sum += arr[i];
//		}
//		if(sum > s){
//			min = Math.min(min, right-left+1);
//			sum(left+1, right);
//		}else{
//			sum(left, right+1);
//		}
//		
//		return;
//	}
}