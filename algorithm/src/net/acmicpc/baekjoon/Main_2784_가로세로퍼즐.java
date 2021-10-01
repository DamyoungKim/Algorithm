package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_2784_가로세로퍼즐 {
	static String[] arr = new String[6];
	static String[] selected = new String[3];
	static boolean[] visited = new boolean[6];
	static boolean[] count = new boolean[6];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 6; i++) {
			arr[i] = sc.next();
		}
		
		if(!solve(0)) System.out.println(0);;
	}
	private static boolean solve(int cnt) {
		if (cnt == 3) {
			char[][] temp = new char[3][3];
			for (int i = 0; i < 3; i++) {
				temp[i] = selected[i].toCharArray();
			}
			
			boolean isAns = true;
			for (int i = 0; i < 3; i++) {
				StringBuffer col = new StringBuffer();
				StringBuffer row = new StringBuffer();
				for (int j = 0; j < 3; j++) {
					row.append(temp[i][j]);
					col.append(temp[j][i]);
				}
				
				for (int j = 0; j < 6; j++) {
					if(count[j]) continue; 
					if (arr[j].equals(row.toString())) {
						count[j] =true;
						break;
					}
					if (j == 5) {
						isAns = false;
						break;
					}
				}
				
				for (int j = 0; j < 6; j++) {
					if(count[j]) continue; 
					if (arr[j].equals(col.toString())) {
						count[j] =true;
						break;
					}
					if (j == 5) {
						isAns = false;
						break;
					}
				}
				
				if (!isAns) break;
			}
			
			if (isAns) {
				for (int i = 0; i < 6; i++) {
					if (!count[i]) {
						isAns =false;
						break;
					}
				}
			}
			
			if (!isAns) {
				count = new boolean[6];
				return false;
			}
			else {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						System.out.print(temp[i][j]);
					}
					System.out.println();
				}
				return true;
			}
		}
		for (int i = 0; i < 6; i++) {
			if(visited[i]) continue;
			visited[i] =true;
			selected[cnt] = arr[i];
			if(solve(cnt + 1)) return true;
			visited[i] = false;
		}
		return false;
	}

}
