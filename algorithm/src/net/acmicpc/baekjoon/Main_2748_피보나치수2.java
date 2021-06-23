package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2748_피보나치수2 {
	static long[] arr = new long[91];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < 91; i++) {
			arr[i] = -1;
		}
		arr[0] = 0;
		arr[1] = 1;
		long result = solve(N);
		System.out.println(result);
	}
	private static long solve(int n) {
		if(arr[n] != -1) return arr[n];
		long a = solve(n - 1);
		long b = solve(n - 2);
		arr[n] = a + b;
		return a + b;
	}
}
