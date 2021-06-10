package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17144_미세먼지안녕 {

	static class Dust {
		int y;
		int x;
		int val;

		public Dust(int y, int x, int val) {
			super();
			this.y = y;
			this.x = x;
			this.val = val;
		}

		public void spread() {
			int ny = 0, nx = 0;
			List<int[]> tempList = new ArrayList<>();
			for (int i = 0; i < 4; i++) {
				ny = this.y + dy[i];
				nx = this.x + dx[i];

				if (ny >= R || nx >= C || ny < 0 || nx < 0 || (nx == 0 && (ny == top || ny == bottom)))
					continue;

				tempList.add(new int[] { ny, nx });
			}
			int temp = this.val / 5;
			for (int i = 0; i < tempList.size(); i++) {
				tempArr[tempList.get(i)[0]][tempList.get(i)[1]] += temp;
			}
			tempArr[this.y][this.x] += this.val - temp * tempList.size();
		}
	}

	static int R, C, T, top, bottom;
	static int[][] arr, tempArr;
	static int[] dx = { 0, 1, 0, -1 }, dy = { -1, 0, 1, 0 };
	static List<Dust> dustList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		arr = new int[R][C];

		boolean tempChk = false;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 0) continue;
				dustList.add(new Dust(i, j, temp));
				if (temp == -1 && !tempChk) {
					tempChk = true;
					top = i;
					bottom = i + 1;
				}
			}
		}

		for (int i = 0; i < T; i++) {
			spreadDust();
			operateAir();
		}
		int result = 0;
		for(int i = 0; i < dustList.size();i++) {
			result += dustList.get(i).val;
		}
		System.out.println(result);
	}

	private static void operateAir() {
		for(int i = 0; i < dustList.size(); i++) {
			int y = dustList.get(i).y;
			int x = dustList.get(i).x;
			if(x == C - 1) {
				if(y == 0) {
					dustList.get(i).x -= 1;
				} else if (y <= top) {
					dustList.get(i).y -= 1;
				} else if (y == R - 1) {
					dustList.get(i).x -= 1;
				} else if (y >= bottom){
					dustList.get(i).y += 1;
				} 
			} else if (x == 0) {
				if(y <= top) {
					if(dustList.get(i).y + 1 == top) {
						dustList.remove(i);
						i--;
						continue;
					}
					dustList.get(i).y += 1;
				} else if (y >= bottom) {
					if(dustList.get(i).y - 1 == bottom) {
						dustList.remove(i);
						i--;
						continue;
					}
					dustList.get(i).y -= 1;
				}
			} else if (y == 0) {
				dustList.get(i).x -= 1;
			} else if (y == top) {
				dustList.get(i).x += 1;
			} else if (y == bottom) {
				dustList.get(i).x += 1;
			} else if (y == R - 1) {
				dustList.get(i).x -= 1;
			}
		}
	}

	private static void spreadDust() {
		tempArr = new int[R][C];
		for (int i = 0; i < dustList.size(); i++) {
			dustList.get(i).spread();
		}
		dustList.clear();

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (tempArr[i][j] == 0 || tempArr[i][j] == -1)
					continue;
				dustList.add(new Dust(i, j, tempArr[i][j]));
			}
		}

	}

}