package net.acmicpc.baekjoon;

import java.util.*;
import java.io.*;

public class Main_2667_단지번호붙이기 {
//	static int N, cnt;
//	static int[][] arr;
//	static int[] dx = {0, 1, 0 , -1}, dy = {-1, 0, 1, 0}; 
//	static boolean[][] visited;
//	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
//		
//		N = sc.nextInt();
//		arr = new int[N][N];
//		visited = new boolean[N][N];
//		for(int i = 0; i < N; i++) {
//			String s = sc.next();
//			for(int j = 0; j < N; j++) {
//				arr[i][j] = s.charAt(j) - '0';
//			}
//		}
//		List<Integer> list = new ArrayList<>();
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < N; j++) {
//				cnt = 0;
//				if(arr[i][j] == 0 || visited[i][j]) continue;
//				
//				dfs(i, j);
//				list.add(cnt);
//			}
//		}
//		
//		System.out.println(list.size());
//		
//		Collections.sort(list, new Comparator<Integer> () {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				// TODO Auto-generated method stub
//				return o1 - o2;
//			}
//		});
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
//	}
//	private static void dfs(int y, int x) {
//		visited[y][x] = true;
//		cnt++;
//
//		for(int i = 0; i < 4; i++) {
//			int ny = y + dy[i];
//			int nx = x + dx[i];
//			if(ny >= N || nx >= N || ny < 0 || nx < 0 || visited[ny][nx] || arr[ny][nx] == 0) continue;
//			dfs(ny, nx);
//		}
//	}
	static int N;
	static char[][] map;
	static boolean[][] visited;
	static List<Integer> list = new ArrayList<>();
	static class Node {
		int y;
		int x;
		public Node (int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
	static Queue<Node> q = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] || map[i][j] == '0') continue;
				visited[i][j] = true;
				q.offer(new Node(i, j));
				bfs();
			}
		}
		StringBuilder sb = new StringBuilder();
		int size = list.size();
		sb.append(size);
		sb.append('\n');
		Collections.sort(list);
		for (int i = 0; i < size; i++) {
			sb.append(list.get(i));
			sb.append('\n');
		}
		System.out.println(sb);
	}
	private static void bfs() {
		int cnt = 1;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int ny = cur.y + dy[d];
				int nx = cur.x + dx[d];
				
				if (ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx] || map[ny][nx] == '0') continue;
				visited[ny][nx] = true;
				cnt++;
				q.offer(new Node(ny, nx));
			}
		}
		list.add(cnt);
	}

}