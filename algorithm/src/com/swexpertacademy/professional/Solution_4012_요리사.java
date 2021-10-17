package com.swexpertacademy.professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4012_요리사 {
	static int T, N, min;
	static int[][] arr;
	static int[] selected, A, B;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			selected = new int[N / 2];
			A = new int[N / 2];
			B = new int[N / 2];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;
			choiceFood(0, 0);
			System.out.println("#" + t + " " + min);
		}
	}
	private static void choiceFood(int cnt, int start) {
		if (cnt == N / 2) {
			int a = 0;
			int b = 0;
			boolean[] visited = new boolean[N];
			for (int i = 0; i < N / 2; i++) {
				visited[selected[i]] = true;
			}
			for (int i = 0; i < N; i++) {
				if (visited[i]) {
					A[a++] = i;
				} else {
					B[b++] = i;
				}
			}
			int SA = 0;
			int SB = 0;
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < N / 2; j++) {
					if (i == j) continue;
					SA += (arr[A[i]][A[j]]);
					SB += (arr[B[i]][B[j]]);
				}
			}
			min = Math.min(Math.abs(SA - SB), min);
			return;
		}
		for (int i = start; i < N; i++) {
			selected[cnt] = i;
			choiceFood(cnt + 1, i + 1);
		}
	}

}
/*
1
4
0 5 3 8
4 0 4 1
2 5 0 3
7 2 3 0

*/