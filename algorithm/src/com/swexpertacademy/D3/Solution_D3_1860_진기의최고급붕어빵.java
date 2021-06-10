package com.swexpertacademy.D3;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_1860_진기의최고급붕어빵 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // 방문 손님 수
			int M = sc.nextInt(); 
			int K = sc.nextInt(); // M 초마다 만들 수 있는 붕어빵 개수 K
			int[] arrN = new int[N];
			for (int i = 0; i < N; i++) {
				arrN[i] = sc.nextInt(); // arrN : 손님 방문 시간 저장 배열
			}
			Arrays.sort(arrN); // 손님 방문 시간순으로 정렬
			boolean check = true;
			int bong = 0; 
			for (int i = 0; i <= arrN[N - 1]; i++) { // arrN[N-1] : 손님이 마지막으로 오는 시간(초)
				if (i != 0 && i % M == 0) 
					bong += K; // M 초마다 K개의 붕어빵 만드는 코드
				for (int j = 0; j < arrN.length; j++) {
					if (i == arrN[j]) {
						if(i > arrN[j]) break;
						bong--; // 붕어빵을 만든 시간과 손님이 방문한 시간이 같을 때 붕어빵 개수 감소
						if (bong < 0) {
							check = false; // 붕어빵 0보다 작으면 끝
							break;
						}
					}
				}
				if (!check)
					break;
			}
			System.out.print("#" + t + " ");
			if (check)
				System.out.print("Possible");
			else
				System.out.print("Impossible");
			System.out.println();
		}
	}
}
