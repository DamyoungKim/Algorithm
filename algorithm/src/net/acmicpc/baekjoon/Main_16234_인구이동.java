package net.acmicpc.baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_16234_인구이동 {
	static int N, L, R, sum, cnt;
	static int[] dx = { 0, 1, 0, -1 }, dy = { -1, 0, 1, 0 };
	static int[][] arr;
	static int[][] visited;
	static Map<Integer, Integer> map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int result = 0;
		while (true) {
			boolean check = false;
			visited = new int[N][N];
			map = new HashMap<>();
			int num = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j] == 0) {
						boolean isPossible = false;
						for(int loop = 0; loop < 4; loop++) {
							isPossible = check(i, j, loop);
							if(isPossible) break;
						}
						if(!isPossible) continue;
						num++;
						sum = cnt = 0;
						check = true;
						dfs(i, j, arr[i][j], num);
						map.put(num, sum / cnt);
					}
				}
			}
			if (!check)
				break;
			set();
			result++;
		}
		System.out.println(result);
	}

	private static void dfs(int y, int x, int val, int num) {
		visited[y][x] = num;
		cnt++;
		sum += val;
		for (int i = 0; i < 4; i++) {
			if (check(y, x, i)) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				dfs(ny, nx, arr[ny][nx], num);
			}
		}
	}

	private static void set() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(visited[i][j] == 0) continue;
				arr[i][j] = map.get(visited[i][j]);
			}
		}
	}

	private static boolean check(int y, int x, int i) {
		int ny = y + dy[i];
		int nx = x + dx[i];
		if (ny >= N || nx >= N || ny < 0 || nx < 0 || visited[ny][nx] != 0)
			return false;
		int abs = Math.abs(arr[y][x] - arr[ny][nx]);
		if (!(abs >= L && abs <= R)) return false;
		
		return true;
	}



}
