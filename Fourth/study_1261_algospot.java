package Fourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class study_1261_algospot {
   static BufferedReader br;
   static int n, m;
   static int[][] map;
   static PriorityQueue<Pair> q;
   static int[][] visited;
   static int min = Integer.MAX_VALUE;
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
         if(x < 1 || y < 1 || x > n || y > m){}
         else{
            visited[x][y] = c;
            //System.out.println(x + ", " + y + " - " + c + "°³");
            if(x == n && y == m) {
               min = Math.min(c, min);
               //System.out.println("min = " + min);
            }
            
            if(map[x+1][y] == 0 && visited[x+1][y] > c) q.add(new Pair(x+1, y, c));
            if(map[x][y+1] == 0 && visited[x][y+1] > c) q.add(new Pair(x, y+1, c));
            if(map[x-1][y] == 0 && visited[x-1][y] > c) q.add(new Pair(x-1, y, c));
            if(map[x][y-1] == 0 && visited[x][y-1] > c) q.add(new Pair(x, y-1, c));
            c++;
            if(map[x+1][y] == 1 && visited[x+1][y] > c) q.add(new Pair(x+1, y, c));
            if(map[x][y+1] == 1 && visited[x][y+1] > c) q.add(new Pair(x, y+1, c));
            if(map[x-1][y] == 1 && visited[x-1][y] > c) q.add(new Pair(x-1, y, c));
            if(map[x][y-1] == 1 && visited[x][y-1] > c) q.add(new Pair(x, y-1, c));
         }
      }
   }
   
   public static void input() throws IOException{
      String[] str = br.readLine().split(" ");
      n = Integer.parseInt(str[1]);
      m = Integer.parseInt(str[0]);
      map = new int[n+3][m+3];
      visited = new int[n+3][m+3];
      str = null;
      Arrays.fill(map[0], -1);
      Arrays.fill(map[n+1], -1);
      for(int i = 0; i < n +2; i++){
         map[i][0] = -1;
         map[i][m+1] = -1;
       }
      for(int i = 1; i < n +1; i++){
         Arrays.fill(visited[i], Integer.MAX_VALUE);
         str = br.readLine().split("");
         for(int j = 1; j < m+1; j++){
            map[i][j] = Integer.parseInt(str[j-1]);
         }
      }
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