package com.swexpertacademy.D4;

import java.util.Scanner;

public class Solution_11545_틱택톰 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		boolean check = false;

		char[][] arr = new char[4][4];

		for (int t = 1; t <= T; t++) {
			int totalCnt = 0;
			for (int i = 0; i < 4; i++) {
				String s = sc.next();
				for (int j = 0; j < 4; j++) {
					arr[i][j] = s.charAt(j);
				}
			}

			for (int i = 0; i < 4; i++) {
				totalCnt++;
				int cntX = 0;
				int cntO = 0;
				int cnt = 0;
				char start = arr[i][0];
				if (start == 'T') {
					start = arr[i][1];
					cntX++;
					cntO++;
					cnt++;
				}

				while (cnt != 4 && arr[i][cnt] != '.') {
					if (start == 'X') {
						if (arr[i][cnt] == 'O')
							break;
						cntX++;
					} else if (start == 'O') {
						if (arr[i][cnt] == 'X')
							break;
						cntO++;
					}

					cnt++;
				}
				if (cntX == 4) {
					check = true;
					System.out.println("X won");
					continue;
				} else if (cntO == 4) {
					check = true;
					System.out.println("O won");
					continue;
				}

			}
			if (check)
				continue;
			for (int i = 0; i < 4; i++) {
				totalCnt++;
				int cntX = 0;
				int cntO = 0;
				int cnt = 0;
				char start = arr[0][i];
				if (start == 'T') {
					start = arr[1][i];
					cntX++;
					cntO++;
					cnt++;
				}

				while (cnt != 4 & arr[cnt][i] != '.') {
					if (start == 'X') {
						if (arr[cnt][i] == 'O')
							break;
						cntX++;
					} else if (start == 'O') {
						if (arr[cnt][i] == 'X')
							break;
						cntO++;
					}

					cnt++;
				}
				if (cntX == 4) {
					check = true;
					System.out.println("X won");
					continue;
				} else if (cntO == 4) {
					check = true;
					System.out.println("O won");
					continue;
				}

			}
			if (check)
				continue;
			for (int i = 0; i < 4; i += 4) {
				totalCnt++;
				int cntX = 0;
				int cntO = 0;
				int cnt = 0;
				char start = arr[0][i];
				if (start == 'T') {
					start = arr[1][i + 1];
					cntX++;
					cntO++;
					cnt++;
					i++;
				}

				while (cnt != 4 && arr[cnt][i] != '.') {
					if (start == 'X') {
						if (arr[cnt][i] == 'O')
							break;
						cntX++;
						i++;
					} else if (start == 'O') {
						if (arr[cnt][i] == 'X')
							break;
						cntO++;
						i++;
					}
					cnt++;
				}

				if (cntX == 4) {
					check = true;
					System.out.println("X won");
					continue;
				} else if (cntO == 4) {
					check = true;
					System.out.println("O won");
					continue;
				}
			}

			if (check)
				continue;
			for (int i = 3; i >= 0; i -= 4) {
				totalCnt++;
				int cntX = 0;
				int cntO = 0;
				int cnt = 0;
				;
				char start = arr[0][i];
				if (start == 'T') {
					start = arr[1][i - 1];
					cntX++;
					cntO++;
					cnt++;
					i--;
				}

				while (cnt != 4 && arr[cnt][i] != '.') {
					if (start == 'X') {
						if (arr[cnt][i] == 'O')
							break;
						cntX++;
						i--;
					} else if (start == 'O') {
						if (arr[cnt][i] == 'X')
							break;
						cntO++;
						i--;
					}
					cnt++;
				}

				if (cntX == 4) {
					check = true;
					System.out.println("X won");
					continue;
				} else if (cntO == 4) {
					check = true;
					System.out.println("O won");
					continue;
				}
			}
			if (check)
				continue;

			System.out.println("Draw");

		}
	}

}
