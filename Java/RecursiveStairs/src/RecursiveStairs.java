import java.util.ArrayList;
import java.util.List;

public class RecursiveStairs {

	/*
	 * N - Number of stairs, N >= 0 [x - array of possible steps]
	 */
	public static int num_ways_rec(int N) {
		// There is only one way for N = 1 and N = 0
		if (N <= 1)
			return 1;

		return num_ways_rec(N - 1) + num_ways_rec(N - 2);
	}

	public static int num_ways_dyn(int N) {
		List<Integer> dynList = new ArrayList<Integer>();

		for (int i = 0; i <= N; i++) {
			if (i <= 1) {
				dynList.add(1);
			} else {
				dynList.add(dynList.get(i - 1) + dynList.get(i - 2));
			}
		}
		return dynList.get(N);
	}

	public static int num_ways_rec(int N, int[] x) {
		if (N <= 1)
			return 1;
		int total = 0;
		for (int y : x) {
			if (N - y >= 0) {
				total += num_ways_rec(N - y, x);
			}
		}
		return total;
	}
	
	public static int num_ways_dyn(int N, int[] x) {
		List<Integer> dynList = new ArrayList<Integer>();

		for (int i = 0; i <= N; i++) {
			if (i <= 1) {
				dynList.add(1);
			} else {
				int total = 0;
				for (int y : x) {
					if (i - y >= 0) {
						total += dynList.get(i - y);
					}
				}
				dynList.add(total);
			}
		}
		return dynList.get(N);
	}

	public static void main(String[] args) {
		System.out.println(num_ways_rec(4));
		System.out.println(num_ways_dyn(4));

		int[] x = new int[] { 1, 2 };
		System.out.println(num_ways_rec(4, x));
		System.out.println(num_ways_dyn(4, x));
	}

}
