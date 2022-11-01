import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		if(N == 1) {
			System.out.println(1);
			return;
		}
		arr = new int[N+1];
		Arrays.fill(arr, -1);
		arr[1] = 1;
		arr[2] = 2;
		int res = count(N);
		System.out.println(res);
	}
	
	static int count(int n) {
		if(arr[n] != -1) return arr[n];
		if(n == 1 || n == 2) return arr[n];
		return arr[n] = (count(n-2) + count(n-1)) % 15746;
	}
}