package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_21611_마법사상어와블리자드 {
	static int N, M;
	static int[][] arr, mode, map;
	static int[] dx = { 0, 0, -1, 1 }, dy = { -1, 1, 0, 0 };
	static int[] result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		mode = new int[M][2];
		map = new int[N][N];
		result = new int[3];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			mode[i][0] = dir;
			mode[i][1] = s;
		}
		makeMap();
		for (int i = 0; i < M; i++) {
			magic(mode[i]);
			move();
			while (true) {
				if (!boom()) {
					break;
				}
				move();
			}
			change();
		}
		int ans = 0;
		for (int i = 0; i < 3; i++) {
			ans += result[i] * (i + 1);
		}
		System.out.println(ans);
	}

	
	private static void change() {
		Queue<Integer> q = new LinkedList<>();
		int len = 1;
		int y = N / 2;
		int x = N / 2;
		int cur = -1;
		int prev = 0;
		int same = 0;
		boolean end = false;
		int cnt = 0;
		while (len != N) {
			for (int j = 0; j < 2; j++) {
				for (int i = 0; i < len; i++) {
					if (len % 2 == 0) {
						if (j == 0) {
							y += dy[3];
							x += dx[3];
						} else {
							y += dy[0];
							x += dx[0];
						}
					} else if (len % 2 != 0) {
						if (j == 0) {
							y += dy[2];
							x += dx[2];
						} else {
							y += dy[1];
							x += dx[1];
						}
					}
					
					cnt++;
					if (cur == -1) {
						cur = arr[y][x];
						same = 1;
						continue;
					}
					prev = cur;
					cur = arr[y][x];
					if (prev == cur) {
						same++;
					} else {
						q.offer(same);
						q.offer(prev);
						same = 1;
					}
					if (arr[y][x] == 0) {
						end = true;
						break;
					}
				}
				if (end) break;
				
				
			}
			if (end) break;
			len++;
		}
		if (!end) {
			while(--x >= 0) {
				prev = cur;
				cur = arr[y][x];
				if (prev == cur) {
					same++;
				} else {
					q.offer(same);
					q.offer(prev);
					same = 1;
				}
			}
		}
		len = 1;
		y = N / 2;
		x = N / 2;
		int[][] temp = new int[N][N];
		while (len != N) {
			for (int j = 0; j < 2; j++) {
				for (int i = 0; i < len; i++) {
					if (len % 2 == 0) {
						if (j == 0) {
							y += dy[3];
							x += dx[3];
						} else {
							y += dy[0];
							x += dx[0];
						}
					} else if (len % 2 != 0) {
						if (j == 0) {
							y += dy[2];
							x += dx[2];
						} else {
							y += dy[1];
							x += dx[1];
						}
					}
					if (q.isEmpty()) {
						arr = temp;
						return;
					} else {
						temp[y][x] = q.poll();
					}
					
				}
			}
			len++;
		}

			while(--x >= 0) {
				if (q.isEmpty()) {
					arr = temp;
					return;
				} else {
					temp[y][x] = q.poll();
				}
			}
		
		arr = temp;
		
	}
	

	private static void makeMap() {
		int len = 1;
		int y = N / 2;
		int x = N / 2;
		int cnt = 0;
		while (len != N) {
			for (int j = 0; j < 2; j++) {
				for (int i = 0; i < len; i++) {
					if (len % 2 == 0) {
						if (j == 0) {
							y += dy[3];
							x += dx[3];
						} else {
							y += dy[0];
							x += dx[0];
						}
					} else if (len % 2 != 0) {
						if (j == 0) {
							y += dy[2];
							x += dx[2];
						} else {
							y += dy[1];
							x += dx[1];
						}
					}
					map[y][x] = ++cnt;
				}
			}
			len++;
		}
		while(--x >= 0) {
			map[y][x] = ++cnt;
		}
	}


	private static boolean boom() {
		boolean visited[] = new boolean[N * N];
		int len = 1;
		int y = N / 2;
		int x = N / 2;
		int cur = -1;
		int prev = 0;
		int cnt = 0;
		int same = 0;
		boolean check = false;
		boolean end = false;
		while (len != N) {
			for (int j = 0; j < 2; j++) {
				for (int i = 0; i < len; i++) {
					if (len % 2 == 0) {
						if (j == 0) {
							y += dy[3];
							x += dx[3];
						} else {
							y += dy[0];
							x += dx[0];
						}
					} else if (len % 2 != 0) {
						if (j == 0) {
							y += dy[2];
							x += dx[2];
						} else {
							y += dy[1];
							x += dx[1];
						}
					}
					cnt++;
					
					
					if (cur == -1) {
						cur = arr[y][x];
						same = 1;
						continue;
					}
					prev = cur;
					cur = arr[y][x];
					if (prev == cur) {
						same++;
					} else {
						if (same >= 4) {
							check = true;
							for (int k = cnt - 1; k > cnt - 1 - same; k--) {
								visited[k] = true;
							}
						}
						same = 1;
					}
					if (arr[y][x] == 0) {
						end = true;
						break;
					}
				}
				if (end) break;
				
				
			}
			if (end) break;
			len++;
		}
		if (!end) {
			while(--x >= 0) {
				cnt++;
				prev = cur;
				cur = arr[y][x];
				if (prev == cur) {
					same++;
				} else {
					if (same >= 4) {
						for (int k = cnt - 1; k > cnt - 1 - same; k--) {
							visited[k] = true;
						}
					}
					same = 1;
				}
				if (arr[y][x] == 0) {
					break;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int no = map[i][j];
				if (visited[no]) {
					result[arr[i][j] - 1]++;
					arr[i][j] = 0;
				}
			}
		}
		return check;
	}


	private static void magic(int[] mode) {
		int y = N / 2;
		int x = N / 2;
		for (int len = 1; len <= mode[1]; len++) {
			int ny = y + dy[mode[0]] * len;
			int nx = x + dx[mode[0]] * len;
			arr[ny][nx] = 0;
		}
	}


	public static void move() {
		int len = 1;
		int y = N / 2;
		int x = N / 2;
		Queue<Integer> q = new LinkedList<>();
		while (len != N) {
			for (int j = 0; j < 2; j++) {
				for (int i = 0; i < len; i++) {
					if (len % 2 == 0) {
						if (j == 0) {
							y += dy[3];
							x += dx[3];
						} else {
							y += dy[0];
							x += dx[0];
						}
					} else if (len % 2 != 0) {
						if (j == 0) {
							y += dy[2];
							x += dx[2];
						} else {
							y += dy[1];
							x += dx[1];
						}
					}
					if (arr[y][x] != 0) {
						q.offer(arr[y][x]);
					}
				}
			}
			len++;
		}
		while(--x >= 0) {
			if (arr[y][x] != 0) {
				q.offer(arr[y][x]);
			}
		}
		len = 1;
		y = N / 2;
		x = N / 2;
		while (len != N) {
			for (int j = 0; j < 2; j++) {
				for (int i = 0; i < len; i++) {
					if (len % 2 == 0) {
						if (j == 0) {
							y += dy[3];
							x += dx[3];
						} else {
							y += dy[0];
							x += dx[0];
						}
					} else if (len % 2 != 0) {
						if (j == 0) {
							y += dy[2];
							x += dx[2];
						} else {
							y += dy[1];
							x += dx[1];
						}
					}
					if (q.isEmpty()) {
						arr[y][x] = 0;
					} else {
						arr[y][x] = q.poll();
					}
				}
			}
			len++;
		}
		while(--x >= 0) {
			if (q.isEmpty()) {
				arr[y][x] = 0;
			} else {
				arr[y][x] = q.poll();
			}
		}
	}

	
}
