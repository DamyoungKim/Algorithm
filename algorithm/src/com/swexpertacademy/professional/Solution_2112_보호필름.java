package com.swexpertacademy.professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2112_보호필름 {
	static int T, D, W, K;
	static int[][] arr;
	static int[] selected;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[D][W];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			if (check(arr)) {
				System.out.println("#" + t + " " + 0);
				continue;
			}
			boolean isFinded = false;
			for (int i = 1; i < D; i++) {
				selected = new int[i];
				visited = new boolean[i];
				if (combi(0, 0, i)) {
					System.out.println("#" + t + " " + i);
					isFinded = true;
					break;
				}
			}
			if (!isFinded) {
				System.out.println("#" + t + " " + D);
			}
		}
	}
	private static boolean combi(int cnt, int start, int R) {
		if (cnt == R) {
			if(powerset(0, R)) return true;
			return false;
		}
		for (int i = start; i < D; i++) {
			selected[cnt] = i;
			if(combi(cnt + 1, i + 1, R)) return true;
		}
		return false;
	}
	
	private static boolean powerset(int cnt, int R) {
		if (cnt == R) {
			int[][] temp = copy();
			for (int i = 0; i < selected.length; i++) {
				int mode = visited[i] ? 0 : 1;
				inject(selected[i], mode, temp);
			}
			if(check(temp)) return true;
			return false;
		}
		visited[cnt] = true;
		if(powerset(cnt + 1, R)) return true;
		visited[cnt] = false;
		if(powerset(cnt + 1, R)) return true;
		
		return false;
	}

	private static int[][] inject(int dir, int mode, int[][] temp) {
		for (int i = 0; i < W; i++) {
			temp[dir][i] = mode;
		}
		return temp;
	}
	private static boolean check(int[][] temp) {
		for (int i = 0; i < W; i++) {
			int cur = temp[0][i];
			int cnt = 1;
			for (int j = 1; j < D; j++) {
				if (cnt >= K) break;
				if (cur == temp[j][i]) {
					cnt++;
				} else {
					cur = temp[j][i];
					cnt = 1;
				}
			}
			if (cnt < K) return false;
		}
		return true;
	}
	
	private static int[][] copy () {
		int[][] temp = new int[D][W];
		for (int i = 0; i < D; i++) {
			for (int j = 0; j < W; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		return temp;
	}
}
