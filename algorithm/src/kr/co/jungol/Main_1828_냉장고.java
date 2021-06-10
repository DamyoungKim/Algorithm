package kr.co.jungol;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1828_냉장고 {
	static int count;
	static class C implements Comparable<C> {
		int min;
		int max;

		public C(int min, int max) {
			super();
			this.min = min;
			this.max = max;
		}

		@Override
		public int compareTo(C o) {
			// TODO Auto-generated method stub
			return this.max != o.max ? this.max - o.max : o.min - this.min;
		}

		@Override
		public String toString() {
			return "C [min=" + min + ", max=" + max + "]";
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		C[] cs = new C[N];
		for (int i = 0; i < N; i++) {
			cs[i] = new C(sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(cs);
		ref(cs);
		//System.out.println(Arrays.toString(cs));
		System.out.println(count);
		
	}

	public static void ref(C[] cs) {
		for (int i = 0, size = cs.length; i < size; i++) {
			int cnt = i;
			while(cnt + 1 < size && cs[i].max >= cs[cnt + 1].min){
				cnt++;
				if(cnt + 1 >= size) {
					break;
				}
				
			}
			i = cnt;
			count++;
		}
	}
}

/*
6
-15 5
-12 5
-10 36
10 73
27 44
29 59
 
*/
