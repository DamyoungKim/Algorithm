package com.swexpertacademy.professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_탈주범검거 {
	static int T, N, M, R, C, L, result;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = { 0, 1, 0, -1 }, dy = { -1, 0, 1, 0 };
	static int[][] pipes = { {}, { 0, 1, 2, 3 }, { 0, 2 }, { 1, 3 }, { 0, 1 }, { 1, 2 }, { 2, 3 }, { 0, 3 } };

	static class Node {
		int y;
		int x;

		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			arr = new int[N][M];
			visited = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			bfs();
			System.out.println("#" + t + " " + result);
		}
	}

	private static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(R, C));
		visited[R][C] = true;
		int time = 1;
		result = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			if (time == L) return;

			for (int s = 0; s < size; s++) {
				Node cur = q.poll();
				int[] curPipe = pipes[arr[cur.y][cur.x]];
				for (int i = 0; i < curPipe.length; i++) {
					int ny = cur.y + dy[curPipe[i]];
					int nx = cur.x + dx[curPipe[i]];
					if (ny >= N || nx >= M || ny < 0 || nx < 0 || visited[ny][nx] || arr[ny][nx] == 0)
						continue;
					int[] nextPipe = pipes[arr[ny][nx]];
					for (int j = 0; j < nextPipe.length; j++) {
						if (curPipe[i] == (nextPipe[j] + 2) % 4) {
							result++;
							q.offer(new Node(ny, nx));
							visited[ny][nx] = true;
							break;
						}
					}
				}
			}
			time++;
		}
	}

}
/*
1
5 6 2 2 6
3 0 0 0 0 3
2 0 0 0 0 6
1 3 1 1 3 1
2 0 2 0 0 2
0 0 4 3 1 1

 */