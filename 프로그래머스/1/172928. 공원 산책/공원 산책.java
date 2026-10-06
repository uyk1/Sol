import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        int h = park.length; // 공원의 세로 길이
        int w = park[0].length(); // 공원의 가로 길이
        char[][] map = new char[h][w]; // 공원 맵
        
        // 공원 맵 채우기
        for(int i = 0; i < h; i++) map[i] = park[i].toCharArray();
        
        // 시작지점 찾기
        out : for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(map[i][j] == 'S') {
                    answer = new int[] {i, j};
                    break out;
                }
            }
        }
        
        // 로봇 이동시키기
        for(int i = 0; i < routes.length; i++) {
            char[] route = routes[i].toCharArray();
            char dir = route[0]; // 이동 방향
            int dist = route[2] - '0'; // 이동 거리
            boolean flag = true; // 명령 수행 가능 여부 확인
            
            // 방향 벡터
            int dx = 0;
            int dy = 0;
            
            if(dir == 'N') dx = -1;
            else if(dir == 'S') dx = 1;
            else if(dir == 'W') dy = -1;
            else dy = 1;
            
            for(int j = 1; j <= dist; j++) {
                int nx = answer[0] + j * dx;
                int ny = answer[1] + j * dy;
                
                if(nx < 0 || nx >= h || ny < 0 || ny >= w || map[nx][ny] == 'X') {
                    flag = false;
                    break;
                }
            }
            
            // 조건을 통과했다면 로봇 이동
            if(!flag) continue;
            
            answer = new int[] {answer[0] + dist * dx, answer[1] + dist * dy};
        }
        
        return answer;
    }
}