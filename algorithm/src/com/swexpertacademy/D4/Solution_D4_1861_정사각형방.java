package com.swexpertacademy.D4;

import java.util.Scanner;

public class Solution_D4_1861_정사각형방 {
	static int N;
	static int[][] arr;
	static int count;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[][] sum;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			arr = new int[N][N];
			sum = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					arr[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sum[i][j] = search(i, j);
					count = 0;
				}
			}
			int max = 0;
			int Index = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (max < sum[i][j]) {
						Index = arr[i][j];
						max = sum[i][j];
						continue;
					}
					if(max == sum[i][j]) {
						Index = Index < arr[i][j] ? Index : arr[i][j];
					}
				}
			}
			System.out.println("#" + t + " " + Index + " " + (max + 1));
		}
	}

	public static int search(int r, int c) {

		for (int i = 0; i < 4; i++) {
			int x = c + dx[i];
			int y = r + dy[i];
			if (x < 0 || x >= N || y < 0 || y >= N)
				continue;
			if (arr[y][x] - arr[r][c] == 1) {
				count++;
				search(y, x);
			}
		}
		return count;
	}
}
