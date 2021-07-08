package net.acmicpc.baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main_13913_숨바꼭질4 {
	static int N, K, result;
	static int[] visited = new int[100001];
	static Queue<Integer> q = new LinkedList<>();
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();
		if(N > K) {
			sb.append(N - K);
			sb.append('\n');
			for(int i = N; i >= K; i--) {
				sb.append(i);
				sb.append(" ");
			}
			System.out.println(sb);
		}else {
			bfs();
			int index = K;
			Stack<Integer> stack = new Stack<>();
			stack.add(K);
			while(index != N) {
				stack.add(visited[index]);
				index = visited[index];
			}
			sb.append(result);
			sb.append('\n');
			while(!stack.empty()) {
				sb.append(stack.pop() + " ");
			}
			System.out.println(sb);
		}
	}

	private static void bfs() {
		Arrays.fill(visited, -1);
		visited[N] = 0;
		q.offer(N);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				int pos = q.poll();
				if (pos == K) {
					return;
				}
				
				if(pos * 2 <= 100000 && visited[pos * 2] == -1) {
					visited[pos * 2] = pos;
					q.offer(pos * 2);
				}
				
				if(pos + 1 <= 100000 && visited[pos + 1] == -1) {
					visited[pos + 1] = pos;
					q.offer(pos + 1);
				}
				
				if(pos - 1 >= 0 && visited[pos - 1] == -1) {
					visited[pos - 1] = pos;
					q.offer(pos - 1);
				}
			}
			result++;

		}

	}

}
