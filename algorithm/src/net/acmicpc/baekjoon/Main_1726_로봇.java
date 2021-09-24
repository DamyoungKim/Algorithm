package net.acmicpc.baekjoon;

import java.util.*;
import java.io.*;

public class Main_1726_로봇 {
	static int N, M, min = Integer.MAX_VALUE;
	static int[][] arr;
	static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };

	static class Node {
		int y;
		int x;
		int dir;

		public Node(int y, int x, int dir) {
			super();
			this.y = y;
			this.x = x;
			this.dir = dir;
		}
	}

	static Node start;
	static Node end;
	static int visited[][][];
	static Queue<Node> q = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new int[N][M][4];
		st = new StringTokenizer(br.readLine());
		start = new Node(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
				Integer.parseInt(st.nextToken()) - 1);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < 4; k++) {
					visited[i][j][k] = Integer.MAX_VALUE;
				}
			}
		}
		
		for (int k = 0; k < 4; k++) {
			visited[start.y][start.x][k] = 0;
		}
		st = new StringTokenizer(br.readLine());
		end = new Node(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
				Integer.parseInt(st.nextToken()) - 1);
		q.offer(start);
		solve();
		System.out.println(min);
	}

	private static void solve() {
		while (!q.isEmpty()) {
			Node cur = q.poll();
			if (cur.y == end.y && cur.x == end.x) {
				min = Math.min(min, visited[cur.y][cur.x][cur.dir] + rotateCnt(cur.dir, end.dir));
				continue;
			}
			for (int j = 0; j < 4; j++) {
				for (int i = 1; i <= 3; i++) {
					int ny = cur.y + dy[j] * i;
					int nx = cur.x + dx[j] * i;
					int cmdCnt = 1 + rotateCnt(cur.dir, j) + visited[cur.y][cur.x][cur.dir];
					if (ny >= N || nx >= M || ny < 0 || nx < 0 || arr[ny][nx] == 1 || visited[ny][nx][j] < cmdCnt) break;
					visited[ny][nx][j] = cmdCnt;
					q.offer(new Node(ny, nx, j));
				}
			}
		}
	}

	private static int rotateCnt(int cur, int next) {
		int temp = 0;

		if (cur == 0) {
			if (next == 1) {
				temp += 2;
			} else if (next == 2 || next == 3) {
				temp += 1;
			}
		} else if (cur == 1) {
			if (next == 0) {
				temp += 2;
			} else if (next == 2 || next == 3) {
				temp += 1;
			}
		} else if (cur == 2) {
			if (next == 3) {
				temp += 2;
			} else if (next == 0 || next == 1) {
				temp += 1;
			}
		} else if (cur == 3) {
			if (next == 2) {
				temp += 2;
			} else if (next == 0 || next == 1) {
				temp += 1;
			}
		}
		return temp;
	}
}
