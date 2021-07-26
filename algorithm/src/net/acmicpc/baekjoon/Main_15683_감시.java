package net.acmicpc.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_15683_감시 {
	static int N, M, result = Integer.MAX_VALUE;

	static boolean[][] visited;
	static List<CCTV> list = new ArrayList<>();
	static int[] dx = { 0, 1, 0, -1 }, dy = { -1, 0, 1, 0 };

	static class CCTV {
		int y;
		int x;
		char num;

		public CCTV(int y, int x, char num) {
			super();
			this.y = y;
			this.x = x;
			this.num = num;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		char[][] arr = new char[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.next().charAt(0);
				if (arr[i][j] == '0' || arr[i][j] == '6') continue;
					list.add(new CCTV(i, j, arr[i][j]));
				
			}
		}
		solve(arr, 0);
		System.out.println(result);
	}

	private static void solve(char[][] arr, int cnt) {
		if (cnt == list.size()) {
			int count = check(arr);
			result = Math.min(result, count);
			return;
		}
		CCTV cctv = list.get(cnt);
		char[][] temp = null;
		switch (cctv.num) {
		case '1':
			for (int i = 0; i < 4; i++) {
				temp = mode1(arr, cctv.y, cctv.x, i);
				solve(temp, cnt + 1);
			}
			break;
		case '2':
			for (int i = 0; i < 2; i++) {
				temp = mode2(arr, cctv.y, cctv.x, i);
				solve(temp, cnt + 1);
			}
			break;
		case '3':
			for (int i = 0; i < 4; i++) {
				temp = mode3(arr, cctv.y, cctv.x, i);
				solve(temp, cnt + 1);
			}
			break;
		case '4':
			for (int i = 0; i < 4; i++) {
				temp = mode4(arr, cctv.y, cctv.x, i);
				solve(temp, cnt + 1);
			}
			break;
		case '5':
			temp = mode5(arr, cctv.y, cctv.x);
			solve(temp, cnt + 1);
			break;
		}

	}

	private static char[][] mode1(char[][] arr, int y, int x, int dir) {
		char[][] temp = copyArr(arr);
		switch (dir) {
		case 0:
			north(temp, y, x);
			break;
		case 1:
			east(temp, y, x);
			break;
		case 2:
			south(temp, y ,x);
			break;
		case 3:
			west(temp, y, x);
			break;
		}
		return temp;
	}

	private static char[][] mode2(char[][] arr, int y, int x, int dir) {
		char[][] temp = copyArr(arr);
		switch (dir) {
		case 0:
			north(temp, y, x);
			south(temp, y, x);
			break;
		case 1:
			east(temp, y, x);
			west(temp, y, x);
			break;
		}
		return temp;
	}

	private static char[][] mode3(char[][] arr, int y, int x, int dir) {
		char[][] temp = copyArr(arr);
		switch (dir) {
		case 0:
			north(temp, y, x);
			east(temp, y, x);
			break;
		case 1:
			east(temp, y, x);
			south(temp, y, x);
			
			break;
		case 2:
			south(temp, y, x);
			west(temp, y, x);
			break;
		case 3:
			west(temp, y, x);
			north(temp, y ,x);
			break;

		}
		return temp;
	}

	private static char[][] mode4(char[][] arr, int y, int x, int dir) {
		char[][] temp = copyArr(arr);
		switch (dir) {
		case 0:
			north(temp, y, x);
			east(temp, y, x);
			south(temp, y, x);
			break;
		case 1:
			east(temp, y, x);
			south(temp, y, x);
			west(temp, y, x);
			break;
		case 2:
			south(temp, y, x);
			west(temp, y, x);
			north(temp, y, x);
			break;
		case 3:
			east(temp, y, x);
			west(temp, y, x);
			north(temp, y, x);
			break;
		}
		return temp;
	}

	private static char[][] mode5(char[][] arr, int y, int x) {
		char[][] temp = copyArr(arr);
		south(temp, y, x);
		west(temp, y, x);
		north(temp, y, x);
		east(temp, y ,x);
		return temp;
	}

	private static char[][] copyArr(char[][] arr) {
		char[][] temp = new char[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		return temp;
	}

	private static int check(char[][] arr) {
		int temp = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == '0')
					temp++;
			}
		}
		return temp;
	}

	private static void north(char[][] arr, int y, int x) {
		for (int i = y - 1; i >= 0; i--) {
			if (arr[i][x] == '6')
				break;
			if (arr[i][x] == '0') {
				arr[i][x] = '#';
			}
		}
	}

	private static void east(char[][] arr, int y, int x) {
		for (int i = x + 1; i < M; i++) {
			if (arr[y][i] == '6')
				break;
			if (arr[y][i] == '0') {
				arr[y][i] = '#';
			}
		}
	}

	private static void south(char[][] arr, int y, int x) {

		for (int i = y + 1; i < N; i++) {
			if (arr[i][x] == '6')
				break;
			if (arr[i][x] == '0') {
				arr[i][x] = '#';
			}
		}
	}

	private static void west(char[][] arr, int y, int x) {
		for (int i = x - 1; i >= 0; i--) {
			if (arr[y][i] == '6')
				break;
			if (arr[y][i] == '0') {
				arr[y][i] = '#';
			}
		}
	}

}
