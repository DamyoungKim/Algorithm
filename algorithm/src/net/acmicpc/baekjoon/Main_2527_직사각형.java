package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_2527_직사각형 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] x = new int[2];
		int[] y = new int[2];
		int[] p = new int[2];
		int[] q = new int[2];
		for (int t = 1; t <= 4; t++) {

			for (int i = 0; i < 2; i++) {
				x[i] = sc.nextInt();
				y[i] = sc.nextInt();
				p[i] = sc.nextInt();
				q[i] = sc.nextInt();
			}
			if (p[0] < x[1] || x[0] > p[1] || q[0] < y[1] || y[0] > q[1]) {
				System.out.println("d");
				continue;
			}

			if (y[0] == q[1]) {
				if (x[0] == p[1] || x[1] == p[0]) {
					System.out.println("c");
					continue;
				}

				System.out.println("b");
				continue;
			}

			if (q[0] == y[1]) {
				if (x[0] == p[1] || x[1] == p[0]) {
					System.out.println("c");
					continue;
				}

				System.out.println("b");
				continue;
			}

			if (x[0] == p[1]) {
				if (y[0] == q[1] || y[1] == q[0]) {
					System.out.println("c");
					continue;
				}

				System.out.println("b");
				continue;
			}

			if (p[0] == x[1]) {
				if (y[0] == q[1] || y[1] == q[0]) {
					System.out.println("c");
					continue;
				}

				System.out.println("b");
				continue;
			}

			System.out.println("a");
		}
	}
}