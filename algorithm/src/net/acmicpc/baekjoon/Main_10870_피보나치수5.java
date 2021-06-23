package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10870_피보나치수5 {
	static int[] arr = new int[21];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < 21; i++) {
			arr[i] = -1;
		}
		arr[0] = 0;
		arr[1] = 1;
		int result = solve(N);
		System.out.println(result);
	}
	private static int solve(int n) {

		if(n == 0) return arr[0];
		if(n == 1) return arr[1];
		
//		if(arr[n - 1] != -1) return arr[n - 1];
		int a = solve(n - 1);
		int b = solve(n - 2);
		
		
		return a + b;
	}
}