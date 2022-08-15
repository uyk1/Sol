import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] wh = new int[1001];

		for (int i = 0; i < N; i++) {
			wh[sc.nextInt()] = sc.nextInt();
		}

		int max = 0;

		for (int i = 0; i < 1001; i++) {
			if (wh[i] >= max) {
				max = wh[i];
			}
		}
		
		int idx = 0;

		List<Integer> maxIdx = new ArrayList<>();
		
		for (int i = 0; i < 1001; i++) {
			if (wh[i] == max) {
				maxIdx.add(idx++, i);
			}
		}
		
		
		int lh = 0;

		List<Integer> lIdx = new ArrayList<>();

		int lidx = 0;

		for (int i = 0; i <= maxIdx.get(0); i++) {
			if (wh[i] > lh) {
				lh = wh[i];
				lIdx.add(lidx++, i);
			}
		}

		int lsum = 0;
		
		if(lidx >= 1) {
			for (int i = 0; i < lIdx.size()-1; i++) {
				lsum += wh[lIdx.get(i)] * (lIdx.get(i + 1) - lIdx.get(i));
			}
		}else if (lidx == 0) {
			lsum = wh[lIdx.get(0)] * (maxIdx.get(0) - lIdx.get(0));
		}
		
		int rh = 0;

		List<Integer> rIdx = new ArrayList<>();

		int ridx = 0;

		for (int i = 1000; i >= maxIdx.get(maxIdx.size() - 1); i--) { 
			if (wh[i] > rh) {
				rh = wh[i];
				rIdx.add(ridx++, i);
			}
		}
		
		int rsum = 0;

		if(ridx >= 1) {
			for (int i = 0; i < rIdx.size()-1; i++) {
				rsum += wh[rIdx.get(i)] * ((rIdx.get(i)) - rIdx.get(i+1));
			}
		}else if(ridx == 0) {
			rsum = wh[rIdx.get(0)] * ((rIdx.get(0)) - maxIdx.get(maxIdx.size()-1));
		}
		
		int res = lsum + rsum;

		if (maxIdx.size() == 1) {
			res += max;
		} else {
			res += max * ((maxIdx.get(maxIdx.size() - 1)+1) - maxIdx.get(0));
		}

		System.out.println(res);

	}
}