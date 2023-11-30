import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static char[][] map;
	static int ans;
	// 상하좌우
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new char[5][5];
		for(int i = 0; i < 5; i++) {
			map[i] = sc.next().toCharArray();
		}
		
		// 25명 중 7명을 뽑고(조합), 뽑힌 7명 중 4명 이상이 S인지 확인하고, 서로 인접해 있는지 확인
		comb(new int[7], 0, 0, 0, 0);
		
		System.out.println(ans);
	}
	
	// 뽑힌 그룹, 그룹 내 번호, 0~24 중 누구, 현재까지 뽑은 수, 현재까지 뽑은 S 수
	static void comb(int[] group, int idx, int depth, int count, int sCount) {
		if(count == 7) {
			if(sCount < 4) return;
			if(bfs(group)) ans++;
			return;
		}
		if(depth == 25) return;
		// 뽑고 지나가기, 안 뽑고 지나가기
		group[idx] = depth;
		if(map[depth/5][depth%5] == 'S') {
			comb(group, idx + 1, depth + 1, count + 1, sCount + 1);
			comb(group, idx, depth + 1, count, sCount);
		} else {
			comb(group, idx + 1, depth + 1, count + 1, sCount);
			comb(group, idx, depth + 1, count, sCount);
		}
	}
	
	// 서로 연결된 상태인지 확인
	static boolean bfs(int[] group) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[7];
		
		visited[0] = true;
		q.add(group[0]);
		
		int cnt = 1;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			// 사방탐색
			for(int i = 0; i < 4; i++) {
				int nx = cur / 5 + dx[i];
				int ny = cur % 5 + dy[i];
				if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue; 
				
				for(int j = 1; j < 7; j++) {
					if(!visited[j] && group[j] / 5 == nx && group[j] % 5 == ny) {
						visited[j] = true;
						q.add(group[j]);
						cnt++;
					}
				}
			}
		}
		
		if(cnt == 7) return true;
		return false;
	}
}
