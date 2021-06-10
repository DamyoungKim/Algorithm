package net.acmicpc.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_14501_퇴사 {
	static int N;
	static int[] T, P, result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		T = new int[N + 1];
		P = new int[N + 1]; //배열 인덱스 = 일
		result = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			T[i] = sc.nextInt(); // 일수
			P[i] = sc.nextInt(); // 비용
		}
	
		solve(N);
		Arrays.sort(result);
		System.out.println(result[N]);
	}
	private static void solve(int day) {
		if(day < 1) { // 1일 까지 계산
			return;
		}
//		if (T[day] == 1) { // 하루만에 상담 가능, 다음날 부터 최대 이득 선택
//			int max = 0;
//			for(int i = day + T[day]; i <= N; i++) {
//				max = max > result[i] ? max : result[i];
//			}
//			result[day] = P[day] + max;
		if(day + T[day] > N + 1) { // 오늘 일 수 + 상담 걸리는 일 수가 퇴사날 보다 클 경우 상담 진행 X
			result[day] = 0;
		} else { // 상담 가능 
			int max = 0;
			for(int i = day + T[day]; i <= N; i++) {
				max = max > result[i] ? max : result[i];
			}
			result[day] = P[day] + max;
		}
		
		solve(day - 1);
		
	}
	
	
}