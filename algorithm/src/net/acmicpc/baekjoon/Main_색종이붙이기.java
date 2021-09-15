package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_색종이붙이기 {
	static int min = Integer.MAX_VALUE;
	static int[][] arr = new int[10][10];
	static boolean[][] selected = new boolean[10][10];
	static int[] cntArr = {0, 5, 5, 5, 5, 5};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve(0, 0);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	private static void solve(int y, int x) {
		if (y >= 10) {
			int count = 25;
			for(int i = 1; i <= 5; i++) {
				count -= cntArr[i];
			}
			min = Math.min(count, min);
			return;
		}
		if(x >= 10) {
			solve(y + 1, 0);
			return;
		}
		if (arr[y][x] == 0 || selected[y][x]) {
			solve(y, x + 1);
			return;
		}
		
		for(int i = 1; i <= 5; i++) {
			if(cntArr[i] > 0 && check(y, x, i)) {
				set(y, x, true, i);
				cntArr[i]--;
				solve(y, x + 1);
				set(y, x, false, i);
				cntArr[i]++;
			}
		}
	}
	
	private static boolean check(int y, int x, int num) {
		for(int i = y; i < y + num; i++) {
			for (int j = x; j < x + num; j++) {
				if(i >= 10 || j >= 10) return false;
				if(arr[i][j] == 0 || selected[i][j]) return false;
			}
		}
		return true;
	}
	
	private static void set(int y, int x, boolean isSelected, int num) {
		for(int i = y; i < y + num; i++) {
			for (int j = x; j < x + num; j++) {
				selected[i][j] = isSelected;
			}
		}
	}
}
