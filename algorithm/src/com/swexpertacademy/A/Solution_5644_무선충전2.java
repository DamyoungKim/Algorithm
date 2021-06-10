package com.swexpertacademy.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5644_무선충전2 {
	static int cntBC;
	static int[] dirA, dirB, dx = {0, 0, 1, 0, -1 }, dy = {0, -1, 0, 1, 0 };
	static ArrayList<Integer>[][] map;
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			map = new ArrayList[11][11];
			for(int i = 1; i < 11; i++) {
				for(int j = 1 ; j < 11; j++) {
					map[i][j] = new ArrayList<>();
				}
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			cntBC = Integer.parseInt(st.nextToken());

			dirA = new int[time];
			dirB = new int[time];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < time; i++) {
				dirA[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < time; i++) {
				dirB[i] = Integer.parseInt(st.nextToken());
			}
			
			arr = new int[cntBC + 1][4];
			for (int i = 1; i <= cntBC; i++) {
				st = new StringTokenizer(br.readLine());
				// x, y, c, p
				for(int j = 0; j < 4; j++) {
					arr[i][j] =  Integer.parseInt(st.nextToken());
				}
				bfs(arr[i][1], arr[i][0], arr[i][2], i);
			}
			for(int i = 1; i < 11; i++) {
				for (int j = 1; j < 11; j++) {
					Collections.sort(map[i][j], new Comparator<Integer>() {

						@Override
						public int compare(Integer o1, Integer o2) {
							return arr[o2][3] - arr[o1][3];
						}
					});	
				}
			}
			
			int[] A = new int[] {1, 1};
			int[] B = new int[] {10, 10};
			int sumA = map[1][1].size() != 0 ? arr[map[1][1].get(0)][3] : 0;
			int sumB = map[10][10].size() != 0 ? arr[map[10][10].get(0)][3] : 0;
			
			for(int i = 0; i< time; i++) {
				A = move(A, dirA[i]);
				B = move(B, dirB[i]);
				if(map[A[0]][A[1]].size() == 0 || map[B[0]][B[1]].size() == 0) {
					if(map[A[0]][A[1]].size() != 0) {
						sumA += arr[map[A[0]][A[1]].get(0)][3];
					}
					if(map[B[0]][B[1]].size() != 0) {
						sumB += arr[map[B[0]][B[1]].get(0)][3];
					}
					continue;
				}
				if(map[A[0]][A[1]].get(0) != map[B[0]][B[1]].get(0)) {
					sumA += arr[map[A[0]][A[1]].get(0)][3];
					sumB += arr[map[B[0]][B[1]].get(0)][3];
					continue;
				}
				int[] temp = solve(A, B);
				sumA += temp[0];
				sumB += temp[1];
			}
			System.out.println("#" + t + " " + (sumA + sumB));
		}
	}

	
	private static int[] solve(int[] A, int[] B) {
		ArrayList<Integer> listA = map[A[0]][A[1]];
		ArrayList<Integer> listB = map[B[0]][B[1]];
		int maxSum = 0;
		int aSum = 0;
		int bSum = 0;
		for(int i = 0; i < listA.size(); i++) {
			for(int j = 0; j < listB.size(); j++) {
				if(listA.get(i) == listB.get(j)) {
					if(maxSum < arr[listA.get(i)][3]) {
						maxSum = arr[listA.get(i)][3];
						aSum = arr[listA.get(i)][3]/2;
						bSum = arr[listB.get(j)][3]/2;	
					}
					continue;
				}
				
				if(maxSum < arr[listA.get(i)][3] + arr[listB.get(j)][3]) {
						maxSum = arr[listA.get(i)][3] + arr[listB.get(j)][3];
						aSum = arr[listA.get(i)][3];
						bSum = arr[listB.get(j)][3];	
				}
			}
		}
		return new int[] {aSum, bSum};
	}
	
	
	private static void bfs(int y, int x, int C, int index) {
		Queue<int[]> q = new LinkedList<>();
		boolean visited[][] = new boolean[11][11];
		q.offer(new int[] { y, x });
		visited[y][x] = true;
		map[y][x].add(index);
		int cnt = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			cnt++;
			for (int i = 0; i < size; i++) {
				int[] temp = q.poll();
				int tempY = temp[0];
				int tempX = temp[1];
				for (int j = 0; j <= 4; j++) {
					int ny = tempY + dy[j];
					int nx = tempX + dx[j];

					if (ny >= 11 || nx >= 11 || ny < 1 || nx < 1 || visited[ny][nx])
						continue;

					visited[ny][nx] = true;
					map[ny][nx].add(index);
					q.offer(new int[] {ny, nx});
				}
			}
			if (cnt == C)
				return;
		}
	}
	private static int[] move(int[] pos, int dir) {
		int ny = pos[0] + dy[dir];
		int nx = pos[1] + dx[dir];
		
		return new int[] {ny, nx};
		
	}
}
