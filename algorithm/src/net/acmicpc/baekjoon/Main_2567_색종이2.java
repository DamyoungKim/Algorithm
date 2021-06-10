package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_2567_색종이2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] arr = new int[100][100];
		int count = 0;
		for (int t = 1; t <= T; t++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int i = y; i < y + 10; i++) {
				for (int j = x; j < x + 10; j++) {
					if (arr[i][j] == 1) {
						continue;
					}
					arr[i][j] = 1;
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] == 1) {
					int checkU = 0;
					int checkD = 0;
					int checkL = 0;
					int checkR = 0;
					if (i + 1 >= arr.length)
						checkD++;
					if (i - 1 < 0)
						checkU++;
					if (j + 1 >= arr.length)
						checkR++;
					if (j - 1 < 0)
						checkL++;
					if (checkD + checkU + checkL + checkR == 2) {
						count = count + 2;
						continue;
					}
					if (checkD + checkU + checkL + checkR == 1) {
						count++;
						if (checkD == 1) {
							if (arr[i - 1][j] + arr[i][j + 1] + arr[i][j - 1] == 2)
								count++;
						} else if (checkU == 1) {
							if (arr[i + 1][j] + arr[i][j + 1] + arr[i][j - 1] == 2)
								count++;
						} else if (checkR == 1) {
							if (arr[i - 1][j] + arr[i + 1][j] + arr[i][j - 1] == 2)
								count++;
						} else if (checkL == 1) {
							if (arr[i + 1][j] + arr[i - 1][j] + arr[i][j + 1] == 2)
								count++;
						}
						continue;
					}
				}
				if (arr[i][j] == 1 && arr[i + 1][j] + arr[i - 1][j] + arr[i][j + 1] + arr[i][j - 1] < 4) {
					if (arr[i + 1][j] + arr[i - 1][j] + arr[i][j + 1] + arr[i][j - 1] == 2) {
						count = count + 2;
						continue;
					}
					count++;
				}
			}
		}

		System.out.println(count);
	}
}