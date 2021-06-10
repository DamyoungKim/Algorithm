package com.swexpertacademy.D3;

import java.util.Scanner;

public class Solution_D3_1493_수의새로운연산1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int ansAI = 0, ansAJ = 0;
			int ansBI = 0, ansBJ = 0;
			for(int i = 1; i <= 10000; i++) {
				for(int j = 1; j <= 10000; j++) {
					if(a == fx(i,j)) {
						ansAI = i;
						ansAJ = j;
					}
					if(b == fx(i,j)) {
						ansBI = i;
						ansBJ = j;
					}
					if(ansAI !=0 && ansBJ != 0) break;
				}
				
				if(ansAI != 0 && ansBJ != 0) break;
			}
			int ansI = ansAI + ansBI;
			int ansJ = ansAJ + ansBJ;
			System.out.println("#" + t + " " + fx(ansI,ansJ));
		}
	}
	
	private static int fx(int i, int j) {
		return 1 + i * (i - 1) / 2 + j * (j - 1) / 2 + i * (j - 1);
	}
}
