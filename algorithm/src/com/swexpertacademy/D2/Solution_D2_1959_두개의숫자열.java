package com.swexpertacademy.D2;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D2_1959_두개의숫자열 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			int[] Ai = new int[N > M ? N : M];
			int[] Bj = new int[N > M ? N : M];

			for (int i = 0; i < N; i++) {
				Ai[i] = sc.nextInt();
			}
			for (int i = 0; i < M; i++) {
				Bj[i] = sc.nextInt();
			}
			int[] result = new int[(N > M ? N : M)];
			for (int k = 0; k <= (N > M ? N - M : M - N); k++) {
				for (int i = k; i < (N > M ? M : N) + k; i++) {
					result[k] += Ai[i] * Bj[i];
				}
				if (k == (N > M ? N - M : M - N))
					continue;
				if (N > M) {
					System.arraycopy(Bj, k, Bj, k + 1, M);
				}
				if (N < M) {
					System.arraycopy(Ai, k, Ai, k + 1, N);
				}
			}
			Arrays.sort(result);
			System.out.println("#" + t + " " + result[result.length - 1]);
		}
	}
}
