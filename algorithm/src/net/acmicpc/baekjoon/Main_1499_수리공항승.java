package net.acmicpc.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1499_수리공항승 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int L = sc.nextInt();

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();

		}

		Arrays.sort(arr);
		int cnt = 1;
		int start = arr[0];
		for (int i = 1; i < N; i++) {
			if (arr[i] - start <= (L - 1)) {
				continue;
			}
			start = arr[i];
			cnt++;
		}

		System.out.println(cnt);

	}

}