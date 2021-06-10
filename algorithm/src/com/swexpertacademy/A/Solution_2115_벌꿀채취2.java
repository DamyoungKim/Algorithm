package com.swexpertacademy.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2115_벌꿀채취2 {
	static int N, M, C;
	static int[][] arr, profit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			arr = new int[N][N];
			profit = new int[N][N - M + 1];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N - M + 1; i++) {
					int check = 0;
					int sum = 0;
					for (int j = 0; j < M; j++) {
						check += arr[k][i + j];
						sum += (arr[k][i + j]) * (arr[k][i + j]);
					}
					if (check > C)
						continue;
					profit[k][i] = sum;
				}
			}
			int[] resultArr = new int[N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N - M + 1; j++) {
					resultArr[i] = resultArr[i] > profit[i][j] ? resultArr[i] : profit[i][j];
				}
			}
			int max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					int temp = resultArr[i] + resultArr[j];
					max = max > temp ? max : temp;
				}
			}
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N - M + 1; i++) {
					for (int j = k + M; j < N - M + 1; j++) {
						int temp = profit[k][i] + profit[k][j];
						max = max > temp ? max : temp;
						
					}
				}
			}

			System.out.println("#" + t + " " + max);
		}

	}

}
