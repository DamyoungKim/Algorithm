package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_15650_N과M2 {
	static int[] numbers;
	static int N ,R;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		numbers = new int[R];
		combination(0, 1);

	}

	static void combination(int cnt, int start) {
		if (cnt == R) {
			for (int i = 0; i < R; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i <= N; i++) { // i: 시도하는 수
			numbers[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}
}
