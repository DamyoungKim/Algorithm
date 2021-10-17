package com.swexpertacademy.professional;
import java.util.Scanner;

public class Solution_4311_오래된스마트폰 {
	static int T, N, O, M, W, length, result;
	static boolean[] operator, selected;
	static int[] number, memo;
	static int[][] list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			O = sc.nextInt();
			M = sc.nextInt();
			number = new int[N];
			operator = new boolean[5];
			selected = new boolean[1000];
			length = 0;
			for (int i = 0; i < N; i++) {
				number[i] = sc.nextInt();
			}
			for (int i = 0; i < O; i++) {
				operator[sc.nextInt()] = true;
			}
			W = sc.nextInt();
			list = new int[1000][2];
			for (int i = 1; i <= 3; i++) {
				combi(0, 0, i);
			}
			memo = new int[1000];
			for (int i = 0; i < 1000; i++) {
				memo[i] = Integer.MAX_VALUE;
			}
			result = Integer.MAX_VALUE;
			for (int i =1; i <= 4; i++) {
				if (!operator[i]) continue;
				for (int j = 0; j < length; j++) {
					solve(list[j][0], list[j][1], true);
				}
			}
			if (result == Integer.MAX_VALUE) {
				System.out.println("#" + t + " " + -1);
			} else {
				System.out.println("#" + t + " " + result);
			}
		}
}
	private static void solve(int num, int cnt, boolean check) {
		if (num < 0 || num > 999) return;
		if (cnt >= result) return;
		if (cnt > M - 1) return;
		if (memo[num] <= cnt) return;
		if (num == W) {
			if (check) {
				result = result > cnt ? cnt : result;
			} else {
				result = result > cnt + 1 ? cnt + 1 : result;
			}
			return;
		}
		memo[num] = cnt;
		for (int i =1; i <= 4; i++) {
			if (!operator[i]) continue;
			for (int j = 0; j < length; j++) {
				if (i == 1) {
					solve(num + list[j][0], cnt + 1 + list[j][1], false);
				} else if (i == 2) {
					solve(num - list[j][0], cnt + 1 + list[j][1], false);
				} else if (i == 3) {
					solve(num * list[j][0], cnt + 1 + list[j][1], false);
				} else if (i == 4 && list[j][0] != 0) {
					solve(num / list[j][0], cnt + 1 + list[j][1], false);
				}
			}
		}
		
	}
	private static void combi(int num ,int cnt, int R) {
		if (cnt == R) {
			if (selected[num]) return;
			selected[num] = true;
			list[length][0] = num;
			list[length++][1] = R;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			combi(num * 10 + number[i], cnt + 1, R);
		}
	}
}
/*
1
5 3 10
8 7 1 2 6
2 4 3
981

1
3 1 4
1 6 5
1
0

* */
