package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_1992_쿼드트리 {
	static StringBuffer sb = new StringBuffer();
	static int N;
	static char[][] map;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new char[N][N];

		boolean all = true;
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j);

			}
		}
		solve(N, 0, 0);

	}

	public static boolean check(int n, int r, int c) {
		for (int i = r; i < r + n; i++) {
			for (int j = c; j < c + n; j++) {
				if (map[i][j] == map[r][c])
					continue;
				return false;
			}
		}
		return true;
	}

	public static void solve(int n, int r, int c) {
		if (check(n, r, c)) {
			System.out.print(map[r][c]);
			return;
		}
		
		System.out.print("(");
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				solve(n / 2, r + n / 2 * i, c + n / 2 * j);
			}
		}
		System.out.print(")");
	}
}