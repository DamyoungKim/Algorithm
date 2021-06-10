package com.swexpertacademy.D2;

import java.util.Scanner;

public class Solution_D2_1945_간단한소인수분해 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int a = 0;
			int b = 0;
			int c = 0;
			int d = 0;
			int e = 0;
			while (N != 1) {
				if (N % 2 == 0) {
					N /= 2;
					a++;
				}
				if (N % 3 == 0) {
					N /= 3;
					b++;
				}
				if (N % 5 == 0) {
					N /= 5;
					c++;
				}
				if (N % 7 == 0) {
					N /= 7;
					d++;
				}
				if (N % 11 == 0) {
					N /= 11;
					e++;
				}
			}
			System.out.println("#" + t + " " + a + " " + b + " " + c + " " + d + " " + e);
		}
	}
}
