package net.acmicpc.baekjoon;

import java.io.*;
import java.util.*;

public class Main_2178_미로탐색 {

//	static int N, M;
//	static int[][] arr;
//	static boolean[][] visited;
//	static int[] dx = { 0, 1, 0, -1 }, dy = { -1, 0, 1, 0 };
//
//	public static void main(String[] args) throws IOException {
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//
//		arr = new int[N][M];
//		visited = new boolean[N][M];
//		for (int i = 0; i < N; i++) {
//			String s = br.readLine();
//			for (int j = 0; j < M; j++) {
//				arr[i][j] = s.charAt(j) - '0';
//			}
//		}
//
//		bfs();
//
//	}
//
//	private static void bfs() {
//		Queue<int[]> q = new LinkedList<>();
//		q.offer(new int[] { 0, 0 });
//		visited[0][0] = true;
//		int cnt = 0;
//		while (!q.isEmpty()) {
//			int size = q.size();
//			cnt++;
//			for (int s = 0; s < size; s++) {
//				int[] temp = q.poll();
//				int y = temp[0];
//				int x = temp[1];
//				if (y == N - 1 && x == M - 1) {
//					System.out.println(cnt);
//					return;
//				}
//				for (int i = 0; i < 4; i++) {
//					int ny = y + dy[i];
//					int nx = x + dx[i];
//
//					if (ny >= N || nx >= M || ny < 0 || nx < 0 || visited[ny][nx] || arr[ny][nx] == 0)
//						continue;
//					visited[ny][nx] = true;
//					q.offer(new int[] { ny, nx });
//				}
//			}
//		}
//	}
	static int N, M;
	static char[][] map;
	static boolean[][] visited;
	static class Node {
		int y;
		int x;
		int cnt = 0;
		public Node (int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}
	static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int ans = bfs();
		System.out.print(ans);
	}

	private static int bfs() {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(0, 0, 1));
		visited[0][0] = true;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			if (cur.y == N - 1 && cur.x == M - 1) {
				return cur.cnt;
			}
			for (int d = 0; d < 4; d++) {
				int ny = cur.y + dy[d];
				int nx = cur.x + dx[d];
				if (ny < 0 || nx < 0|| ny >= N || nx >= M || visited[ny][nx] || map[ny][nx] == '0') continue;
				q.offer(new Node(ny, nx, cur.cnt + 1));
				visited[ny][nx] = true;
			}
		}
		return 0;
	}
}