package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_13418_학교탐방하기 {
	static class Edge {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

	}

	static int V, E;
	static int parents[];
	static Edge[] edgeList;

	static void make() { // 크기가 1인 단위집합을 만든다.
		for (int i = 0; i <= V; i++) {
			parents[i] = i;
		}
	}

	static int findSet(int a) {
		if (parents[a] == a)
			return a;

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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		
		parents = new int[V + 1];
		edgeList = new Edge[E + 1];
		for(int i = 0; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from, to, weight);
		}
	
		
		Arrays.sort(edgeList, new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				
				return Integer.compare(o1.weight, o2.weight);
			}
		});
		make();
		
		int resultMax = 0;
		int count = 0; // 선택한 간선수
		
		for(Edge edge : edgeList) {
			if(union(edge.from, edge.to)) { // 싸이클이 발생하지 않았다면
				resultMax += edge.weight;
				if(++count == V) break;
			}
		}
		resultMax = V - resultMax;
		int resultMin = 0;
		count = 0;
		parents = new int[V + 1];
		
		Arrays.sort(edgeList, new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				return Integer.compare(o2.weight, o1.weight);
			}
		});
		
		make();
		for(Edge edge : edgeList) {
			if(union(edge.from, edge.to)) { // 싸이클이 발생하지 않았다면
				resultMin += edge.weight;
				if(++count == V) break;
			}
		}
		
		resultMin = V - resultMin;
		
		System.out.println(resultMax * resultMax - resultMin * resultMin);
	}

}
