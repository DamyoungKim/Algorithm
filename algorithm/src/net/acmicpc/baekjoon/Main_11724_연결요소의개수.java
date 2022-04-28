package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11724_연결요소의개수 {
//	static int N, M;
//	static class Edge implements Comparable<Edge> {
//		int from;
//		int to;
//		public Edge(int from, int to) {
//			this.from = from;
//			this.to = to;
//		}
//		
//		public int compareTo(Edge that) {
//			return this.from - that.from;
//		}
//	}
//	static Edge[] E;
//	static int[] cnt = new int[1001];
//	static boolean[] visited = new boolean[1001];
//	public static void main(String[] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//		E = new Edge[M * 2 + 1];
//		for (int i = 0; i < M * 2 + 1; i++) {
//			E[i] = new Edge(Integer.MAX_VALUE, Integer.MAX_VALUE);
//		}
//		for (int i = 0; i < M; i++) {
//			st = new StringTokenizer(br.readLine());
//			E[i].from = Integer.parseInt(st.nextToken());
//			E[i].to = Integer.parseInt(st.nextToken());
//			E[i + M].from = E[i].to;
//			E[i + M].to = E[i].from;
//		}
//		Arrays.sort(E);
//		M *= 2;
//		for (int i = 0; i < M; i++) {
//			cnt[E[i].from]++;
//		}
//		
//		for (int i = 1; i <= N; i++) {
//			cnt[i] += cnt[i - 1];
//		}
//		int ans = 0;
//		for (int i = 1; i <= N; i++) {
//			if (visited[i]) continue;
//			ans++;
//			dfs(i);
//			
//		}
//		System.out.println(ans);
//	}
//	private static void dfs(int cur) {
//		visited[cur] = true;
//		for (int i = cnt[cur - 1]; i < cnt[cur]; i++) {
//			int next = E[i].to;
//			if (visited[next]) continue;
//			dfs(next);
//		}
//	}
	
//	static int N, M;
//	static ArrayList<Integer>[] adj = new ArrayList[2000001];
//	static boolean[] visited = new boolean[1001];
//	public static void main(String[] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//		for (int i = 0; i < M; i++) {
//			st = new StringTokenizer(br.readLine());
//			int from = Integer.parseInt(st.nextToken());
//			int to = Integer.parseInt(st.nextToken());
//			if (adj[from] == null) {
//				adj[from] = new ArrayList<>();
//			}
//			adj[from].add(to);
//			if (adj[to] == null) {
//				adj[to] = new ArrayList<>();
//			}
//			adj[to].add(from);
//		}
//		int ans = 0;
//		for (int i = 1; i <= N; i++) {
//			if (visited[i]) continue;
//			ans++;
//			if (adj[i] == null) continue;
//			dfs(i);
//			
//		}
//		System.out.println(ans);
//	}
//	private static void dfs(int cur) {
//		visited[cur] = true;
//		for (int i = 0; i < adj[cur].size(); i++) {
//			int next = adj[cur].get(i);
//			if (visited[next]) continue;
//			dfs(next);
//		}
//	}
	
	static int N, M;
	static ArrayList<Integer>[] adj;
	static boolean[] visited = new boolean[1001];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adj[from].add(to);
			adj[to].add(from);
		}
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			if (visited[i]) continue;
			ans++;
			dfs(i);
			
		}
		System.out.println(ans);
	}
	private static void dfs(int cur) {
		visited[cur] = true;
		for (int i = 0; i < adj[cur].size(); i++) {
			int next = adj[cur].get(i);
			if (visited[next]) continue;
			dfs(next);
		}
	}

}
