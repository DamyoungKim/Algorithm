package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1707_이분그래프 {
	static int K, V, E;
	static ArrayList<Integer>[] adj;
	static int[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		for (int t = 1; t <= K; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			adj = new ArrayList[V + 1];
			for (int i = 1; i <= V; i++) {
				adj[i] = new ArrayList<>();
			}
			visited = new int[V + 1];
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adj[from].add(to);
				adj[to].add(from);
			}
			boolean ans = true;
			for (int i = 1; i <= V; i++) {
				if (visited[i] == 0) {
					dfs(i, 1);
				}
			}
			for (int i = 1; i <= V; i++) {
				for (int j = 0; j < adj[i].size(); j++ ) {
					if (visited[i] == visited[adj[i].get(j)]) {
						ans = false;
						break;
					}
				}
				if (!ans) break;
			}
			System.out.println(ans ? "YES" : "NO");
		}
	}
	private static void dfs(int cur, int type) {
		visited[cur] = type * -1;
		for (int i = 0; i < adj[cur].size(); i++) {
			int next = adj[cur].get(i);
			if (visited[next] == 0) {
				dfs(next, visited[cur]);
			}
		}
	}

}
