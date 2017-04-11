import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BinarySearch1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		//1920�� �� ã�� (�̺�Ž��) https://www.acmicpc.net/problem/1920
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n1 = Integer.parseInt(br.readLine());
		int n2; 
		int[] base = new int[n1+1];
		int[] target;
		
		String[] str1  =  br.readLine().split(" ");
		for(int i = 0; i < n1; i ++){
			base[i] = Integer.parseInt(str1[i]);
		}
		n2 = Integer.parseInt(br.readLine());
		target = new int[n2+1];
		String[] str2  =  br.readLine().split(" ");
		for(int i = 0; i < n2; i ++){
			target[i] = Integer.parseInt(str2[i]);
		}
		
		quickSort(base, 0, n1-1); //Arrays.sort(array)�ص���
		for(int i = 0; i < n2; i++){
			//System.out.println(i+"Loop");
			if(binarySearch(base, 0, n1-1, target[i])){
				System.out.println("1");
			}
			else {
				System.out.println("0");
			}
		}
		
		
		
	
	}
	
	static boolean binarySearch (int[] base, int left, int right, int targetNum){
		//System.out.println("�̺�Ž������");
		int mid = (right+left)/2;
		while(left <= right){
			if(base[mid] < targetNum){
				left = mid+1;
			}
			else if(base[mid] > targetNum){
				right = mid-1;
			}
			else if(base[mid] == targetNum) return true;
			mid = (right+left)/2;
			//System.out.println(left + "," +right);
		}
		return false;
		
	}
	
	static void quickSort(int[] arr, int left, int right){
		if(left < right){
			int j = left; // �Ǻ� ��ġ
			
			for(int i = left+1; i < right+1; i++){
				if(arr[left] > arr[i]){ //���� �Ǻ����� ������ 
					j++; //�Ǻ��� ��ġ�� �ڸ��� ��ĭ ���������� �Ű��ְ�
					int tmp; //����
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				} 
			}
			int tmp; // �Ǻ��� j��ġ�� ����
			tmp = arr[left];
			arr[left] = arr[j];
			arr[j] = tmp;
			quickSort(arr, left, j-1);
			quickSort(arr, j+1, right);
		
		}
	}
}
