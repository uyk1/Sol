import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int x;
		int y;
		int dist;//이동 거리
		int crash;//벽을 부쉈는지 여부
		public Node(int x, int y, int dist, int crash) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.crash = crash;
		}
	}
	
	static int N, M;
	static char[][] map;
	static int[][] visit; //방문 확인 및 벽 파괴 횟수 저장. 이를 위해 최대값으로 초기화할 것.
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visit = new int[N][M];
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray(); //입력
			Arrays.fill(visit[i], Integer.MAX_VALUE); //초기화
		}
		//입력 끝
		System.out.println(bfs(0,0));
	}
	
	static int bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y, 1, 0));
		visit[x][y] = 0; //시작점 0
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			//도착하면 종료
			if(n.x == N-1 && n.y == M-1) {
				return n.dist;
			}
			//탐색 후 이동
			for(int i = 0; i < 4; i++) {
				int nx = n.x + dr[i];
				int ny = n.y + dc[i];
				//범위 확인 및 방문상태 확인(0 or 1)
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || visit[nx][ny] <= n.crash) continue;
				//이동한 위치가 벽인지 확인
				if(map[nx][ny] == '0') {//char형인걸 잊었다 '' 필요
					//벽이 아니면 거리를 늘리고 큐에 삽입
					visit[nx][ny] = n.crash;//현재까지의 공사 횟수 기록 //이거 그냥 0으로 해두면 위의 비교 구간이 제대로 작동 안 함
					q.add(new Node(nx, ny, n.dist + 1, n.crash)); //파괴 수행 여부는 전달되어야 함
				}
				else {
					//벽일 때, 작업 가능한지 확인 //파괴 후 거리를 늘리고 crash를 1로 전달
					if(n.crash == 0) {
						visit[nx][ny] = 1;
						q.add(new Node(nx, ny, n.dist + 1, 1));
					}
				}
			}
		}
		//큐가 다 돌았는데도 도착하지 못한 경우
		return -1;
	}
}