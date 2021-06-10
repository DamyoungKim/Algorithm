package com.swexpertacademy.A;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Core {
	int r;
	int c;

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	Core(int r, int c) {
		setR(r);
		setC(c);
	}
}

public class Solution_1767_프로세서연결하기 {
	static int N, size, length, useCore, indexCnt;
	static int[][] arr;
	static boolean[] isSelected;

	static boolean[][] map;
	static List<Core> coreList = new ArrayList<>();
	static int[] dc = { 0, 1, 0, -1 };
	static int[] dr = { -1, 0, 1, 0 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			arr = new int[N][N];
			coreList.clear();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int temp = sc.nextInt();
					arr[i][j] = temp;
					if (temp == 1 && i != 0 && j != 0 && i != N - 1 && j != N - 1) {
						coreList.add(new Core(i, j));
					}
				}
			}
			size = coreList.size();
			isSelected = new boolean[size];
			if (size == 0) {
				System.out.println("#" + t + " " + 0);
				continue;
			}
			length = 0;
			useCore = 0;
			p(0);
			System.out.println("#" + t + " " + length);

		}
	}

	private static void p(int cnt) {
		if (cnt == size) {
			List<Core> listTemp = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				if (isSelected[i]) {
					listTemp.add(coreList.get(i));
				}
			}
			solve(listTemp, 0, 0);
			return;
		}

		
			isSelected[cnt] = true;
			p(cnt + 1);
	}

	private static void solve(List<Core> listTemp, int cnt, int coreCnt) {
		int totalCore = listTemp.size();

		if (cnt == totalCore) {
			if (useCore > coreCnt) {
				return;
			}
			int tempLength = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == -1) {
						tempLength++;
					}
				}
			}
			if (useCore < coreCnt) {
				useCore = coreCnt;
				length = tempLength;
			} else if (useCore == coreCnt) {
				length = length > tempLength ? tempLength : length;
			}

			return;

		}

		int startC = listTemp.get(cnt).c;
		int startR = listTemp.get(cnt).r;
		boolean check = false;
		for (int i = 0; i < 4; i++) {
			if (chk(startR, startC, i)) {
				check = true;
				setT(startR, startC, i);
				solve(listTemp, cnt + 1, coreCnt + 1);
				setF(startR, startC, i);
			} 
		}
		if(!check) {
			solve(listTemp, cnt + 1, coreCnt);
		}

	}

	private static void setT(int r, int c, int dir) {
	
		while(true) {
			r += dr[dir];
			c += dc[dir];
			if (r >= N || c >= N || r < 0 || c < 0) {
				return;
			}
			
			arr[r][c] = -1;
		}

	}

	private static void setF(int r, int c, int dir) {
	
		while(true) {
			r += dr[dir];
			c += dc[dir];
			if (r >= N || c >= N || r < 0 || c < 0) {
				return;
			}
				arr[r][c] = 0;
			
		}
	}

	private static boolean chk(int r, int c, int dir) {
		
		while(true) {
			r += dr[dir];
			c += dc[dir];
			if (r >= N || c >= N || r < 0 || c < 0) {
				return true;
			}
			if (arr[r][c] == 1 || arr[r][c] == -1) {
				return false;
			}
		}
	}
}
