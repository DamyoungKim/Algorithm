package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_2999_비밀이메일 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String s = sc.next();

		int N = s.length();

		int R = 0;
		int C = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = i; j <= N; j++) {
				if (i * j == N) {
					R = i;
					C = j;
				}
			}
		}
		char[][] arr = new char[R][C];
		int cnt = 0;
		for (int j = 0; j < C; j++) {
			for (int i = 0; i < R; i++) {
				arr[i][j] = s.charAt(cnt);
				cnt++;
			}
		}
		
		for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
				System.out.print(arr[i][j]);
				
			}
		}
	}

}