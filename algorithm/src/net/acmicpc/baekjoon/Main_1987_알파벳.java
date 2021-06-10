package net.acmicpc.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_1987_알파벳 {
	static int R, C, cnt;
	static char[][] arr;
	static List<Character> list = new ArrayList<>();
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int result;
	static boolean[] alph = new boolean['Z' - 'A' + 1];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();
		arr = new char[R][C];
		for (int i = 0; i < R; i++) {
			String s = sc.next();
			for (int j = 0; j < C; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		solve(0, 0);

		System.out.println(result + 1);
	}

	public static boolean solve(int r, int c) {
		//list.add(arr[r][c]); list 속도 저하
		 alph[arr[r][c] - 'A'] = true;
		for (int i = 0; i < 4; i++) {
			int x = c + dx[i];
			int y = r + dy[i];
			if (x >= C || y >= R || x < 0 || y < 0 || alph[arr[y][x] - 'A']  /*list.indexOf(arr[y][x]) != -1*/)
				continue;
			cnt++;
		
			if (!solve(y, x)) {

				//list.remove(list.size() - 1);
				 alph[arr[y][x] - 'A'] = false;
				cnt--;
			}

		}
//		if (cnt > result) {
//			result = cnt;
//		}
		result = result > cnt ? result : cnt;
		return false;
	}
}