package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2902_KMP는왜KMP일까 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < s.length(); i++) {
			if('A' <= s.charAt(i) && s.charAt(i) <= 'Z') sb.append(s.charAt(i));
		}
		System.out.println(sb);
	}
}
