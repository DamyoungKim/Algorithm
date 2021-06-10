package com.swexpertacademy.D2;

import java.util.Scanner;

public class Solution_D2_2005_파스칼의삼각형 {
	static int N, R, count;
	static int[] number;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		R = N;

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			System.out.println("#" + t);
			System.out.println(1);
			for (int i = 1; i < N; i++) {
				System.out.print(1 + " ");

				for (int j = 1; j <= i; j++) {
					number = new int[j];
					c(i, j, 0, 1);
					System.out.print(count + " ");
					count = 0;
				}
				System.out.println();
			}
		}
	}

	private static void c(int n, int r, int cnt, int start) {
		// sCe
		if(cnt == r) {
			count++;
			return;
		}
		for (int i = start; i <= n; i++) {
			number[cnt] = i;
			c(n, r, cnt + 1, i + 1);
		}
	}
}
