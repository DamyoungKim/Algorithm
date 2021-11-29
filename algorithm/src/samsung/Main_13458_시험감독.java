package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13458_시험감독 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		long cnt = 0;
		for (int i = 0; i < N; i++) {
			int num = arr[i];
			int temp = num - B;
			if (temp <= 0) {
				cnt++;
			} else {
				cnt++;
				if (temp % C == 0) {
					cnt += (temp / C);
				} else {
					cnt += (temp / C + 1);
				}
			}
		}
		System.out.println(cnt);
	}

}
