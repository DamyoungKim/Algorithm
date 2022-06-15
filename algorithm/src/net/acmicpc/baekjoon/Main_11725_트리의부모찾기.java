package net.acmicpc.baekjoon;
import java.io.*;
import java.util.*;
public class Main_11725_트리의부모찾기 {
	static int N, root;
	static ArrayList<Integer>[] arr;
	static boolean[] visited;
	static int[] ansArr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		ansArr = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			if (from == 1) root = from;
			if (to == 1) root = to;
			arr[from].add(to);
			arr[to].add(from);
		}
		
		bfs();
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i < N + 1; i++) {
			sb.append(ansArr[i]);
			sb.append('\n');
		}
		System.out.print(sb);
	}
	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(root);
		visited[root] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 0, size = arr[cur].size(); i < size; i++) {
				int next = arr[cur].get(i);
				if (visited[next]) continue;
				q.offer(next);
				visited[next] = true;
				ansArr[next] = cur;
			}
		}
	}
}
