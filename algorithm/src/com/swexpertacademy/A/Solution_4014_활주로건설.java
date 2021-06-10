package com.swexpertacademy.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4014_활주로건설 {
	static int N, X, result;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			result = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			solveRow(0, 1, 1, arr[0][0]);
			solveCol(1, 0, 1, arr[0][0]);
			System.out.println("#" + t + " " + result);
		}

	}

	private static void solveRow(int r, int c, int cnt, int val) {
	
		if (c == N) {
			result++;
			if (r + 1 == N)
				return;
			solveRow(r + 1, 1, 1, arr[r + 1][0]);
			return;
		}
		if (Math.abs(val - arr[r][c]) >= 2) {
			if(r + 1 >= N) return;
			solveRow(r + 1, 1, 1, arr[r + 1][0]);
			return;
		}
		if (arr[r][c] == val) {
			solveRow(r, c + 1, cnt + 1, arr[r][c]);
		} else if (arr[r][c] > val) {
			if (cnt < X) {
				if (r + 1 >= N)
					return;
				solveRow(r + 1, 1, 1, arr[r + 1][0]);
			} else {
				solveRow(r, c + 1, 1, arr[r][c]);
			}

		} else if (arr[r][c] < val) {
			for (int i = 0; i < X; i++) {
				int nc = c + i;
				if (nc >= N || arr[r][c] != arr[r][nc]) {
					if (r + 1 >= N)
						return;
					solveRow(r + 1, 1, 1, arr[r + 1][0]);
					return;
				}
			}
			solveRow(r, c + X, 0, arr[r][c + X - 1]);
		}
	}

	private static void solveCol(int r, int c, int cnt, int val) {
		
		if (r == N) {
			result++;
			if (c + 1 == N)
				return;
			solveCol(1, c + 1, 1, arr[0][c + 1]);
			return;
		}

		if (Math.abs(val - arr[r][c]) >= 2) {
			if(c + 1 >= N) return;
			solveCol(1, c + 1, 1, arr[0][c + 1]);
			return;
		}
		if (arr[r][c] == val) {
			solveCol(r + 1, c, cnt + 1, arr[r][c]);
		} else if (arr[r][c] > val) {
			if (cnt < X) {
				if (c + 1 >= N)
					return;
				solveCol(1, c + 1, 1, arr[0][c + 1]);
			} else {
				solveCol(r + 1, c, 1, arr[r][c]);
			}

		} else if (arr[r][c] < val) {
			for (int i = 0; i < X; i++) {
				int nr = r + i;
				if (nr >= N || arr[r][c] != arr[nr][c]) {
					if (c + 1 >= N)
						return;
					solveCol(1, c + 1, 1, arr[0][c + 1]);
					return;
				}
			}
			solveCol(r + X, c, 0, arr[r + X - 1][c]);
		}
	}
}

