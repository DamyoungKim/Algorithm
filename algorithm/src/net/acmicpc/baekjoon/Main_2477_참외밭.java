package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_2477_참외밭 {
	public static void main(String[] args) {

		// TODO Auto-generated constructor stub
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int[] len = new int[6];
		int maxH = 0;
		int maxW = 0;
		int maxHIndex = 0;
		int maxWIndex = 0;
		for (int i = 0; i < 6; i++) {
			int dir = sc.nextInt();
			len[i] = sc.nextInt();
			if (dir == 1 || dir == 2) {
				if (maxW < len[i]) {
					maxW = len[i];
					maxWIndex = i;
				}
			} else {
				if (maxH < len[i]) {
					maxH = len[i];
					maxHIndex = i;
				}
			}
		}

		int xH = maxWIndex + 3;
		int xW = maxHIndex + 3;

		if (xH > 5)
			xH -= 6;
		if (xW > 5)
			xW -= 6;

		System.out.println((maxW * maxH - (len[xH] * len[xW])) * s);

	}
}