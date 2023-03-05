import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] tree;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 0;
		while(true) {
			tc++;
			String str = br.readLine();
			if(str.equals("0 0")) break;
			StringTokenizer st = new StringTokenizer(str);
			N = Integer.parseInt(st.nextToken()); //정점의 개수
			M = Integer.parseInt(st.nextToken()); //간선의 개수
			//그래프가 트리인지 확인하기 위해 입력 저장(인접 리스트)
			tree = new ArrayList[N+1];
			for(int i = 0; i <= N; i++) {
				tree[i] = new ArrayList<>();
			}
			for(int i = 1; i <= M; i++) {
				StringTokenizer stt = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(stt.nextToken()); 
				int B = Integer.parseInt(stt.nextToken()); 
				tree[A].add(B);
				tree[B].add(A);
			}
			//확인을 위해 방문 배열 이용(사이클이 있다면 트리가 아니다)
			int cnt = 0;//트리의 개수
			visited = new boolean[N+1];
			for(int i = 1; i <= N; i++) {
				if(!visited[i]) {
					visited[i] = true;
					if(dfs(0, i)) cnt++;
				}
			}
			
			System.out.print("Case " + tc + ": ");
			if(cnt == 0) System.out.println("No trees.");
			else if(cnt == 1) System.out.println("There is one tree.");
			else System.out.println("A forest of " + cnt + " trees.");			
		}
	}
	
	static boolean dfs(int root, int num) {
		for(int i: tree[num]) {
			if(i == root) continue;//직전노드의 경우 방문했더라도 false가 아님.
			if(visited[i]) return false;//이미 방문한 곳을 또 방문하는 경우, 사이클 생성
			visited[i] = true;//아직 방문하지 않은 경우, 방문 표시
			if(!dfs(num, i)) return false;//다음 노드 탐색 중 사이클 생성 시 return false
		}
		return true;
	}
}