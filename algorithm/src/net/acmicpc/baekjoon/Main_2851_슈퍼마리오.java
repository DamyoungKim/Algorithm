package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_2851_슈퍼마리오 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		for(int i = 0 ; i < 10; i++) {
			arr[i] = sc.nextInt();
		}
		int cnt = 0;
		int sum = 0;
		while(sum < 100) {
			sum += arr[cnt++];
			if(cnt == 10) break;
		}
		
		if(sum == 100) {
			System.out.println(sum);
		}else {
			int temp = sum - arr[cnt - 1];
			if((100 - temp) < (sum - 100)) {
				System.out.println(temp);
			}else {
				System.out.println(sum);
			}
			
		}
	}	

}