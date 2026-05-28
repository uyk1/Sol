import java.util.*;

class Solution {
    // 사방탐색
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] land) {
        int answer = 0;
        
        // 한 번 전체 맵을 돌면서 각 열에서 얻을 수 있는 석유의 양 확인
        int n = land.length; // 행 수
        int m = land[0].length; // 열 수
        
        // 방문 확인용
        boolean[][] visited = new boolean[n][m];
        
        // 각 열에 시추관을 꽂아 얻을 수 있는 석유량
        int[] oil = new int[m];
        
        // 전체 맵 돌기
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                // 석유가 있는 칸인지, 기 방문한 지점인지 확인
                if(land[i][j] == 1 && !visited[i][j]) {
                    // bfs 탐색 - 얻을 수 있는 석유량 확인
                    bfs(i, j, land, visited, oil);
                }
            }
        }
        
        for(int o : oil) answer = Math.max(answer, o);
        
        return answer;
    }
    
    void bfs(int a, int b, int[][] land, boolean[][] visited, int[] oil) {
        int n = land.length;
        int m = land[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        
        // 시작 지점
        q.offer(new int[] {a, b});
        
        // 방문 처리
        visited[a][b] = true;
        
        // 열 위치 저장
        Set<Integer> cols = new HashSet<>();
        cols.add(b);
        
        // 획득한 석유량
        int count = 1;
        
        // 큐가 빌 때까지 탐색 반복 진행
        while(!q.isEmpty()) {
            int[] target = q.poll();
            int x = target[0];
            int y = target[1];
                
            // 사방탐색
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 범위 확인
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                
                // 방문 여부 및 오일 유무 확인
                if(visited[nx][ny] || land[nx][ny] == 0) continue;
                
                // 탐색 이어서 진행하기 위해 큐에 넣기, 방문 처리, 카운트 증가
                q.add(new int[] {nx, ny});
                visited[nx][ny] = true;
                count++;
                
                // 방문한 열 위치 저장
                cols.add(ny);
            }
        }
        
        for(int col : cols) {
            oil[col] += count;   
        }
    }
}