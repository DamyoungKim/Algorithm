package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_17837_새로운게임2 {
	static class Node {
		int no;
		int y;
		int x;
		int dir;
		int lev = 1;

		public Node(int no, int y, int x, int dir) {
			super();
			this.no = no;
			this.y = y;
			this.x = x;
			this.dir = dir;
		}

		@Override
		public boolean equals(Object obj) {
			Node node = (Node) obj;
			if (this.y == node.y && this.x == node.x)
				return true;
			return false;
		}
	}

	static int N, K;
	static int[][] arr, size;
	static int[] dx = { 0, 1, -1, 0, 0 }, dy = { 0, 0, 0, -1, 1 };
	static List<Node> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N + 2][N + 2];
		for (int i = 0; i < N + 2; i++) {
			if (i != 0 && i != N + 1) {
				st = new StringTokenizer(br.readLine());
			}
			for (int j = 0; j < N + 2; j++) {
				arr[i][j] = 2;
				if (i > N || j > N || i < 1 || j < 1)
					continue;
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		list = new ArrayList<>();
		size = new int[N + 2][N + 2];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			list.add(new Node(i + 1, y, x, dir));
			size[y][x] = 1;
		}
		int cnt = 0;
		while (cnt++ < 1000) {
			for (int i = 0; i < K; i++) {
				if (move(list.get(i))) {
					System.out.println(cnt);
					return;
				}
			}
		}
		System.out.println(-1);
	}

	private static boolean move(Node cur) {
		int ny = cur.y + dy[cur.dir];
		int nx = cur.x + dx[cur.dir];
		if (arr[ny][nx] == 0) {
			white(cur, ny, nx);
		} else if (arr[ny][nx] == 1) {
			red(cur, ny, nx);
		} else if (arr[ny][nx] == 2) {
			blue(cur);
			ny = cur.y;
			nx = cur.x;
		}
		if (size[ny][nx] >= 4) {
			return true;
		}
		return false;
	}

	private static void blue(Node cur) {
		switch (cur.dir) {
		case 1:
			cur.dir = 2;
			break;
		case 2:
			cur.dir = 1;
			break;
		case 3:
			cur.dir = 4;
			break;
		case 4:
			cur.dir = 3;
			break;
		}
		int ny = cur.y + dy[cur.dir];
		int nx = cur.x + dx[cur.dir];
		
		if (arr[ny][nx] == 0) {
			white(cur, ny, nx);
		} else if (arr[ny][nx] == 1) {
			red(cur, ny, nx);
		} 
	}

	private static void white(Node cur, int ny, int nx) {
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.lev - o2.lev;
			}
		});
		int nextLev = size[ny][nx];
		int curLev = cur.lev;
		for (int i = 0; i < K; i++) {
			Node node = list.get(i);
			if (cur.equals(node)) {
				if (curLev <= node.lev)
					pq.offer(node);
			}
		}
		size[cur.y][cur.x] = curLev - 1;
		size[ny][nx] = nextLev + pq.size();
		int cnt = 0;
		while (!pq.isEmpty()) {
			Node next = pq.poll();
			next.y = ny;
			next.x = nx;
			cnt++;
			next.lev = nextLev + cnt;
		}
	}

	private static void red(Node cur, int ny, int nx) {
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o2.lev - o1.lev;
			}
		});
		int nextLev = size[ny][nx];
		int curLev = cur.lev;
		for (int i = 0; i < K; i++) {
			Node node = list.get(i);
			if (cur.equals(node)) {
				if (curLev <= node.lev)
					pq.offer(node);
			}
		}
		size[cur.y][cur.x] = curLev - 1;
		size[ny][nx] = nextLev + pq.size();
		int cnt = 0;
		while (!pq.isEmpty()) {
			Node next = pq.poll();
			next.y = ny;
			next.x = nx;
			cnt++;
			next.lev = nextLev + cnt;
		}
	}
}
/*
4 4
0 0 2 0
0 0 1 0
0 0 1 2
0 2 0 0
2 1 1
3 2 3
2 2 1
4 1 2

*/