package com.swexpertacademy.D2;

import java.util.Scanner;

public class Solution_D2_1204_최빈수구하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
	
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int[] arr = new int[101];
			int tc = sc.nextInt();
			for(int i = 0; i < 1000; i++) {
				arr[sc.nextInt()]++;
			}
		int result = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[result] <= arr[i])
				result = i;
		}
		System.out.println("#" + tc + " " + result);
		}
	}

}
