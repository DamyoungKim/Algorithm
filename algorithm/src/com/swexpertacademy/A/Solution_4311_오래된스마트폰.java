package com.swexpertacademy.A;

import java.util.Scanner;

public class Solution_4311_오래된스마트폰 {
	static int T, N, O, M, W, result;
	static int[] number, operator;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			O = sc.nextInt();
			M = sc.nextInt();

			number = new int[N];
			operator = new int[O];

			for (int i = 0; i < N; i++) {
				number[i] = sc.nextInt();

			}

			for (int i = 0; i < O; i++) {
				operator[i] = sc.nextInt();
			}

			W = sc.nextInt();

			String sw = Integer.toString(W);
			boolean check = false;
			int cnt = 0;
			for (int j = 0; j < sw.length(); j++) {
				for (int i = 0; i < N; i++) {
					check = false;
					if (sw.charAt(j) - '0' == number[i]) {
						cnt++;
						break;
					}
					if (i == N - 1 && !check) {
						check = true;
						break;
					}
				}
				if (check)
					break;
			}
			if (check)
				solve();
			else
				result = cnt;

			System.out.println("#" + t + " " + result);

		}
	}

	private static void solve() {
		
	}
}
