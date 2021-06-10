package com.swexpertacademy.D4;

import java.util.Scanner;

public class Solution_D4_3289_서로소집합 {
	static int N;
	static int[] parents;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			parents = new int[N + 1];
			makeSet();
			StringBuffer sb = new StringBuffer();
			sb.append("#" + t + " ");
			int M = sc.nextInt();
			for (int i = 0; i < M ; i++) {
				int type = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				if (type == 0) {
					unionSet(a , b);
				} else {
					int aRoot = findSet(a);
					int bRoot = findSet(b);
					if(aRoot == bRoot) {
						sb.append(1);
					}else {
						sb.append(0);
					}
				}
			}
			System.out.println(sb);
		}
	}

	private static int findSet(int a) {
		// TODO Auto-generated method stub
		if(parents[a] == a) return a;
		
		return parents[a] = findSet(parents[a]);
	}

	private static boolean unionSet(int a, int b) {
		// TODO Auto-generated method stub
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(parents[aRoot] == parents[bRoot]) return false;
		
		parents[bRoot] =  aRoot ;
		return true;
	}

	private static void makeSet() {
		// TODO Auto-generated method stub
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
}
