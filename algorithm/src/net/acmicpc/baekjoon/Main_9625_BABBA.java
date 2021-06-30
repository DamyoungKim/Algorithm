package net.acmicpc.baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class Main_9625_BABBA {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int[] A = new int[46];
		int[] B = new int[46];
		
		A[0] = 1;
		B[0] = 0;
		for(int i = 1; i <= K; i++) {
			A[i] = B[i - 1];
			B[i] = B[i - 1] + A[i - 1];
		}
		
		System.out.println(A[K] + " " + B[K]);
	}
}
