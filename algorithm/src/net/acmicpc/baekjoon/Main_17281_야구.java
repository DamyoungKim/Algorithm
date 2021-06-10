package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17281_야구 {

	static int N, totalScore;
	static int[][] arr;
	static boolean[] selcted = new boolean[10];
	static int[] order = new int[10];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][10];
		StringTokenizer st = null;

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < 10; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		selcted[1] = true;
		order[4] = 1;
		solve(1);
		System.out.println(totalScore);

	}

	private static void solve(int cnt) {
		if (cnt == 4)
			cnt++;

		if (cnt == 10) {
			play(1, 1, 0);
			return;
		}
		for (int i = 1; i < 10; i++) {
			if (selcted[i])
				continue;
			selcted[i] = true;
			order[cnt] = i;
			solve(cnt + 1);
			selcted[i] = false;
		}
	}

	private static void play(int inning, int first, int score) {
		if (inning == N + 1) {
			totalScore = totalScore > score ? totalScore : score;
			return;
		}
		int out = 0;
		int[] base = new int[4];
		while (out != 3) {
			int hitter = order[first];
			int mode = arr[inning][hitter];
			switch (mode) {
			case 0:
				out++;
				break;
			case 1:
				if (base[3] == 1) {
					base[3] = 0;
					score++;
				}
				if (base[2] == 1) {
					base[2] = 0;
					base[3] = 1;
				}
				if (base[1] == 1) {
					base[1] = 0;
					base[2] = 1;
				}

				base[1] = 1;

				break;
			case 2:
				if (base[3] == 1) {
					base[3] = 0;
					score++;
				}
				if (base[2] == 1) {
					base[2] = 0;
					score++;
				}
				if (base[1] == 1) {
					base[1] = 0;
					base[3] = 1;
				}

				base[2] = 1;

				break;
			case 3:
				if (base[3] == 1) {
					base[3] = 0;
					score++;
				}
				if (base[2] == 1) {
					base[2] = 0;
					score++;
				}
				if (base[1] == 1) {
					base[1] = 0;
					score++;
				}

				base[3] = 1;
				break;
			case 4:
				int sum = 0;
				score++;
				for (int i = 1; i < 4; i++) {
					sum += base[i];
					base[i] = 0;
				}
				score += sum;
				break;
			}
			first++;
			first %= 10;
			if (first == 0)
				first = 1;
		}

		play(inning + 1, first, score);

	}

}