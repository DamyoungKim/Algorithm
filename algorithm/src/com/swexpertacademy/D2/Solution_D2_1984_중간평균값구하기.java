package com.swexpertacademy.D2;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D2_1984_중간평균값구하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t =1; t <= T; t++) {
			int[] arr = new int[10];
			for(int i = 0; i < 10; i++) {
				arr[i] = sc.nextInt();
			}
			
			Arrays.sort(arr);
			int sum = 0;
			for(int i = 1; i < 9; i++) {
				sum += arr[i];
			}
			System.out.print("#" + t + " ");
			System.out.printf("%.0f",(double)sum / 8 );
			System.out.println();
		}
	}

}
