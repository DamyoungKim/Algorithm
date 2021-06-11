package net.acmicpc.baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class Main_1110_더하기사이클 {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		if(N < 10 ) N *= 10;
		int sumN = 0;
		int cnt = 0;
		int tempN = -1;
		while(N != tempN) {
			if(cnt == 0) {
				tempN = N;
			}
			
			cnt++;
	
			sumN = tempN / 10 + tempN % 10;
			tempN = ( tempN % 10 ) * 10 + ( sumN % 10 );
			
			
		}
		
		System.out.println(cnt);
		
		
	}

}
