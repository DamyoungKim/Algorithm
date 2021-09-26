package net.acmicpc.baekjoon;

import java.util.*;
import java.io.*;

public class Main_2536_버스갈아타기 {
	static int N, M, k, dx, dy;

	static class Bus {
		int y1;
		int x1;
		int y2;
		int x2;

		public Bus(int y1, int x1, int y2, int x2) {
			super();
			this.y1 = Math.min(y1, y2);
			this.x1 = Math.min(x1, x2);
			this.y2 = Math.max(y1, y2);
			this.x2 = Math.max(x1, x2);
		}

		private boolean takeBus(int y, int x) {
			if (y1 <= y && y <= y2 && x1 <= x && x <= x2) return true;
			return false;
		}
		
		private boolean transper(Bus bus) {
			if(bus.x1 <= this.x2 && bus.x2 >= this.x1 && bus.y1 <= this.y2 && bus.y2 >= this.y1) return true;
			return false;
		}

	}

	static Queue<Integer> q = new LinkedList<>();
	static boolean[] visited;
	static Bus[] buses;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(br.readLine());
		buses = new Bus[k + 1];
		visited = new boolean[k + 1];

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken()) - 1;
			int y1 = N - Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken()) - 1;
			int y2 = N - Integer.parseInt(st.nextToken());
			buses[num] = new Bus(y1, x1, y2, x2);
		}
		st = new StringTokenizer(br.readLine());
		int sx = Integer.parseInt(st.nextToken()) - 1;
		int sy = N - Integer.parseInt(st.nextToken());
		for (int i = 1; i <= k; i++) {
			if (buses[i].takeBus(sy, sx)) {
				visited[i] = true;				
				q.offer(i);
			}
		}
		
		dx = Integer.parseInt(st.nextToken()) - 1;
		dy = N - Integer.parseInt(st.nextToken());
		solve();
	}

	private static void solve() {
		int cnt = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			cnt++;
			for (int s = 0; s < size; s++) {
				int num = q.poll();
				if (buses[num].takeBus(dy, dx)) {
					System.out.println(cnt);
					return;
				}
				for (int i = 1; i <= k; i++) {
					if (visited[i]) continue;
					if (buses[num].transper(buses[i])) {
						visited[i] = true;
						q.offer(i);
					}
				}
			}
		}
	}
}
