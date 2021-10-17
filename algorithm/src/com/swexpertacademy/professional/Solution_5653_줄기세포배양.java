package com.swexpertacademy.professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_5653_줄기세포배양 {
	static class Node implements Comparable<Node> {
		int y;
		int x;
		int life;
		int time;
		boolean isActive = false;
		boolean isDied = false;

		public Node(int y, int x, int life) {
			super();
			this.y = y;
			this.x = x;
			this.life = life;
		}

		@Override
		public boolean equals(Object obj) {
			Node node = (Node) obj;
			if (this.y == node.y && this.x == node.x)
				return true;
			return false;
		}

		public boolean passTime() {
			if (!this.isActive) {
				this.time++;
				if (this.time == this.life) {
					this.isActive = true;
				}
			} else {
				if (time == life) {
					q.offer(this);
				}
				this.time--;
				if (this.time == 0) {
					this.isDied = true;
					return true;
				}
			}
			return false;
		}

		@Override
		public int compareTo(Node o) {
			return o.life - this.life;
		}
	}

	static int T, N, M, K;
	static int[] dx = { 0, 1, 0, -1 }, dy = { -1, 0, 1, 0 };
	static List<Node> list;
	static boolean[][] visited;
	static PriorityQueue<Node> q = new PriorityQueue<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			visited = new boolean[800][800];
			list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int temp = Integer.parseInt(st.nextToken());
					if (temp != 0) {
						list.add(new Node(i + 300, j + 300, temp));
						visited[i + 300][j + 300] = true;
					}
				}
			}
			while (K-- != 0) {
				passTime();
			}
			System.out.println("#" + t + " " + list.size());
		}
	}

	public static void passTime() {
		for (int i = 0; i < list.size(); i++) {
			Node node = list.get(i);
			boolean isDied = node.passTime();
			if (isDied) {
				list.remove(node);
				i--;
			}
		}

		while (!q.isEmpty()) {
			Node node = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				if (visited[ny][nx])
					continue;
				visited[ny][nx] = true;
				list.add(new Node(ny, nx, node.life));
			}
		}
	}
}
