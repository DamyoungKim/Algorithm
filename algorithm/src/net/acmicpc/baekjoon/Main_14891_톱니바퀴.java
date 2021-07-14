package net.acmicpc.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_14891_톱니바퀴 {
	static int[][] arr;

	public static void main(String[] args) {
		arr = new int[5][8];

		Scanner sc = new Scanner(System.in);
		for (int i = 1; i < 5; i++) {
			String s = sc.next();
			for (int j = 0; j < 8; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}

		int K = sc.nextInt();
		int[][] rot = new int[K][2];
		for (int i = 0; i < K; i++) {
			for (int j = 0; j < 2; j++) {
				rot[i][j] = sc.nextInt();
			}

			bfs(rot[i][0], rot[i][1]);
		}
		System.out.println(arr[1][0] + arr[2][0] * 2 + arr[3][0] * 4 + arr[4][0] * 8);
	}

	private static void bfs(int start, int dir) {
		Queue<int[]> q = new LinkedList<>();
		boolean[] visited = new boolean[5];
		q.offer(new int[] { start, dir });
		visited[start] = true;
		while (!q.isEmpty()) {
			int temp[] = q.poll();
			int right = arr[temp[0]][2];
			int left = arr[temp[0]][6];

			if (temp[1] == 1) {
				colckwise(temp[0]);
			} else if (temp[1] == -1) {
				counterclockwise(temp[0]);
			}
			if (temp[0] - 1 > 0 && !visited[temp[0] - 1]) {
				if (left != arr[temp[0] - 1][2]) {
					q.offer(new int[] { temp[0] - 1, temp[1] * -1 });
					visited[temp[0] - 1] = true;
				}
			}

			if (temp[0] + 1 < 5 && !visited[temp[0] + 1]) {
				if (right != arr[temp[0] + 1][6]) {
					q.offer(new int[] { temp[0] + 1, temp[1] * -1 });
					visited[temp[0] + 1] = true;
				}
			}
		}
	}

	private static void colckwise(int start) {
		int last = arr[start][7];
		for (int i = 6; i >= 0; i--) {
			arr[start][i + 1] = arr[start][i];
		}
		arr[start][0] = last;
	}

	private static void counterclockwise(int start) {
		int temp = arr[start][0];
		for (int i = 0; i < 7; i++) {
			arr[start][i] = arr[start][i + 1];
		}
		arr[start][7] = temp;
	}
}
