package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_2210_숫자판점프 {
	static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
	static int[] visited = new int[6];
	static int[][] arr = new int[5][5];
	static boolean[] selected =  new boolean[(int)Math.pow(10, 6)];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				visited[0] = arr[i][j];
				solve(i, j, 0);
			}
		}
		int cnt = 0;
		for (int i = 0; i < selected.length; i++) {
			if(selected[i]) cnt++;
		}
		System.out.println(cnt);
	}

	private static void solve(int y, int x, int cnt) {
		if (cnt == 6) {
			int sum = 0;
			for(int i = 0; i < 6; i++) {
				sum += visited[i] * Math.pow(10, 5 - i);
			}
			selected[sum] = true;
			return;
		}
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (ny >= 5 || nx >= 5 || ny < 0 || nx < 0) continue;
			visited[cnt] = arr[ny][nx];
			solve(ny, nx, cnt + 1);
		}
	}
}
