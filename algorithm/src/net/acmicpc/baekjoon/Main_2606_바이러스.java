package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2606_바이러스 {
	static boolean[][] arr;
	static boolean[] check;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new boolean[N + 1][N + 1];
		check = new boolean[N + 1];
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[r][c] = true;
			arr[c][r] = true;
		}
		check[1] = true;
		solve(1);
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (check[i])
				cnt++;
		}
		System.out.println(cnt - 1);
	}

	private static void solve(int r) {

		for (int i = 2; i <= N; i++) {
			if (arr[r][i] && !check[i]) {
				check[i] = true;
				solve(i);
			}
		}
	}
}