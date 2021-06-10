package com.swexpertacademy.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_5648_원자소멸시물레이션 {

	static class Atom {
		int no;
		int y;
		int x;
		int dir;
		int energy;

		public Atom(int no, int y, int x, int dir, int energy) {
			super();
			this.no = no;
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.energy = energy;
		}

		public void move() {
			this.y += dy[dir];
			this.x += dx[dir];
		}
	}

	static int N;
	static List<Atom> atoms;
	static int[] dx = { 0, 0, -1, 1 }, dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			atoms = new ArrayList<>();
			StringTokenizer st = null;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				int energy = Integer.parseInt(st.nextToken());
				atoms.add(new Atom(i, y * 2, x * 2, dir, energy));
			}

			System.out.println("#" + t + " " + solve());

		}

	}

	private static int solve() {
		int sum = 0;
		while (atoms.size() != 0) {
			for (int i = 0; i < atoms.size(); i++) {
				atoms.get(i).move();
			}
			for (int i = 0; i < atoms.size(); i++) {
				Atom a = atoms.get(i);
				if (a.x > 2000 || a.x < -2000 || a.y > 2000 || a.y < -2000) {
					atoms.remove(i--);
					continue;
				}
			}
			
			boolean[] check = new boolean[1000];
			for (int i = 0; i < atoms.size(); i++) {
				Atom a = atoms.get(i);
				for (int j = i + 1; j < atoms.size(); j++) {
					Atom b = atoms.get(j);
					if (a.x == b.x && a.y == b.y) {
						if(!check[a.no]) {
							check[a.no] = true;
							sum += a.energy;
						}
						if(!check[b.no]) {
							check[b.no] = true;
							sum += b.energy;
						}
					}
				}
			}
			
			for (int i = 0; i < atoms.size(); i++) {
				if(check[atoms.get(i).no]) atoms.remove(i--);
			}
			
		}
		return sum;
	}

}
