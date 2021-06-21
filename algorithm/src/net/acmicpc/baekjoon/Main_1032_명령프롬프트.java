package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1032_명령프롬프트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		char[][] arr = new char[N][];
		for(int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < arr[0].length; i++) {
			boolean check = true;
			char temp = arr[0][i];
			for(int j = 1; j < N; j++) {
				if(temp != arr[j][i]) {
					check = false;
					break;
				}
			}
			if(check) sb.append(arr[0][i]);
			else sb.append('?');
		}
		

		
		System.out.println(sb);
	}
}
