package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_21610_마법사상어와비바라기 {
	static class Cloud { 
		int y;
		int x;
		
		private void move(int d, int s) {
			s %= N;
			this.y = (this.y + dy[d] * s + N) % N;
			this.x = (this.x + dx[d] * s + N) % N;
			isExist[this.y][this.x] = true;
		}
		
		private void rain() {
			arr[y][x]++;
		}
		
		public Cloud(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

		private void bug() {
			int cnt = 0;
			for(int i = 1; i < 8; i += 2) {
				int ny = this.y + dy[i];
				int nx = this.x + dx[i];
				if(ny >= N || nx >= N || ny < 0 || nx < 0 || arr[ny][nx] == 0) continue;
				cnt++;
			}
			arr[y][x] += cnt;
		}
		
		@Override
		public boolean equals (Object obj) {
			if(obj instanceof Cloud) {
				Cloud cloud = (Cloud) obj;
				if(this.y == cloud.y && this.x == cloud.x) return true;
			}
			return false;
		}
	}
	static int N, M;
	static int[][] arr, commandArr;
	static boolean[][] isExist;
	static List<Cloud> list = new ArrayList<>();
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}, dy = {0, -1, -1, -1, 0, 1, 1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		isExist = new boolean[N][N];
		commandArr = new int[M][2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				commandArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		list.add(new Cloud(N - 1, 0));
		list.add(new Cloud(N - 1, 1));
		list.add(new Cloud(N - 2, 0));
		list.add(new Cloud(N - 2, 1));
		
		for (int i = 0; i < M; i++) {
			for (int j = 0, size = list.size(); j < size; j++) {
				list.get(j).move(commandArr[i][0] - 1, commandArr[i][1]);
			}
			for (int j = 0, size = list.size(); j < size; j++) {
				list.get(j).rain();
			}
			for (int j = 0, size = list.size(); j < size; j++) {
				list.get(j).bug();
			}
			makeCloud();
		}
		int result = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				result += arr[i][j];
			}
		}
		System.out.println(result);
		
	}
	
	private static void makeCloud() {
		list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if (isExist[i][j]) {
					isExist[i][j] = false;
				} else {
					if(arr[i][j] >= 2) {
						arr[i][j] -= 2;
						list.add(new Cloud(i, j));
					}
				}
			}
		}
	}
}
