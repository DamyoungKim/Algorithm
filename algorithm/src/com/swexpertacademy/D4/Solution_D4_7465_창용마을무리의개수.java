package com.swexpertacademy.D4;

import java.util.Scanner;

public class Solution_D4_7465_창용마을무리의개수 {
	static int N;
	static int[] parents;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			System.out.print("#" + t + " ");
			N = sc.nextInt();
			parents = new int[N + 1];
			makeSet();
			int M = sc.nextInt();
			
			for (int i = 0; i < M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				unionSet(a, b);
			}
			if (M == 0) {
				System.out.println(N);
				continue;
			}

			int result = 0;

			for (int i = 1; i <= N; i++) {
				if (parents[i] == i)
					result++;
			}
			System.out.println(result);
		}
	}

	private static boolean unionSet(int a, int b) {
		// TODO Auto-generated method stub
		int rootA = findSet(a);
		int rootB = findSet(b);

		if (rootA == rootB)
			return false;

		parents[rootB] = rootA;

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
