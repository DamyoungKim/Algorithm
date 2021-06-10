package com.swexpertacademy.D4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_D4_1210_Ladder1 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("src\\com\\swexpertacademy\\D4\\input.txt"));
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[100][100];
		int[] dx = { 0, -1, 1 }; // 상, 좌, 우
		int[] dy = { -1, 0, 0 };
		int[] rx = new int[3];
		int[] ry = new int[3];
		int count = 0;
		int t = 0;
		int dir = 0; // 왼쪽 -1, 오른쪽 1, 위로 0
		while (count < 10) {
			count++;
			t = sc.nextInt();
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int xIndex = 0;
			int yIndex = 99;
			for (int j = 0; j < arr.length; j++) {
				if (arr[yIndex][j] == 2) {
					xIndex = j;
					break;
				}
			}
			while (yIndex > 0) {

				for (int i = 0; i < dx.length; i++) {
					rx[i] = xIndex + dx[i];
					ry[i] = yIndex + dy[i];
				}
				boolean oneZero = false;
				boolean twoZero = false;
				boolean oneOne = false;
				boolean twoOne = false;
				if (rx[1] < 0 || rx[2] >= arr.length) {
					if (rx[1] < 0) {
						oneZero = true;
						oneOne = true;
						twoOne = arr[ry[2]][rx[2]] == 1;
						twoZero = arr[ry[2]][rx[2]] == 0;
					}
					if (rx[2] >= arr.length) {
						twoZero = true;
						twoOne = true;
						oneZero = arr[ry[1]][rx[1]] == 0;
						oneOne = arr[ry[1]][rx[1]] == 1;
					}
				} else {
					oneZero = arr[ry[1]][rx[1]] == 0;
					twoZero = arr[ry[2]][rx[2]] == 0;
					oneOne = arr[ry[1]][rx[1]] == 1;
					twoOne = arr[ry[2]][rx[2]] == 1;
				}
				if (dir == 0 && arr[ry[0]][rx[0]] == 1 && oneZero && twoZero) {
					yIndex--;
					dir = 0;
					continue;
				}
				if (arr[ry[0]][rx[0]] == 1 && dir == 0) {
					if (rx[1] < 0) {
						if (arr[ry[2]][rx[2]] == 1) {
							xIndex = rx[2];
							dir = 1;
						}
						continue;
					}
					if (rx[2] >= arr.length) {
						if (arr[ry[1]][rx[1]] == 1) {
							xIndex = rx[1];
							dir = -1;
						}
						continue;
					}
					if (arr[ry[2]][rx[2]] == 1) {
						xIndex = rx[2];
						dir = 1;
					}
					if (arr[ry[1]][rx[1]] == 1) {
						xIndex = rx[1];
						dir = -1;
					}
					continue;
				}
				if (arr[ry[0]][rx[0]] == 1 && dir != 0 && oneZero || twoZero) {
					yIndex--;
					dir = 0;
					continue;
				}

				if (arr[ry[0]][rx[0]] == 0 && dir != 0 && oneOne && twoOne) {
					if (dir == 1) {
						xIndex = rx[2];
					}
					if (dir == -1) {
						xIndex = rx[1];
					}
				}
			}
			System.out.println("#" + t + " " + xIndex);
		}
	}
}
