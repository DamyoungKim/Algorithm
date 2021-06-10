package com.swexpertacademy.A;

import java.util.Scanner;

public class Solution_4008_숫자만들기2 {
	static int N, max, min;
	static int[] number, operator = new int[4], order, tempOrder;
	static boolean[] selected;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			N = sc.nextInt();
			number = new int[N];
			for (int i = 0; i < 4; i++) {
				operator[i] = sc.nextInt();

			}

			for (int i = 0; i < N; i++) {
				number[i] = sc.nextInt();
			}
		
			solve(number[0], 1, operator[0], operator[1], operator[2], operator[3]);
			System.out.println("#" + t + " " + (max - min));
		}
	}

	private static void solve(int val, int cnt, int op1, int op2, int op3, int op4) {
		if(cnt == N) {
			min = min > val ? val : min;
			max = max > val ? max : val;
			return;
		}
		
		if(op1 > 0) solve(val + number[cnt], cnt + 1, op1 - 1, op2, op3, op4);
		if(op2 > 0) solve(val - number[cnt], cnt + 1, op1, op2 - 1, op3, op4);
		if(op3 > 0) solve(val * number[cnt], cnt + 1, op1, op2, op3 - 1, op4);
		if(op4 > 0) solve(val / number[cnt], cnt + 1, op1, op2, op3, op4 - 1);
		
		
	}
}
