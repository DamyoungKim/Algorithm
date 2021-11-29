package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_19237_어른상어 {
	static class Shark {
		int no;
		int y;
		int x;
		int dir;
		int[][] priority;
		boolean died;

		public Shark(int no, int y, int x) {
			super();
			this.no = no;
			this.y = y;
			this.x = x;
		}

		@Override
		public boolean equals(Object obj) {
			Shark s = (Shark) obj;
			return this.no == s.no;
		}
	}

	static class Node {
		int no;
		int time;
	}

	static int N, M, K;
	static int[] dx = { 0, 0, -1, 1 }, dy = { -1, 1, 0, 0 };
	static Node[][] memo;
	static List<Shark> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		memo = new Node[N][N];
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				memo[i][j] = new Node();
				int no = Integer.parseInt(st.nextToken());
				if (no == 0)
					continue;
				list.add(new Shark(no, i, j));
				memo[i][j].no = no;
				memo[i][j].time = K;
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			int dir = Integer.parseInt(st.nextToken()) - 1;
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).no == i) {
					list.get(j).dir = dir;
					break;
				}
			}
		}

		for (int i = 1; i <= M; i++) {
			int index = 0;
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).no == i) {
					index = j;
					break;
				}
			}
			int[][] priority = new int[4][4];
			for (int j = 0; j < 4; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 4; k++) {
					priority[j][k] = Integer.parseInt(st.nextToken()) - 1;
				}
			}
			list.get(index).priority = priority;
		}
		int cnt = 0;
		while (cnt < 1000) {
			cnt++;
			move();
			removeShark();
			removeSmell();
			setSmell();
			if (list.size() == 1) {
				System.out.println(cnt);
				return;
			}
		}
		System.out.println(-1);
	}

	private static boolean canMove(int ny, int nx) {
		if (ny >= N || nx >= N || ny < 0 || nx < 0 || memo[ny][nx].no != 0)
			return false;
		return true;
	}

	private static void move() {
		for (int i = 0; i < list.size(); i++) {
			Shark s = list.get(i);
			int ny = 0;
			int nx = 0;
			int[] priorty = s.priority[s.dir];
			boolean moved = false;
			for (int d = 0; d < 4; d++) {
				ny = s.y + dy[priorty[d]];
				nx = s.x + dx[priorty[d]];
				if (!canMove(ny, nx))
					continue;
				s.y = ny;
				s.x = nx;
				s.dir = priorty[d];
				moved = true;
				break;
			}
			if (moved) continue;
			for (int d = 0; d < 4; d++) {
				ny = s.y + dy[priorty[d]];
				nx = s.x + dx[priorty[d]];
				if (ny >= N || nx >= N || ny < 0 || nx < 0 || memo[ny][nx].no != s.no)
					continue;
				s.y = ny;
				s.x = nx;
				s.dir = priorty[d];
				break;
			}

		}
	}

	private static void setSmell() {
		for (int i = 0; i < list.size(); i++) {
			Shark s = list.get(i);
			memo[s.y][s.x].no = s.no;
			memo[s.y][s.x].time = K;
		}
	}

	private static void removeSmell() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (memo[i][j].time == 0)
					continue;
				memo[i][j].time--;
				if (memo[i][j].time == 0) {
					memo[i][j].no = 0;
				}
			}
		}
	}

	private static void removeShark() {
		for (int i = 0; i < list.size(); i++) {
			Shark a = list.get(i);
			if (a.died)
				continue;
			for (int j = 0; j < list.size(); j++) {
				if (i == j)
					continue;
				Shark b = list.get(j);
				if (b.died)
					continue;
				if (a.y == b.y && a.x == b.x) {
					if (a.no > b.no) { // a 제거
						a.died = true;
						break;
					} else { // b 제거
						b.died = true;
					}
				}
			}
		}
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).died) {
				list.remove(i--);
			}
		}
	}

}
