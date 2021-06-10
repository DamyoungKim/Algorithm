package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_14889_스타트와링크 {
	static int N, result = Integer.MAX_VALUE, sumT, sumF;
	static int[][] arr;
	static int[] numbers;
	static boolean[] team;
	static int[] synergy = new int[2];
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N + 1][N + 1];
		numbers = new int[N / 2];

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		solve(0, 1);
		System.out.println(result);
	}

	private static void solve(int cnt, int start) {
		if (cnt == N / 2) {
			team = new boolean[N + 1];
			for (int i = 0; i < N / 2; i++) {
				team[numbers[i]] = true;
			}
			int[] teamT = new int[N / 2];
			int[] teamF = new int[N / 2];
			int cntT = 0;
			int cntF = 0;
			for (int i = 1; i <= N; i++) {
				if (team[i]) {
					teamT[cntT++] = i;
				} else {
					teamF[cntF++] = i;
				}
			}
		
			sumT = 0;
			sumF = 0;
			cT(0, 0, teamT);
			cF(0, 0, teamF);
			int sum = Math.abs(sumT - sumF);
			result = result > sum ? sum : result;
			return;
		}

		for (int i = start; i <= N; i++) {
			numbers[cnt] = i;
			solve(cnt + 1, i + 1);
		}
	}
	
	private static void cT(int cnt, int start, int[] team) {
		if(cnt == 2) {
			sumT += arr[synergy[0]][synergy[1]];
			sumT += arr[synergy[1]][synergy[0]];
			return;
		}
		for(int i = start; i < team.length; i++) {
			synergy[cnt] = team[i];
			cT(cnt + 1, i + 1, team);
		}
	}
	
	
	private static void cF(int cnt, int start, int[] team) {
		if(cnt == 2) {
			sumF += arr[synergy[0]][synergy[1]];
			sumF += arr[synergy[1]][synergy[0]];
			return;
		}
		for(int i = start; i < team.length; i++) {
			synergy[cnt] = team[i];
			cF(cnt + 1, i + 1, team);
		}
	}

}