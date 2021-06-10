package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_2116_주사위쌓기 {
	static int[][] arr;
	static int N;
	static int U, B, result;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// 아래의 윗면 숫자 = 위에 아래 숫자, 1번 맘대로
		// A -F , B - D, C - E

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new int[N][6];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 6; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int u = 0;
		int max = 0;
		for (int i = 0; i < 6; i++) {
			if (i == 0) {
				u = arr[0][5];
				max = findMax(0, 0, 5);
			} else if (i == 5) {
				u = arr[0][0];
				max = findMax(0, 0, 5);
			} else if (i == 1 || i == 2) {
				u = arr[0][i + 2];
				max = findMax(0, i, i+2);
			} else if (i == 3 || i == 4) {
				u = arr[0][i - 2];
				max = findMax(0, i, i -2);
			}

			solve(1, u, max);
		}
		System.out.println(result);
	}

	private static void solve(int index, int b, int sum) {
		if(index == N) {
			result = Math.max(result, sum);
			return;
		}
		int i = bottom(index, b);
		int u = 0;
		int max = 0;
		if (i == 0) {
			u = arr[index][5];
			max = findMax(index, i, 5);
		} else if (i == 5) {
			u = arr[index][0];
			max = findMax(index, i, 0);
		} else if (i == 1 || i == 2) {
			u = arr[index][i + 2];
			max = findMax(index, i, i + 2);
		} else if (i == 3 || i == 4) {
			u = arr[index][i - 2];
			max = findMax(index, i, i -2);
		}
		
		solve(index + 1, u, sum + max);

	}

	private static int bottom(int index, int u) {
		int i = 0;
		for (i = 0; i < 6; i++) {
			if (arr[index][i] == u) {
				return i;
			}
		}
		return 0;
	}

	private static int findMax(int index, int a, int b) {
		int max = 0;
		for (int i = 0; i < 6; i++) {
			if (i == a || i == b)
				continue;
			max = Math.max(max, arr[index][i]);
		}

		return max;
	}
}
