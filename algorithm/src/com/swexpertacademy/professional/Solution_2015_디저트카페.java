package com.swexpertacademy.professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2015_디저트카페 {
	static int T, N, max;
	static int[][] arr;
	static int[] dx = {1, 1, -1, -1}, dy = {-1, 1, 1, -1};
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			max = 0;
			for (int i = 0; i < N - 2; i++) {
				for (int j = 1; j < N - 1; j++) {
					visited = new boolean[101];
					visited[arr[i][j]] = true;
					solve(1, 0, 1, i, j, 1);
				}
			}
			if(max == 0) max = -1;
			System.out.println("#" + t + " " + max);
		}
	}
	private static void solve(int rightCnt, int leftCnt, int dir, int y, int x, int cnt) {
		visited[arr[y][x]] = true;
		int ny = y + dy[dir];
		int nx = x + dx[dir];
		if (rightCnt == 0 && leftCnt == 0) {
			max = Math.max(max, cnt);
			return;
		}
		if (ny >= N || nx >= N || ny < 0 || nx < 0 || visited[arr[ny][nx]]) return;
		if (dir == 1) {
			solve(rightCnt + 1, leftCnt, 1, ny, nx, cnt + 1);
			solve(rightCnt, leftCnt + 1, 2, ny, nx, cnt + 1);
		} else if (dir == 2) {
			solve(rightCnt, leftCnt + 1, 2, ny, nx, cnt + 1);
			solve(rightCnt - 1, leftCnt, 3, ny, nx, cnt + 1);
		} else if (dir == 3) {
			if (rightCnt == 0) {
				solve(rightCnt, leftCnt - 1, 0, ny, nx, cnt + 1);
			} else {
				solve(rightCnt - 1, leftCnt, 3, ny, nx, cnt + 1);
			}
		} else if (dir == 0) {
			solve(rightCnt, leftCnt - 1, 0, ny, nx, cnt + 1);
		}
		visited[arr[ny][nx]] = false;
	}

}
/*
1
4

9 8 9 8
4 6 9 4
8 7 7 8
4 5 3 5

 */
 