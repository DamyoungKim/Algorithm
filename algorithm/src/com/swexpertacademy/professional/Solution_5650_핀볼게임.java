package com.swexpertacademy.professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_5650_핀볼게임 {
	static int T, N, score, max;
	static int[][] arr;
	static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
	static class Node {
		int y;
		int x;
		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	static Node start;
	static ArrayList<Node>[] warmHole;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			max = 0;
			warmHole = new ArrayList[5];
			for (int i = 0; i < 5; i++) {
				warmHole[i] = new ArrayList<>();
			}
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (6 <= arr[i][j] && arr[i][j] <= 10) {
						warmHole[arr[i][j] - 6].add(new Node(i, j));
					}
				}
			}
			start = new Node(0, 0);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 0) {
						start.y = i;
						start.x = j;
						for (int dir = 0; dir < 4; dir++) {
							int ny = i + dy[dir];
							int nx = j + dx[dir];
							score = 0;
							solve(ny, nx, dir);
							max = Math.max(score, max);
						}
					}
				}
			}
			System.out.println("#" + t + " " + max);
		}
	}
//	private static void solve(int y, int x, int dir) {
//		if (start.y == y && start.x == x) return;
//		int tempDir = 0;
//		if (y < 0 || x < 0 || y >= N || x >= N) {
//			score++;
//			tempDir = (dir + 2) % 4;
//			solve(y + dy[tempDir], x + dx[tempDir], tempDir);
//			return;
//		}
//		
//		if (arr[y][x] == -1) return;
//		if (arr[y][x] == 0) {
//			solve(y + dy[dir], x + dx[dir], dir);
//			return;
//		}
//		
//		if (1 <= arr[y][x] && arr[y][x] <= 5) {
//			score++;
//			if (arr[y][x] == 1) {
//				if (dir == 1 || dir == 0) {
//					tempDir = (dir + 2) % 4;
//				}else if (dir == 3) {
//					tempDir = (dir + 1) % 4;
//				} else if (dir == 2) {
//					tempDir = (dir - 1) % 4;
//				}
//			} else if (arr[y][x] == 2) {
//				if (dir == 1 || dir == 2) {
//					tempDir = (dir + 2) % 4;
//				}else if (dir == 0) {
//					tempDir = (dir + 1) % 4;
//				} else if (dir == 3) {
//					tempDir = (dir - 1) % 4;
//				}
//			} else if (arr[y][x] == 3) {
//				if (dir == 3 || dir == 2) {
//					tempDir = (dir + 2) % 4;
//				}else if (dir == 1) {
//					tempDir = (dir + 1) % 4;
//				} else if (dir == 0) {
//					tempDir = 3;
//				}
//			} else if (arr[y][x] == 4) {
//				if (dir == 0 || dir == 3) {
//					tempDir = (dir + 2) % 4;
//				}else if (dir == 2) {
//					tempDir = (dir + 1) % 4;
//				} else if (dir == 1) {
//					tempDir = (dir - 1) % 4;
//				}
//			} else if (arr[y][x] == 5) {
//				tempDir = (dir + 2) % 4;
//			}
//			solve(y + dy[tempDir], x + dx[tempDir], tempDir);
//			return;
//		}
//		
//		if (6 <= arr[y][x] && arr[y][x] <= 10) {
//			for (int i = 0; i < 2; i++) {
//				Node node = warmHole[arr[y][x] - 6].get(i);
//				if (node.y == y && node.x == x) continue;
//				solve(node.y + dy[dir], node.x + dx[dir], dir);
//				return;
//			}
//		}
//	}
	
	private static void solve(int y, int x, int dir) {
		while (true) {
			if (start.y == y && start.x == x) return;
			int tempDir = 0;
			if (y < 0 || x < 0 || y >= N || x >= N) {
				score++;
				tempDir = (dir + 2) % 4;
				y += dy[tempDir];
				x += dx[tempDir];
				dir = tempDir;
			} else if (arr[y][x] == -1) {
				return;
			} else if (arr[y][x] == 0) {
				y += dy[dir];
				x += dx[dir];
			} else if (1 <= arr[y][x] && arr[y][x] <= 5) {
				score++;
				if (arr[y][x] == 1) {
					if (dir == 1 || dir == 0) {
						tempDir = (dir + 2) % 4;
					}else if (dir == 3) {
						tempDir = (dir + 1) % 4;
					} else if (dir == 2) {
						tempDir = (dir - 1) % 4;
					}
				} else if (arr[y][x] == 2) {
					if (dir == 1 || dir == 2) {
						tempDir = (dir + 2) % 4;
					}else if (dir == 0) {
						tempDir = (dir + 1) % 4;
					} else if (dir == 3) {
						tempDir = (dir - 1) % 4;
					}
				} else if (arr[y][x] == 3) {
					if (dir == 3 || dir == 2) {
						tempDir = (dir + 2) % 4;
					}else if (dir == 1) {
						tempDir = (dir + 1) % 4;
					} else if (dir == 0) {
						tempDir = 3;
					}
				} else if (arr[y][x] == 4) {
					if (dir == 0 || dir == 3) {
						tempDir = (dir + 2) % 4;
					}else if (dir == 2) {
						tempDir = (dir + 1) % 4;
					} else if (dir == 1) {
						tempDir = (dir - 1) % 4;
					}
				} else if (arr[y][x] == 5) {
					tempDir = (dir + 2) % 4;
				}
				y += dy[tempDir];
				x += dx[tempDir];
				dir = tempDir;
			} else if (6 <= arr[y][x] && arr[y][x] <= 10) {
				for (int i = 0; i < 2; i++) {
					Node node = warmHole[arr[y][x] - 6].get(i);
					if (node.y == y && node.x == x) continue;
					y = node.y + dy[dir];
					x = node.x + dx[dir];
					break;
				}
			}
		}
		
	}
}
/*
1
10
0 1 0 3 0 0 0 0 7 0 
0 0 0 0 -1 0 5 0 0 0 
0 4 0 0 0 3 0 0 2 2 
1 0 0 0 1 0 0 3 0 0 
0 0 3 0 0 0 0 0 6 0 
3 0 0 0 2 0 0 1 0 0 
0 0 0 0 0 1 0 0 4 0 
0 5 0 4 1 0 7 0 0 5 
0 0 0 0 0 1 0 0 0 0 
2 0 6 0 0 4 0 0 0 4  
 * */
 