package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_DFS와BFS {
//	static int N, M, start;
//	static boolean[][] arr;
//	static boolean[] check;
//
//	static Queue<Integer> q = new LinkedList<>();
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		N = sc.nextInt();
//		M = sc.nextInt();
//		arr = new boolean[N + 1][N + 1];
//		check = new boolean[N + 1];
//		start = sc.nextInt();
//		for (int i = 0; i < M; i++) {
//			int from = sc.nextInt();
//			int to = sc.nextInt();
//			arr[from][to] = true;
//			arr[to][from] = true;
//		}
//		dfs(start);
//		check = new boolean[N + 1];
//		System.out.println();
//		bfs();
//
//	}
//
//	private static void dfs(int from) {
//		check[from] = true;
//		System.out.print(from + " ");
//		for(int i = 1; i <= N; i++) {
//			if(arr[from][i]) {
//				if(check[i]) continue;
//				check[i] = true; 
//				dfs(i);
//			}
//			
//		}
//	}
//
//	private static void bfs() {
//		q.offer(start);
//		check[start] = true;
//		while (!q.isEmpty()) {
//			int from = q.poll();
//			System.out.print(from + " ");
//			for (int i = 1; i <= N; i++) {
//				if (arr[from][i]) {
//					if(check[i]) continue;
//					check[i] = true;
//					q.offer(i);
//				}
//			}
//		}
//
//	}
	static int N, M, V;
	static int[][]  E = new int[10000 * 2 + 1][2];
	static int[] cnt = new int[1001];
	static boolean[] visited = new boolean[1001];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		for (int i = 0; i < 20001; i++) {
			E[i][0] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			E[i][0] = from;
			E[i][1] = to;
			E[i + M][0] = to;
			E[i + M][1] = from;
		}
		Arrays.sort(E, new Comparator<int []>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		});
		M *= 2;
		for (int i = 0; i < M; i++) {
			cnt[E[i][0]]++;
		}
		
		for (int i = 1; i <= N; i++) {
			cnt[i] += cnt[i - 1];
		}
		
		dfs(V);
		visited = new boolean[1001];
		sb.append('\n');
		bfs(V);
		System.out.println(sb);
	}

	private static void dfs(int cur) {
		sb.append(cur);
		sb.append(" ");
		visited[cur] = true;
		for (int i = cnt[cur - 1]; i < cnt[cur]; i++) {
			int next = E[i][1];
			if (visited[next]) continue;
			dfs(next);
		}
	}
	
	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start] = true;
		sb.append(start + " ");
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = cnt[cur - 1]; i < cnt[cur]; i++) {
				int next = E[i][1];
				if (visited[next]) continue;
				visited[next] = true;
				q.offer(next);
				sb.append(next + " ");
			}
		}
	}
	
}