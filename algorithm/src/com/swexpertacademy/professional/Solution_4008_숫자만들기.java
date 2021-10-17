package com.swexpertacademy.professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4008_숫자만들기 {
	static int T, N, min, max;
	static int[] number;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			number = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int plus = Integer.parseInt(st.nextToken());
			int minus = Integer.parseInt(st.nextToken());
			int dot = Integer.parseInt(st.nextToken());
			int div = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				number[i] = Integer.parseInt(st.nextToken());
			}
			solve(number[0], 0, plus, minus, dot, div);
			System.out.println("#" + t + " " + (max - min));
		}
	}
	private static void solve(int val, int cnt, int plus, int minus, int dot, int div) {
		if (cnt == N - 1) {
			min = Math.min(min, val);
			max = Math.max(max, val);
			return;
		}
		
		if (plus > 0) solve(val + number[cnt + 1], cnt + 1, plus - 1, minus, dot, div); 
		
		if (minus > 0) solve(val - number[cnt + 1], cnt + 1, plus, minus - 1, dot, div);
		
		if (dot > 0) solve(val * number[cnt + 1], cnt + 1, plus, minus, dot - 1, div);
		
		if (div > 0) solve(val / number[cnt + 1], cnt + 1, plus, minus, dot, div - 1);
		
	}
}
