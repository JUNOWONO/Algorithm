import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MinHeap {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int[] heap;
		int n;
		int count = 0;// count the number of nodes
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		heap = new int[n+1];
		for(int i =0; i < n+1; i++){
			heap[i] = -1;
			int v =Integer.parseInt(br.readLine());
			if(v != 0) {
				heapInsert(heap, v, count);
				count++;
			}
			else heapDelete(heap, count);
		}
		
	}
	
	static void heapInsert(int[] heap, int v, int count){
		heap[count+1] = v;
		int p = getParent(count);
		while(p != -1){
			if(heap[p] > heap[count]){
				int temp = heap[count];
				heap[count] = heap[p];
				heap[p] = temp;
			}
			count = p;
		}
		
		
		
	}
	static void heapDelete(int[] heap, int count){//루트 삭제후 맨 마지막 노드의 값을 루트로 보내고 다시 PrecolateDown작업
		int nowNode = 1;
		int min;
		heap[1] = heap[count];
		heap[count] = -1;
		while(nowNode < count){
			if(heap[getLeftChild(heap, nowNode)] < heap[getRightChild(heap, nowNode)]){
				min = getLeftChild(heap, nowNode);
			} else{
				min = getRightChild(heap, nowNode);
			}
			if(heap[nowNode] > heap[min]){
				int temp = heap[nowNode];
				heap[nowNode] = heap[min];
				heap[min] = temp;
			}
			nowNode = min;
		}
	}
	
	
	static int getParent(int a){
		if(a == 1){
			return -1;
		}
		return a/2;
	}
	static int getLeftChild(int[] heap, int a){
		if(heap[a*2] == -1) return -1;
		else return a*2;
	}
	static int getRightChild(int[] heap, int a){
		if(heap[a*2+1] == -1) return -1;
		else return a*2+1;
	}

}
