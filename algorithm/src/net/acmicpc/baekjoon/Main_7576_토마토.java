package net.acmicpc.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_7576_토마토 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { 1, -1, 0, 0 };
		int M = sc.nextInt();
		int N = sc.nextInt();
		int[][] arr = new int[N][M];
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
				if (arr[i][j] == 1) {
					q.offer(new int[] { i, j , 0});
				}
			}
		}
		int cnt = 0;
		int result = 0;
		int check = 0;
		int day= 0;
		while (!q.isEmpty()) {
			int qSize = q.size();
			while (qSize != cnt) {
				int[] temp = q.poll();
				for (int k = 0; k < 4; k++) {
					day = temp[2];
					int x = dx[k] + temp[1];
					int y = dy[k] + temp[0];
					
					if (x < 0 || y < 0 || x >= M || y >= N || arr[y][x] == -1 || arr[y][x] == 1) {
						continue;
					}
					arr[y][x] = 1;
					q.offer(new int[] { y, x, day + 1 });
				}
				cnt++;
			}
			cnt = 0;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					day = -1;
					break;
				}
				if (day == -1)
					break;
			}
		}
		System.out.println(day);
	}
}