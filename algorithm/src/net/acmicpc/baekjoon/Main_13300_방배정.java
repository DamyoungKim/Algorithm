package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_13300_방배정 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
// 남자끼리, 여자끼리, 같은 학년끼리, 한명만가능 방에 들어갈 수 있는 최대인원수 K 최소 몇개 방?
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] m = new int[7];
		int[] wm = new int[7];
		for(int i = 0; i < N; i++) {
			int S = sc.nextInt();
			int Y = sc.nextInt();
			if(S == 1) {
				m[Y]++;
			}else {
				wm[Y]++;
			}
		}
		int cntRoom = 0;
		for(int i = 1; i < 7; i++) {
			while(true) {
				if(m[i]/K != 0) {
					m[i] -= K;
					cntRoom++;
				}
				
				if(wm[i] / K != 0) {
					wm[i] -= K;
					cntRoom++;
				}
				
				if(m[i]/K == 0 && wm[i] / K == 0) {
					if(m[i] % K != 0) cntRoom++;
					if(wm[i] % K != 0) cntRoom++;
					break;
				}
			}
		}
		
		System.out.println(cntRoom);
	
	}

}