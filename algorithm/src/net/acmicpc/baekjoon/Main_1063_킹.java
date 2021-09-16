package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1063_킹 {
	static class Pos {
		int y;
		int x;

		public Pos(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return (char) (x + 'A') + Integer.toString(7 - y + 1);
		}
	}
	static int[] dx = { 1, -1, 0, 0, 1, -1, 1, -1 }, dy = { 0, 0, 1, -1, -1, -1, 1, 1 };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String kingPos = st.nextToken();
		String stonePos = st.nextToken();
		int N = Integer.parseInt(st.nextToken());

		int x = kingPos.charAt(0) - 'A';
		int y = 7 - (kingPos.charAt(1) - '1');

		Pos king = new Pos(y, x);

		x = stonePos.charAt(0) - 'A';
		y = 7 - (stonePos.charAt(1) - '1');

		Pos stone = new Pos(y, x);
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			switch (s) {
			case "R":
				arr[i] = 0;
				break;
			case "L":
				arr[i] = 1;
				break;
			case "B":
				arr[i] = 2;
				break;
			case "T":
				arr[i] = 3;
				break;
			case "RT":
				arr[i] = 4;
				break;
			case "LT":
				arr[i] = 5;
				break;
			case "RB":
				arr[i] = 6;
				break;
			case "LB":
				arr[i] = 7;
				break;
			}
		}

		for (int i = 0; i < N; i++) {
			int k_ny = king.y + dy[arr[i]];
			int k_nx = king.x + dx[arr[i]];

			if (k_ny >= 8 || k_nx >= 8 || k_ny < 0 || k_nx < 0)
				continue;

			if (k_ny == stone.y && k_nx == stone.x) {
				int s_ny = stone.y + dy[arr[i]];
				int s_nx = stone.x + dx[arr[i]];

				if (s_ny >= 8 || s_nx >= 8 || s_ny < 0 || s_nx < 0)
					continue;

				stone.y = s_ny;
				stone.x = s_nx;
			}
			king.y = k_ny;
			king.x = k_nx;
		}

		System.out.println(king.toString());
		System.out.println(stone.toString());
	}
}