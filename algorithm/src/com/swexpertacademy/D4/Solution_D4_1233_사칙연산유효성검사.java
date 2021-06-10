package com.swexpertacademy.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_1233_사칙연산유효성검사 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		String operator = "*/-+";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			boolean result = true;
			char[] arr = new char[N + 1];
			int[] check = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int MAX = st.countTokens();
				int parent = Integer.parseInt(st.nextToken());
				arr[parent] = st.nextToken().charAt(0);
				while (st.countTokens() != 0) {
					int index = Integer.parseInt(st.nextToken());
					check[index] = parent;
				}
			}
			for (int i = 2; i < check.length; i++) {
				if (check[1] == 0 && operator.indexOf(arr[check[i]]) == -1) {
					result = false;
					break;
				}
			}
			System.out.print("#" + t + " ");
			if (result)
				System.out.print("1");
			else
				System.out.print("0");
			System.out.println();
		}
	}
}
