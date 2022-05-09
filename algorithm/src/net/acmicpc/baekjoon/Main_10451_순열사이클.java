package net.acmicpc.baekjoon;

import java.io.*;
import java.util.*;

public class Main_10451_순열사이클 {
	static int T, N;
	static ArrayList<Integer>[] adj;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			adj = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				adj[i] = new ArrayList<>();
			}
			visited = new boolean[N + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				int to = Integer.parseInt(st.nextToken());
				adj[i].add(to);
			}
			
		}
	}

}
