package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_13022_늑대와올바른단어 {
	static char[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		arr = sc.next().toCharArray();
		
		int n = 0;
		int index = 0;
		while(index < arr.length) {
			n = countN(index);
			if(n == -1) {
				System.out.println(0);
				return;
			}
			char word = 'w';
			for(int i = 0; i < n; i++) {
				if(index == arr.length - 1 || arr[index++] != word) {
					System.out.println(0);
					return;
				}
			}
			word = 'o';
			for(int i = 0; i < n; i++) {
				if(index == arr.length - 1 || arr[index++] != word) {
					System.out.println(0);
					return;
				}
			}
			word = 'l';
			for(int i = 0; i < n; i++) {
				if(index == arr.length || arr[index++] != word) {
					System.out.println(0);
					return;
				}
			}
			word = 'f';
			for(int i = 0; i < n; i++) {
				if(index == arr.length || arr[index++] != word) {
					System.out.println(0);
					return;
				}
			}
		}
		System.out.println(1);
		
	}
	private static int countN(int index) {
		int n = 0;
		while(arr[index] == 'w') {
			index++;
			n++;
			if(index >= arr.length) {
				n = -1;
				break;
			}
		}
		if(n == 0) {
			n = -1;
		}
		return n;
	}
}
