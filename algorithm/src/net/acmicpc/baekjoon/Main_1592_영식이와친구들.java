package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_1592_영식이와친구들 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		
		int[] arr = new int[N];
		arr[0] = 1;
		int cnt = 0;
		int index = 0;
		boolean endChk = false; 
		while(true) {
			index += L;
			cnt++;
			if(index >= N) index %= N;
			
			arr[index]++;
			
			for(int i = 0; i < N; i++) {
				if(arr[i] == M) {
					endChk = true;
					break;
				}
			}
			
			if(endChk) {
				System.out.println(cnt);
				return;
			}
			
		}
		
		
	}

}