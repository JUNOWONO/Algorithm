package Fifth;

import java.util.Scanner;
import java.io.FileInputStream;

/* 사용하는 클래스명이 Solution 이어야 하며, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해 볼 수 있습니다. */

class study_subArray_CodeGround {
	static int[] arr;
	static int min;
	static int s;
	static int n;
	public static void main(String args[]) throws Exception	{
		/* 아래 메소드 호출은 앞으로 표준입력(키보드) 대신 sample_input.txt 파일로 부터 읽어오겠다는 의미의 코드입니다.
		   만약 본인의 PC 에서 테스트 할 때는, 입력값을 sample_input.txt에 저장한 후 이 코드를 첫 부분에 사용하면,
		   표준입력 대신 sample_input.txt 파일로 부터 입력값을 읽어 올 수 있습니다.
		   또한, 본인 PC에서 아래 메소드를 사용하지 않고 표준입력을 사용하여 테스트하셔도 무방합니다.
		   단, Codeground 시스템에서 "제출하기" 할 때에는 반드시 이 메소드를 지우거나 주석(//) 처리 하셔야 합니다. */
		//Scanner sc = new Scanner(new FileInputStream("sample_input.txt"));
        
		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;
		
		
		T = sc.nextInt();        
		for(test_case = 1; test_case <= T; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오. 기본 제공된 코드를 수정 또는 삭제하고 본인이 코드를 사용하셔도 됩니다.
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
			
			// 이 부분에서 정답을 출력하십시오.
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