package net.acmicpc.baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class Main_1427_소트인사이드 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		
		int[] arr = new int[10];
		
		for(int i = 0; i < s.length(); i++) {
			arr[s.charAt(i) - '0']++;
		}
		StringBuffer sb = new StringBuffer();
		for(int i = 9; i >= 0; i--) {
			for(int j = 0; j < arr[i]; j++) {
				sb.append(i);
			}
		}
		
		System.out.println(sb);
	}

}