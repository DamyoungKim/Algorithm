package net.acmicpc.baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class Main_2438_별찍기1 {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		for(int i = 1; i <= N; i++) {
			sb.append("*");
			
			System.out.println(sb);
			
		}
		
	}

}
