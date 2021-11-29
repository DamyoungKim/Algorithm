import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
	static int T, N, result;
	static int[][] arr;

	static class Node {
		int y;
		int x;
		boolean died;

		public Node(int y, int x, boolean died) {
			super();
			this.y = y;
			this.x = x;
			this.died = died;
		}
		
	}

	static List<Node> list;
	static Node start;
	static int[] dx = { 0, 1, 0, -1 }, dy = { -1, 0, 1, 0 };
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			visited = new boolean[N][N];
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 1)
						list.add(new Node(i, j, false));
					if (arr[i][j] == 2) {
						start = new Node(i, j, false);
						arr[i][j] = 0;
					}
				}
			}
			result = 0;
			for (int j = 0; j < 4; j++) {
				for (int len = 1; len < N; len++) {
					int ny = start.y + dy[j] * len;
					int nx = start.x + dx[j] * len;
					if (ny >= N || nx >= N || ny < 0 || nx < 0 || arr[ny][nx] == 0)
						continue;
					ny = ny + dy[j];
					nx = nx + dx[j];
					if (ny >= N || nx >= N || ny < 0 || nx < 0)
						continue;
					solve(1, ny, nx, j);
						break;
				}
			}
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i).died) result++;
			}
			System.out.println("#" + t + " " + result);
		}
	}

	private static void solve(int cnt, int y, int x, int dir) {
		boolean temp_chk = visited[y][x];
		if (arr[y][x] == 1) {
			if (!visited[y][x]) {
				for (int i = 0; i < list.size(); i++) {
					Node node = list.get(i);
					if (y == node.y && x == node.x) {
						node.died = true;
						break;
					}
				}
				visited[y][x] = true;
			}
		}
		if (temp_chk || arr[y][x] == 0){
			int ny = y + dy[dir];
			int nx = x + dx[dir];
			if (check(ny, nx)) {
				solve(cnt, ny, nx, dir);
			}
		}
		
		if (cnt == 3) {
			if (!temp_chk && visited[y][x]) {
				visited[y][x] = false;
			}
			return;
		}
		for (int j = 0; j < 4; j++) {
			for (int len = 1; len < N; len++) {
				int ny = y + dy[j] * len;
				int nx = x + dx[j] * len;
				if (ny >= N || nx >= N || ny < 0 || nx < 0) {
					break;
				}
				if (arr[ny][nx] == 0)continue;
				ny = ny + dy[j];
				nx = nx + dx[j];
				if (ny >= N || nx >= N || ny < 0 || nx < 0)
					continue;
				solve(cnt + 1, ny, nx, j);
				break;
			}
		}
		if (!temp_chk && visited[y][x]) {
			visited[y][x] = false;
		}
	}
	
	private static boolean check(int ny, int nx) {
		if (ny >= N || nx >= N || ny < 0 || nx < 0)  return false;
		return true;
	}
}
/*
 
1
10
0 1 0 0 0 0 0 0 0 0
0 0 0 0 1 0 0 0 0 0
0 1 1 0 1 0 1 0 0 0
0 0 0 0 1 0 0 0 0 0
0 1 1 0 0 0 0 0 0 0
0 0 0 0 2 0 1 0 1 0
0 0 0 0 0 0 1 0 0 0
1 0 1 1 0 0 1 0 0 0
0 0 0 0 0 0 0 0 1 0
0 1 0 0 1 0 1 1 0 0


1
5
0 1 0 0 1 
1 1 0 0 0
0 1 1 0 1
0 0 2 0 0
1 0 1 1 0

*/