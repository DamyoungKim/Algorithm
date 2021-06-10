package com.swexpertacademy.D2;

import java.util.Scanner;

public class Solution_D2_1986_지그재그숫자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int check = 1;
			if (N % 2 == 0)
				check = -1;

			System.out.print("#" + t + " ");
			System.out.printf("%.0f", (double) N / 2 * check);
			System.out.println();
		}
	}
}
