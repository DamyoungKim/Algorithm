package com.swexpertacademy.professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2115_벌꿀채취 {
	static int T, N, M, C, max;
	static int[][] arr;
	static int[] selected, dp;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			selected = new int[M];
			dp = new int[N * N];
			arr = new int[N][N];
			visited = new boolean[N * N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N * N; i++) {
				if ((i % N) + M > N) continue;;
				powerset(i, 0);
			}
			max = 0;
			combi(0, 0, 0);
			System.out.println("#" + t + " " + max);
		}
	}
	private static void combi(int cnt, int start, int val) {
		if (cnt == 2) {
			max = Math.max(max, val);
			return;
		}
		for (int i = start; i < N * N; i ++) {
			combi(cnt + 1, i + M, val + dp[i]);
		}
	}
	private static void powerset(int num, int cnt) {
		if (cnt == M) {
			int sum = 0;
			for (int i = num - 1; i >= num - M; i--) {
				if (visited[i]) sum += arr[i / N][i % N];
			}
			if (sum > C) return;
			int gain = 0;
			for (int i = num - 1; i >= num - M; i--) {
				if (visited[i]) gain += Math.pow(arr[i / N][i % N], 2);
			}
			dp[num - M] = Math.max(dp[num - M], gain);
			return;
		}
			visited[num] = true;
			powerset(num + 1, cnt + 1);
			visited[num] = false;
			powerset(num + 1, cnt + 1);
			return;
	}

}
/*
1
3 3 10
7 2 9
6 6 6
5 5 7

*/