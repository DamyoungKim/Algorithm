package net.acmicpc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9207_페그솔리테어 {
	static int resultPin, resultCnt;
	static char[][] arr, temp;
	static int[] dx = {0, 1, 0 ,-1}, dy = {-1, 0, 1, 0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			arr = new char[5][9];
			resultPin = resultCnt = Integer.MAX_VALUE;
			int pinCnt = 0;
			for(int i = 0; i < 5; i++) {
				String s = br.readLine();
				for(int j = 0; j < 9;j++) {
					arr[i][j] = s.charAt(j);
					if(arr[i][j] == 'o') pinCnt++;
				}
			}
			
			temp = new char[5][9];

			for(int i = 0; i < 5; i++) {
				for(int j = 0; j < 9; j++) {
					if(arr[i][j] == 'o') {
						for(int ii = 0; ii < 5; ii++) {
							for(int jj = 0; jj < 9; jj++) {
								temp[ii][jj] = arr[ii][jj];
							}
						}
						solve(i, j, pinCnt, 0);
					}
				}
			}
			System.out.println(resultPin + " " + resultCnt);
			if(t != T) br.readLine();
		}
		
	}
	private static void solve(int y, int x, int pin, int cnt) {
		if(pin < resultPin) {
			resultCnt = cnt;
			resultPin = pin;
		}else if(pin == resultPin) {
			resultCnt = Math.min(resultCnt, cnt);
		}
		 
		for(int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			int ny_2 = y + dy[d] * 2;
			int nx_2 = x + dx[d] * 2;
			if(ny >= 5 || nx >= 9 || ny < 0 || nx < 0 || temp[ny][nx] == '#' || temp[ny][nx] == '.' ) continue;
			
			
			if(ny_2 >= 5 || nx_2 >= 9 || ny_2 < 0 || nx_2 < 0 || temp[ny_2][nx_2] == '#' || temp[ny_2][nx_2] == 'o') continue;
			
			temp[y][x] = '.';
			temp[ny][nx] = '.';
			temp[ny_2][nx_2] = 'o';
			for(int i = 0; i < 5; i++) {
				for(int j = 0; j < 9; j++) {
					if(temp[i][j] == 'o') solve(i, j, pin - 1, cnt + 1);
				}
			}
			temp[ny_2][nx_2] = '.';
			temp[y][x] = 'o';
			temp[ny][nx] = 'o';
		
		}
	}

}
