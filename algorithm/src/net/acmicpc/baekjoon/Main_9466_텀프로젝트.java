package net.acmicpc.baekjoon;
import java.util.*;
import java.io.*;
public class Main_9466_텀프로젝트 {
	static int n;
	static int[] adj, check;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			adj = new int[n + 1];
			visited = new boolean[n + 1];
			check = new int[n + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				adj[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 1; i <= n; i++) {
				if (i == adj[i]) {
					visited[i] = true;
					check[i] = 1;
				}
			}
			
			for (int i = 1; i <= n; i++) {
				if (check[i] != 0) continue;
				if (dfs(i ,i) == 1) check[i] = 1;
				visited[i] = false;
			}
			int ans = 0;
			for (int i = 1; i <= n; i++) {
				if (check[i] != 1) ans++;
			}
			sb.append(ans);
			sb.append('\n');
		}
		System.out.println(sb);
	}
	private static int dfs(int cur, int start) {
		visited[cur] = true;
		int next = adj[cur];
		
		
		if (next == start) return 1;
		if (check[next] != 0) return -1;
		if (visited[next]) return 0;
		
		
		int result = dfs(next, start);
		if (result == 1) {
			check[next] = 1;
			visited[next] = false;
			return 1;
		} else if (result == -1) {
			check[next] = -1;
			return -1;
		}
		visited[next] = false;
		return 0;
	}

}
