import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] map; //이 문제에서 맵은 일차원 배열로 풀이 가능
//	static int[][] info; //사다리 & 뱀 정보
	static int[] visited; //방문 확인
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		//맵을 1부터 100까지 채우기
		map = new int[101];
		for(int i = 1; i < 101; i++) {
			map[i] = i;
		}
		//사다리 & 뱀 정보 -> 맵에 그대로 적용
//		info = new int[N+M][2];
		for(int i = 0; i < N+M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x] = y;
		}
		//최소 횟수를 구하기 위해 bfs 이용 //인수는 시작점
		System.out.println(bfs(1));
	}
	
	static int bfs(int start) {
		//확인 및 반환을 위한 배열 설정
		int visited[] = new int[101];
		//큐 생성 및 시작점 주입
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		visited[start] = 0;
		//큐가 빌 때까지 반복 //단, 문제에서 100번 지점에 도달하지 못하는 경우는 없다
		outer:
		while(!q.isEmpty()) {
			int curr = q.poll();//현재 방문지
			//주사위 1~6
			for(int i = 1; i < 7; i++) {
				int next = curr + i;
				//map을 벗어나는 경우 컨티뉴
				if(next > 100) continue;
				//방문하지 않은 경우에만 map[next]의 위치값을 큐에 넣기
				if(visited[map[next]] == 0) {
					q.offer(map[next]);
					//다음 방문지의 횟수값 채우기
					visited[map[next]] = visited[curr] + 1;
				}
				//100번에 도달하면 반환
				if(next == 100) break outer;
			}
		}
		return visited[100];
	}
}