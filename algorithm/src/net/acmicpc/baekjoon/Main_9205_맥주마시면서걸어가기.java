package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_9205_맥주마시면서걸어가기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		List<int[]> list;
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n + 2][n + 2];
			st = new StringTokenizer(br.readLine());
			list = new ArrayList<>();
			list.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				list.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
			}

			st = new StringTokenizer(br.readLine());
			list.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });

			for (int i = 0; i < n + 2; i++) {
				for (int j = 0; j < n + 2; j++) {
					if (i == j)
						arr[i][j] = 0;
					arr[i][j] = Math.abs(list.get(i)[0] - list.get(j)[0]) + Math.abs(list.get(i)[1] - list.get(j)[1]);
				}
			}
			if (arr[0][n + 1] <= 1000) {
				System.out.println("happy");
				continue;
			}
			int cnt = 0;
			for (int k = 0; k < n + 2; k++) {
				for (int i = 0; i < n + 2; i++) {
					if (k == i)
						continue;
					for (int j = 0; j < n + 2; j++) {
						if (k == j || i == j)
							continue;
						if (arr[i][k] > 1000 || arr[k][j] > 1000)
							continue;
//						if (arr[i][j] > arr[i][k] + arr[k][j]) {
						arr[i][j] = 0;
//						}
						
					}
				}
			}
			if (arr[0][n + 1] == 0) {
				System.out.println("happy");
			} else {
				System.out.println("sad");

			}
		}
	}

}
