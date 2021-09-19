package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194_달이차오른다가자 {
	static class Man {
		int y;
		int x;
		List<Key> keys;
		boolean[][] visited;
		
		public Man(int y, int x, boolean[][] visited) {
			super();
			this.y = y;
			this.x = x;
			this.visited = visited;
		}
		
		public Man(int y, int x, boolean[][] visited, List<Key> list) {
			this(y, x, visited);
			this.keys = list;
		}
		
		public Man(int y, int x, List<Key> list, Key key) {
			this.y = y;
			this.x = x;
			
			this.keys = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				this.keys.add(list.get(i));
			}
			this.keys.add(key);
			
			this.visited = new boolean[N][M];
			for (int i = 0; i < this.keys.size(); i++) {
				this.visited[this.keys.get(i).y][this.keys.get(i).x] = true;
			}
		}
	}
	
	static class Key {
		int y;
		int x;
		int val;
		
		public Key(int y, int x, int val) {
			super();
			this.y = y;
			this.x = x;
			this.val = val;
		}

		@Override
		public boolean equals(Object obj) {
			Key key = (Key) obj;
			if(this.y == key.y && this.x == key.x) return true;
			else return false;
		}
	}
	static int N, M, min = Integer.MAX_VALUE;
	static char[][] arr;
	static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
	static Queue<Man> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new char[N][M];
		int x = 0;
		int y = 0;

		for (int i = 0; i < N; i++) {
			String s =br.readLine();
			for (int j = 0; j < M; j++) {
				char c = s.charAt(j);
				arr[i][j] = c;
				if (c == '0') {
					y = i;
					x = j;
				}
			}
		}
		boolean[][] visited = new boolean[N][M];
		visited[y][x] = true;
		List<Key> keys = new ArrayList<>();
		q.offer(new Man(y, x, visited, keys));
		solve();
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}
	private static void solve() {
		int cnt = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			cnt++;
			for (int s = 0; s < size; s++) {
				Man man = q.poll();
				for (int d = 0; d < 4; d++) {
					int ny = man.y + dy[d];
					int nx = man.x + dx[d];
					
					boolean[][] visited = man.visited;
					List<Key> keys = man.keys;
					if(ny >= N || nx >= M || ny < 0 || nx < 0 || visited[ny][nx] || arr[ny][nx] == '#') continue;
					
					if(arr[ny][nx] == '1') {
						min = cnt;
						return;
					}
					
					if('A' <= arr[ny][nx] && arr[ny][nx] <= 'F') {
						if (hadKey(keys, arr[ny][nx])) {
							visited[ny][nx] = true;
							q.offer(new Man(ny, nx, visited, keys));
						}
					} else if ('a' <= arr[ny][nx] && arr[ny][nx] <= 'f') {
						q.offer(new Man(ny, nx, keys, new Key(ny, nx, arr[ny][nx])));
					} else {
						visited[ny][nx] = true;
						q.offer(new Man(ny, nx, visited, keys));
					}
					
				}
			}
		}
	}
	
	
	private static boolean hadKey(List<Key> keys, char val) {
		for(int i = 0; i < keys.size(); i++) {
			if(keys.get(i).val == val + 'a' - 'A') return true;
		}
		return false;
	}
	
}
