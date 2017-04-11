package Second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class study_6593_building {
	static Queue<String> result = new LinkedList<String>();
	static char[][][] map;
	static int[][][] visited;
	static int startL, startR, startC;
	static int min = 50000;
	static int L,R,C;
	static boolean check;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String[] str = br.readLine().split(" ");
			L = Integer.parseInt(str[0]);
			R = Integer.parseInt(str[1]);
			C = Integer.parseInt(str[2]);
			map = new char[L+2][R+2][C+2];
			visited = new int[L+2][R+2][C+2];
			if(L == 0 && R == 0 && C == 0) break;
			for(int k = L; k > 0; k--){
				for(int i = 1; i < R + 1; i ++){
					String str2 = br.readLine();
					for(int j = 1; j < C + 1; j++){
						visited[k][i][j] = 50000;
						map[k][i][j] = str2.charAt(j-1);
						if(map[k][i][j] == 'S') {
							startL = k;
							startR = i;
							startC = j;
						}
					}
				}
				br.readLine();
			}
			
            min = 50000;
            check = false;
			search(startL, startR, startC, 0, 0 );
			if(check == false) {
				result.add("Trapped!");
			}
			else{
				result.add("Escaped in "+min+" minute(s).");
			}
			
		}
		int r_size = result.size();
		for(int i = 0; i < r_size; i ++){
			System.out.println(result.poll());
		}
	}
	static void search(int l, int r, int c, int cnt, int last){
		if(cnt >= min) return;
		if(l == 0 || r == 0 || c == 0 || l == L +1 || r == R+1 || c == C+1) return;
	
		if (map[l + 1][r][c] != '#' && last != 2) {
			if (map[l + 1][r][c] == 'E') {
				if(min > cnt+1){
					check = true;
					min = cnt+1;
				}
				return;
			}
			if (visited[l + 1][r][c] > cnt + 1 ) {
				visited[l+1][r][c] = cnt+1;
				search(l + 1, r, c, cnt+1, 1);
			}
		}
		if (map[l - 1][r][c] != '#' && last != 1) {
			if (map[l - 1][r][c] == 'E') {
				if(min > cnt+1){
					check = true;
					min = cnt+1;
				}
				//System.out.println(map[l-1][r][c] + ","+(cnt+1));
				return;
			}
			if (visited[l - 1][r][c] > cnt + 1 ) {
				visited[l-1][r][c] = cnt+1;
				search(l - 1, r, c, cnt+1, 2);
			}
		}
		
		if (map[l][r + 1][c] != '#' && last != 5) {
			if (map[l][r + 1][c] == 'E') {
				if(min > cnt+1){
					check = true;
					min = cnt+1;
				}
				return;
			}
			if (visited[l][r + 1][c] > cnt + 1 || visited[l][r + 1][c] == 0) {
				visited[l][r + 1][c] = cnt+1;
				search(l, r + 1, c, cnt+1, 3);
			}
		}
		if (map[l][r][c + 1] != '#' && last != 6) {
			if (map[l][r][c + 1] == 'E') {
				if(min > cnt+1){
					check = true;
					min = cnt+1;
				}
				return;
			}
			if (visited[l][r][c + 1] > cnt + 1 || visited[l][r][c + 1] == 0) {
				visited[l][r][c + 1] = cnt+1;
				search(l, r, c + 1, cnt+1, 4);
			}
		}
		if (map[l][r - 1][c] != '#' && last != 3) {
			if (map[l][r - 1][c] == 'E') {
				if(min > cnt+1){
					check = true;
					min = cnt+1;
				}
				return;
			}
			if (visited[l][r - 1][c] > cnt + 1 || visited[l][r - 1][c] == 0) {
				visited[l][r - 1][c] = cnt+1;
				search(l, r - 1, c, cnt+1, 5);
			}
		}
		if (map[l][r][c - 1] != '#' && last != 4) {
			if (map[l][r][c - 1] == 'E') {
				if(min > cnt+1){
					check = true;
					min = cnt+1;
				}
				return;
			}
			if (visited[l][r][c - 1] > cnt + 1 || visited[l][r][c - 1] == 0) {
				visited[l][r][c - 1] = cnt+1;
				search(l, r, c - 1, cnt+1, 6);
			}
		}
	}

}
