package net.acmicpc.baekjoon;
import java.util.*;
import java.io.*;
public class Main_1167_트리의지름 {
	static int N;
	static boolean[] visited;
	static ArrayList<int[]>[] adj;
	static int V, max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N + 1];
		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			while(st.hasMoreTokens()) {
				int to = Integer.parseInt(st.nextToken());
				if (to == -1) break;
				int length = Integer.parseInt(st.nextToken());
				adj[from].add(new int[] {to, length});
			}
		}
			dfs(1, 0);
			max = 0;
			Arrays.fill(visited, false);
			dfs(V, 0);
			System.out.print(max);
	}
	
	private static void dfs(int from, int totalLen) {
		if (visited[from]) return;
		visited[from] = true;
		if (totalLen > max) {
			max = totalLen;
			V = from;
		}
		for (int i = 0; i < adj[from].size(); i++) {
			int to = adj[from].get(i)[0];
			int len = adj[from].get(i)[1];
			dfs(to, totalLen + len);
		}
	}

}
