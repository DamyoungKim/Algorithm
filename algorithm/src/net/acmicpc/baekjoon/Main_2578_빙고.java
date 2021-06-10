package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_2578_빙고 {
	static int[][] arr;
	static boolean[][] map;
	static Set<Integer> setR = new HashSet<>();
	static Set<Integer> setC = new HashSet<>();
	static Set<Integer> setX = new HashSet<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[5][5];
		map = new boolean[5][5];
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int ans = Integer.parseInt(st.nextToken());
				cnt++;
				if (check(ans)) {
					System.out.println(cnt);
					return;
				}
			}
		}

	}

	public static int[] set(int ans) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (arr[i][j] == ans) {
					map[i][j] = true;
					return new int[] { i, j };
				}
			}
		}
		return null;
	}

	public static boolean check(int ans) {
		int[] pos = set(ans);
		int r = pos[0];
		int c = pos[1];
		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			if (map[r][i]) {
				cnt++;
			}
		}
		if (cnt == 5) {
			setR.add(r);
		}
		cnt = 0;
		for (int i = 0; i < 5; i++) {
			if (map[i][c]) {
				cnt++;
			}
		}
		if (cnt == 5) {
			setC.add(c);
		}
		cnt = 0;
		if (r + c == 4) {
			for (int i = 0; i < 5; i++) {
				if (map[4 - i][i]) {
					cnt++;
				}
			}
		}

		if (cnt == 5) {
			setX.add(4);
		}
		cnt = 0;
		if (r == c) {
			for (int i = 0; i < 5; i++) {
				if (map[i][i]) {
					cnt++;
				}
			}
		}
		if (cnt == 5) {
			setX.add(0);
		}
		
		
		if (setX.size() + setR.size() + setC.size() >= 3)
			return true;
		else
			return false;
	}
}