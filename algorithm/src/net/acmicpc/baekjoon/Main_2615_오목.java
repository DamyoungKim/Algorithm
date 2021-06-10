package net.acmicpc.baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main_2615_오목 {
	static int[][] map = new int[19][19];
	static int[] dx = { 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1 };
	static boolean[][] check = new boolean[19][19];
	static int cnt = 1;
	static List<int[]> list = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (map[i][j] == 0)
					continue;
				if (find(i, j)) {
					System.out.println(map[i][j]);

					Collections.sort(list, new Comparator<int[]>() {

						@Override
						public int compare(int[] o1, int[] o2) {
							// TODO Auto-generated method stub
							return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];
						}

					});
					System.out.println((list.get(0)[0] + 1) + " " + (list.get(0)[1] + 1));
					return;
				}
				list.clear();
				cnt = 1;
			}
		}

		System.out.println(0);

	}

	public static boolean find(int i, int j) {
		for (int k = 0; k < 4; k++) {
			int x = j + dx[k];
			int y = i + dy[k];
			if (x >= 19 || y >= 19 || x < 0 || y < 0 || map[y][x] != map[i][j])
				continue;
			list.add(new int[] { i, j });
			if (solve(y, x, k)) {
				int reverseX = j + dx[k] * -1;
				int reverseY = i + dy[k] * -1;
				if (reverseX >= 19 || reverseY >= 19 || reverseX < 0 || reverseY < 0 ) {
					return true;
				} 
				if ( map[reverseY][reverseX] == 0 ||  map[reverseY][reverseX] != map[i][j]) {
					return true;
				} else {
					list.clear();
					return false;
				}
			}
		}
		return false;

	}

	public static boolean solve(int i, int j, int k) {
		int x = j + dx[k];
		int y = i + dy[k];
		if (cnt == 4) {
			if (x >= 19 || y >= 19 || x < 0 || y < 0) {
				list.add(new int[] { i, j });
				return true;
			}
			if (map[i][j] != map[y][x]) {
				list.add(new int[] { i, j });
				return true;
			} else {
				return false;
			}
		}

		if (x < 19 && y < 19 && x >= 0 && y >= 0 && map[y][x] == map[i][j]) {
			cnt++;
			list.add(new int[] { i, j });
			if (solve(y, x, k))
				return true;
		}
		cnt = 1;
		list.clear();
		return false;
	}
}