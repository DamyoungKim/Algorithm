package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_12100_2048Easy {
	static int N;
	static int[][][] arr;
	static int[] dx = { 0, 1, 0, -1 }, dy = { -1, 0, 1, 0 };
	static Queue<int[][][]> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N][2];
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j][0] = Integer.parseInt(st.nextToken());
			}
		}
		q.offer(arr);
		System.out.println(bfs());

	}

	static int bfs() {

		int cnt = 0;
		int result = 0;
		while (true) {
			int size = q.size();
			cnt++;
			if(cnt == 6) {
				for(int i = 0; i < size; i++) {
					int[][][] resultArr= q.poll();
					for(int j = 0; j < N; j++) {
						for (int k = 0; k < N; k++) {
							result = result > resultArr[j][k][0] ? result : resultArr[j][k][0];
						}
					}
				}
				return  result;
			}
			for (int i = 0; i < size; i++) {
				int[][][] tempArr = q.poll();
				for (int j = 0; j < 4; j++) {
					q.offer(move(copyArr(tempArr), j));
				}
			}
		}
	}

	static int[][][] copyArr(int[][][] ori) {
		int[][][] temp = new int[N][N][2];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp[i][j][0] = ori[i][j][0];
				temp[i][j][1] = 0;
			}
		}
		return temp;
	}

	static int[][][] move(int[][][] map, int dir) {
		Queue<int[]> qu = new LinkedList<>();
		int[][][] copyArr = new int[N][N][2];
		switch (dir) {
		case 0:
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					qu.offer(new int[] {map[j][i][0], map[j][i][1]});
				}
				int index = 0;
				while(!qu.isEmpty()) {
					int[] temp = qu.poll();
					if(temp[0] == 0) continue;
					if(index == 0 ) {
						copyArr[index][i][0] = temp[0];
						copyArr[index][i][1] = temp[1];
						index++;
						continue;
					}
					if(copyArr[index - 1][i][1] == 1 || copyArr[index - 1][i][0] != temp[0]) {
						copyArr[index][i][0] = temp[0];
						copyArr[index][i][1] = temp[1];
						index++;
						continue;
					}
					copyArr[index - 1][i][0] = temp[0] * 2;
					copyArr[index - 1][i][1] = 1;
				}
			}
			break;
		case 1:
			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j >= 0; j--) {
					qu.offer(new int[] {map[i][j][0], map[i][j][1]});
				}
				int index = N - 1;
				while(!qu.isEmpty()) {
					int[] temp = qu.poll();
					if(temp[0] == 0) continue;
					if(index == N - 1 ) {
						copyArr[i][index][0] = temp[0];
						copyArr[i][index][1] = temp[1];
						index--;
						continue;
					}
					if(copyArr[i][index + 1][1] == 1 || copyArr[i][index + 1][0] != temp[0]) {
						copyArr[i][index][0] = temp[0];
						copyArr[i][index][1] = temp[1];
						index--;
						continue;
					}
					copyArr[i][index + 1][0] = temp[0] * 2;
					copyArr[i][index + 1][1] = 1;
				}
			}
			break;
		case 2:
			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j >= 0; j--) {
					qu.offer(new int[] {map[j][i][0], map[j][i][1]});
				}
				int index = N - 1;
				while(!qu.isEmpty()) {
					int[] temp = qu.poll();
					if(temp[0] == 0) continue;
					if(index == N - 1 ) {
						copyArr[index][i][0] = temp[0];
						copyArr[index][i][1] = temp[1];
						index--;
						continue;
					}
					if(copyArr[index + 1][i][1] == 1 || copyArr[index + 1][i][0] != temp[0]) {
						copyArr[index][i][0] = temp[0];
						copyArr[index][i][1] = temp[1];
						index--;
						continue;
					}
					copyArr[index + 1][i][0] = temp[0] * 2;
					copyArr[index + 1][i][1] = 1;
				}
			}
			
			break;
		case 3:
			for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						qu.offer(new int[] {map[i][j][0], map[i][j][1]});
					}
					int index = 0;
					while(!qu.isEmpty()) {
						int[] temp = qu.poll();
						if(temp[0] == 0) continue;
						if(index == 0 ) {
							copyArr[i][index][0] = temp[0];
							copyArr[i][index][1] = temp[1];
							index++;
							continue;
						}
						if(copyArr[i][index - 1][1] == 1 || copyArr[i][index - 1][0] != temp[0]) {
							copyArr[i][index][0] = temp[0];
							copyArr[i][index][1] = temp[1];
							index++;
							continue;
						}
						copyArr[i][index - 1][0] = temp[0] * 2;
						copyArr[i][index - 1][1] = 1;
					}
				}
			break;
		}

		return copyArr;
	}

}