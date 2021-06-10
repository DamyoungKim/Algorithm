package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1937_욕심쟁이판다 {
	static int N;
	static int[][] arr, result;
	static int[] dx = {0 ,1, 0, -1}, dy = {-1, 0, 1, 0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		arr = new int[N][N];
		result = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(result[i][j] == 0)
					dfs(i, j);
			}
		}
		int max = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				max = max > result[i][j] ? max : result[i][j];
			}
		}
		
		System.out.println(max);
	}
	private static int dfs(int y, int x) {
		List<int[]> list = moveCheck(y, x);
		if(list.size() == 0) {
			result[y][x] = 1;
			return result[y][x];
		}
		int max = 0;
		for(int i = 0; i < list.size(); i++) {
			int[] tempArr = list.get(i);
			int ny = tempArr[0];
			int nx = tempArr[1];
			if(result[ny][nx] == 0) {
				int temp = dfs(tempArr[0], tempArr[1]);
				int cur = result[y][x];
				max = max > cur + temp ? max : cur + temp ;
			}else {
				max = max > result[ny][nx] ? max : result[ny][nx];
			}
		}
		result[y][x] += (max + 1);
		return result[y][x];
	}
	
	private static List<int[]> moveCheck(int y, int x) {
		List<int[]> list = new ArrayList<>();
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny >= N || nx >= N || ny < 0 || nx < 0 || arr[y][x] >= arr[ny][nx] ) continue;
			
			list.add(new int[] {ny, nx});
		}
		
		return list;
	}

}