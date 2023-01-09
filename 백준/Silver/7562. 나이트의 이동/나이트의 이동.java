import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int x, y, cnt; //좌표

		public Node(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); //테스트 케이스
		for(int t = 1; t <= T; t++) {
			int L = Integer.parseInt(br.readLine()); //한 변의 길이
			boolean[][] visited = new boolean[L][L]; //체스판
			int[] place = new int[4]; //0,1은 현재 칸 / 2,3은 이동하려는 칸
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int i = 0; i < 2; i++) {
				place[i] = Integer.parseInt(st.nextToken());
				place[i+2] = Integer.parseInt(st2.nextToken());
			}
			if(place[0] == place[2] && place[1] == place[3]) {
				System.out.println(0);
				continue;
			}
			Queue<Node> q = new LinkedList<>(); //BFS를 위한 큐
			Node start = new Node(place[0], place[1], 0);
			q.add(start);
			visited[start.x][start.y] = true;
			
			//나이트가 갈 수 있는 칸 체크
			int[] dr = {-2, -2, -1, 1, 2, 2, 1, -1};
			int[] dc = {-1, 1, 2, 2, 1, -1, -2, -2};
			
			outer:
			while(!q.isEmpty()) {
				Node curr = q.poll();
				for(int i = 0; i < 8; i++) {
					int nr = curr.x + dr[i];
					int nc = curr.y + dc[i];
					int cnt = curr.cnt;
							
					if(nr == place[2] && nc == place[3]) {
						System.out.println(cnt+1);
						break outer;
					}
					if(nr >= 0 && nr < L && nc >= 0 && nc < L) {
						if(!visited[nr][nc]) {
							visited[nr][nc] = true;
							q.add(new Node(nr, nc, cnt + 1));
						}
					}
				}
			}
			
		}
	}
}
//최소 도달 횟수를 구하면 되므로  BFS