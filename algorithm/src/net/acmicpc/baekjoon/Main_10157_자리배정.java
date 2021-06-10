package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_10157_자리배정 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int r = sc.nextInt();

		int K = sc.nextInt();
		if (c * r < K) {
			System.out.println(0);
			return;
		}
		int down = 0;
		int dir = 4;
		int sum = 0;

		int i = 0;
		int j = 1;
		while (true) {
			int x = dir % 4;
			switch (x) {
			case 0:
				sum += r + down;
				i += r + down;
				break;
			case 1:
				down--;
				sum += c + down;
				j += c + down;
				break;
			case 2:
				sum += r + down;
				i -= r + down;
				break;
			case 3:
				down--;
				sum += c + down;
				j -= c + down;
				break;
			}
			if (sum >= K) {
				int move = sum - K;
				switch (x) {
				case 0:
					i -= move;
					break;
				case 1:
					j -= move;
					break;
				case 2:
					i += move;
					break;
				case 3:
					j += move;
					break;
				}
				break;
			}
			dir++;

		}
		System.out.println(j + " " + i);
	}
}