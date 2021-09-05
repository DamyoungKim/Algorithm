package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_20056_마법사상어와파이어볼 {
	static class FireBall {
		int r;
		int c;
		int m;
		int s;
		int d;

		public FireBall(int r, int c, int m, int s, int d) {
			super();
			this.r = r;
			this.c = c;
			this.m = m; // 질량
			this.s = s; // 속력
			this.d = d; // 방향
		}

		private void move() {
			int s = this.s % N;
			this.r = (this.r + dr[d] * s + N) % N;
			this.c = (this.c + dc[d] * s + N) % N;
			arr[this.r][this.c].add(this);
		}

	}

	static int N, M, K;
	static List<FireBall> list = new ArrayList<>();
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 }, dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static ArrayList<FireBall>[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = new ArrayList<>();
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			list.add(new FireBall(r, c, m, s, d));
		}
		for (int i = 0; i < K; i++) {
			move();
			setting();
		}
		int result = 0;
		for (int i = 0; i < list.size(); i++) {
			result += list.get(i).m;
		}
		System.out.println(result);
	}

	private static void move() {
		for (int i = 0; i < list.size(); i++) {
			list.get(i).move();
		}
	}

	private static void setting() {
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j].size() == 1) {
					list.add(arr[i][j].get(0));
				} else if (arr[i][j].size() >= 2) {
					fusion(i, j);
				}
				arr[i][j] = new ArrayList<>();
			}
		}
	}

	private static void fusion(int r, int c) {
		List<FireBall> temp = arr[r][c];
		int sumM = 0;
		int sumS = 0;
		int oddCnt = 0;
		int evenCnt = 0;
		for (int i = 0; i < temp.size(); i++) {
			sumM += temp.get(i).m;
			sumS += temp.get(i).s;
			if (temp.get(i).d % 2 == 0)
				evenCnt++;
			else if (temp.get(i).d % 2 == 1)
				oddCnt++;
		}

		if (sumM / 5 == 0)
			return;

		for (int j = oddCnt == 0 || evenCnt == 0 ? 0 : 1; j < 8; j += 2) {
			list.add(new FireBall(r, c, sumM / 5, sumS / temp.size(), j));
		}
	}
}
