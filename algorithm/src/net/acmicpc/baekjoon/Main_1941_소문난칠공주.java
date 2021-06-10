package net.acmicpc.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Index {
	int y;
	int x;

	public Index(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
public class Main_1941_소문난칠공주 {
	static char[][] arr = new char[5][5];
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int[] numbers = new int[7];
	static boolean check[][]; 
	static boolean visited[][];
	
	static int result, count;

	static List<Index> list = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 행에 최소 S가 2개
		int x = 0;
		int y = 0;
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			String s = sc.next();
			for (int j = 0; j < 5; j++) {
				arr[i][j] = s.charAt(j);
				list.add(new Index(i, j));
			}
		}

		c(0, 0);
		System.out.println(result);

	}

	public static void c(int cnt, int start) {
		if (cnt == 7) {
			check = new boolean[5][5];
			List<Index> temp = new ArrayList<>();
			int cntY = 0;
			for (int i = 0; i < 7; i++) {
				Index index = list.get(numbers[i]);
				if (arr[index.y][index.x] == 'Y')
					cntY++;
				check[index.y][index.x] = true;
				if (cntY == 4)
					return;
			}
			
			int startY = 0, startX = 0;
			boolean str = false;
			for(int i = 0; i < 5; i++) {
				for(int j = 0;j < 5; j++) {
					if(check[i][j]) {
						startY = i;
						startX = j;
						str = true;
						break;
					}
				}
				if(str) break;
			}
			count = 0;
			visited = new boolean[5][5];
			solve(startX, startY);
			if(count == 6) {
				result++;
			}
			return;
		}
		
		
		for (int i = start; i < 25; i++) {
			numbers[cnt] = i;
			c(cnt + 1, i + 1);
		}

	}
	
	public static void solve (int x, int y) {
	
		for(int i = 0; i < 4; i++) {
			visited[y][x] = true;
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 5 || ny >= 5 || nx < 0 || ny < 0 || !check[ny][nx] || visited[ny][nx]) continue;
			count++;
			solve(nx, ny);
		}

	}

}
