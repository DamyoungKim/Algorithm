package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_15651_N과M3 {
	static int[] numbers;
	static int N, R;
	static StringBuilder sb;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		R = sc.nextInt();
		numbers = new int[R];
		sb = new StringBuilder();
		combination(0, 1);
		System.out.println(sb);

	}

	static void combination(int cnt, int start) {
		if (cnt == R) {
			for (int i = 0; i < R; i++) {
				sb.append(numbers[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= N; i++) { // i: 시도하는 수
			numbers[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}
}