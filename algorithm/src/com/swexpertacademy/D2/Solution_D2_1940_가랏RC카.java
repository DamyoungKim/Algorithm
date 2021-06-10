package com.swexpertacademy.D2;

import java.util.Scanner;

public class Solution_D2_1940_가랏RC카 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int s = 0;
			int v = 0;
			int a = 0;
			for (int i = 1; i <= N; i++) {
				int type = sc.nextInt();
				if (type != 0)
					a = sc.nextInt();
				switch (type) {
				case 0:
					s += v;
					break;
				case 1:
					v = v + a;
					s += v;
					break;
				case 2:
					v = v - a;
					if (v <= 0) {
						v = 0;
						s += 0;
					} else
						s += v;
					break;
				}
			}
			System.out.println("#" + t + " " + s);
		}
	}
}
