package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5557_1학년 {
	static int N;
	static long result;
	static int[] arr;
	static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		dp = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(result);
	}
	private static void solve(int cnt, int val) {
		if(val < 0 || val > 20) return;
		if(cnt == N - 2) {
			if(arr[N - 1] == val) result++;
			return;
		}
		solve(cnt + 1, val + arr[cnt + 1]);
		solve(cnt + 1, val - arr[cnt + 1]);
	}
}
