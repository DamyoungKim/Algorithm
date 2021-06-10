package com.swexpertacademy.D3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D3_9280_진용이네주차타워 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<>();
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] arrN = new int[n];
			int[] arrM = new int[m];
			boolean[] map = new boolean[n];
			int[] check = new int[m];
			for (int i = 0; i < n; i++) {
				arrN[i] = sc.nextInt();
			}
			for (int i = 0; i < m; i++) {
				arrM[i] = sc.nextInt();
			}
			int sum = 0;
			for (int i = 0; i < 2 * m; i++) {
				int x = sc.nextInt();
				if (x > 0) {
					int j = 0;
					for (; j < map.length; j++) {
						if (!map[j]) {
							map[j] = true;
							sum += arrN[j] * arrM[x - 1];
							check[x - 1] = j;
							break;
						}
						if (j == map.length - 1)
							q.offer(x);
					}
				} else {
					x = Math.abs(x);
					if (!q.isEmpty()) {
						int y = q.poll();
						sum += arrN[check[x - 1]] * arrM[y - 1];
						check[y - 1] = check[x - 1];
						continue;
					}
					map[check[x - 1]] = false;
				}
			}
			System.out.println("#" + t + " " + sum);
		}
	}
}
