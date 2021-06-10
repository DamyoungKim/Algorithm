package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_8320_직사각형을만드는방법 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		for(int i = 1; i <= n; i++) {
			for(int j = i; j <= n; j++) {
				if(i * j > n) continue;
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
