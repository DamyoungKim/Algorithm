package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_3985_롤케이크 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int L = sc.nextInt();

		int N = sc.nextInt();
		int maxCnt = 0;
		int maxN = 0;
		int[] arr = new int[L + 1];
		for (int i = 1; i <= N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			int dif = y - x + 1;
			
			if(maxCnt < dif) {
				maxCnt = dif;
				maxN = i;
			}
			for(int j = x; j <= y; j++) {
				if(arr[j] == 0) {
					arr[j] = i;
				}
			}
		}
		
		System.out.println(maxN);
		int[] result = new int[N + 1];
		for(int i = 1; i <= L; i++) {
			if(i == 0) continue;
			result[arr[i]]++;
		}
		int resultMax = 0 ;
		int resultN = 0 ;
		for(int i = 1; i <= N; i++) {
			if(result[i] > resultMax ) {
				resultMax = result[i];
				resultN = i;
			}
		}
		System.out.println(resultN);
	}

}