package net.acmicpc.baekjoon;
import java.util.*;
import java.io.*;
public class Main_11047_동전0 {
	static int N, K;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int ans = 0;
		for (int i = N - 1; i >= 0; i--) {
			ans += (K / arr[i]);
			K %= arr[i];
		}
		System.out.print(ans);
	}
}
