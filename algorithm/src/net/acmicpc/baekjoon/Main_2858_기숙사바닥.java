package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2858_기숙사바닥 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken()); 
		int B = Integer.parseInt(st.nextToken());
		int temp = 0; 
		int L = 0, W = 0; 
		int i = 1; 
		for (; i <= B; i++) {
			if (B % i != 0)
				continue;
			temp = B / i;

			if ((i * 2 + temp * 2 + 4) == R)
				break;
		}
		if (i > temp) {
			L = i;
			W = temp;
		} else {
			L = temp;
			W = i;
		}
		System.out.println((L + 2) + " " + (W + 2));
	}
}
