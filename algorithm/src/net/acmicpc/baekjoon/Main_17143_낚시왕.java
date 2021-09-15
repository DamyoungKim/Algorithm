package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_17143_낚시왕 {
	static class Shark implements Comparable<Shark>{
		int y;
		int x;
		int s;
		int d;
		int z;
		public Shark(int y, int x, int s, int d, int z) {
			super();
			this.y = y;
			this.x = x;
			this.s = d == 0 || d == 1 ? s % (R * 2 - 2) : s % (C * 2 - 2); 
			this.d = d;
			this.z = z;
			
		}
		@Override
		public int compareTo(Shark o) {
			// TODO Auto-generated method stub
			return this.z - o.z;
		}
		
		private void move() {
			int ny = 0;
			int nx = 0;
			if(this.d == 0 || d == 1) {
				if (d == 0) {
					if (0 <= s && s <= y) {
						ny = y + dy[d] * s;
					} else if (y < s && s < y + R) {
						this.d = 1;
						ny = dy[d] * (s - y);
					} else {
						ny = R - 1 + dy[d] * (s - (y + R - 1));
					}
				} else {
					if (0 <= s && s < R - y) {
						ny = y + dy[d] * s;
					} else if (R - y <= s && s <= 2 * R - 2 - y) {
						this.d = 0;
						ny = R - 1 + dy[d] * (s - (R - 1 - y));
					} else {
						ny = dy[d] * (s - (2 * R - 2 - y));
					}
				}
				nx = x;
			} else {
				if (d == 3) {
					if (0 <= s && s <= x) {
						nx = x + dx[d] * s;
					} else if (x < s && s < x + C) {
						this.d = 2;
						nx = dx[d] * (s - x);
					} else {
						nx = C - 1 + dx[d] * (s - (x + C - 1));
					}
				} else {
					if (0 <= s && s < C - x) {
						nx = x + dx[d] * s;
					} else if (C - x <= s && s <= 2 * C - 2 - x) {
						this.d = 3;
						nx = C - 1 + dx[d] * (s - (C - 1 - x));
					} else {
						nx = dx[d] * (s - (2 * C - 2 - x));
					}
				}
				ny = y;
			}
			this.y = ny;
			this.x = nx;
			list.add(this);
		}
		
		@Override
		public boolean equals(Object obj) {
			Shark shark = (Shark) obj;
			if(this.y == shark.y && this.x == shark.x) return true;
			return false;
		}
		
	}
	static int R, C, M, result;
	static int[] dx = {0, 0, 1, -1}, dy = {-1, 1, 0, 0}; // 상 하 우 좌
	static PriorityQueue<Shark>[][] arr;
	static List<Shark> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new PriorityQueue[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				arr[i][j] = new PriorityQueue<>();
			}
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());
			arr[y][x].add(new Shark(y, x, s, d, z));
		}
		
		for(int i = 0; i < C; i++) {
			huntShark(i);
			moveShark();
			removeShark();
		}
		System.out.println(result);
		
	}

	private static void huntShark(int x) {
		for(int i = 0; i < R; i++) {
			if(arr[i][x].size() == 0) continue;
			Shark shark = arr[i][x].poll();
			list.remove(shark);
			result += shark.z;
			return;
		}
	}
	
	private static void moveShark() {
		
		for(int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(arr[i][j].size() == 0) continue;
				arr[i][j].poll().move();;
			}
		}
		
		for(int i = 0; i < list.size(); i++) {
			Shark shark = list.get(i);
			arr[shark.y][shark.x].add(shark);
		}
		
		list.clear();
	}
	
	private static void removeShark() {
		for(int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(arr[i][j].size() == 0) continue;
				while(arr[i][j].size() != 1) {
					arr[i][j].poll();
				}
			}
		}
	}
}
