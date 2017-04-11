import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;



public class study01_traversal {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub 
		// https://www.acmicpc.net/problem/1991 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //number of nodes
		Node root = new Node();
		Queue<Node> q = new LinkedList<Node>();
		
		String[] strarr = br.readLine().split(" ");
		if(!strarr[1].equals(".")) {
			root.addLeftNode(strarr[1].charAt(0));
			q.offer(root.getLeftChild());
		}
		if(!strarr[2].equals(".")) {
			root.addRightNode(strarr[2].charAt(0));
			q.offer(root.getRightChild());
		}
		
		for(int i = 1; i < n; i++){
			Node node;
			node = q.poll();
			String[] strArr = br.readLine().split(" ");
			for(int j = 0; j < q.size(); j++){
				if(node.getData() ==  strArr[0].charAt(0)) //삽입하려는 노드와 큐의 노드가 일치하면
					break;
				else{						// 일치하지 않으면
					q.offer(node);			//뒤로 넘기고
					node = q.poll();		//새로 뽑고
				}
			}
			
			
			if(!strArr[1].equals(".")){ //왼쪽 노드 추가
				node.addLeftNode(strArr[1].charAt(0));
				q.offer(node.getLeftChild());
			}
			if(!strArr[2].equals(".")){	 //오른쪽 노드 추가 
				node.addRightNode(strArr[2].charAt(0));
				q.offer(node.getRightChild());
			}
		
		}
		
		root.preorder();
		System.out.println();
		root.inorder();
		System.out.println();
		root.postorder();
		System.out.println();
	}
	
	public static class Node{
		private char data;
		private Node leftNode;
		private Node rightNode;
		
		public Node(char c){
			data = c;
			leftNode = null;
			rightNode = null;
		}
		public Node(){ 
			data = 'A';
			leftNode = null;
			rightNode = null;
		}
		
		public void addLeftNode(char c){
			leftNode = new Node(c);

		}
		public void addRightNode(char c){
			rightNode = new Node(c);
		}
		public char getData(){
			return data;
		}
		public Node getLeftChild(){
			return leftNode;
		}
		public Node getRightChild(){
			return rightNode;
		}
		
		public void preorder(){
			System.out.print(data);
			if(leftNode != null){
				leftNode.preorder();
			}
			if(rightNode != null){
				rightNode.preorder();
			}
		}
		public void inorder(){
			if(leftNode != null){
				leftNode.inorder();
			}
			System.out.print(data);
			if(rightNode != null){
				rightNode.inorder();
			}
		}
		public void postorder(){
			if(leftNode != null){
				leftNode.postorder();
			}
			if(rightNode != null){
				rightNode.postorder();
			}
			System.out.print(data);
		}
	}
	

}
