package com.swexpertacademy.D2;

import java.util.Scanner;

public class Solution_D2_1954_달팽이숫자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int[][] snail = new int[n][n];
			int count = 1;
			int x = 0;
			int y = 0;
			snail[x][y] = 1;
			for (int i = 0; i < 2 * n - 1; i++) {
				int loop = i % 4;
				while (true) {
					x += dx[loop];
					y += dy[loop];
					if (x >= n || x < 0 || y >= n || y < 0 || snail[y][x] != 0) {
						x -= dx[loop];
						y -= dy[loop];
						break;
					}
					snail[y][x] = ++count;
				}
			}
			System.out.println("#" + t);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
/**
 * 1. 행 고정 열 0~2 1씩 증가
 * 2. 열 고정 행 1_2 1씩 증가
 * 3.
 * ...
 * 열 단위 이동후 이동 획수 감소
 * 행 단위 이동후 증감 변경
 * */
 