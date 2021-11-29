package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_23290_마법사상어와복제 {
	static class Node {
		int y;
		int x;
		int dir;
		public Node(int y, int x, int dir) {
			super();
			this.y = y;
			this.x = x;
			this.dir = dir;
		}
		
		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
	static int M, S, fishCntMax;
	static List<Node> list, eggs;
	static Node shark;
	static int[][] diedArr, fishArr;
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}, dy = {0, -1, -1, -1, 0, 1, 1, 1}, sharkDir, selected;
	static int[] sharkRotate = {2, 0, 6, 4};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		list = new ArrayList<>();
		eggs = new ArrayList<>();
		M = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		fishArr = new int[4][4];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken()) - 1;
			fishArr[y][x]++;
			list.add(new Node(y, x, dir));
		}
		st = new StringTokenizer(br.readLine());
		shark = new Node(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
		diedArr = new int[4][4];
		sharkDir = new int[3];
		selected = new int[3];
		for (int i = 0; i < S; i++) {
			addEggs();
			move();
			fishCntMax = -1;
			findSharkDir(shark.y, shark.x, 0, 0);
			moveShark();
			removeBode();
			addFish();
		}
		System.out.println(list.size());
	}

	private static void addFish() {
		while (eggs.size() != 0) {
			Node node = eggs.get(0);
			fishArr[node.y][node.x]++; 
			list.add(node);
			eggs.remove(0);
		}
	} 

	private static void removeBode() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (diedArr[i][j] != 0) {
					diedArr[i][j]--;
				}
			}
		}
	}

	private static void moveShark() {
		int ny = shark.y;
		int nx = shark.x ;
		for (int i = 0; i < 3; i++) {
			ny += dy[sharkDir[i]];
			nx += dx[sharkDir[i]];
			for (int j = 0; j < list.size(); j++) {
				Node node = list.get(j);
				if (node.y == ny && node.x == nx) {
					diedArr[ny][nx] = 3;
					fishArr[ny][nx]--;
					list.remove(j--);
				}
			}
		}
		shark.y = ny;
		shark.x = nx;
	}

	private static void findSharkDir(int y, int x, int cnt, int sum) {
		if (cnt == 3) {
			if (fishCntMax < sum ) {
				fishCntMax = sum;
				for (int i = 0; i < 3; i++) {
					sharkDir[i] = selected[i];
				}
			}
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[sharkRotate[i]];
			int nx = x + dx[sharkRotate[i]];
			if (ny >= 4 || nx >= 4 || ny < 0 || nx < 0) continue;
			selected[cnt] = sharkRotate[i];
			int temp = fishArr[ny][nx];
			fishArr[ny][nx] = 0;
			findSharkDir(ny, nx, cnt + 1, sum + temp);
			fishArr[ny][nx] = temp;
		}
	}

	private static void move() {
		for (int i = 0; i < list.size(); i++) {
			Node node = list.get(i);
			for (int d = node.dir; d >= node.dir - 7; d--) {
				int dir = d;
				if (dir < 0) dir += 8;
				int ny = node.y + dy[dir];
				int nx = node.x + dx[dir];
				if (ny >= 4 || nx >= 4 || ny < 0 || nx < 0 || diedArr[ny][nx] != 0) continue;
				if (ny == shark.y && nx == shark.x) continue;
				fishArr[node.y][node.x]--;
				node.y = ny;
				node.x = nx;
				node.dir = dir;
				fishArr[node.y][node.x]++;
				break;
			}
		}
	}

	private static void addEggs() {
		for (int i = 0; i < list.size(); i++) {
			Node node = list.get(i);
			eggs.add(new Node(node.y, node.x, node.dir));
		}
	}

}
