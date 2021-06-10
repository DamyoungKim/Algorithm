package com.swexpertacademy.D3;

import java.util.Scanner;

public class Solution_5356_의석이의세로로말해요 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {

			int maxLength = 0;
			char[][] arr = new char[5][];
			for (int i = 0; i < 5; i++) {
				String s = sc.next();
				int size = s.length();
				if (size > maxLength)
					maxLength = size;
				arr[i] = new char[size];
				for (int j = 0; j < size; j++) {
					
					arr[i][j] = s.charAt(j);
				}
			}
			System.out.print("#" + t + " ");
			for (int i = 0; i < maxLength; i++) {
				for (int j = 0; j < 5; j++) {

					if (i >= arr[j].length)
						continue;
					System.out.print(arr[j][i]);
				}
			}
			System.out.println();
		}
	}
	

}
