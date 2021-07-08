package net.acmicpc.baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_12851_숨바꼭질2 {
	static int N, K, cnt = -1, wayCnt;
	static int[] visited = new int[100001];
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();

		visited[N] = 0;
		q.offer(N);
		if (N == K) {
			cnt = 0;
			wayCnt = 1;
		} else {
			bfs();
		}
		System.out.println(cnt);
		System.out.println(wayCnt);
	}

	private static void bfs() {
		boolean findedBro = false;
		Arrays.fill(visited, Integer.MAX_VALUE);
		while (!q.isEmpty()) {
			int size = q.size();
			cnt++;
			for (int s = 0; s < size; s++) {
				int temp = q.poll();
				if (temp == K) {
					wayCnt++;
					findedBro = true;
				}
				if (temp - 1 >= 0 && cnt + 1 <= visited[temp - 1] && !findedBro) {
					q.offer(temp - 1);
					visited[temp - 1] = cnt + 1;
				}

				if (temp + 1 <= 100000 && cnt + 1 <= visited[temp + 1] && !findedBro) {
					q.offer(temp + 1);
					visited[temp + 1] = cnt + 1;
				}

				if (temp * 2 <= 100000 && cnt + 1 <= visited[temp * 2] && !findedBro) {
					q.offer(temp * 2);
					visited[temp * 2] = cnt + 1;
				}
			}
			if (findedBro)
				break;
		}
	}

}
