package net.acmicpc.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_15684_사다리조작 {
	static int N, M, H, choice;
	static boolean[][] arr;
	static int[] selected;
	static List<int[]> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // 열
		M = sc.nextInt();
		H = sc.nextInt(); // 행
		arr = new boolean[2 * H + 1][2 * N + 1];
		// (행, 열)
		for(int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[2 * a - 1][2 * b] = true;
		}
		list = new ArrayList<>();
		for(int i = 1; i < 2 * H; i += 2) {
			for(int j = 2; j < 2 * N - 1; j += 2) {
				if(!arr[i][j] && isPossible(i, j)) {
					list.add(new int[] {i, j});
				}
			}
		}

		if(down()) {
			System.out.println(0);
			return;
		}
		while(true) {
			choice++;
			if(choice > 3) {
				choice = -1;
				break;
			}
			selected = new int[choice];
			if(select(0, 0)) break;
		}
		System.out.println(choice);
	}
	
	private static boolean down() {
		for(int i = 1; i < 2 * N ; i = i + 2) {
			int finish = i;
			for(int j = 1; j < 2 * H; j += 2) {
				finish += isExistNext(j, finish);
			}
			if(finish != i) return false;
		}
		return true;
	}
	
	private static int isExistNext(int y, int x) {
		if(arr[y][x + 1]) return 2;
		if(arr[y][x - 1]) return -2;
		return 0;
	}
	
	private static boolean isPossible(int y, int x) {
		if(arr[y][x + 2]) return false;
		if(arr[y][x - 2]) return false;
		return true;
	}
	
	private static boolean select(int start, int cnt) {
		if(cnt == choice) {
			int[] temp = null;
			for(int i = 0; i < choice; i++) {
				temp = list.get(selected[i]);
				int y = temp[0];
				int x = temp[1];
				if(!isPossible(y, x)) return false;
			}
			
			for(int i = 0; i < choice; i++) {
				temp = list.get(selected[i]);
				arr[temp[0]][temp[1]] = true;
			}
			if(down()) return true;
			for(int i = 0; i < choice; i++) {
				temp = list.get(selected[i]);
				arr[temp[0]][temp[1]] = false;
			}
			return false;
		}
		for(int i = start; i < list.size(); i++) {
			selected[cnt] = i;
			if(select(i + 1, cnt + 1)) return true;
		}
		
		return false;
	}
		
}
