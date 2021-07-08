package net.acmicpc.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1697_숨바꼭질 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		Queue<Integer> q = new LinkedList<>();
		
		q.offer(N);
		boolean[] visited = new boolean[100001];
		int result = -1;
		while (!q.isEmpty()) {
			int size = q.size();
			result++;
			for(int s = 0; s < size; s++) {
				int temp = q.poll();
				if(temp == K) {
					System.out.println(result);
					return;
				}
				if(temp + 1 <= 100000 && !visited[temp + 1]) {
					q.offer(temp + 1);
					visited[temp + 1] = true;
				}
				if(temp - 1 >= 0 && !visited[temp - 1]) {
					q.offer(temp - 1);
					visited[temp - 1] = true;
				}
				if(temp * 2 <= 100000 && !visited[temp * 2]) {
					q.offer(temp * 2);
					visited[temp * 2] = true;
				}
			}
		}

	}

}
