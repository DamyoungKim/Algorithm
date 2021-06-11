package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1157_단어공부 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();

		int[] arr = new int['Z' - 'A' + 1];

		for (int i = 0; i < s.length(); i++) {
			int temp = s.charAt(i);
			if ('a' <= temp && temp <= 'z') {
				temp -= ('a' - 'A');
			}
			arr[temp - 'A']++;
		}
		int maxCnt = 0;
		int maxIndex = 0;
		for(int i = 0; i < arr.length; i++) {
			if(maxCnt < arr[i]) {
				maxCnt = arr[i];
				maxIndex = i;
			}
		}
		
		int checkCnt = 0;
		for(int i = 0; i < arr.length; i++) {
			if(maxCnt == arr[i]) {
				checkCnt++;
			}
			if(checkCnt >= 2) {
				System.out.println("?");
				return;
			}
		}
		
		System.out.println((char) ('A' + maxIndex));
		
	}

}
