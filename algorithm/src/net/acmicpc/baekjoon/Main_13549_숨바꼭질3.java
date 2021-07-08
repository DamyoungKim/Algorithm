package net.acmicpc.baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_13549_숨바꼭질3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { N, 0 });
		int[] visited = new int[100001];
		Arrays.fill(visited, Integer.MAX_VALUE);
		visited[N] = 0;
		if(N > K) {
			System.out.println(N - K);
			return;
		}
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int pos = temp[0];
			int time = temp[1];
			if (pos == K) {
				System.out.println(visited[K]);
				return;
			}
			
			if (pos + 1 <= 100000 && time + 1 < visited[pos + 1]) {
				q.offer(new int[] { pos + 1, time + 1 });
				visited[pos + 1] = time + 1;
			}
			
			if (pos - 1 >= 0 &&  time + 1 < visited[pos - 1]) {
				q.offer(new int[] { pos - 1, time + 1 });
				visited[pos - 1] = time + 1;
			}
			
			if (pos * 2 <= 100000 &&  time < visited[pos * 2]) {
				q.offer(new int[] { pos * 2, time });
				 visited[pos * 2] = time;
			}
		}
	}

}
