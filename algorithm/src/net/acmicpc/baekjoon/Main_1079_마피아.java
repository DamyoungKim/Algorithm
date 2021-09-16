package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1079_마피아 {
	static int N, me, max;
	static int[][] arr;
	static int[] power;
	static List<Integer> list = new ArrayList<>();
	static boolean[] isAlive;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		power = new int[N];
		for(int i = 0; i < N; i++) {
			power[i] = Integer.parseInt(st.nextToken());
			list.add(i);
		}
		
		arr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		isAlive = new boolean[N];
		Arrays.fill(isAlive, true);
		me = Integer.parseInt(br.readLine());
		solve(N, 0);
		System.out.println(max);
	}
	private static void solve(int player, int cnt) {
		if (player % 2 == 1) {
			int num = day();
			if(num == me) {
				max = Math.max(cnt, max);
				return;
			}
			isAlive[num] = false;
			solve(player - 1, cnt);
			isAlive[num] = true;
		} else {
			for (int i = 0; i < N; i++) {
				if(!isAlive[i] || i == me) continue;
				isAlive[i] = false;
				setVal(i, 1);
				solve(player - 1, cnt + 1);
				setVal(i, -1);
				isAlive[i] = true;
			}
		}
		
	}
	
	private static int day() {
		int index = 0;
		int max = 0;;
		for (int i = 0; i < N; i++) {
			if(!isAlive[i]) continue;
			if(max < power[i]) {
				max = power[i];
				index = i;
			}
		}
		return index;
	}
	private static void setVal(int num, int val) {
		for (int i = 0; i < N; i++) {
			if(!isAlive[i]) continue;
			power[i] += (arr[num][i] * val);
		}
	}
}
