package com.swexpertacademy.professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1952_수영장 {
	static int T, min;
	static int[] cost, month;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cost = new int[4];
			month = new int[12];
			min = Integer.MAX_VALUE;
			for (int i = 0; i < 4; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				month[i] = Integer.parseInt(st.nextToken());
			}
			
			solve(0, 0);
			
			if (min > cost[3]) min = cost[3];
			
			System.out.println("#" + t + " " + min);
		}
	}

	private static void solve(int cnt, int val) {
		if (cnt >= 12) {
			min = Math.min(val, min);
			return;
		}
		if (min <= val) return;
		
		solve(cnt + 1, val + month[cnt] * cost[0]);
		
		if (month[cnt] != 0) {
			solve(cnt + 1, val + cost[1]);
			solve(cnt + 3, val + cost[2]);
		}
	}

}
/*
1
10 40 100 300
0 0 2 9 1 5 0 0 0 0 0 0

*/