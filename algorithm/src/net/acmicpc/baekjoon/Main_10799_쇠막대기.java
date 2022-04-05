package net.acmicpc.baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Main_10799_쇠막대기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack = new Stack<>();
		char[] arr = sc.next().toCharArray();
		int ans = 0;
		for (int i = 0, size = arr.length; i < size; i++) {
			if (arr[i] == '(') {
				stack.add(arr[i]);
			} else if (arr[i] == ')') {
				if (arr[i - 1] == '(') {
					stack.pop();
					ans += stack.size();
				} else {
					stack.pop();
					ans += 1;
				}
			}
		}
		System.out.println(ans);
	}
}