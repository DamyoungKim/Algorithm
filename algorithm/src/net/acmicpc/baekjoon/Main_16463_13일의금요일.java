package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_16463_13일의금요일 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int week = 2; // 0 : 일, 1 : 월, 2 : 화, 3 : 수, 4 : 목 , 5 : 금, 6 : 토
		int[] month = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int N = sc.nextInt();
		int[] arr = new int[100000 - 2019 + 1];
		for (int i = 2019; i <= 100000; i++) {
			int friday13 = 0;
			for (int j = 0; j < 12; j++) {
				if (week == 0) {
					friday13++;
				}
				int days = month[j];
				if (j == 1 && (i % 400 == 0 || (i % 100 != 0 && i % 4 == 0))) {
					days = 29;
				}
				week = (week + (days - 28)) % 7;
			}
			if(i == 2019) {
				arr[i - 2019] = friday13;
			}else {
				arr[i - 2019] = friday13 + arr[i - 2019 - 1]; 
			}
		}
		
		System.out.println(arr[N - 2019]);
	}
}
