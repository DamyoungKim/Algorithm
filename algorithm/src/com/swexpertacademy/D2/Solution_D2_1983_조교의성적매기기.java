package com.swexpertacademy.D2;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D2_1983_조교의성적매기기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			double[] scores = new double[N + 1];
			double[] sortScores = new double[N + 1];

			for (int i = 1; i < N + 1; i++) {
				scores[i] = sc.nextDouble() * 0.35 + sc.nextDouble() * 0.45 + sc.nextDouble() * 0.2;
				sortScores[i] = scores[i];
			}

			Arrays.sort(sortScores);
			double per = 0;
			for (int i = 1; i < N + 1; i++) {
				if (scores[K] == sortScores[i]) {
					per = (double)i / N * 100;
				}
			}
			System.out.print("#" + t + " ");
			if (per > 90)
				System.out.println("A+");
			else if (per > 80)
				System.out.println("A0");
			else if (per > 70)
				System.out.println("A-");
			else if (per > 60)
				System.out.println("B+");
			else if (per > 50)
				System.out.println("B0");
			else if (per > 40)
				System.out.println("B-");
			else if (per > 30)
				System.out.println("C+");
			else if (per > 20)
				System.out.println("C0");
			else if (per > 10)
				System.out.println("C-");
			else if (per > 0)
				System.out.println("D0");
		}
	}
}
