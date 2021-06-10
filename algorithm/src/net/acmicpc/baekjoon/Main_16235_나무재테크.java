package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Tree3 implements Comparable<Tree3> {
	int y;
	int x;

	int age;

	public Tree3(int y, int x, int age) {
		super();
		this.y = y;
		this.x = x;
		this.age = age;

	}

	public boolean die(int food) {
		if (food < age) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int compareTo(Tree3 o) {
		// TODO Auto-generated method stub
		return this.age - o.age;
	}

}

public class Main_16235_나무재테크 {
	static int N, M, K;
	static int[][] A, arr;
	static PriorityQueue<Tree3> pq = new PriorityQueue<>();
//	static List<Tree3> trees = new ArrayList<Tree3>();;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		A = new int[N + 1][N + 1];
		arr = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = 5;
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			pq.offer(new Tree3(y, x, age));
		}

		for (int i = 0; i < K; i++) {
			spring();
		}

		System.out.println(pq.size());

	}

	static public void spring() {
		// 나무 찾기
		List<Tree3> diedTrees = new ArrayList<>();
		PriorityQueue<Tree3> temp = new PriorityQueue<>();

		while (!pq.isEmpty()) {
			Tree3 tree = pq.poll();
			if (tree.die(arr[tree.y][tree.x])) {
				diedTrees.add(tree);
			} else {
				arr[tree.y][tree.x] -= tree.age;
				tree.age += 1;
				temp.offer(tree);
			}
		}

//		while (!temp.isEmpty()) {
//			pq.offer(temp.poll());
//		}
		pq = temp;
		summer(diedTrees);
	}

	static public void summer(List<Tree3> dieTrees) {
		for (int i = 0; i < dieTrees.size(); i++) {
			Tree3 tree = dieTrees.get(i);
			arr[tree.y][tree.x] += (tree.age / 2);
		}
		fall();
	}

	static public void fall() {
		int dx[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
		int dy[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
		PriorityQueue<Tree3> temp = new PriorityQueue<>();
		for (int i = 0, size = pq.size(); i < size; i++) {
			Tree3 tree = pq.poll();
			temp.offer(tree);
			if (tree.age % 5 != 0)
				continue;
			for (int j = 0; j < 8; j++) {
				int nx = tree.x + dx[j];
				int ny = tree.y + dy[j];

				if (nx > N || ny > N || nx < 1 || ny < 1)
					continue;
				temp.offer(new Tree3(ny, nx, 1));
			}
		}
//		while (!temp.isEmpty()) {
//			pq.offer(temp.poll());
//		}
		pq = temp;
		winter();
	}

	static public void winter() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				arr[i][j] += A[i][j];
			}
		}
	}

}
