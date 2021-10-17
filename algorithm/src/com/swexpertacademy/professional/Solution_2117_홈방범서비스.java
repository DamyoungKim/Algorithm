package com.swexpertacademy.professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2117_홈방범서비스 {
	static int T, N, M, max;
	static int[][] arr;
	static int cost[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			cost = new int[2 * N];
			max = 0;
			for (int k = 1; k < 2 * N; k++) {
				cost[k] =  k * k + (k - 1) * (k - 1);
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = 1; k < N * 2; k++) {
						solve(i, j, k);
					}
				}
			}
			System.out.println("#" + t + " " + max);
		}
	}
	private static void solve(int y, int x, int k) {
		int gain = 0;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (Math.abs(y - i) + Math.abs(x - j) < k && arr[i][j] == 1) {
					gain += M;
					cnt++;
				}
			}
		}
		if (gain - cost[k] < 0) return;
		max = Math.max(max, cnt);
	}
}
