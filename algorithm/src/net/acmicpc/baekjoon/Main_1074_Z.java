package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_1074_Z {
	static int[][] arr;
	static int N, result, count, resultI, resultJ, r, c;
	static boolean check;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		resultI = sc.nextInt();
		resultJ = sc.nextInt();
		z(1 << N, 0, 0);
		System.out.println(result);
	}

	public static void z(int n, int r, int c) {
		if(n/2 == 1) {
			if (resultI < n / 2 + r && resultJ < n / 2 + c) {
			} else if (resultI < n / 2 + r && resultJ >= n / 2 + c) {
				result += 1;
			} else if (resultI >= n / 2 + r && resultJ < n / 2 + c) {
				result += 2;
			} else if (resultI >= n / 2 + r && resultJ >= n / 2 + c) {
				result += 3;
			}
			
			return;
		}
		if (resultI < n / 2 + r && resultJ < n / 2 + c) {
			z(n / 2, r, c);
		} else if (resultI < n / 2 + r && resultJ >= n / 2 + c) {
			result += (n / 2 * n / 2) * 1;
			z(n / 2, r, c + n / 2);
		} else if (resultI >= n / 2 + r && resultJ < n / 2 + c) {
			result += (n / 2 * n / 2) * 2;
			z(n / 2, r + n / 2, c);
		} else if (resultI >= n / 2 + r && resultJ >= n / 2 + c) {
			result += (n / 2 * n / 2) * 3;
			z(n / 2, r + n / 2, c + n / 2);
		}

	}
}