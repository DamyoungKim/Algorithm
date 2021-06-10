package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_11387_님무기가좀나쁘시네여 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		long[][] arr = new long[4][5];
		
		for(int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		solve(arr[0], arr[2], arr[3]);
		
		solve(arr[1], arr[3], arr[2]);
		
	}
	
	private static void solve(long[] user, long[] myWeapon, long[] yourWeapon) {
		
		long before = cal(user);
		long[] temp = new long[5];
		
		for(int i = 0; i < 5; i++) {
			temp[i] = user[i] -  myWeapon[i] + yourWeapon[i];
		}
		
//		for(int i = 0; i < 5; i ++) {
//			System.out.print(temp[i] + " ");
//		}
//		System.out.println();
		long after = cal(temp);
		char out = ' ';
//		System.out.println(before);
//		System.out.println(after);
		if(before == after) out =  '0';
		else if(before > after) out =  '-';
		else out = '+';
		
		System.out.println(out);
		
	}
	
	private static long cal(long[] user) {
		
		
		return  user[0] * (100 + user[1]) * ( 
				
						(100 - Math.min(user[2], 100)) * 100
						
						+ Math.min(user[2], 100) * user[3]
				
				) * (
						
						100 + user[4]
								
						
						);
	}
}
