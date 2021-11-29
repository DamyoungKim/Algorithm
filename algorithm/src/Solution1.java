import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1 {
	static int T, N, max = 0;;
	static int[] arr, selected;
	static boolean[] visited;
	static class Node {
		int start;
		int end;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			selected = new int[4];
			visited = new boolean[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			max = 0;
			permu(0);
			System.out.println("#" + t + " " + max);
		}
		
	}
	private static void permu(int cnt) {
		if (cnt == 4) {
			int[] visited = new int[N];
			visited[selected[0]] = 1;
			visited[selected[1]] = 1;
			visited[selected[2]] = 2;
			visited[selected[3]] = 2;
			for (int i = 0; i < N; i++) {
				if (visited[i] == 0) continue;
				int next = i + 1;
				int prev = i - 1;
				if (next == N) next = 0;
				if (prev == -1) prev = N - 1;
				if (visited[next] != 0) return;
				if (visited[prev] != 0) return;
			}
			int other = 0;
			for (int i = selected[0] + 1; i < selected[0] + N; i++) {
				int temp = i % N;
				if (visited[temp] == 2) {
					other++;
				}
				if (visited[temp] == 1) {
					break;
				}
			}
			if (other % 2 != 0) return;
			
			int score = (int) Math.pow(arr[selected[0]] + arr[selected[1]], 2) + (int) Math.pow(arr[selected[2]] + arr[selected[3]], 2);
			max = Math.max(max, score);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			selected[cnt] = i;
			permu(cnt + 1);
			visited[i] = false;
		}
	}
}

