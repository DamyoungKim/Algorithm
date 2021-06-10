package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_3109_빵집 {
	static int R;
	static int C;
	static char[][] map;
	static int cnt;
	static boolean[][] check;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		check = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String s = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'x')
					check[i][j] = true;
			}
		}
		for (int i = 0; i < R; i++) {
			solve(i, 0);
		}
		System.out.println(cnt);
	}
	
	public static boolean solve(int r, int c) {
		int[] dr = {-1, 0, 1};
		if(c == C - 1) {
			
			cnt++;
			return true;
		}
		
		
		for(int i = 0; i < 3; i++) {
			int x = c + 1;
			int y = r + dr[i];
			
			if(y < 0 || y >= R || check[y][x]) continue;
			
			check[y][x] = true;
			if(solve(y,x)) return true;
		}
		return false;
	}
}
