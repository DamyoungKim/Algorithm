package com.swexpertacademy.D3;

import java.util.Scanner;

public class Solution_D3_1493_수의새로운연산2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int aI = 0;
			int aJ = 0;
			int bI = 0;
			int bJ = 0;
			for (int i = 1; i <= 10000; i++) {
				int start = 1 + i * (i - 1) / 2;
				int end = start + i - 1;
				if (start <= a && a <= end) {
					for (int j = 0; j < i; j++) {
						if (a == start + j) {
							aI = i - j;
							aJ = j + 1;
							break;
						}
					}
				}

				if (start <= b && b <= end) {
					for (int j = 0; j < i; j++) {
						if (b == start + j) {
							bI = i - j;
							bJ = j + 1;
							break;
						}
					}
				}
				if (aI != 0 && bI != 0)
					break;
			}
			System.out.println("#" + t + " " + fx(aI + bI, aJ + bJ));

		}
	}

	private static int fx(int i, int j) {
		return 1 + i * (i - 1) / 2 + j * (j - 1) / 2 + i * (j - 1);
	}
}
