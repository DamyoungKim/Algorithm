package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_20061_모노미노도미노2 {
	static int N, result;
	static int[][] map;

	static class Node {
		int y;
		int x;
		int t;

		public Node(int y, int x, int t) {
			super();
			this.y = y;
			this.x = x;
			this.t = t;
		}

	}

	static boolean canDown;
	static List<Node> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		map = new int[10][10];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			list.add(new Node(y, x, t));
		}
		for (int i = 4; i < 8; i++) {
			map[i][9] = 9;
			map[9][i] = 9;
		}
		for (int i = 0; i < N; i++) {
			Node node = list.get(i);
			int removeCnt = 0;

			canDown = false;
			right(node);
			result += check(0);
			if (canDown) {
				down(0);
			}
			removeCnt = canRemove(0);
			canDown = false;
			remove(removeCnt, 0);
			if (canDown) {
				down(0);
			}
			
			
			canDown = false;
			bottom(node);
			result += check(1);
			if (canDown) {
				down(1);
			}
			removeCnt = canRemove(1);
			canDown = false;
			remove(removeCnt, 1);
			if (canDown) {
				down(1);
			}
		}
		System.out.println(result);
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 4; j < 10; j++) {
				if (map[i][j] == 1)
					cnt++;
			}
		}

		for (int i = 4; i < 10; i++) {
			for (int j = 0; j < 4; j++) {
				if (map[i][j] == 1)
					cnt++;
			}
		}
		System.out.println(cnt);
	}

	private static int canRemove(int mode) {
		int min = Integer.MAX_VALUE;
		if (mode == 0) {
			for (int i = 0; i < 4; i++) {
				min = Math.min(min, map[i + 4][9]);
			}
			
		} else if (mode == 1) {
			for (int i = 0; i < 4; i++) {
				min = Math.min(min, map[9][i + 4]);
			}
		
		}
		if (min == 3) {
			return 2;
		}
		if (min == 4) {
			return 1;
		}
		return 0;
	}

	private static void down(int mode) {
		Stack<Integer> stack = new Stack<>();
		boolean[] empty = new boolean[10];
		Arrays.fill(empty, true);
		if (mode == 0) {
			for (int j = 4; j < 10; j++) {
				for (int i = 0; i < 4; i++) {
					if (map[i][j] == 1) {
						empty[j] = false;
						break;
					}
				}
				if (!empty[j])
					continue;
				empty[j] = true;
			}

			for (int i = 0; i < 4; i++) {
				for (int j = 4; j < 10; j++) {
					if (empty[j])
						continue;
					stack.add(map[i][j]);
				}
				for (int j = 9; j >= 4; j--) {
					if (stack.isEmpty()) {
						map[i][j] = 0;
					} else {
						map[i][j] = stack.pop();
					}
				}
			}
		} else {
			for (int i = 4; i < 10; i++) {
				for (int j = 0; j < 4; j++) {
					if (map[i][j] == 1) {
						empty[i] = false;
						break;
					}
				}
				if (!empty[i])
					continue;
				empty[i] = true;
			}

			for (int j = 0; j < 4; j++) {
				for (int i = 4; i < 10; i++) {
					if (empty[i])
						continue;
					stack.add(map[i][j]);
				}
				for (int i = 9; i >= 4; i--) {
					if (stack.isEmpty()) {
						map[i][j] = 0;
					} else {
						map[i][j] = stack.pop();
					}
				}
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 4; j < 10; j++) {
				if (map[i][j] == 0) {
					if (j == 9) {
						map[i + 4][9] = 9;
					}
					continue;
				}
				map[i + 4][9] = j - 1;
				break;

			}
		}

		for (int j = 0; j < 4; j++) {
			for (int i = 4; i < 10; i++) {
				if (map[i][j] == 0) {
					if (i == 9) {
						map[9][j + 4] = 9;
					}
					continue;
				}
				map[9][j + 4] = i - 1;
				break;

			}
		}
	}

	private static void right(Node block) {
		int t = block.t;
		int y = block.y;
		int h = 0;
		if (t == 1) {
			h = map[y + 4][9];
			map[y][h] = 1;
			h = h - 1;
			map[y + 4][9] = h;
		} else if (t == 2) {
			h = map[y + 4][9];
			map[y][h] = 1;
			map[y][h - 1] = 1;
			h = h - 2;
			map[y + 4][9] = h;
		} else if (t == 3) {
			h = Math.min(map[y + 4][9], map[y + 5][9]);
			map[y][h] = 1;
			map[y + 1][h] = 1;
			h = h - 1;
			map[y + 4][9] = h;
			map[y + 5][9] = h;
		}
	}

	private static void bottom(Node block) {
		int t = block.t;
		int x = block.x;
		int h = 0;
		if (t == 1) {
			h = map[9][x + 4];
			map[h][x] = 1;
			h = h - 1;
			map[9][x + 4] = h;
		} else if (t == 2) {
			h = Math.min(map[9][x + 4], map[9][x + 5]);
			map[h][x] = 1;
			map[h][x + 1] = 1;
			h = h - 1;
			map[9][x + 4] = h;
			map[9][x + 5] = h;

		} else if (t == 3) {
			h = map[9][x + 4];
			map[h][x] = 1;
			map[h - 1][x] = 1;
			h = h - 2;
			map[9][x + 4] = h;
		}
	}

	private static int check(int mode) {
		int result = 0;
		if (mode == 0) {
			for (int j = 6; j < 10; j++) {
				boolean temp = true;
				for (int i = 0; i < 4; i++) {
					if (map[i][j] == 0) {
						temp = false;
						break;
					}
				}
				if (temp) {
					canDown = true;
					result++;
					for (int i = 0; i < 4; i++) {
						map[i][j] = 0;
					}

				}
			}
		} else if (mode == 1) {
			for (int i = 6; i < 10; i++) {
				boolean temp = true;
				for (int j = 0; j < 4; j++) {
					if (map[i][j] == 0) {
						temp = false;
						break;
					}
				}
				if (temp) {
					canDown = true;
					result++;
					for (int j = 0; j < 4; j++) {
						map[i][j] = 0;
					}
				}
			}
		}
		return result;
	}

	private static void remove(int cnt, int mode) {
		if (cnt == 0)
			return;
		canDown = true;
		if (mode == 0) {
			for (int j = 9; j > 9 - cnt; j--) {
				for (int i = 0; i < 4; i++) {
					map[i][j] = 0;
				}
			}
		} else if (mode == 1) {
			for (int i = 9; i > 9 - cnt; i--) {
				for (int j = 0; j < 4; j++) {
					map[i][j] = 0;
				}
			}
		}
	}
}
