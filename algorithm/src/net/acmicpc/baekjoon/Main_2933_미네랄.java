package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2933_미네랄 {
	static int N, M, turn, minY;
	static char[][] arr;
	static int[] height, dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
	static boolean isGround = true;
	static int[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		turn = Integer.parseInt(br.readLine());
		height = new int[turn];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < turn; i++) {
			height[i] = N - Integer.parseInt(st.nextToken());
		}
		int cur = 0;
		while (cur != turn) {
			if (cur % 2 == 0) {
				for (int i = 0; i < M; i++) {
					if (arr[height[cur]][i] == 'x') {
						arr[height[cur]][i] = '.';
						break;
					}
				}
			} else if (cur % 2 == 1) {
				for (int i = M - 1; i >= 0; i--) {
					if (arr[height[cur]][i] == 'x') {
						arr[height[cur]][i] = '.';
						break;
					}
				}
			}
			isGround = true;
			visited = new int[N][M];
			int num = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == 'x' && visited[i][j] == 0) {
						isGround = false;
						minY = 0;
						num++;
						dfs(i, j, num);
						if (!isGround) {
							down(num);
							break;
						}
					}
				}
				if (!isGround) {
					break;
				}
			}
			cur++;
		}
		
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]);
			}
			if (i == N - 1) continue;
			sb.append('\n');
		}
		System.out.println(sb);
	}
	private static void down(int num) {
		int height = Integer.MAX_VALUE;
		boolean isPossible = true;
		for (int i = minY; i >= 0; i--) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == '.' || visited[i][j] != num) continue;
				
				int cnt = 0;
				while (true) {
					cnt++;
					int ny = i + cnt;
					if (ny >= N) break;
					if (arr[ny][j] == 'x' && visited[ny][j] != num)  break;
				}
				
				height = Math.min(cnt - 1, height);
			}
		}
		for (int i = N - 1; i >= 0; i--) {
			for (int j = M - 1; j >= 0; j--) {
				if (visited[i][j] == num) {
					arr[i + height][j] = 'x';
					arr[i][j] = '.';
				}
			}
		}
	}
	private static void dfs(int y, int x, int num) {
		visited[y][x] = num;
		if (minY < y) {
			minY = y;
		}
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (ny >= N) {
				isGround = true;
				continue;
			}
			if (nx >= M || ny < 0 || nx < 0 || visited[ny][nx] != 0 || arr[ny][nx] != 'x') continue;
			dfs(ny, nx, num);
		}
	}

}


/*
........
........
...x.xx.
...xxx..
..xxx...
..x.xxx.
..x...x.
.xxx..x.


........
........
.....x..
...xxx..
...xx...
..x.xx..
..x...x.
.xxx..x.


........
........
........
........
.....x..
..xxxx..
..xxx.x.
.xxxxxx.

2 2
..
.x
2
2 2

2 2
.x
xx
2
1 1

3 3
xxx
x.x
..x
1
3

4 4
xxxx
xx.x
x..x
...x 
1
3

12 24
........................
........................
..........xxxxxxxxxxx...
..........x.........x...
..........x.........x...
..........x.........x...
..........x.........x...
..........xxxxxxxxxxx...
..............x.........
..............x.........
..............x.........
..............x.........
1
10

5 5
xxxxx
x....
xxxxx
x....
x....
10
1 2 3 4 5 1 2 3 4 5

.....
xxxxx
x....
xxxxx
x....


.....
.....
xxxxx
xxxx.
x....

10 10
xxxxxxxxxx
....x.....
...xxx....
.....x....
....xx....
.....x....
xxxxxx....
..x.......
.xxxx.....
...xxxxxxx
10
9 8 7 6 5 4 3 2 1 1

3 3
...
..x
x.x
2
1 1

4 4
...x
..xx
xx.x
x..x
2
1 1

4 4
...x
..xx
.xxx
xxxx
10
1 2 3 4 1 2 3 4 3 4
*/