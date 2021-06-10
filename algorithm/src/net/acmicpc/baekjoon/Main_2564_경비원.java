package net.acmicpc.baekjoon;

import java.util.Scanner;

public class Main_2564_경비원 {
	static int result, dongDis, r;
    static int M, N;
    static int[][] map;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        int T = sc.nextInt();
        map = new int[4][T + 1];
        r = 2 * (M + N);
        int e = 0, w = 0, s = 0, n = 0;
        for (int t = 0; t < T; t++) {
            int dir = sc.nextInt(); // 방향
            int dis = sc.nextInt(); // 거리
            switch (dir) {
            case 1: // 북
                map[0][n++] = dis;
                break;

            case 2: // 남
                map[1][s++] = dis;

                break;
            case 3: // 서
                map[2][w++] = dis;
                break;
            case 4: // 동
                map[3][e++] = dis;
                break;
            }
        }
        int dongDir = sc.nextInt();
        dongDis = sc.nextInt();

        switch (dongDir) {
        case 1:
            dongN();
            break;
        case 2:
            dongS();
            break;
        case 3:
            dongW();
            break;
        case 4:
            dongE();
            break;

        }
        System.out.println(result);
    }

    private static void dongN() {
        int cnt = 0;
        while (map[3][cnt] != 0) {
            result +=  M - dongDis + map[3][cnt++];
        }
        cnt = 0;
        while (map[2][cnt] != 0) {
            result += dongDis + map[2][cnt++];
        }
        cnt = 0;

        while (map[0][cnt] != 0) {
            result += Math.abs(map[0][cnt++] - dongDis);
        }
        cnt = 0;
        while (map[1][cnt] != 0) {
            int x = N + dongDis + map[1][cnt++];
            result += x > r - x ? r - x : x;
        }
    }

    private static void dongS() {
        int cnt = 0;
        while (map[2][cnt] != 0) {
            result += dongDis + N - map[2][cnt++];
        }
        cnt = 0;
        while (map[3][cnt] != 0) {
            result +=  M - dongDis + N - map[3][cnt++];
        }
        cnt = 0;

        while (map[1][cnt] != 0) {
            result += Math.abs(map[1][cnt++] - dongDis);
        }
        cnt = 0;
        while (map[0][cnt] != 0) {
            int x = N + dongDis + map[0][cnt++];
            result += x > r - x ? r - x : x;
        }
    }

    private static void dongW() {
        int cnt = 0;
        while (map[0][cnt] != 0) {
            result += dongDis + map[0][cnt++];
        }
        cnt = 0;
        while (map[1][cnt] != 0) {
            result += N - dongDis + map[1][cnt++];
        }
        cnt = 0;

        while (map[2][cnt] != 0) {
            result += Math.abs(map[2][cnt++] - dongDis);
        }
        cnt = 0;
        while (map[3][cnt] != 0) {
            int x = M + dongDis + map[3][cnt++];
            result += x > r - x ? r - x : x;
        }
    }

    private static void dongE() {
        int cnt = 0;
        while (map[0][cnt] != 0) {
            result += dongDis + M - map[0][cnt++];
        }
        cnt = 0;
        while (map[1][cnt] != 0) {
            result +=  N - dongDis + M - map[1][cnt++];
        }
        cnt = 0;

        while (map[3][cnt] != 0) {
            result +=  Math.abs(map[3][cnt++] - dongDis);
        }
        cnt = 0;
        while (map[2][cnt] != 0) {
            int x = M + dongDis + map[2][cnt++];
            result += x > r - x ? r - x : x;
        }
    }
}