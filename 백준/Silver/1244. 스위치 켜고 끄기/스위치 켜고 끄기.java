import java.util.Scanner;

public class Main {

	public static Scanner sc = new Scanner(System.in);

	public static int size = sc.nextInt();

	public static int[] status = new int[size];

	public static void main(String[] args) {

		for (int i = 0; i < size; i++) {
			status[i] = sc.nextInt();
		}

		int stdSize = sc.nextInt();

		for (int i = 0; i < stdSize; i++) {

			if (sc.nextInt() == 1) {
				stdM();
			} else {
				stdW();
			}

		}

		for (int i = 1; i < size + 1; i++) {
			if (!(i % 20 == 0)) {
				System.out.print(status[i - 1] + " ");
			} else {
				System.out.println(status[i - 1]);
			}
		}
		
		sc.close();
	}

	public static void stdM() {
		int t = sc.nextInt();
		for (int i = 1; i < size + 1; i++) {
			if (i % t == 0) {
				if (status[i - 1] == 0) {
					status[i - 1] = 1;
				} else {
					status[i - 1] = 0;
				}
			}
		}
	}

	public static void stdW() {
		int t = sc.nextInt() - 1;
		if (status[t] == 0) {
			status[t] = 1;
		} else {
			status[t] = 0;
		}
		if ((t+1) <= size / 2) {
			for (int i = t - 1, j = t + 1; i >= 0; i--, j++) {
				if (!(status[i] == status[j])) {
					break;
				} else {
					if (status[i] == 0) {
						status[i] = 1;
						status[j] = 1;
					} else {
						status[i] = 0;
						status[j] = 0;
					}
				}
			}
		}else {
			for (int i = t - 1, j = t + 1; j < size; i--, j++) {
				if (!(status[i] == status[j])) {
					break;
				} else {
					if (status[i] == 0) {
						status[i] = 1;
						status[j] = 1;
					} else {
						status[i] = 0;
						status[j] = 0;
					}
				}
			}			
		}
	}
}