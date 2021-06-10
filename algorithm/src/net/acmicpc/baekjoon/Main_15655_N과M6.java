package net.acmicpc.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_15655_N과M6 {
	static int[] numbers;
	static int N, R;
	static StringBuilder sb;
	static int[] arr;
	static boolean[] isSlected;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		R = sc.nextInt();
		arr = new int[N];
		isSlected = new boolean[N + 1];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
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
		for (int i = start; i <= arr.length; i++) { // i: 시도하는 수
			if(isSlected[i]) continue;
			numbers[cnt] = arr[i -1];
			isSlected[i] = true;
			combination(cnt + 1, i);
			isSlected[i] = false;
		}
	}
}