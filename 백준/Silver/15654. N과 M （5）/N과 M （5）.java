import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] arr;
	static int[] tmp;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		tmp = new int[M];
		visited = new boolean[N]; //방문확인
		for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
		Arrays.sort(arr); //사전적 증가 순으로 출력하기 위해 정렬
		//순열(중복 X)
		combi(0);
	}
	
	static void combi(int sidx) {
		if(sidx == M) {
			StringBuilder sb = new StringBuilder();
			for(int i: tmp) sb.append(i).append(" ");
			System.out.println(sb);
			return;
		}
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				tmp[sidx] = arr[i];
				combi(sidx+1);
				visited[i] = false;
			}
		}
	}
}