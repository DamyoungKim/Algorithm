package com.swexpertacademy.D4;

import java.util.Scanner;

public class Solution_11545_틱택톰2 {
	static char[][] arr;
	static int cntX, cntO;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int check = 0;
		boolean finish = true;
		arr = new char[4][4];

		for (int t = 1; t <= T; t++) {
			finish = true;
			for (int i = 0; i < 4; i++) {
				String s = sc.next();
				for (int j = 0; j < 4; j++) {
					arr[i][j] = s.charAt(j);
					if (finish && arr[i][j] == '.') {
						finish = false;
					}
				}
			}
			check = cross1();
			
			if(check == 0) {
				check = cross2();
			}
			
			if(check == 0) {
				for (int i = 0; i < 4; i++) {
					check = row(i);
					if (check != 0)
						break;
					check = col(i);
					if (check != 0)
						break;
					
				}
			}
			System.out.print("#" + t + " ");
			if(check == 1) {
				System.out.println("O won");
			}else if(check == -1) {
				System.out.println("X won");
			}else if(check == 0) {
				if(finish) System.out.println("Draw");
				if(!finish) System.out.println("Game has not completed");
			}
		}

	}

	private static int row(int c) {
		int cnt = 0;
		while (true) {
			if (cnt == 4) {
				cntX = 0;
				cntO = 0;
				return 0;
			}
			if (arr[cnt][c] == '.') {
				cntX = 0;
				cntO = 0;
				return 0;
			}
			
			if (arr[cnt][c] == 'T') {
				cntX++;
				cntO++;
			} else if (arr[cnt][c] == 'O') {
				cntO++;
			} else if (arr[cnt][c] == 'X') {
				cntX++;
			}
			if (cntO == 4) {
				cntX = 0;
				cntO = 0;
				return 1;
			}
			if (cntX == 4) {
				cntX = 0;
				cntO = 0;
				return -1;
			}
			cnt++;
		}
	}

	private static int col(int r) {
		int cnt = 0;
		while (true) {
			if (cnt == 4) {
				cntX = 0;
				cntO = 0;				
				return 0;
			}
			if (arr[r][cnt] == '.') {
				cntX = 0;
				cntO = 0;				
				return 0;
			}
			
			if (arr[r][cnt] == 'T') {
				cntX++;
				cntO++;
			} else if (arr[r][cnt] == 'O') {
				cntO++;
			} else if (arr[r][cnt] == 'X') {
				cntX++;
			}
			if (cntO == 4) {
				cntX = 0;
				cntO = 0;
				return 1;
			}
			if (cntX == 4) {
				cntX = 0;
				cntO = 0;
				return -1;
			}
			cnt++;
		}
	}

	private static int cross1() {
		int r = 0;
		int c = 0;

		while (true) {
			if (r == 4) {
				cntX = 0;
				cntO = 0;
				return 0;
			}
			if (arr[r][c] == '.') {
				cntX = 0;
				cntO = 0;
				return 0;
			}
			
			if (arr[r][c] == 'T') {
				cntX++;
				cntO++;
			} else if (arr[r][c] == 'O') {
				cntO++;
			} else if (arr[r][c] == 'X') {
				cntX++;
			}
			if (cntO == 4) {
				cntX = 0;
				cntO = 0;
				return 1;
			}
			if (cntX == 4) {
				cntX = 0;
				cntO = 0;
				return -1;
			}
			r++;
			c++;
		}

	}

	private static int cross2() {
		int r = 0;
		int c = 3;

		while (true) {
			if (r == 4) {
				cntX = 0;
				cntO = 0;				
				return 0;
			}
			if (arr[r][c] == '.') {
				cntX = 0;
				cntO = 0;				
				return 0;
			}
			
			if (arr[r][c] == 'T') {
				cntX++;
				cntO++;
			} else if (arr[r][c] == 'O') {
				cntO++;
			} else if (arr[r][c] == 'X') {
				cntX++;
			}
			if (cntO == 4) {
				cntX = 0;
				cntO = 0;
				return 1;
			}
			if (cntX == 4) {
				cntX = 0;
				cntO = 0;
				return -1;
			}
			r++;
			c--;
		}
	}
}
