package com.swexpertacademy.D6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D6_1263_사람네트워크2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int temp = Integer.parseInt(st.nextToken());
					if (i != j && temp == 0) {
						arr[i][j]= Integer.MAX_VALUE/2;
						continue;
					}
					arr[i][j] = temp;
				}
			}

			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					if (k == i)
						continue;
					for (int j = 0; j < N; j++) {
						if (k == j || i == j)
							continue;

						if (arr[i][j] > arr[i][k] + arr[k][j]) {
							arr[i][j] = arr[i][k] + arr[k][j];
						}
					}
				}
			}
			int result = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					int temp = arr[i][j];
					if (temp == Integer.MAX_VALUE/2)
						continue;
					sum += arr[i][j];
				}
				result = result > sum ? sum : result;

			}
			System.out.println("#" + t + " " + result);
		}

	}

}

