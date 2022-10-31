import java.util.Scanner;

public class Main {
	static int n, cnt1, cnt2;
	static int[] f;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		f = new int[n+1];
		cnt1 = fib(n);
		cnt2 = fibdp(n);
		System.out.println(cnt1);
		System.out.println(cnt2);
	}
	
	static int fib(int n) {
		if(n==1 || n==2) return 1;
		else return (fib(n-1) + fib(n-2));
	}
	
	static int fibdp(int n) {
		f[1] = 1;
		f[2] = 1;
		int tmpcnt = 0;
		for(int i = 3; i <= n; i++) {
			f[i] = f[i-1] + f[i-2];
			tmpcnt++;
		}
		return tmpcnt;
	}
}