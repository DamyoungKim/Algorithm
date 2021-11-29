package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_19238_스타트택시 {
	static int N, M, L, goalNum;
	static int[][] arr;

	static class Node {
		int y;
		int x;
		Node goal;
		int len;
		boolean finish;
		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

		public Node(int y, int x, int len) {
			super();
			this.y = y;
			this.x = x;
			this.len = len;
		}
	}

	static Node taxi;
	static List<Node> list;
	static int[] dx = { 0, 1, 0, -1 }, dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken()) - 1;
		int x = Integer.parseInt(st.nextToken()) - 1;
		taxi = new Node(y, x);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken()) - 1;
			x = Integer.parseInt(st.nextToken()) - 1;
			list.add(new Node(y, x));
			y = Integer.parseInt(st.nextToken()) - 1;
			x = Integer.parseInt(st.nextToken()) - 1;
			Node goal = new Node(y, x);
			list.get(i).goal = goal;
		}

		for (int i = 0; i < M; i++) {
			if (!findMan()) {
				System.out.println(-1);
				return;
			}
			if (!findGoal()) {
				System.out.println(-1);
				return;
			}
		}
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).finish) continue;
			L = -1;
			break;
		}
		System.out.println(L);
	}

	private static boolean findGoal() {
		Queue<Node> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		q.offer(new Node(taxi.y, taxi.x, 0));
		visited[taxi.y][taxi.x] = true;
		int cnt = 0;
		Node goal = list.get(goalNum).goal;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Node cur = q.poll();
				if (goal.y == cur.y && goal.x == cur.x) {
					L += (cnt * 2);
					taxi.y = goal.y;
					taxi.x = goal.x;
					return true;
				}
				for (int i = 0; i < 4; i++) {
					int ny = cur.y + dy[i];
					int nx = cur.x + dx[i];
					if (ny >= N || nx >= N || ny < 0 || nx < 0 || visited[ny][nx] || arr[ny][nx] == 1)
						continue;
					q.offer(new Node(ny, nx, cur.len + 1));
					visited[ny][nx] = true;
				}
			}
			if (L == 0) return false;
			L--;
			cnt++;
		}
		return false;		
	}

	private static boolean findMan() {
		PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if (o1.len == o2.len) {
					if (o1.y == o2.y) {
						return o1.x - o2.x;
					}
					return o1.y - o2.y;
				} else {
					return o1.len - o2.len;
				}
			}
		});
		boolean[][] visited = new boolean[N][N];
		q.offer(new Node(taxi.y, taxi.x, 0));
		visited[taxi.y][taxi.x] = true;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Node cur = q.poll();
				for (int i = 0; i < list.size(); i++) {
					Node node = list.get(i);
					if (node.finish) continue;
					if (cur.y == node.y && cur.x == node.x) {
						taxi.y = cur.y;
						taxi.x = cur.x;
						goalNum = i;
						node.finish = true;
						return true;
					}
				}
				for (int i = 0; i < 4; i++) {
					int ny = cur.y + dy[i];
					int nx = cur.x + dx[i];
					if (ny >= N || nx >= N || ny < 0 || nx < 0 || visited[ny][nx] || arr[ny][nx] == 1)
						continue;
					q.offer(new Node(ny, nx, cur.len + 1));
					visited[ny][nx] = true;
				}
			}
			if (L == 0) return false;
			L--;
		}
		return false;
	}
	
}
