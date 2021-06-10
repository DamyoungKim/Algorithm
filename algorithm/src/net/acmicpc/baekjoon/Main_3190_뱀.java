package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3190_뱀 {
	static int N;
	static int[][] arr;
	static int[] times = new int[10001];
	static Queue<int[]> q = new LinkedList<>();
	static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
	public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	N = Integer.parseInt(br.readLine());
	arr = new int[N][N];
	int K = Integer.parseInt(br.readLine());
	StringTokenizer st = null;
	for(int i = 0; i < K; i++) {
		st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		arr[y - 1][x - 1] = 1;
	}
	int T = Integer.parseInt(br.readLine());
	for(int i = 0; i < T; i++) {
		st = new StringTokenizer(br.readLine());
		int index = Integer.parseInt(st.nextToken());
		char dir = st.nextToken().charAt(0);
		int temp = 0;
		if(dir == 'D') temp = 1;
		if(dir == 'L') temp = -1;
		times[index] = temp;
	}
	
	
	q.offer(new int[] {0, 0});
	System.out.println(solve(0, 0, 1, 1));
	
	}
	private static int solve(int y, int x, int dir, int time) {
		for(int i = 0, size = q.size(); i < size; i++) {
			int[] temp = q.poll();
			int r = temp[0];
			int c = temp[1];
			arr[r][c] = -1;
			q.offer(temp);
		}
		int ny = y + dy[dir];
		int nx = x + dx[dir];
		
		if(ny >= N || nx >= N || ny < 0 || nx < 0 || arr[ny][nx] == -1) return time;
		if(arr[ny][nx] != 1) {
			int[] temp = q.poll();
			int r = temp[0];
			int c= temp[1];
			arr[r][c] = 0;
		}
		q.offer(new int [] {ny, nx});
		int tempTime = dir + times[time];
		if(tempTime == 4) tempTime = 0;
		if(tempTime == -1) tempTime = 3;
		
		return solve(ny, nx, tempTime, time + 1);
	}
}