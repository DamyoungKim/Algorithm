package net.acmicpc.baekjoon;

import java.util.*;
import java.io.*;

public class Main_7576_토마토 {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int[] dx = { 0, 0, -1, 1 };
//		int[] dy = { 1, -1, 0, 0 };
//		int M = sc.nextInt();
//		int N = sc.nextInt();
//		int[][] arr = new int[N][M];
//		Queue<int[]> q = new LinkedList<>();
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				arr[i][j] = sc.nextInt();
//				if (arr[i][j] == 1) {
//					q.offer(new int[] { i, j , 0});
//				}
//			}
//		}
//		int cnt = 0;
//		int result = 0;
//		int check = 0;
//		int day= 0;
//		while (!q.isEmpty()) {
//			int qSize = q.size();
//			while (qSize != cnt) {
//				int[] temp = q.poll();
//				for (int k = 0; k < 4; k++) {
//					day = temp[2];
//					int x = dx[k] + temp[1];
//					int y = dy[k] + temp[0];
//					
//					if (x < 0 || y < 0 || x >= M || y >= N || arr[y][x] == -1 || arr[y][x] == 1) {
//						continue;
//					}
//					arr[y][x] = 1;
//					q.offer(new int[] { y, x, day + 1 });
//				}
//				cnt++;
//			}
//			cnt = 0;
//		}
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				if (arr[i][j] == 0) {
//					day = -1;
//					break;
//				}
//				if (day == -1)
//					break;
//			}
//		}
//		System.out.println(day);
//	}
	static int N, M, ans;
	static int[][] map;
	static boolean[][] visited;
	static class Node {
		int y;
		int x;
		public Node (int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	static Queue<Node> q = new LinkedList<>();
	static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					q.offer(new Node(i, j));
					visited[i][j] = true;
				}
			}
		}
		
		ans = bfs();
		check();
		System.out.print(ans);
	}
	private static int bfs() {
		int day = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			boolean check = false;
			for (int i = 0; i < size; i++) {
				Node cur = q.poll();
				for (int d = 0; d < 4; d++) {
					int ny = cur.y + dy[d];
					int nx = cur.x + dx[d];
					if (ny < 0 || nx < 0 || ny >= N || nx >= M || visited[ny][nx] || map[ny][nx] == -1) continue;
					check = true;
					q.offer(new Node(ny, nx));
					visited[ny][nx] = true;
				}
			}
			if (check) day++;
		}
		return day;
	}
	
	private static void check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] == 0) {
					ans = -1;
					return;
				}
			}
		}
	}
}