package com.swexpertacademy.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_1251_하나로 {
	static class Edge implements Comparable<Edge> {
		int from, to;
		double weight;

		public Edge(int from, int to, double weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
//			return this.weight - o.weight;
			return Double.compare(this.weight, o.weight);
		}
	}

	static int N;
	static int parents[];
	static Edge[] edgeList;

	static void make() { // 크기가 1인 단위집합을 만든다.
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}

	static int findSet(int a) {
		if (parents[a] == a)
			return a;

//		return findSet(parents[a]); // path compression 전
		return parents[a] = findSet(parents[a]); // path compression 후
	}

	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);

		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			int[][] arr = new int[2][N];
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			parents = new int[N];
			int edgeSize = N * (N - 1) / 2;
			edgeList = new Edge[edgeSize];

			for (int i = 0, cnt = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					double weight = Math.sqrt(Math.pow(arr[0][i] - arr[0][j], 2) + Math.pow(arr[1][i] - arr[1][j], 2));
					edgeList[cnt++] = new Edge(i, j, weight);
				}
			} // 간선 리스트

			// 1. 간선리스트 가중치 기준 오름차순 정렬
			Arrays.sort(edgeList);

			make();

			double sum = 0;
			int count = 0; // 선택한 간선수
			double E = Double.parseDouble(br.readLine());
			for (Edge edge : edgeList) {
				if (union(edge.from, edge.to)) { // 싸이클이 발생하지 않았다면
					sum += E*Math.pow(edge.weight,2);
					if (++count == N - 1)
						break;
				}
			}
			long result = Math.round(sum);
			System.out.println("#" + t + " " + result);
		}
	}
}
