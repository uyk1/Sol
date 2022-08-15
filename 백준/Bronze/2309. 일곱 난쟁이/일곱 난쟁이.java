import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] small = new int[9];
		int sum = 0;

		for (int i = 0; i < 9; i++) {
			small[i] = sc.nextInt();
			sum += small[i];
		}

		for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sum - small[i] - small[j] == 100) {
					small[i] = 0;
					small[j] = 0;
					Arrays.sort(small);
					for (int k = 0; k < 9; k++) {
						if(small[k] != 0) {
							System.out.println(small[k]);
						}
					}
					return;
				}
			}
		}
	}
}