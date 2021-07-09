package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_14890_경사로 {
	static int N, L;
	static int[][] arr;
	static boolean[][] visited;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		L = sc.nextInt();
		arr = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			boolean check = false;
			for (int j = 0; j < N - 1; j++) {
				if (Math.abs(arr[i][j] - arr[i][j + 1]) > 1) {
					check = true;
					break;
				}
				if (arr[i][j] > arr[i][j + 1]) {
					int temp = arr[i][j + 1];
					j++;
					if(visited[i][j]) {
						check = true;
						break;
					}
					visited[i][j] = true;
					for (int l = 1; l < L; l++) {
						if (++j < N && arr[i][j] == temp && !visited[i][j]) {
							visited[i][j] = true;
							continue;
						}
						check = true;
						break;
					}
					if (check)
						break;
					else
						j--;
				} else if (arr[i][j] < arr[i][j + 1]) {
					int temp = arr[i][j];
					if(visited[i][j]) {
						check = true;
						break;
					}
					visited[i][j] = true;
					for (int l = 1; l < L; l++) {
						if (j - l >= 0 && arr[i][j - l] == temp && !visited[i][j - l]) {
							visited[i][j - l] = true;
							continue;
						}
						check = true;
						break;
					}
					if (check)
						break;
				}
			}
			if (!check)
				cnt++;
		}
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			boolean check = false;
			for (int j = 0; j < N - 1; j++) {
				if (Math.abs(arr[j][i] - arr[j + 1][i]) > 1) {
					check = true;
					break;
				}
				if (arr[j][i] > arr[j + 1][i]) {
					int temp = arr[j + 1][i];
					j++;
					if (visited[j][i]) {
						check = false;
						break;
					}
					visited[j][i] = true;
					for (int l = 1; l < L; l++) {
						if (++j < N && arr[j][i] == temp && !visited[j][i]) {
							visited[j][i] = true;
							continue;
						}
						check = true;
						break;
					}
					if (check)
						break;
					else
						j--;
				} else if (arr[j][i] < arr[j + 1][i]) {
					int temp = arr[j][i];
					if(visited[j][i]) {
						check = true;
						break;
					}
					visited[j][i] = true;
					for (int l = 1; l < L; l++) {
						if (j - l >= 0 && arr[j - l][i] == temp && !visited[j - l][i]) {
							visited[j - l][i] = true;
							continue;
						}
						check = true;
						break;
					}
					if (check)
						break;
				}
			}
			if (!check)
				cnt++;
		}

		System.out.println(cnt);

	}
}
