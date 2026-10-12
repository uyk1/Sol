import java.util.*;

class Solution {
    
    private List<int[]>[] graph;
    private int n, k, start, answer;
    
    public int solution(int n, int infection, int[][] edges, int k) {
        
        this.n = n;
        this.k = k;
        this.start = infection;
        this.answer = 0;
        
        // 파이프를 여는 순서가 중요
        // 그래프 생성(초기화)
        graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int type = e[2];
            
            graph[u].add(new int[]{v, type});
            graph[v].add(new int[]{u, type});
        }
        
        // 타입 순서 DFS
        dfs(new ArrayList<>());
        
        return answer;
    }
    
    // 타입 순열 생성
    private void dfs(List<Integer> seq) {
        // 현재 순서로 시뮬
        simulate(seq);
        
        // k번 제한
        if(seq.size() == k) return;
        
        for(int i = 1; i <= 3; i++) {
            // 만약 직전 페이즈와 같은 파이프 타입이라면 컨티뉴
            if(seq.size() != 0 && seq.get(seq.size() - 1) == i) continue;
            
            seq.add(i);
            
            dfs(seq);
            
            seq.remove(seq.size() - 1);
        }
    }
    
    // 감염 시뮬레이션
    private void simulate(List<Integer> seq) {
        Set<Integer> infected = new HashSet<>();
        infected.add(start);
        
        for(int type : seq) {
            spread(infected, type);
        }
        
        answer = Math.max(answer, infected.size());
    }
    
    // BFS 확장
    private void spread(Set<Integer> infected, int type) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        
        for(int node : infected) {
            q.add(node);
            visited[node] = true;
        }
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for(int[] next : graph[cur]) {
                int nxt = next[0];
                int t = next[1];
                
                // 타입이 다르면 감염 X(무시)
                if(t != type) continue;
                
                if(visited[nxt]) continue;
                
                visited[nxt] = true;
                infected.add(nxt);
                q.add(nxt);
            }
        }
    }
}