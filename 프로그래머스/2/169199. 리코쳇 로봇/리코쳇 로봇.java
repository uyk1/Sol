import java.util.*;

class Solution {
    /*
    사방탐색을 기반으로, 최소 경로 탐색.
    BFS 방식 활용.
    */
    
    public int solution(String[] board) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        Queue<Position> q = new LinkedList<>();
        
        char[][] map = new char[board.length][board[0].length()];
        
        boolean[][] visited = new boolean[board.length][board[0].length()];
        
        int[] dst = new int[2];
        
        for(int i = 0; i < board.length; i++) {
            map[i] = board[i].toCharArray();
            
            for(int j = 0; j < board[0].length(); j++) {
                if(map[i][j] == 'R') {
                    q.add(new Position(i, j, 0));
                    visited[i][j] = true;
                }
                
                if(map[i][j] == 'G') dst = new int[] {i, j};
            }
        }
        
        // BFS
        while(!q.isEmpty()) {
            // 사방탐색 가능한지 확인 & 경계 확인
            Position start = q.poll();
            
            // 목적지에 도달한 경우 BFS이므로 바로 반환(최소 이동 거리)
            if(start.x == dst[0] && start.y == dst[1]) {
                return start.distance;
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = start.x;
                int ny = start.y;
                
                while(true) {
                    nx += dx[i];
                    ny += dy[i];
                    
                    if(nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length || map[nx][ny] == 'D') {
                        nx -= dx[i];
                        ny -= dy[i];
                        
                        break;
                    }
                }
                
                if(nx == start.x && ny == start.y) continue;
                
                if(!visited[nx][ny]){
                    q.add(new Position(nx, ny, start.distance + 1));
                    visited[nx][ny] = true;
                }
            }
        }
        
        return -1;
    }
    
    private class Position {
        int x;
        int y;
        int distance;
        
        Position(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}