package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_14889_스타트와링크 {
	static int N, min;
	static int[][] arr;
	static int[] selected;
	static boolean[] visited;
	static List<Integer> A = new ArrayList<>(), B = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N];
		min = Integer.MAX_VALUE;
		selected = new int[N / 2];
		combi(0, 0);
		System.out.println(min);
	}
	private static void combi(int cnt, int start) {
		if (cnt == N / 2) {
			Arrays.fill(visited, false);
			A.clear();
			B.clear();
			for (int i = 0; i < N / 2; i++) {
				visited[selected[i]] = true;
			}
			for (int i = 0; i < N; i++) {
				if (visited[i]) {
					A.add(i);
				} else {
					B.add(i);
				}
			}
			int sumA = 0;
			int sumB = 0;
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < N / 2; j++) {
					sumA += arr[A.get(i)][A.get(j)];
					sumB += arr[B.get(i)][B.get(j)];		
				}
			}
			min = Math.min(Math.abs(sumA - sumB), min);
			return;
		}
		for (int i = start; i < N; i++) {
			selected[cnt] = i;
			combi(cnt + 1, i + 1);
		}
	}

}
