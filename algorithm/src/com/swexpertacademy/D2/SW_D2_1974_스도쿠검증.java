package com.swexpertacademy.D2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SW_D2_1974_스도쿠검증 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Set<Integer> base1 = new HashSet<>();
		Set<Integer> base2 = new HashSet<>();
		Set<Integer> base3 = new HashSet<>();
		for (int i = 1; i <= T; i++) {
			int[][] arr = new int[9][9];
			for (int j = 0; j < 9; j++) {
				for (int k = 0; k < 9; k++) {
					arr[j][k] = sc.nextInt();
				}		
			}
			int result = 1;
			for (int j = 0; j < 9; j++) {
				for (int k = 0; k < 9; k++) {
					base1.add(arr[j][k]);
					base2.add(arr[k][j]);
					base3.add(arr[j / 3 * 3 + k / 3][j % 3 * 3 + k % 3]);
				}
				if (base1.size() != 9 || base2.size() != 9 || base3.size() != 9) {
					result = 0;
					break;
				}
				base1.clear(); base2.clear(); base3.clear();
			}
			System.out.printf("#%d %d%n", i, result);
		}
		sc.close();
	}
}