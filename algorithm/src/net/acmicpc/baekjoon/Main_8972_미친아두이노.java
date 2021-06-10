package net.acmicpc.baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_8972_미친아두이노 {
	static class Jongsu {
		int y;
		int x;

		public Jongsu(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

		public void move(int index) {
//			arr[this.y][this.x] = '.';
			this.y += dy[index];
			this.x += dx[index];
//			arr[this.y][this.x] = 'I';
		}

	}

	static class Arduino {
		int y;
		int x;

		public Arduino(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

		public void move(int r, int c) {
			int min = Integer.MAX_VALUE;
			int tempY = 0;
			int tempX = 0;
			for (int i = 1; i <= 9; i++) {
				int ny = this.y + dy[i];
				int nx = this.x + dx[i];

				if (i == 5 || ny >= R || nx >= C || ny < 0 || nx < 0)
					continue;
				int temp = Math.abs(r - ny) + Math.abs(c - nx);
				if (min > temp) {
					min = temp;
					tempY = ny;
					tempX = nx;
				}
			}
//			arr[this.y][this.x] = '.';
			this.y = tempY;
			this.x = tempX;
//			arr[this.y][this.x] = 'R';
		}

	}

	static int R, C, cnt;
	static char[][] arr;
	static int[] dx = { 0, -1, 0, 1, -1, 0, 1, -1, 0, 1 }, dy = { 0, 1, 1, 1, 0, 0, 0, -1, -1, -1 };
	static List<Arduino> arduinoList = new ArrayList<>();
	static Jongsu jongsu;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		arr = new char[R][C];
		for (int i = 0; i < R; i++) {
			String s = sc.next();
			for (int j = 0; j < C; j++) {
				int temp = s.charAt(j);
				arr[i][j] = '.';
				if (temp == 'R') {
					arduinoList.add(new Arduino(i, j));
				} else if (temp == 'I') {
					jongsu = new Jongsu(i, j);
				}
			}
		}
		String s = sc.next();
		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			if (!solve(temp))
				return;
		}
		arrange();
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

	private static boolean solve(char index) {
		cnt++;
		index -= '0';
		jongsu.move(index);
		if (!checkJongsu()) {
			System.out.println("kraj" + " " + cnt);
			return false;
		}
		moveArduino();
		if (!checkArduino()) {
			System.out.println("kraj" + " " + cnt);
			return false;
		}
//		arrange();
		return true;
	}

	private static void arrange() {
		for (int i = 0; i < arduinoList.size(); i++) {
			Arduino arduino = arduinoList.get(i);
			arr[arduino.y][arduino.x] = 'R';
		}
		arr[jongsu.y][jongsu.x] = 'I';
	}

	private static boolean checkJongsu() {
		for (int i = 0; i < arduinoList.size(); i++) {
			Arduino arduino = arduinoList.get(i);
			if (arduino.y == jongsu.y && arduino.x == jongsu.x) {
				return false;
			}
		}
		return true;
	}

	private static void moveArduino() {
		for (int i = 0; i < arduinoList.size(); i++) {
			Arduino arduino = arduinoList.get(i);
			arduino.move(jongsu.y, jongsu.x);
		}
	}

	private static boolean checkArduino() {
		int[][] check = new int[R][C];
		boolean[][] boom = new boolean[R][C];
		List<Integer> boomList = new ArrayList<>();
		for (int i = 0; i < arduinoList.size(); i++) {
			Arduino arduino = arduinoList.get(i);
			int y = arduino.y;
			int x = arduino.x;
			if (y == jongsu.y && x == jongsu.x)
				return false;
			if (check[y][x] == 0) {
				check[y][x] = i + 1;
			} else {
				if (!boom[y][x]) {
					boomList.add(check[y][x] - 1);
					boom[y][x] = true;
				}
//				arr[y][x] = '.';
				boomList.add(i);
			}
		}
		Collections.sort(boomList);

		for (int i = boomList.size() - 1; i >= 0; i--) {
			int temp = boomList.get(i);
			arduinoList.remove(temp);
		}
		return true;
	}

}
