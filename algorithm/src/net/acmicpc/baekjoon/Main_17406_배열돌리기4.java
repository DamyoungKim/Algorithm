package net.acmicpc.baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main_17406_배열돌리기4 {

	static int N, M, S;
	static int[][] arr;
	static int[] r, c, s;
	static int[] numbers;
	static boolean[] isSelected;
	static int[][] original;
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		S = sc.nextInt();
		arr = new int[N][M];
		original = new int[N][M];
		numbers = new int[S];
		isSelected = new boolean[S];
		numbers = new int[S];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
				original[i][j] = arr[i][j];
			}
		}
		r = new int[S];
		c = new int[S];
		s = new int[S];
		for (int i = 0; i < S; i++) {
			r[i] = sc.nextInt();
			c[i] = sc.nextInt();
			s[i] = sc.nextInt();
		}
		permutation(0);
		Collections.sort(list);
		System.out.println(list.get(0));
	}

	private static void rotation(int r, int c, int s) {

		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		int index = 0;
		Queue<Integer> oneQ = new LinkedList<>();
		Queue<Integer> twoQ = new LinkedList<>();
		for (int k = 0; k < 2*s + 1; k++) {
			int i = r - s - 1 + k, j = c - s - 1 + k;
			oneQ.offer(arr[i][j]);
			index = 0;
			while (index != 4) {
				int x = j + dx[index];
				int y = i + dy[index];
				if (y >= r + s - k || x >= c + s - k || y < r - s - 1 + k || x < c - s - 1 + k) {
					index++;
					continue;
				}
				twoQ.offer(arr[y][x]);
				arr[y][x] = oneQ.poll();
				oneQ.offer(twoQ.poll());
				i = y;
				j = x;
			}
			oneQ.poll();
		}
	}

	static void permutation(int cnt) {
		if (cnt == S) {
			for (int i = 0; i < S; i++) {
				rotation(r[numbers[i]], c[numbers[i]], s[numbers[i]]);
			}
			int sum = 0;
			int result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (i == 0)
						result += arr[i][j];
					else
						sum += arr[i][j];
				}
				if (i != 0) {
					result = result > sum ? sum : result;
					sum = 0;
				}
			}
			list.add(result);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arr[i][j] = original[i][j];
				}
			}
			return;
		}
		for (int i = 0; i < S; i++) {
			if (isSelected[i])
				continue;
			numbers[cnt] = i;
			isSelected[i] = true;
			permutation(cnt + 1);
			isSelected[i] = false;
		}
	}
}
