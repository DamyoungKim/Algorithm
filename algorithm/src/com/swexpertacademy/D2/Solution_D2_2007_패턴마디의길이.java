package com.swexpertacademy.D2;

import java.io.IOException;
import java.util.Scanner;

public class Solution_D2_2007_패턴마디의길이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] arr = new int[128];
		for (int t = 1; t <= T; t++) {
			String s = sc.next();
			for (int i = 0; i < s.length(); i++) {
					           
                arr[s.charAt(i)]++;
			}
			int count = 0;
			int min = s.length();
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != 0 && min > arr[i])
					min = arr[i];
			}
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != 0)
					count += arr[i] / min;
				arr[i] = 0;
			}
                   
			System.out.println("#" + t + " " + count);
		}
	}
}

/*
 * 
 * 3 KOREAKOREAKOREAKOREAKOREAKOREA SAMSUNGSAMSUNGSAMSUNGSAMSUNGSA
 * GALAXYGALAXYGALAXYGALAXYGALAXY
 * 
 * 
 */
