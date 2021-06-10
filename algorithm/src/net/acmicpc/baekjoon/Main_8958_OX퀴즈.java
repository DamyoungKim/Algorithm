package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_8958_OX퀴즈 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			String s = sc.next();

			char[] arr = s.toCharArray();
			int cnt = 0;
			int cntO = 0;
			int sum = 0;
			while (cnt != arr.length) {
				if (arr[cnt++] == 'O') {
					cntO++;
					sum += cntO;

				} else {
					cntO = 0;
				}
			}
			System.out.println(sum);
		}
	}

}