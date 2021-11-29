package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17142_연구소3 {
	static int N, M, min;
	static int[][] arr;
	static int[] dx = { 0, 1, 0, -1 }, dy = { -1, 0, 1, 0 }, selected;

	static class Node {
		int y;
		int x;
		int time;

		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}

	static List<Node> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		selected = new int[M];
		list = new ArrayList<>();
		min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2)
					list.add(new Node(i, j));
			}
		}
		combi(0, 0);
		if (min == Integer.MAX_VALUE)
			min = -1;
		System.out.println(min);
	}

	private static void combi(int cnt, int start) {
		if (cnt == M) {
			int time = solve();
			min = Math.min(min, time);
			return;
		}

		for (int i = start; i < list.size(); i++) {
			selected[cnt] = i;
			combi(cnt + 1, i + 1);
		}
	}

	private static int solve() {
		boolean[][] visited = new boolean[N][N];
		Queue<Node> q = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			Node node = list.get(selected[i]);
			visited[node.y][node.x] = true;
			q.offer(node);
		}
		int temp = 0;
		int time = 0;
		while (!q.isEmpty()) {
			boolean check = false;
			int size = q.size();
			temp++;
			for (int s = 0; s < size; s++) {
				Node cur = q.poll();
				if (time >= min)
					return Integer.MAX_VALUE;
				for (int i = 0; i < 4; i++) {
					int ny = cur.y + dy[i];
					int nx = cur.x + dx[i];
					if (ny >= N || nx >= N || ny < 0 || nx < 0 || arr[ny][nx] == 1 || visited[ny][nx])continue;
					if (arr[ny][nx] == 0) {
						check = true;
					}
					visited[ny][nx] = true;
					q.offer(new Node(ny, nx));
				}
			}
			
			if (check) {
				time += temp;
				temp = 0;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && arr[i][j] != 1) return Integer.MAX_VALUE;
			}
		}
		return time;
	}


}
/*
5 1
2 2 2 1 1
2 1 1 1 1
2 1 1 1 1
2 1 1 1 1
2 2 2 0 1

*/