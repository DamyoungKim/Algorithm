package kr.co.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_1863_종교 {
	static int N, M;
	static int[] parents;
	static boolean[] roots;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		if (M == 0) {
			System.out.println(N);
			return;
		}

		parents = new int[N + 1];
		roots = new boolean[N + 1];

		makeSet();

		int result = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			unionSet(a, b);
		}
		for (int i = 1; i <= N; i++) {
			if (parents[i] == i)
				result++;
		}
		System.out.println(result);
	}

	private static boolean unionSet(int a, int b) {
		// TODO Auto-generated method stub
		int aRoot = findSet(a);
		int bRoot = findSet(b);

		if (aRoot == bRoot)
			return false;
		parents[bRoot] = aRoot;
		return true;

	}

	private static int findSet(int a) {
		// TODO Auto-generated method stub
		if (parents[a] == a)
			return a;

		return parents[a] = findSet(parents[a]);
	}

	private static void makeSet() {
		// TODO Auto-generated method stub
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
}
