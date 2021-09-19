package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1194_달이차오른다가자 {
	static class Key {
		int y;
		int x;
		char val;
		public Key(int y, int x, char val) {
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
	static boolean[][] visited;
	static List<Key> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new char[N][M];
		visited = new boolean[N][M];
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
		
		solve(y, x, 0);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}
	private static void solve(int y, int x, int cnt) {
		if(arr[y][x] == '1') {
			min = Math.min(min, cnt);
			return;
		}
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if ( ny >= N || nx >= M || ny < 0 || nx < 0 || visited[ny][nx] || arr[ny][nx] == '#') continue;
			
			if('a' <= arr[ny][nx] && arr[ny][nx] <= 'f') {
				Key key = new Key(ny, nx, arr[ny][nx]);
				list.add(key);
				boolean[][] temp = new boolean[N][M]; 
				for(int j = 0; j < list.size(); j++) {
					Key keyT = list.get(j);
					temp[keyT.y][keyT.x] = true;
				}
				boolean[][] copy = new boolean[N][M];
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < M; c++) {
						copy[r][c] = visited[r][c];
					}
				}
				visited = temp;
				solve(ny, nx, cnt + 1);
				list.remove(key);
				visited = copy;
			} else if('A' <= arr[ny][nx] && arr[ny][nx] <= 'F') {
				boolean check =false;
				for (int j = 0; j < list.size(); j++) {
					if(list.get(j).val == arr[ny][nx] + 'a' - 'A') {
						check = true;
						break;
					}
				}
				if (check) {
					visited[ny][nx] = true;
					solve(ny, nx, cnt + 1);
					visited[ny][nx] = false;
				}
			} else {
				visited[ny][nx] = true;
				solve(ny, nx, cnt + 1);
				visited[ny][nx] = false;
			}
		}
	}
	
}
