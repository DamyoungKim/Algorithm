package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_3040_백설공주와일곱난쟁이 {
	static int[] arr, numbers;
	static int count;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		arr = new int[9];
		numbers = new int[7];
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}

		c(0, 0);

	}

	public static void c(int cnt, int start) {
		if (cnt == 7) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += numbers[i];
			}

			if (sum == 100) {
				for (int i = 0; i < 7; i++) {
					System.out.println(numbers[i]);
				}
			}
			return;
		}

		for (int i = start; i < 9; i++) {
			numbers[cnt] = arr[i];
			c(cnt + 1, i + 1);
		}
	}
}