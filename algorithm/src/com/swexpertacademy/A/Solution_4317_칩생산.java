package com.swexpertacademy.A;

import java.util.Scanner;

public class Solution_4317_칩생산 {

	static int N, M, result;
	static int[][] arr;
	static boolean[][] selected;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			result = 0;
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			selected = new boolean[N][M];
			solve(0, 0, 0);
			System.out.println("#" + t + " " + result);
		}
	}

	private static void solve(int y, int x, int cnt) {
		if (x + 1 >= M) {
			solve(y + 1, 0, cnt);
			return;
		}
		if (y + 1 >= N) {
			result = result > cnt ? result : cnt;
			return;
		}
		
		if (!selected[y][x] && check(y, x)) {
			selected[y][x] = true;
			selected[y][x + 1] = true;
			selected[y + 1][x] = true;
			selected[y + 1][x + 1] = true;
			solve(y, x + 2, cnt + 1);
			selected[y][x] = false;
			selected[y][x + 1] = false;
			selected[y + 1][x] = false;
			selected[y + 1][x + 1] = false;
		}

		solve(y, x + 1, cnt);

	}

	private static boolean check(int y, int x) {

		if (selected[y][x] || selected[y][x + 1] || selected[y + 1][x] || selected[y + 1][x + 1])
			return false; // 이미 선택함
		if (arr[y][x] == 1 || arr[y][x + 1] == 1 || arr[y + 1][x] == 1 || arr[y + 1][x + 1] == 1)
			return false; // 고장
		return true;
	}
}

/*
1
8 7
0 0 0 1 0 0 0
0 0 0 0 0 0 0
0 0 0 0 0 0 0
0 1 0 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 0 0
0 0 1 0 0 0 0
0 0 0 0 0 0 0

 */


/*

#include <iostream>
using namespace std;
int h, w;
int map[25][10];
int used[25][10];
int memo[25][(1 << 10) + 1];
int isClean(int y, int x)
{
	if (x >= w - 1) return 0;
	if (map[y][x] + map[y + 1][x] + map[y][x + 1] + map[y + 1][x + 1] > 0) return 0;
	if (used[y][x] + used[y + 1][x] + used[y][x + 1] + used[y + 1][x + 1] > 0) return 0;
	return 1;
}
void setNemo(int y, int x)
{
	used[y][x] = 2;
	used[y][x + 1] = 1;
	used[y + 1][x] = 1;
	used[y + 1][x + 1] = 1;
}
void clearNemo(int y, int x)
{
	used[y][x] = 0;
	used[y][x + 1] = 0;
	used[y + 1][x] = 0;
	used[y + 1][x + 1] = 0;
}
int getState(int y, int x) {
	int state = 0;
	for (int i = 0; i < w - 1; i++) {
		state <<= 1;
		if (used[y][i] == 2) state |= 0x1;
	}
	return state;
}
int getMaxChipCnt(int stage)
{
	int dy = stage / w;
	int dx = stage % w;
	int state = 0;
	if (dy == h - 2 && dx == w - 1) return 0;
	if (dx == w - 1) {
		state = getState(dy, dx);
		if (memo[dy][state] != 0) return memo[dy][state];
	}
	int maxi = 0;
	if (isClean(dy, dx)) {
		setNemo(dy, dx);
		maxi = getMaxChipCnt(stage + 1) + 1;
		clearNemo(dy, dx);
	}
	int ret = getMaxChipCnt(stage + 1);
	if (maxi < ret)  maxi = ret;
	if (dx == w - 1) {
		memo[dy][state] = maxi;
	}
	return maxi;
}
int main()
{
	//freopen("text.txt", "r", stdin);
	int tcCnt, ret;
	cin >> tcCnt;
	for (int tc = 1; tc <= tcCnt; tc++) {
		cin >> h >> w;
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				cin >> map[x][y];
			}
		}
		//가로 세로 변경
		int temp = h;
		h = w;
		w = temp;
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < (1 << w); x++) {
				memo[y][x] = 0;
			}
		}
		ret = getMaxChipCnt(0);
		cout << "#" << tc << " " << ret << "\n";
	}
	return 0;
}





*/

/*
 * 

#include <iostream>
using namespace std;
char memo[1 << 21][4][5];
char map[4][5];
int h = 4;
int w = 5;
int tarY, tarX;
int direct[4][2] = { -1, 0, 1, 0, 0, 1, 0, -1 };
int setBit(int state, int y, int x)
{
	int index = y * w + x;
	state |= (1 << index);
	return state;
}
int clearBit(int state, int y, int x)
{
	int index = y * w + x;
	state &= ~(1 << index);
	return state;
}
int isSet(int state, int y, int x)
{
	int index = y * w + x;
	return (state >> index) & 0x1;
}
int getMini(int state, int dy, int dx)
{
	if (isSet(state, dy, dx)) return 99;
	state = setBit(state, dy, dx);
	if (memo[state][dy][dx] != 0) return memo[state][dy][dx];
	if (dy == tarY && dx == tarX) return 0;
	int min = 99;
	for (int t = 0; t < 4; t++) {
		int ny = dy + direct[t][0];
		int nx = dx + direct[t][1];
		if (ny < 0 || nx < 0 || ny >= h || nx >= w) continue;
		if (map[ny][nx] == '#') continue;
		int ret = getMini(state, ny, nx);
		if (ret < min) min = ret;
	}
	memo[state][dy][dx] = min + 1;
	return memo[state][dy][dx];
}
int main()
{
	//freopen("text.txt", "r", stdin);
	int startY, startX;
	for (int y = 0; y < h; y++) {
		for (int x = 0; x < w; x++) {
			cin >> map[y][x];
			if (map[y][x] == '#') continue;
			if (map[y][x] == 'A') startY = y, startX = x;
			if (map[y][x] == 'B') tarY = y, tarX = x;
			map[y][x] = '_';
		}
	}
	int ret = getMini(0, startY, startX);
	if (ret >= 99) {
		cout << "impossible";
		return 0;
	}
	cout << ret << "회";
	return 0;
}
 * 
 * */
 