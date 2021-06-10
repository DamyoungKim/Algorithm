package com.swexpertacademy.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_D3_1220_Magnetic {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		Stack<Integer> stack = new Stack<>();
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			for (int i = 0; i < arr.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int count = 0;
			for (int j = 0; j < arr.length; j++) {
				stack.clear();
				for (int i = 0; i < arr.length; i++) {	
					if(arr[i][j] ==0 ) continue;

					if (arr[i][j] == 1) {
						stack.push(arr[i][j]);
						continue;
					}
					if (!stack.empty() && arr[i][j] == 2) {
						stack.push(arr[i][j]);
					}
					if (!stack.empty() && arr[i][j] == 2 && stack.peek() == 1) {

						stack.push(arr[i][j]);
						continue;
					}
				}
				while (!stack.empty() && stack.peek() == 1) {
					stack.pop();
				}
				while (!stack.empty()) {
					int temp = stack.pop();
					if(stack.peek() == 2) {
						continue;
					}
					while (!stack.isEmpty() && stack.peek() != 2) {
						stack.pop();
					}
					count++;
				}
			}
			System.out.println("#" + t + " " + count);
		}
	}
}
/*
 * 7 1 0 2 0 1 0 1 0 2 0 0 0 0 0 0 0 1 0 0 1 0 0 0 0 0 1 2 2 0 0 0 0 0 1 0 0 0 2
 * 1 0 2 1 0 0 1 2 2 0 2
 */
