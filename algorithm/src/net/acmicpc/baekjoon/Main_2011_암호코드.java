package net.acmicpc.baekjoon;

	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;

	public class Main_2011_암호코드 {
		static int N;
		static int[][] dp = new int[5001][2];
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			char[] arr = br.readLine().toCharArray();
			int size = arr.length;
			dp[0][0] = 1;
//			if (arr[0] == 0) {
//				System.out.println(0);
//			}
			for (int i = 0; i < size; i++ ) {
				int a = arr[i] - '0';
				if (1 <= a && a <= 9) {
					dp[i + 1][0] = dp[i][0] + dp[i][1];
					dp[i + 1][0] %= 1000000;
				}
				if (i == 0) continue;
				int b = (arr[i - 1] - '0') * 10 + a;
				if (10 <= b && b <= 26) {
					dp[i + 1][1] = dp[i - 1][0] + dp[i - 1][1];
					dp[i + 1][1] %= 1000000;
				}
			}
			System.out.println((dp[size][0] + dp[size][1]) % 1000000);
		}
	}
