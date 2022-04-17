package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11053_가장긴증가하는부분수열 {
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		int[] arr = new int[N];
//		int[] LIS = new int[N];
//
//		for (int i = 0; i < N; i++) {
//			arr[i] = sc.nextInt();
//		}
//		int max = 1;
//		for (int i = 0; i < N; i++) {
//			LIS[i] = 1;
//			for (int j = 0; j < i; j++) {
//				if (arr[i] > arr[j] && LIS[i] < LIS[j] + 1) {
//					LIS[i] = LIS[j] + 1;
//				}
//			}
//
//			if (max < LIS[i])
//				max = LIS[i];
//		}
//
//		System.out.println(max);
//	}

	static int N;
	static int[] arr = new int[1001];
	static int[] dp = new int[1001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int max = 0;
		for (int i = 1; i <= N; i++) {
			dp[i] = 1;
			for (int j = 1; j < i; j++) {
				if (arr[i] > arr[j] && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
				}
			}
			max = Math.max(dp[i], max);
		}
		
		System.out.println(max);
	}
}
