package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2638_치즈 {
	static class Node {
		int y;
		int x;
		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	static int N, M;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
	static Queue<Node> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
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
		int time = 0;
		while(!end()) {
			time++;
			visited = new boolean[N][M];
			boolean doBfs = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == 0) {
						q.offer(new Node(i, j));
						bfs();
						doBfs = true;
					}
					if (doBfs) break;
				}
				if (doBfs) break;
			}
			findCheeze();
		}
		System.out.println(time);
	}
	private static boolean end() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1) return false;
			}
		}
		return true;
	}
	
	private static void bfs() {
		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				if (ny >= N || nx >= M || ny < 0 || nx < 0 || arr[ny][nx] == 1 || visited[ny][nx]) continue;
				visited[ny][nx] = true;
				q.offer(new Node(ny, nx));
			}
		}
	}
	
	private static void findCheeze() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) continue;
				int temp = 0;
				for (int d = 0; d < 4; d++) {
					int ny = i + dy[d];
					int nx = j + dx[d];
					
					if (ny >= N || nx >= M || ny < 0 || nx < 0) continue;
					
					if (visited[ny][nx]) temp++;
				}
				if (temp >= 2) arr[i][j] = 0;
			}
		}
	}

}
