package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_15649_N과M1 {
	static int[] numbers;
	static int N;
	static boolean[] isSelected;
	static int R;;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		numbers = new int[R];
		isSelected = new boolean[N + 1];
		permutation(0);
	}

	static void permutation(int cnt) {
		if (cnt == R) {
			for (int i = 0; i < R; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i <= N; i++) {// i: 시도하는 숫자
			if (isSelected[i])
				continue;
			numbers[cnt] = i;
			isSelected[i] = true;

			permutation(cnt + 1);

			isSelected[i] = false;
		}
	}
}