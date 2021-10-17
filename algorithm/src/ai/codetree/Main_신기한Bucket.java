package ai.codetree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_신기한Bucket {
	static int N, max;
	static int[][] blocks, dropPoints, arr;
	static int[] dx = { 0, -1, -1, -1, 0, 1, 1, 1 }, dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		blocks = new int[8][8];
		StringTokenizer st = null;
		for (int i = 0; i < 8; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 8; j++) {
				blocks[i][j] = Integer.parseInt(st.nextToken()) - 1;
			}
		}
		dropPoints = new int[N][2];
		arr = new int[101][4];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int point = Integer.parseInt(st.nextToken()) - 1;
			dropPoints[i][0] = num;
			dropPoints[i][1] = point;
		}
		max = 0;
		play(0, 0, arr);
		System.out.println(max);
	}

	private static void play(int cnt, int sum, int[][] array) {
		if (cnt == N) {
			max = Math.max(max, sum);
			return;
		}
		int n = dropPoints[cnt][0];
		int p = dropPoints[cnt][1];
		if (p == -1) {
			for (int i = 0; i < 4; i++) {
				int[][] temp = copy(array);
				int s = 0;
				drop(i, n, temp);
				s += gain(temp);
				down(temp);
				temp = move(temp);
				down(temp);
				s += gain(temp);
				down(temp);
				play(cnt + 1, sum + s, temp);
			}
		} else {
			int s = 0;
			drop(p, n, array);
			s += gain(array);
			down(array);
			int[][] temp = move(array);
			down(temp);
			s += gain(temp);
			down(temp);
			play(cnt + 1, sum + s, temp);
		}
	}
	
	private static int[][] move(int[][] array) {
		int[][] temp = new int[101][4];
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 4; j++) {
				if (array[i][j] == 0) continue;
				int dir = findDir(i, j, array[i][j]);
				int ny = i + dy[dir];
				int nx = j + dx[dir];
				if (temp[ny][nx] != 0) {
					if (array[i][j] >= temp[ny][nx]) continue;
				} 
				temp[ny][nx] = array[i][j];
			}
		}
		return temp;
	}
	private static int findDir (int y, int x, int num) {
		int dir = 0;
		for (int i = 0; i < 8; i++) {
			dir = blocks[num - 1][i];
			int ny = y + dy[dir];
			int nx = x + dx[dir];
			if (ny >= 101 || nx >= 4 || ny < 0 || nx < 0) continue;
			return dir;
		}
		return dir;
	}
	private static void drop(int p, int n, int[][] array) {
		for (int i = 0; i < 100; i++) {
			if (array[i + 1][p] != 0) {
				array[i][p] = n;
				return;
			} 
		}
		array[100][p] = n;
	}

	private static int[][] copy(int[][] array) {
		int[][] temp = new int[101][4];
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 4; j++) {
				temp[i][j] = array[i][j];
			}
		}
		return temp;
	}
	
	private static int gain(int[][] array) {
		int sum = 0;
		for (int i = 0; i < 101; i++) {
			boolean check = true;
			for (int j = 0; j < 4; j++) {
				if(array[i][j] != 0) continue;
				check =false;
				break;
			}
			if (check) {
				sum++;
				for (int j = 0; j < 4; j++) {
					array[i][j] = 0;
				}
			}
			
		}
		return sum;
	}
	
	private static void down(int[][] array) {
		for (int j = 0; j < 4; j++) {
			Stack<Integer> stack = new Stack<>();
			for (int i = 0; i < 101; i++) {
				if (array[i][j] != 0) {
					stack.add(array[i][j]);
				}
			}
			
			for (int i = 100; i >= 0; i--) {
				if (stack.isEmpty()) {
					array[i][j] = 0;
				} else {
					array[i][j] = stack.pop();
				}
			}
		}
	}

}
