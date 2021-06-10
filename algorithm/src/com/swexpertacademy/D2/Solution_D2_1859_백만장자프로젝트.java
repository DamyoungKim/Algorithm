package com.swexpertacademy.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1859_백만장자프로젝트 {
	static int day, result;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb =new StringBuffer();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			day = Integer.parseInt(br.readLine());
			arr = new int[day];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int max = arr[day - 1];
			long sum = 0;
			for (int i = day - 1; i >= 0; i--) {
				if (arr[i] > max) {
					max = arr[i];
				} else {
					sum += (max - arr[i]);
				}
			}
			sb.append("#" + t + " " + sum + "\n");
		}
		
		System.out.println(sb);
	}
}
