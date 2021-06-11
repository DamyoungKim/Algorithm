package net.acmicpc.baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class Main_2577_숫자의개수 {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		String s = Integer.toString(A * B * C);
		int[] arr = new int[10];
		for(int i = 0; i < s.length(); i++) {
			arr[s.charAt(i) - '0']++;
		}
		
		for(int i = 0; i < 10; i++) {
			System.out.println(arr[i]);
		}
	}

}
