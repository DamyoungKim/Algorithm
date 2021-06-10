package net.acmicpc.baekjoon;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Copy {
	int r;
	int c;
	int distance;

	public Copy(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}

	@Override
	public boolean equals(Object obj) {
		Copy x = (Copy) obj;
		if (this.r == x.r && this.c == x.c)
			return true;
		else
			return false;
	}
}

class Monster {
	int r;
	int c;
	int distance;

	public Monster(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}

}
public class Main_17135_캐슬디펜스 {

	static int N, M, D;
	static int[][] map;
	static List<Monster> monsters = new ArrayList<>();
	static List<Copy> copy = new ArrayList<>();
	static boolean[][] killedMonster;
	static int[] hunters = new int[3];
	static int killCnt, result;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		map = new int[N][M];
		killedMonster = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1)
					monsters.add(new Monster(i, j));
			}
		}
		huntersC(0, 0);
		System.out.println(result);
	}

	public static void hunting() {
		List<Copy> h1 = new ArrayList<>();
		List<Copy> h2 = new ArrayList<>();
		List<Copy> h3 = new ArrayList<>();
		for (int i = 0; i < copy.size(); i++) {
			int d1 = Math.abs(copy.get(i).r - N) + Math.abs(copy.get(i).c - hunters[0]);
			if (d1 <= D) {
				copy.get(i).distance = d1;
				h1.add(copy.get(i));
			}
		}
		huntingSort(h1);
		if (h1.size() != 0)
			killedMonster[h1.get(0).r][h1.get(0).c] = true;

		for (int i = 0; i < copy.size(); i++) {
			int d2 = Math.abs(copy.get(i).r - N) + Math.abs(copy.get(i).c - hunters[1]);
			if (d2 <= D) {
				copy.get(i).distance = d2;
				h2.add(copy.get(i));
			}
		}
		huntingSort(h2);
		if (h2.size() != 0)
			killedMonster[h2.get(0).r][h2.get(0).c] = true;

		for (int i = 0; i < copy.size(); i++) {
			int d3 = Math.abs(copy.get(i).r - N) + Math.abs(copy.get(i).c - hunters[2]);
			if (d3 <= D) {
				copy.get(i).distance = d3;
				h3.add(copy.get(i));
			}
		}
		huntingSort(h3);
		if (h3.size() != 0)
			killedMonster[h3.get(0).r][h3.get(0).c] = true;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (killedMonster[i][j]) {
					copy.remove(new Copy(i, j));
					killCnt++;
				}
				killedMonster[i][j] = false;
			}
		}
	}

	public static void huntingSort(List<Copy> h1) {
		Collections.sort(h1, new Comparator<Copy>() {

			@Override
			public int compare(Copy o1, Copy o2) {
				// TODO Auto-generated method stub
				return o1.distance == o2.distance ? o1.c - o2.c : o1.distance - o2.distance;
			}
		});

	}

	public static void moveMonster() {
		for (int i = 0; i < copy.size(); i++) {
			if (copy.get(i).r == N - 1) {
				copy.remove(i);
				i--;
				continue;
			}
			copy.get(i).r += 1;
		}
	}

	public static void huntersC(int cnt, int start) { 
		// 궁수 3명 뽑는 조합 함수 --> 3명 뽑을 시 시물레이션 실행
		if (cnt == 3) {
			copy.clear();
			for (int i = 0; i < monsters.size(); i++) {
				copy.add(new Copy(monsters.get(i).r, monsters.get(i).c));
			}
			for(int i = 0; i < N; i++) {
			//while(copy.size() != 0) {
				hunting();
				moveMonster();
			}
			result = result > killCnt ? result : killCnt;
			killCnt = 0;
			return;
		}
		for (int i = start; i < M; i++) {
			hunters[cnt] = i;
			huntersC(cnt + 1, i + 1);
		}
	}
}