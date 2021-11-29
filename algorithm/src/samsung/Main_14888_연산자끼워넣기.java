package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14888_연산자끼워넣기 {
	static int N, min, max;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int plus  = Integer.parseInt(st.nextToken());
		int minus = Integer.parseInt(st.nextToken());
		int dot  = Integer.parseInt(st.nextToken());
		int div  = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		solve(arr[0], plus, minus, dot, div, 0);
		System.out.println(max);
		System.out.println(min);
	}
	private static void solve(int val, int plus, int minus, int dot, int div, int cnt) {
		if (cnt == N - 1) {
			min = Math.min(min, val);
			max = Math.max(max, val);
			return;
		}
		
		if (plus > 0) {
			solve(val + arr[cnt + 1], plus - 1, minus, dot, div, cnt + 1);
		}
		
		if (minus > 0) {
			solve(val - arr[cnt + 1], plus, minus - 1, dot, div, cnt + 1);
		}
		
		if (dot > 0) {
			solve(val * arr[cnt + 1], plus, minus, dot - 1, div, cnt + 1);

		}
		
		if (div > 0) {
			solve(val / arr[cnt + 1], plus, minus, dot, div - 1, cnt + 1);
		}
	}
}
