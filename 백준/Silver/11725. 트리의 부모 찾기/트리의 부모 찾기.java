import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static List<Integer>[] tree;
	static boolean[] visited;
	static int[] parent;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		tree = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) tree[i] = new ArrayList<>();
		for(int i = 0; i < N-1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			tree[a].add(b);
			tree[b].add(a);
		}
		visited = new boolean[N+1];
		parent = new int[N+1];
		
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[1] = true;
		while(!q.isEmpty()) {
			int v = q.poll();
			for(int n: tree[v]) {
				if(!visited[n]) {
					visited[n] = true;
					q.add(n);
					parent[n] = v;
				}
			}
		}
		
		for(int i = 2; i <= N; i++) System.out.println(parent[i]);
	}
}