package com.swexpertacademy.D4;

import java.util.Scanner;

public class Solution_8382_방향전환 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
		for (int t = 1; t <= T; t++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int x = Math.abs(x1 - x2);
			int y = Math.abs(y1 - y2);
			int len = x + y;
			int result = Integer.MAX_VALUE;
			if(len % 2 == 0) {
				int temp = x > y ? x : y;
				
				result = temp * 2;
			}else {
				for (int i = 0; i < 4; i++) {
					x = Math.abs(x1 + dx[i] - x2); 
					y = Math.abs(y1 + dy[i] - y2);
					
					int temp = x > y ? x : y;
					
					result = result > temp * 2 ? temp * 2 : result;
				}
				result++;
			}
			
			System.out.println("#" + t + " " + result);
		
		}
	}
}
