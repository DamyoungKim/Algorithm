package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2846_오르막길 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0;
		int end = 0;
		int result = 0;
		for(int i = 0; i < N - 1; i++) {
			if(arr[i + 1] > arr[i]) {
				start = arr[i];
				while(true) {
					if(i + 1 == N - 1) {
						end = arr[N - 1];
						break;
					}
					end = arr[++i];
					if(arr[i + 1] <= arr[i]) break;
				}
				int cal = end - start;
				result = result > cal ? result : cal;
			}
		}
		System.out.println(result);
	}
}