package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1463_1로만들기 {
	static int N;
	static boolean[] visited;
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		visited = new boolean[N + 1];
		if(N == 1) {
			System.out.println(0);
			return;
		}
		q.offer(1);
		bfs();
	}

	private static void bfs() {
		int cnt = 0;
		int size = 0;
		while (!q.isEmpty()) {
			size = q.size();
			cnt++;
			for (int i = 0; i < size; i++) {
				int temp = q.poll();
				int n1 = temp * 3;
				int n2 = temp * 2;
				int n3 = temp + 1;
				if (n1 == N || n2 == N || n3 == N) {
					System.out.println(cnt);
					return;
				}
				if (n1 <= N && !visited[n1]) {
					visited[n1] = true;
					q.offer(n1);
				}
				if (n2 <= N && !visited[n2]) {
					visited[n2] = true;
					q.offer(n2);
				}

				if (n3 <= N && !visited[n3]) {
					visited[n3] = true;
					q.offer(n3);
				}
			}
		}
	}
}
