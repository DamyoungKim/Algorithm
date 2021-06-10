package com.swexpertacademy.D3;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_1873_상호의배틀필드 {
	static int xIndex;
	static int yIndex;
	static char[][] arr;
	static char dir;
	static int W, H;
	static int x, y;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			H = sc.nextInt();
			W = sc.nextInt();
			arr = new char[H][W];

			for (int i = 0; i < H; i++) {
				String s = sc.next();

				for (int j = 0; j < W; j++) {
					arr[i][j] = s.charAt(j);
					if (arr[i][j] == '<' || arr[i][j] == 'v' || arr[i][j] == '>' || arr[i][j] == '^') {
						xIndex = j;
						yIndex = i;
						dir = arr[i][j];
					}
				}
			}
				int play = sc.nextInt();
				String playGame = sc.next();
				char[] playArr = new char[play];
				for(int i = 0; i < play; i++) {
					playArr[i] = playGame.charAt(i);
				}
				int count = 0;
				while (count < play) {
					if (playArr[count] != 'S')
						move(playArr[count]);
					else
						shoot(dir);
					count++;
				}
				System.out.print("#" + t + " ");
				for(int i = 0; i < H; i++) {
					for (int j = 0; j < W; j++) {
						System.out.print(arr[i][j]);
					}
					System.out.println();
				}
			}
		}

	static private void move(char c) {
		switch (c) {
		case 'L':
			dir = '<';
			if (xIndex - 1 < 0 || arr[yIndex][xIndex - 1] == '-' || arr[yIndex][xIndex - 1] == '*'
					|| arr[yIndex][xIndex - 1] == '#') {
				arr[yIndex][xIndex] = dir;
				break;
			}
			arr[yIndex][xIndex] = '.';
			xIndex = xIndex - 1;
			arr[yIndex][xIndex] = dir;

			break;
		case 'D':
			dir = 'v';
			if (yIndex + 1 >= H || arr[yIndex + 1][xIndex] == '-' || arr[yIndex + 1][xIndex] == '*'
					|| arr[yIndex + 1][xIndex] == '#') {
				arr[yIndex][xIndex] = dir;
				break;
			}
			arr[yIndex][xIndex] = '.';
			yIndex = yIndex + 1;
			arr[yIndex][xIndex] = dir;

			break;
		case 'R':
			dir = '>';
			if (xIndex + 1 >= W || arr[yIndex][xIndex + 1] == '-' || arr[yIndex][xIndex + 1] == '*'
					|| arr[yIndex][xIndex + 1] == '#') {
				arr[yIndex][xIndex] = dir;
				break;
			}
			arr[yIndex][xIndex] = '.';
			xIndex = xIndex + 1;
			arr[yIndex][xIndex] = dir;

			break;
		case 'U':
			dir = '^';
			if (yIndex - 1 < 0 || arr[yIndex - 1][xIndex] == '-' || arr[yIndex - 1][xIndex] == '*'
					|| arr[yIndex - 1][xIndex] == '#') {
				arr[yIndex][xIndex] = dir;
				break;
			}
			arr[yIndex][xIndex] = '.';
			yIndex = yIndex - 1;
			arr[yIndex][xIndex] = dir;

			break;
		}
	}

	static private void shoot(char c) {
		switch (c) {
		case '<':
			x = xIndex;
			while (true) {
				x--;
				if (x < 0 || arr[yIndex][x] == '#')
					break;
				if (arr[yIndex][x] == '-')
					continue;
				if (arr[yIndex][x] == '*') {
					arr[yIndex][x] = '.';
					break;
				}

			}
			break;
		case 'v':
			y = yIndex;
			while (true) {
				y++;
				if (y >= H || arr[y][xIndex] == '#')
					break;
				if (arr[y][xIndex] == '-')
					continue;
				if (arr[y][xIndex] == '*') {
					arr[y][xIndex] = '.';
					break;
				}

			}
			break;
		case '>':
			x = xIndex;
			while (true) {
				x++;
				if (x >= W || arr[yIndex][x] == '#')
					break;
				if (arr[yIndex][x] == '-')
					continue;
				if (arr[yIndex][x] == '*') {
					arr[yIndex][x] = '.';
					break;
				}

			}
			break;
		case '^':
			y = yIndex;
			while (true) {
				y--;
				if (y < 0 || arr[y][xIndex] == '#')
					break;
				if (arr[y][xIndex] == '-')
					continue;
				if (arr[y][xIndex] == '*') {
					arr[y][xIndex] = '.';
					break;
				}

			}
			break;
		}
	}
}