package net.acmicpc.baekjoon;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_1927_최소힙 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int temp = sc.nextInt();
			if (temp == 0) {
				if (pq.isEmpty()) {
					sb.append(0);
				} else {
					sb.append(pq.poll());
				}
				sb.append('\n');
			} else {
				pq.offer(temp);
			}
		}
		System.out.println(sb);
	}

}

