package com.swexpertacademy.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_1868_파핑파핑지뢰찾기4 {
	static int N, count;
	static char[][] arr;
	static boolean[][] visited;
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 }, dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] order;
	static Queue<int[]> q = new LinkedList<>();

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
			count = 0;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					boolean check = false;
					if(visited[i][j]) continue;
					visited[i][j] = true;
					for(int d = 0; d < 8; d++) {
						int ny = i + dy[d];
						int nx = j + dx[d];
						if (ny >= N || nx >= N || ny < 0 || nx < 0) continue;
						if(check(ny, nx)) {
							solve(i, j);
							check = true;
						}
					}
					if(!check) count++;
				}
			}
			System.out.println("#" + t + " " + count);
		}

	}

	private static void solve(int r, int c) {
		count++;
		q.offer(new int[] { r, c });
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int y = temp[0];
			int x = temp[1];
			int cnt = 0;
			for (int i = 0; i < 8; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];

				if (ny >= N || nx >= N || ny < 0 || nx < 0 || visited[ny][nx])
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
					if (ny >= N || nx >= N || ny < 0 || nx < 0 || arr[ny][nx] == '*' || visited[ny][nx])
						continue;
					q.offer(new int[] { ny, nx });
					visited[ny][nx] = true;
				}
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
