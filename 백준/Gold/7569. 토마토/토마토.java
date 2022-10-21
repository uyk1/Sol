import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Node {
		int z;//층
		int x;//행
		int y;//열
		public Node(int z, int x, int y) {
			super();
			this.z = z;
			this.x = x;
			this.y = y;
		}
	}
	
	static int M, N, H, ans;
	static int[][][] map;
	static Node[] dir =
		{new Node(-1,0,0), new Node(1,0,0)};
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static Queue<Node> q = new LinkedList<>();//bfs 탐색을 위한 큐
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();//가로
		N = sc.nextInt();//세로
		H = sc.nextInt();//층
		map = new int[H][N][M];
		for(int h = 0; h < H; h++)
			for(int i = 0; i < N; i++)
				for(int j = 0; j < M; j++) {
					map[h][i][j] = sc.nextInt();
					//이와 같이 처음에 숙성 토마토를 한번에 큐에 넣어둬야 정상적으로 동작
					if(map[h][i][j] == 1) q.add(new Node(h,i,j));
				}
		ans = -1;
		//입력
		ripe();
		System.out.println(ans);
	}
	
	static void ripe() {
		bfs();
		//토마토 상태 확인
		//현재 토마토에 기록된 가장 큰 수 -1이 다 숙성되는데 걸리는 시간
		int day = 0;
		//만약 0인 상태의 토마토가 있다면 완전 숙성에 실패한 것이므로 -1 출력
		boolean sign = true;
		outer:
		for(int h = 0; h < H; h++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[h][i][j] == 0) {
						sign = false;
						break outer;
					}
					day = Math.max(day, map[h][i][j]-1);
				}
			}
		}
		if(sign) ans = Math.max(ans, day);
	}
	
	static void bfs() {
		while(!q.isEmpty()) {
			Node a = q.poll();
			for(int i = -1; i <= 1; i++) {
				if(i == 0) {
					for(int j = 0; j < 4; j++) {
						int dx = a.x + dr[j];
						int dy = a.y + dc[j];
						if(dx < 0 || dx >= N || dy < 0 || dy >= M) continue;
						if(map[a.z][dx][dy] == 0) {
							q.add(new Node(a.z, dx, dy));
							map[a.z][dx][dy] = map[a.z][a.x][a.y] + 1;
						}
					}
				}
				else {
					int dz = a.z + i;
					if(dz < 0 || dz >= H) continue;
					if(map[dz][a.x][a.y] == 0) {
						q.add(new Node(dz, a.x, a.y));
						map[dz][a.x][a.y] = map[a.z][a.x][a.y] + 1;
					}
				}
			}
		}
	}
}