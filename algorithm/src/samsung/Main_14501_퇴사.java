package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14501_퇴사 {
	static int N;
	static int[][] arr;
	static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][2];
		dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve(N);
		int result = findMax(1);
		System.out.println(result);
	}
	private static void solve(int day) {
		if (day == 0) {
			return;
		}
		
		if (arr[day][0] + day - 1 <= N) {
			if (arr[day][0] + day > N) {
				dp[day] = arr[day][1];
			} else {
				int a = findMax(arr[day][0] + day);
				a += arr[day][1];
				int b = findMax(day + 1);
				dp[day] = Math.max(a, b);
			}
		} 
		
		solve(day - 1);
	}
	private static int findMax(int start) {
		int max = 0;
		for (int i = start; i <= N; i++) {
			max = Math.max(max, dp[i]);
		}
		return max;
	}
}

