package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_2839_설탕배달 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int cnt5 = -1;
		int cnt3 = 0;
		int result = 5000;

		while (cnt3 >= 0) {
			cnt5++;
			cnt3 = (N - cnt5 * 5) / 3;
			if (cnt3 >= 0 && N == cnt5 * 5 + cnt3 * 3 ) {
				result = result > cnt5 + cnt3 ? cnt5 + cnt3 : result;
			}
		}
		cnt5 = 0;
		cnt3 = -1;
		while (cnt5 >= 0) {
			cnt3++;
			cnt5 = (N - cnt3 * 3) / 5;
			if (cnt5 >= 0 &&N == cnt5 * 5 + cnt3 * 3) {
				result = result > cnt5 + cnt3 ? cnt5 + cnt3 : result;
			}
		}
		
		if(result== 5000) result = -1;
		System.out.println(result);
	}
}