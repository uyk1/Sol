import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		sb.append(a * (b % 10) + "\n");
		sb.append(a * ((b % 100) / 10) + "\n");
		sb.append(a * ((b % 1000) / 100) + "\n");
		sb.append(a * b + "\n");
		System.out.println(sb);
	}
}