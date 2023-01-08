import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R; //정점 수, 간선 수, 시작 정점
    static ArrayList<Integer>[] edges; //간선을 저장
    static int[] visited; //정점 방문 확인 및 각 정점의 방문 순서 기록
    static int cnt; //방문 순서 기록을 위한 카운트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        edges = new ArrayList[N+1];
        //초기화
//        for(ArrayList<Integer> a: edges) a = new ArrayList<Integer>();
        for(int i = 0; i <= N; i++) edges[i] = new ArrayList<>();
        visited = new int[N+1];
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            edges[b].add(a);
        }
        //오름차순으로 방문 -> 미리 정렬
        for(int i = 1; i <= N; i++) Collections.sort(edges[i]);
        //R부터 방문 시작
        cnt = 1;
        DFS(R);
        //방문 순서 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) sb.append(visited[i] + "\n");
        System.out.println(sb);
    }

    static void DFS(int r) {
        visited[r] = cnt;
        for(int next: edges[r]){
            if(visited[next] == 0) {
                cnt++;
                DFS(next);
            }
        }
    }
}