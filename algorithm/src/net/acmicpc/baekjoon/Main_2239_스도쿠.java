package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_2239_스도쿠 {
	static int[][] arr = new int[10][10];;
	static boolean[][] selectedRow = new boolean[10][10];
	static boolean[][] selectedCol = new boolean[10][10];
	static boolean[][] selectedSquare = new boolean[10][10];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= 9; i++) {
			String s = sc.next();
			for (int j = 1; j <= 9; j++) {
				arr[i][j] = s.charAt(j - 1) - '0';
			}
		}
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if (arr[i][j] == 0)
					continue;
				selectedRow[i][arr[i][j]] = true;
			}
			
			for (int j = 1; j <= 9; j++) {
				if (arr[j][i] == 0)
					continue;
				selectedCol[i][arr[j][i]] = true;
			}
		}
		int cnt = 0;
		for(int ii = 0; ii < 3; ii++) {
			for(int jj = 0; jj < 3; jj++) {
				cnt++;
				for(int i = ii * 3; i <ii * 3 + 3; i++) {
					for(int j = jj * 3; j < jj * 3 + 3; j++) {
						if(arr[i + 1][j + 1] == 0) continue;
						selectedSquare[cnt][arr[i + 1][j + 1]] = true;
					}
				}
				
				
			}
		}

			solve(1, 1);
	}

	private static boolean solve(int r, int c) {
		
		if(r==10) {
			for(int i = 1; i <= 9; i++) {
				for(int j = 1; j <= 9; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
			return true;
		}
		if(c == 10) {
			if(solve(r + 1, 1)) return true;
			return false;
		}
		
		if(arr[r][c] != 0) {
			if(solve(r, c + 1)) return true;
			return false;
		}
		for (int i = 1; i <= 9; i++) {
			if(arr[r][c] != 0 ) continue;
			int squareNumber = 3 * ((r - 1) / 3 ) + (c - 1)  / 3 + 1;
			if (selectedRow[r][i] || selectedCol[c][i])
				continue;
			if(selectedSquare[squareNumber][i]) continue;
			arr[r][c] = i;
			selectedRow[r][i] = true;
			selectedCol[c][i] = true;
			selectedSquare[squareNumber][i] = true;
			if(solve(r, c + 1)) return true;
			arr[r][c] = 0;
			selectedRow[r][i] = false;
			selectedCol[c][i] = false;
			selectedSquare[squareNumber][i] = false;
		}
		return false;
	}
}