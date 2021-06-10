package com.swexpertacademy.A;

import java.util.Scanner;

public class Solution_4008_숫자만들기 {
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
			order = new int[N - 1];
			selected = new boolean[N - 1];
			tempOrder = new int[N - 1];
			for (int i = 0; i < 4; i++) {
				operator[i] = sc.nextInt();

			}

			for (int i = 0; i < N; i++) {
				number[i] = sc.nextInt();
			}
			int cnt = 0;
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < operator[i]; j++) {
					order[cnt++] = i;
				}
			}
			solve(0);
			System.out.println("#" + t + " " + (max - min));
		}
	}

	private static void solve(int cnt) {
		if (cnt == N - 1) {
			int val = operate(number[0], 0);
			
			min = min > val ? val : min;
			max = max > val ? max : val;
			
			return;
		}

		for (int i = 0; i < N - 1; i++) {
			if (selected[i])
				continue;
			selected[i] = true;
			tempOrder[cnt] = order[i];
			solve(cnt + 1);
			selected[i] = false;

		}
	}

	private static int operate(int val, int cnt) {
		if(cnt == N - 1) {
			return val;
		}
		switch (tempOrder[cnt]) {
		case 0:
			val += number[cnt + 1]; 
			break;
		case 1:
			val -= number[cnt + 1];
			break;
		case 2:
			val *= number[cnt + 1];
			break;
		case 3:
			val /= number[cnt + 1];
			break;

		}
		
		return operate(val, cnt + 1);
	}

}
