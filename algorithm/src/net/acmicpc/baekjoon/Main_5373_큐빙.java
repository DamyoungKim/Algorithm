package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5373_큐빙 {
	static int T, N;
	static char[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		for (int t = 1; t <= T; t++) {
			arr = new char[][] {
				{'X', 'X', 'X', 'w', 'w', 'w', 'X', 'X', 'X', 'X', 'X', 'X'},
				{'X', 'X', 'X', 'w', 'w', 'w', 'X', 'X', 'X', 'X', 'X', 'X'},
				{'X', 'X', 'X', 'w', 'w', 'w', 'X', 'X', 'X', 'X', 'X', 'X'},
				{'g', 'g', 'g', 'r', 'r', 'r', 'b', 'b', 'b', 'o', 'o', 'o'},
				{'g', 'g', 'g', 'r', 'r', 'r', 'b', 'b', 'b', 'o', 'o', 'o'},
				{'g', 'g', 'g', 'r', 'r', 'r', 'b', 'b', 'b', 'o', 'o', 'o'},
				{'X', 'X', 'X', 'y', 'y', 'y', 'X', 'X', 'X', 'X', 'X', 'X'},
				{'X', 'X', 'X', 'y', 'y', 'y', 'X', 'X', 'X', 'X', 'X', 'X'},
				{'X', 'X', 'X', 'y', 'y', 'y', 'X', 'X', 'X', 'X', 'X', 'X'},
			};
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				String s = st.nextToken();
				solve(s.charAt(0), s.charAt(1));
			}
			
			for (int i = 0; i <= 2; i++) {
				for (int j = 3; j <= 5; j++) {
					sb.append(arr[i][j]);
				}
				sb.append('\n');
			}
		}
		System.out.println(sb);
	}

	private static void solve(char dir, char rotateDir) {
		switch (dir) {
		case 'U':
			if (rotateDir == '-') {
				um();
			} else {
				up();
			}
			break;
		case 'D':
			if (rotateDir == '-') {
				dm();
			} else {
				dp();
			}
			break;
		case 'F':
			if (rotateDir == '-') {
				fm();
			} else {
				fp();
			}
			break;
		case 'B':
			if (rotateDir == '-') {
				bm();
			} else {
				bp();
			}
			break;
		case 'L':
			if (rotateDir == '-') {
				lm();
			} else {
				lp();
			}
			break;
		case 'R':
			if (rotateDir == '-') {
				rm();
			} else {
				rp();
			}
			break;
		}
	}

	private static void um() {
		Queue<Character> q = new LinkedList<>();
		for (int i = 0; i < 12; i++) {
			q.offer(arr[3][i]);
		}
		
		for (int i = 3; i < 3 + 12; i++) {
			arr[3][i % 12] = q.poll();
		}
		minus(0, 2, 3, 5);
	}

	private static void up() {
		Queue<Character> q = new LinkedList<>();
		for (int i = 0; i < 12; i++) {
			q.offer(arr[3][i]);
		}
		
		for (int i = 9; i < 9 + 12; i++) {
			arr[3][i % 12] = q.poll();
		}
		plus(0, 2, 3, 5);
	}

	private static void dm() {
		Queue<Character> q = new LinkedList<>();
		for (int i = 0; i < 12; i++) {
			q.offer(arr[5][i]);
		}
		
		for (int i = 9; i < 9 + 12; i++) {
			arr[5][i % 12] = q.poll();
		}
		minus(6, 8, 3, 5);
	}

	private static void dp() {
		Queue<Character> q = new LinkedList<>();
		for (int i = 0; i < 12; i++) {
			q.offer(arr[5][i]);
		}
		
		for (int i = 3; i < 3 + 12; i++) {
			arr[5][i % 12] = q.poll();
		}
		plus(6, 8, 3, 5);
	}

	private static void fm() {
		Queue<Character> q = new LinkedList<>();
		for (int j = 3; j <= 5; j++) {
			q.offer(arr[2][j]);
		}
		
		for (int i = 3; i <= 5; i++) {
			q.offer(arr[i][6]);
		}
		
		for (int j = 5; j >= 3; j--) {
			q.offer(arr[6][j]);
		}
		
		for (int i = 5; i >= 3; i--) {
			q.offer(arr[i][2]);
		}
		
		// 넣기
		for (int i = 5; i >= 3; i--) {
			arr[i][2] = q.poll();
		}
		
		for (int j = 3; j <= 5; j++) {
			arr[2][j] = q.poll();
		}
		
		for (int i = 3; i <= 5; i++) {
			arr[i][6] = q.poll();
		}
		
		for (int j = 5; j >= 3; j--) {
			arr[6][j] = q.poll();
		}
		
		minus(3, 5, 3, 5);
	}

	private static void fp() {
		Queue<Character> q = new LinkedList<>();
		for (int j = 3; j <= 5; j++) {
			q.offer(arr[2][j]);
		}
		
		for (int i = 3; i <= 5; i++) {
			q.offer(arr[i][6]);
		}
		
		for (int j = 5; j >= 3; j--) {
			q.offer(arr[6][j]);
		}
		
		for (int i = 5; i >= 3; i--) {
			q.offer(arr[i][2]);
		}
		
		// 넣기
		for (int i = 3; i <= 5; i++) {
			arr[i][6] = q.poll();
		}
		for (int j = 5; j >= 3; j--) {
			arr[6][j] = q.poll();
		}
		for (int i = 5; i >= 3; i--) {
			arr[i][2] = q.poll();
		}
		for (int j = 3; j <= 5; j++) {
			arr[2][j] = q.poll();
		}
		plus(3, 5, 3, 5);
	}

	private static void bm() {
		Queue<Character> q = new LinkedList<>();
		for (int j = 3; j <= 5; j++) {
			q.offer(arr[0][j]);
		}
		
		for (int i = 3; i <= 5; i++) {
			q.offer(arr[i][8]);
		}
		
		for (int j = 5; j >= 3; j--) {
			q.offer(arr[8][j]);
		}
		
		for (int i = 5; i >= 3; i--) {
			q.offer(arr[i][0]);
		}
		
		// 넣기
		for (int i = 3; i <= 5; i++) {
			arr[i][8] = q.poll();
		}
		for (int j = 5; j >= 3; j--) {
			arr[8][j] = q.poll();
		}
		for (int i = 5; i >= 3; i--) {
			arr[i][0] = q.poll();
		}
		for (int j = 3; j <= 5; j++) {
			arr[0][j] = q.poll();
		}
		
		
		minus(3, 5, 9, 11);		
	}

	private static void bp() {
		Queue<Character> q = new LinkedList<>();
		for (int j = 3; j <= 5; j++) {
			q.offer(arr[0][j]);
		}
		
		for (int i = 3; i <= 5; i++) {
			q.offer(arr[i][8]);
		}
		
		for (int j = 5; j >= 3; j--) {
			q.offer(arr[8][j]);
		}
		
		for (int i = 5; i >= 3; i--) {
			q.offer(arr[i][0]);
		}
		
		// 넣기
		for (int i = 5; i >= 3; i--) {
			arr[i][0] = q.poll();
		}
		
		for (int j = 3; j <= 5; j++) {
			arr[0][j] = q.poll();
		}
		
		for (int i = 3; i <= 5; i++) {
			arr[i][8] = q.poll();
		}
		
		for (int j = 5; j >= 3; j--) {
			arr[8][j] = q.poll();
		}
		plus(3, 5, 9, 11);	
	}

	private static void lm() {
		Queue<Character> q = new LinkedList<>();
		for (int i = 0; i <= 8; i++) {
			q.offer(arr[i][3]);
		}
		
		for (int i = 5; i >= 3; i--) {
			q.offer(arr[i][11]);
		}
		
		for (int i = 5; i >= 3; i--) {
			arr[i][11] = q.poll();
		}
		
		for (int i = 0; i <= 8; i++) {
			arr[i][3] = q.poll();
		}

		minus(3, 5, 0, 2);	
	}

	private static void lp() {
		Queue<Character> q = new LinkedList<>();
		for (int i = 0; i <= 8; i++) {
			q.offer(arr[i][3]);
		}
		
		for (int i = 5; i >= 3; i--) {
			q.offer(arr[i][11]);
		}
		
		for (int i = 3; i <= 8; i++) {
			arr[i][3] = q.poll();
		}
		for (int i = 5; i >= 3; i--) {
			arr[i][11] = q.poll();
		}
		for (int i = 0; i <= 2; i++) {
			arr[i][3] = q.poll();
		}
		
		plus(3, 5, 0, 2);	
	}

	private static void rm() {
		Queue<Character> q = new LinkedList<>();
		for (int i = 0; i <= 8; i++) {
			q.offer(arr[i][5]);
		}
		
		for (int i = 5; i >= 3; i--) {
			q.offer(arr[i][9]);
		}
		
		for (int i = 3; i <= 8; i++) {
			arr[i][5] = q.poll();
		}
		
		for (int i = 5; i >= 3; i--) {
			arr[i][9] = q.poll();
		}
		
		for (int i = 0; i <= 2; i++) {
			arr[i][5] = q.poll();
		}
		minus(3, 5, 6, 8);
	}

	private static void rp() {
		Queue<Character> q = new LinkedList<>();
		for (int i = 0; i <= 8; i++) {
			q.offer(arr[i][5]);
		}
		
		for (int i = 5; i >= 3; i--) {
			q.offer(arr[i][9]);
		}
		
		for (int i = 5; i >= 3; i--) {
			arr[i][9] = q.poll();
		}
		
		for (int i = 0; i <= 8; i++) {
			arr[i][5] = q.poll();
		}
		plus(3, 5, 6, 8);
	}
	
	private static void minus(int y, int ny, int x, int nx) {
		Queue<Character> q = new LinkedList<>();
		for (int j = nx; j >= x; j--) {
			for (int i = y; i <= ny; i++) {
				q.offer(arr[i][j]);
			}
		}
		
		for (int i = y; i <= ny; i++) {
			for (int j = x; j <= nx; j++) {
				arr[i][j] = q.poll();
			}
		}
	}
	
	private static void plus(int y, int ny, int x, int nx) {
		Queue<Character> q = new LinkedList<>();
		for (int j = x; j <= nx; j++) {
			for (int i = ny; i >= y; i--) {
				q.offer(arr[i][j]);
			}
		}
		
		for (int i = y; i <= ny; i++) {
			for (int j = x; j <= nx; j++) {
				arr[i][j] = q.poll();
			}
		}
	}
}
/*
12
1
L-
1
L+
1
R-
1
R+
1
F-
1
F+
1
B-
1
B+
1
U-
1
U+
1
D-
1
D+
*/