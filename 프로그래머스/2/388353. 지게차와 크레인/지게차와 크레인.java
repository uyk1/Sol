import java.util.Arrays;

class Solution {
    // 전역 변수 설정
    static int answer;
    static char[][] grid;
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        answer = n * m; // 초기화
        grid = new char[n + 2][m + 2]; // 주변부 패딩을 위해 2칸씩 크게 생성
        for(char[] row : grid) Arrays.fill(row, ' '); // 공백으로 초기화
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                grid[i + 1][j + 1] = storage[i].charAt(j); // 값 채우기
        
        for(String str : requests) {
            if(str.length() == 1) {
                // 지게차
                forklift(str.charAt(0));
            } else {
                // 크레인
                crane(str.charAt(0));
            }
        }
        
        return answer;
    }
    
    private void forklift(char c) {
        boolean[][] visited = new boolean[n + 2][m + 2];
        dfs(0, 0, c, visited);
    }
    
    private void dfs(int x, int y, char c, boolean[][] visited) {
        visited[x][y] = true; // 방문 처리
        
        // 사방 탐색
        for(int i = 0; i < 4; i++) {
            int tmpX = x + dx[i];
            int tmpY = y + dy[i];
            
            // 범위 확인
            if(tmpX < 0 || tmpX > n + 1 || tmpY < 0 || tmpY > m + 1) continue;
            
            // 기 방문 여부 체크
            if(visited[tmpX][tmpY]) continue;
            
            // 빈칸일 경우 dfs 진행, 타겟일 경우 출고, 타겟이 아닌 컨테이너의 경우 처리 X
            if(grid[tmpX][tmpY] == ' ') {
                dfs(tmpX, tmpY, c, visited);
            } else if(grid[tmpX][tmpY] == c) {
                visited[tmpX][tmpY] = true; // 방문 처리 - 연쇄 출고 방지
                grid[tmpX][tmpY] = ' ';
                answer--;
            }
        }
    }
    
    private void crane(char c) {
        // grid를 돌며 컨테이너 출고
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < m + 1; j++) {
                if(grid[i][j] != c) continue;
                grid[i][j] = ' ';
                answer--;
            }
        }
    }
}