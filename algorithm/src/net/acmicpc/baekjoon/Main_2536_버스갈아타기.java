package net.acmicpc.baekjoon;

import java.util.*;
import java.io.*;

public class Main_2536_버스갈아타기 {
	static int N, M, k;
	static ArrayList<Integer>[][] arr;

	static class Node {
		int y;
		int x;

		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

		@Override
		public boolean equals(Object obj) {
			Node node = (Node) obj;
			return this.y == node.y && this.x == node.x;
		}
	}

	static class Bus {
		int y1;
		int x1;
		int y2;
		int x2;

		public Bus(int y1, int x1, int y2, int x2) {
			super();
			this.y1 = y1;
			this.x1 = x1;
			this.y2 = y2;
			this.x2 = x2;
		}

	}

	static Queue<Node> q = new LinkedList<>();
	static Node end;
	static boolean[][] visited;
	static Bus[] buses;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(br.readLine());
		arr = new ArrayList[N][M];
		buses = new Bus[k + 1];
		visited = new boolean[N ][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = new ArrayList<>();
			}
		}
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken()) - 1;
			int y1 = N - Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken()) - 1;
			int y2 = N - Integer.parseInt(st.nextToken());
			buses[num] = new Bus(y1, x1, y2, x2);
			if (x1 == x2) {
				if (y1 < y2) {
					for (int y = y1; y <= y2; y++) {
						arr[y][x1].add(num);
					}
				} else {
					for (int y = y1; y >= y2; y--) {
						arr[y][x1].add(num);
					}
				}
			} else if (y1 == y2) {
				if (x1 < x2) {
					for (int x = x1; x <= x2; x++) {
						arr[y1][x].add(num);
					}
				} else {
					for (int x = x1; x >= x2; x--) {
						arr[y1][x].add(num);
					}
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		int sx = Integer.parseInt(st.nextToken()) - 1;
		int sy = N - Integer.parseInt(st.nextToken());
		visited[sy][sx] = true;
		q.offer(new Node(sy, sx));
		int dx = Integer.parseInt(st.nextToken()) - 1;
		int dy = N - Integer.parseInt(st.nextToken());
		end = new Node(dy, dx);
		solve();
	}

	private static void solve() {
		int cnt = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			cnt++;
			for (int s = 0; s < size; s++) {
				Node cur = q.poll();
				if(cur.equals(end)) {
					System.out.println(cnt - 1);
					return;
				}
				for (int i = 0; i < arr[cur.y][cur.x].size(); i++) {
					int num = arr[cur.y][cur.x].get(i);
					Bus  bus = buses[num];
					if (bus.x1 == bus.x2) {
						if (bus.y1 < bus.y2) {
							for (int y = bus.y1; y <= bus.y2; y++) {
								if(visited[y][bus.x1]) continue;
								visited[y][bus.x1] = true;
								q.offer(new Node(y, bus.x1));
							}
						}else {
							for (int y = bus.y1; y >= bus.y2; y--) {
								if(visited[y][bus.x1]) continue;
								visited[y][bus.x1] = true;
								q.offer(new Node(y, bus.x1));
							}
						}
					} else if (bus.y1 == bus.y2) {
						if (bus.x1 < bus.x2) {
							for (int x = bus.x1; x <= bus.x2; x++) {
								if(visited[bus.y1][x]) continue;
								visited[bus.y1][x] = true;
								q.offer(new Node(bus.y1, x));
							}
						}else {
							for (int x = bus.x1; x >= bus.x2; x--) {
								if(visited[bus.y1][x]) continue;
								visited[bus.y1][x] = true;
								q.offer(new Node(bus.y1, x));
							}
						}
					}
				}
			}
		}
	}
}
