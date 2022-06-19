package net.acmicpc.baekjoon;
import java.util.*;
import java.io.*;
public class Main_1967_트리의지름 {
	static class Edge {
		int to;
		int cost;
		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}
	static int N;
	static boolean[] visited;
	static ArrayList<Edge>[] adj;
	static int[] dist;
	static Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		if (N == 1) {
			System.out.print(0);
			return;
		}
		visited = new boolean[N + 1];
		dist = new int[N + 1];
		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adj[from].add(new Edge(to, cost));
			adj[to].add(new Edge(from, cost));
		}
			bfs(1);
			Arrays.fill(visited, false);
			int V = 0;
			int max = 0;
			for (int i = 1; i <= N; i++) {
				if (max < dist[i]) {
					V = i;
					max = dist[i];
				}
			}
			Arrays.fill(dist, 0);
			bfs(V);
			for (int i = 1; i <= N; i++) {
				if (max < dist[i]) {
					V = i;
					max = dist[i];
				}
			}
			System.out.print(max);
	}
	
	private static void bfs(int start) {
		q.offer(start);
		visited[start] = true;
		
		while (!q.isEmpty()) {
			int from = q.poll();
			for (int i = 0; i < adj[from].size(); i++) {
				int to = adj[from].get(i).to;
				int cost = adj[from].get(i).cost;
				if (visited[to]) continue;
				dist[to] = dist[from] + cost;
				q.offer(to);
				visited[to] = true;
			}
			
		}
	}

}
