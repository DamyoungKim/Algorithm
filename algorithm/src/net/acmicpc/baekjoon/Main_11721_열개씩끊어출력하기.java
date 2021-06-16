package net.acmicpc.baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class Main_11721_열개씩끊어출력하기 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		StringBuffer sb = new StringBuffer();
		for(int i = 1; i <= s.length(); i++) {
			sb.append(s.charAt(i - 1));
			if(i % 10 == 0) sb.append('\n');
		}
		System.out.println(sb);
	}

}
