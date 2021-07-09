package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_14888_연산자끼워넣기 {
	static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		solve(arr[0], 0, sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
		System.out.println(max);
		System.out.println(min);
	}

	private static void solve(int val, int index, int op1, int op2, int op3, int op4) {
		if(index == N - 1) {
			max = Math.max(val, max);
			min = Math.min(val, min);
			return;
		}
		if (op1 > 0) {
			solve(val + arr[index + 1], index + 1, op1 - 1, op2, op3, op4);
		}
		
		if (op2 > 0) {
			solve(val - arr[index + 1], index + 1, op1, op2 - 1, op3, op4);
		}
		
		if (op3 > 0) {
			solve(val * arr[index + 1], index + 1, op1, op2, op3 - 1, op4);
		}
		
		if (op4 > 0) {
			solve(val / arr[index + 1], index + 1, op1, op2, op3, op4 - 1);
		}

	}

}
