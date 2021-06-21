package net.acmicpc.baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class Main_10808_알파벳개수 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		int[] arr = new int['z' - 'a' + 1];
		for(int i = 0; i < s.length(); i++) {
			arr[s.charAt(i) - 'a']++;
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
