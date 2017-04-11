package Second;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class study_2098_Salesman {

   public static int[][] mat;
   public static int[][] dp;
   public static int n;
   public static double endPoint;
   public static void main(String[] args) throws NumberFormatException, IOException 
   {
      // TODO Auto-generated method stub
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      n = Integer.parseInt(br.readLine());
      mat = new int[18][18];
      dp = new int[18][1<<n+1];
      for (int i = 1; i <= n; i++) {
			Arrays.fill(dp[i], -1);
		}
      for(int i = 1; i<n+1; i++)
      {
         StringTokenizer st = new StringTokenizer(br.readLine());
         for(int j = 1; j<n+1; j++)
         {
            mat[i][j] = Integer.parseInt(st.nextToken());
         }
      }
      endPoint = (1<<n)-1;
      System.out.println(TSP(1,1));
   }
 
   public static int TSP(int current, int visited)
   {
	  int min = Integer.MAX_VALUE;
	  if( endPoint == visited) return mat[current][1];
	  if (dp[current][visited] >= 0)
			return dp[current][visited];
	  
	  for(int i = 0; i<n; i++)
      {
         int temp = visited>>i;
         if(temp%2==0)
         {
            if(mat[current][i+1] != 0)
            {
               int newV = visited+(1<<i);
               dp[i+1][newV] = mat[current][i+1]+TSP(i+1, newV);
               min = Math.min(min, dp[i+1][newV]);
            }
         }
      }
      return dp[current][visited] = min;
   }
}