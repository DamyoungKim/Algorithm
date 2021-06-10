package com.swexpertacademy.D4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D4_10966_물놀이를가자3 {
	static int N, M;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int totalCnt = Integer.MAX_VALUE;
	static int[][] cntArr;
	static Queue<int[]> q = new LinkedList<int[]>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new char[N][M];
			visited = new boolean[N][M];
			cntArr = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					cntArr[i][j] = 0;
				}
			}
			for (int i = 0; i < N; i++) {
				String s = sc.next();
				for (int j = 0; j < M; j++) {
					char temp = s.charAt(j);
					map[i][j] = temp;
					if (temp == 'W') {
						cntArr[i][j] = 0;
						q.offer(new int[] { i, j, 0 });
					}
				}
			}
			int sum = 0;
			solve();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (cntArr[i][j] != 0)
						sum += cntArr[i][j];
				}
			}
			System.out.println("#" + t + " " + sum);
		}

	}

	private static void solve() {
		while (!q.isEmpty()) {
			int y = q.peek()[0];
			int x = q.peek()[1];
			int count = q.poll()[2];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= M || ny >= N || nx < 0 || ny < 0 || map[ny][nx] == 'W' || visited[ny][nx])
					continue;
				visited[ny][nx] = true;
				cntArr[ny][nx] = count + 1;
				q.offer(new int[] { ny, nx, count + 1 });
			}
		}
	}
}
