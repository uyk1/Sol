import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int c = sc.nextInt(); // 가로 길이
		int r = sc.nextInt(); // 세로 길이
		
		int N = sc.nextInt(); // 자르는 횟수
		
		List<Integer> carr = new ArrayList<>(); // 가로 
		List<Integer> rarr = new ArrayList<>(); // 세로
		
		carr.add(0);
		rarr.add(0);
		
		for(int i = 0; i < N; i++) {
			
			int D = sc.nextInt(); // 식별자(가로 0, 세로 1)
			
			if(D == 0) {
				carr.add(sc.nextInt());
			} else {
				rarr.add(sc.nextInt());
			}
		}
		
		carr.add(r);
		rarr.add(c);
		
		carr.sort(null);
		rarr.sort(null);
		
		int cmax = 0;
		int rmax = 0;
		
		for(int i = 1; i < carr.size(); i++) {
			int tmp;
			tmp = carr.get(i) - carr.get(i - 1);
			if(cmax < tmp) {
				cmax = tmp;
			}
		}
		for(int i = 1; i < rarr.size(); i++) {
			int tmp;
			tmp = rarr.get(i) - rarr.get(i - 1);
			if(rmax < tmp) {
				rmax = tmp;
			}
		}
		
		System.out.println(cmax * rmax);
	}
}