package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_17103_골드바흐파티션 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		boolean[] check = new boolean[1000000 + 1];
		for (int i = 2; i < check.length; i++) {
			if (check[i])
				continue;
			for (int j = i + i; j < check.length; j += i) {
				check[j] = true;
			}
		}
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int cnt = 0;
			for (int i = 2; i < N; i++) {
				if (!check[i]) {
					int b = N - i;
					if (i == b || b < 2)
						continue;
					if (!check[b])
						cnt++;
				}
			}
			cnt /= 2;
			if (!check[N / 2])
				cnt++;
			System.out.println(cnt);
		}
	}
}