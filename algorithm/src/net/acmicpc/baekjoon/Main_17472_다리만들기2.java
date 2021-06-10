package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17472_다리만들기2 {

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
	}

	static int N, M, cnt = 2;
	static int[][] arr;
	static int[] dx = { 0, 1, 0, -1 }, dy = { -1, 0, 1, 0 };
	static boolean[][] visited;
	static Queue<int[]> q = new LinkedList<>();
	static int[][] adjMatrix;

	static int V, E;
	static int parents[];
	static Edge[] edgeList;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1) {
					visited[i][j] = true;
					q.offer(new int[] { i, j });
					arr[i][j] = cnt;
					bfs(cnt++);
				}
			}
		}
		makeAdjMatrix();
		kruskal();
	}

	private static void kruskal() {
		// TODO Auto-generated method stub
		V = cnt;
		for (int i = 2; i < cnt; i++) {
			for (int j = 2; j < cnt; j++) {
				if (i == j || adjMatrix[i][j] == Integer.MAX_VALUE)
					continue;
				E++;
			}
		}
		parents = new int[V];
		edgeList = new Edge[E];
		int index = 0;
		for (int i = 2; i < cnt; i++) {
			for (int j = 2; j < cnt; j++) {
				if (i == j || adjMatrix[i][j] == Integer.MAX_VALUE)
					continue;
				edgeList[index++] = new Edge(i, j, adjMatrix[i][j]);
			}
		}
		Arrays.sort(edgeList);

		make();

		int result = 0;
		int count = 0;
		for (Edge edge : edgeList) {
			if (union(edge.from, edge.to)) { // 싸이클이 발생하지 않았다면
				result += edge.weight;
				if (++count == V - 1 - 2)
					break;
			}
		}
		if (result == 0 || count < V - 1 - 2)
			System.out.println(-1);
		else
			System.out.println(result);

	}

	private static void makeAdjMatrix() {
		// TODO Auto-generated method stub

		adjMatrix = new int[cnt][cnt];
		for (int i = 2; i < cnt; i++) {
			for (int j = 2; j < cnt; j++) {
				if (i == j) {
					adjMatrix[i][j] = 0;
					continue;
				}
				adjMatrix[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] != 0) {
					findWeight(i, j);
				}
			}
		}
	}

	private static void findWeight(int y, int x) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 4; i++) {

			for (int j = 0; j < 4; j++) {
				int ny = y + dy[j];
				int nx = x + dx[j];

				if (ny >= N || nx >= M || ny < 0 || nx < 0 || arr[ny][nx] != 0)
					continue;

				while (true) {
					ny += dy[j];
					nx += dx[j];

					if (ny >= N || nx >= M || ny < 0 || nx < 0)
						break;

					if (arr[ny][nx] != 0) {
						int temp = Math.abs(ny - y) + Math.abs(nx - x) - 1;
						if (temp == 1)
							break;
						if (adjMatrix[arr[y][x]][arr[ny][nx]] > temp) {
							adjMatrix[arr[y][x]][arr[ny][nx]] = temp;
						}
						break;
					}
				}
			}
		}
	}

	private static void bfs(int cnt) {
		// TODO Auto-generated method stub

		while (!q.isEmpty()) {
			int y = q.peek()[0];
			int x = q.poll()[1];

			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];

				if (ny >= N || nx >= M || ny < 0 || nx < 0 || visited[ny][nx] || arr[ny][nx] != 1)
					continue;
				arr[ny][nx] = cnt;
				q.offer(new int[] { ny, nx });
				visited[ny][nx] = true;

			}
		}
	}

	static void make() {
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}

	static int findSet(int a) {
		if (parents[a] == a)
			return a;

		return parents[a] = findSet(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);

		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;
	}

}
