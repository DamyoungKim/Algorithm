package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9252_LCS2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s1 = br.readLine();
		String s2 = br.readLine();
		int[][] arr = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					arr[i][j] = arr[i - 1][j - 1] + 1;

				} else {
					if (arr[i - 1][j] > arr[i][j - 1]) {
						arr[i][j] = arr[i - 1][j];
					} else {
						arr[i][j] = arr[i][j - 1];
					}

				}
			}
		}
		int y = s1.length();
		int x = s2.length();
		System.out.println(arr[y][x]);
		if (arr[y][x] == 0)
			return;
		Stack<Character> stack = new Stack<>();

		while (true) {
			if (arr[y][x] == 0)
				break;
			if (arr[y][x] == arr[y][x - 1])
				x--;
			else if (arr[y][x] == arr[y - 1][x])
				y--;
			else if (arr[y][x] == arr[y - 1][x - 1] + 1) {
				stack.add(s2.charAt(x - 1));
				y--;
				x--;
			}
		}

		StringBuffer sb = new StringBuffer();
		for (int i = 0, size = stack.size(); i < size; i++) {
			sb.append(stack.pop());
		}

		System.out.println(sb);
	}
}
