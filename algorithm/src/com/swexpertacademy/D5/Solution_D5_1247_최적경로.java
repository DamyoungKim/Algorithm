package com.swexpertacademy.D5;

import java.util.Arrays;
import java.util.Scanner;

class Home {
	int x;
	int y;

	public Home(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

class Comp {
	int x;
	int y;

	public Comp(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}

class Client {
	int x;
	int y;

	public Client(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}

public class Solution_D5_1247_최적경로 {
	static Client[] clients;
	static boolean[] isSelected;
	static Client[] temp;
	static Home home;
	static Comp comp;
	static int result = Integer.MAX_VALUE, cli;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			cli = sc.nextInt();
			comp = new Comp(sc.nextInt(), sc.nextInt());
			home = new Home(sc.nextInt(), sc.nextInt());
			isSelected = new boolean[cli];
			clients = new Client[cli];
			temp = new Client[cli];
			for (int c = 0; c < cli; c++) {
				clients[c] = new Client(sc.nextInt(), sc.nextInt());
			}
			p(0);
			System.out.println("#" + t + " " + result);
			result = Integer.MAX_VALUE;

		}
	}

	public static void p(int cnt) {
		if (cnt == clients.length) {
			int sum = Math.abs(comp.x - temp[0].x) + Math.abs(comp.y - temp[0].y);
			for (int i = 0; i < clients.length - 1; i++) {
				sum += Math.abs(temp[i].x - temp[i + 1].x) + Math.abs(temp[i].y - temp[i + 1].y);
			}
			sum += Math.abs(home.x - temp[clients.length - 1].x) + Math.abs(home.y - temp[clients.length - 1].y);

			result = result > sum ? sum : result;
			return;
		}
		for (int i = 0; i < clients.length; i++) {
			if (isSelected[i])
				continue;
			temp[cnt] = clients[i];
			isSelected[i] = true;
			p(cnt + 1);
			isSelected[i] = false;
		}
	}
}
