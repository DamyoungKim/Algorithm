package net.acmicpc.baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Chicken {
	int r;
	int c;

	public Chicken(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}

class Home {
	int r;
	int c;

	public Home(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}


public class Main_15686_치킨배달 {
	private static final Class<Integer> Comparator = null;
	static int N, M;
	static int[][] map;
	static List<Chicken> chickens = new ArrayList<>();
	static List<Home> homes = new ArrayList<>();
	static List<Integer> cityChickens = new ArrayList<>();
	static Chicken[] ck;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][N];
		ck = new Chicken[M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 2)
					chickens.add(new Chicken(i, j));
				if (map[i][j] == 1)
					homes.add(new Home(i, j));
			}
		}
			chickenC(0, 0);
		Collections.sort(cityChickens);
		System.out.println(cityChickens.get(0));
	}

	public static void chickenC(int cnt, int start) {

		if (cnt == M) {
			findChicken(ck);
			return;
		}
		for (int i = start, size = chickens.size(); i < size; i++) {
			ck[cnt] = chickens.get(i);
			chickenC(cnt + 1, i + 1);
		}
	}

	public static void findChicken(Chicken[] ck) {
		int homeCnt = homes.size();
		int sum = 0;
		for (int i = 0; i < homeCnt; i++) {
			int minCs = Integer.MAX_VALUE;
			for (int j = 0, size = ck.length; j < size; j++) {
				int cs = Math.abs(homes.get(i).r - ck[j].r) + Math.abs(homes.get(i).c - ck[j].c);
				minCs = cs > minCs ? minCs : cs;
			}
			sum += minCs;
		}
		cityChickens.add(sum);
	}
}
