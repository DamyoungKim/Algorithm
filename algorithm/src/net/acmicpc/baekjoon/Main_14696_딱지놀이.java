package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_14696_딱지놀이 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		for (int n = 0; n < N; n++) {
			int a = sc.nextInt();
			int[] A = new int[5];
			for (int i = 0; i < a; i++) {
				A[sc.nextInt()]++;
			}
			int b = sc.nextInt();
			int[] B = new int[5];
			for (int i = 0; i < b; i++) {
				B[sc.nextInt()]++;
			}
			boolean draw = true;
			for (int i = 4; i >= 1; i--) {
				if (A[i] == B[i])
					continue;

				System.out.println(A[i] > B[i] ? "A" : "B");
				draw = false;
				break;
			}
			if (draw)
				System.out.println("D");
		}
	}

}