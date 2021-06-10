package com.swexpertacademy.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1868_파핑파핑지뢰찾기 {
	static int N, result = Integer.MAX_VALUE, count;
	static char[][] arr;
	static boolean[][] visited;
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 }, dy = { -1, -1, 0, 1, 1, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new char[N][N];

			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = s.charAt(j);
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visited = new boolean[N][N];
					count = 1;
					solve(i, j);
					result = result > count ? count : result;
				}
			}
			System.out.println("#" + t + " " + result);
		}

	}

	private static void solve(int y, int x) {
		visited[y][x] = true;
		int cnt = 0;
		for (int i = 0; i < 8; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny >= N || nx >= N || ny < 0 || nx < 0)
				continue;

			if (arr[ny][nx] == '*') {
				cnt++;
				break;
			}
		}

		if (cnt == 0) {
			for (int i = 0; i < 8; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (ny >= N || nx >= N || ny < 0 || nx < 0 || visited[ny][nx]) continue;
				if (!check(ny, nx))
					visited[ny][nx] = true;
			}

		}
		for (int i = y; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] || arr[i][j] == '*')
					continue;
				solve(i, j);
				count++;
			}
		}
	}

	private static boolean check(int y, int x) {
		for (int i = 0; i < 8; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny >= N || nx >= N || ny < 0 || nx < 0)
				continue;
			if (arr[ny][nx] == '*')
				return false;
		}

		return true;
	}

}
