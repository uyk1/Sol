import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = Integer.MAX_VALUE;
		
		for(int i = N-1; i >= 0; i--) {
			int sum = i;
			char[] arr = String.valueOf(i).toCharArray();
			for(char c : arr) {
				sum += c - '0';
			}
			if(sum == N) {
				ans = Math.min(ans, i);
			}
		}
        if(ans == Integer.MAX_VALUE) ans = 0;
		System.out.println(ans);
	}
}