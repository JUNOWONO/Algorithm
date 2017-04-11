package Fourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Test {
   static BufferedReader br;
   static int n, m;
   static int[][] map;
   static PriorityQueue<Pair> q;
   static int[][] visited;
   static int min = Integer.MAX_VALUE;
   static int[] dx = {0,0,-1,1};
   static int[] dy = {-1,1,0,0};
   public static void main(String[] args) throws IOException {
      //https://www.acmicpc.net/problem/1261
      br = new BufferedReader(new InputStreamReader(System.in));
      input();
      q = new PriorityQueue<Pair>();
      q.add(new Pair(1,1,0));
      search();
      System.out.println(min);
   }

   public static void search(){
      int x,y,c;
      while(!q.isEmpty()){
         Pair p = q.poll();
         x = p.getX();
         y = p.getY();
         c = p.getC();
         if(x < 1 || y < 1 || x > n || y > m)continue;
         else{
            if(x == n && y == m) {
               min = Math.min(c, min);
            }
            for(int i = 0 ; i<4; i++){
               if(map[x+dx[i]][y+dy[i]]==0 && visited[x+dx[i]][y+dy[i]]>c){
                  visited[x+dx[i]][y+dy[i]] = c;
                  q.offer(new Pair(x+dx[i],y+dy[i],c));
               }
            }
            for(int i = 0 ; i<4; i++){
               if(map[x+dx[i]][y+dy[i]]==1 && visited[x+dx[i]][y+dy[i]]>c){
                  visited[x+dx[i]][y+dy[i]] = c;
                  q.offer(new Pair(x+dx[i],y+dy[i],c+1));
               }
            }
         }
      }
   }

   public static void input() throws IOException{
      String[] str = br.readLine().split(" ");
      n = Integer.parseInt(str[1]);
      m = Integer.parseInt(str[0]);
      map = new int[n+2][m+2];
      visited = new int[n+2][m+2];
      str = null;
      for(int i = 0; i<n+2; i++){
         Arrays.fill(map[i], -1);
      }
      for(int i = 1; i < n +1; i++){
         Arrays.fill(visited[i], Integer.MAX_VALUE);
         String[] temp = br.readLine().split("");
         for(int j = 1; j < m+1; j++){
            map[i][j] = Integer.parseInt(temp[j-1]);
         }
      }
//		for(int i = 1; i < n +1; i++){
//		System.out.println();
//		for(int j = 1; j < m+1; j++){
//			System.out.print(map[i][j]);
//		}
//	}
   }
   static class Pair implements Comparable<Pair>{
      int x, y, c;
      public Pair(int a, int b, int c_){
         x = a; y = b; c = c_;
      }
      public int getX(){
         return x;
      }
      public int getY(){
         return y;
      }
      public int getC(){
         return c;
      }
      @Override
      public int compareTo(Pair o) {
         // TODO Auto-generated method stub
         return c <= o.getC() ? -1 : 1;
      }
   }
}