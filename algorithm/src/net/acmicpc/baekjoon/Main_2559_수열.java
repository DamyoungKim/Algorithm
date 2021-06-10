package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_2559_수열 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int end = K - 1;
		int start = 0;
		int sum = 0;
		for (int i = start; i <= end; i++) {
			sum += arr[i];
		}
		int temp = sum;
		while (end != N - 1) {
			temp = temp - arr[start++] + arr[++end];
			sum = Math.max(sum, temp);
		}
		System.out.println(sum);
	}

}
