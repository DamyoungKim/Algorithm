package com.swexpertacademy.D3;

import java.util.Scanner;

public class Solution_D3_1289_원재의메모리구하기 {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int test_case = 1; test_case <= T; test_case++) {
			String memory = sc.nextLine();
			char[] arr = new char[memory.length()];
			int[] memoryArr = new int[memory.length()];
			arr = memory.toCharArray();
			int count = 0;
			for (int i = 0; i < arr.length; i++) {
				if ((memoryArr[i] + 48) == (int) arr[i])
					continue;
				for (int j = i; j < arr.length; j++) {
					memoryArr[j] = (int) arr[i] - 48;
				}
				count++;
			}
			System.out.println("#" + test_case + " " + count);
		}
	}
}
