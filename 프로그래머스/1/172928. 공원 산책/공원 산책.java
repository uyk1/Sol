import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        int h = park.length; // 공원의 세로 길이
        int w = park[0].length(); // 공원의 가로 길이
        char[][] map = new char[h][w]; // 공원 맵
        
        // 공원 맵 채우기
        for(int i = 0; i < h; i++) map[i] = park[i].toCharArray();
        
        System.out.println(Arrays.deepToString(map));
        
        // 시작지점 찾기
        out : for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(map[i][j] == 'S') {
                    answer = new int[] {i, j};
                    break out;
                }
            }
        }
        
        System.out.println(Arrays.toString(answer));
        
        // 로봇 이동시키기
        for(int i = 0; i < routes.length; i++) {
            char[] route = routes[i].toCharArray();
            char dir = route[0]; // 이동 방향
            int dist = route[2] - '0'; // 이동 거리
            boolean flag = true; // 명령 수행 가능 여부 확인
            
            for(int j = 1; j <= dist; j++) {
                // N
                if(dir == 'N') {
                    int tmp = answer[0] - j;
                    
                    // 맵 범위 확인
                    if(tmp < 0) {
                        flag = false;
                        break;
                    }
                    
                    // 장애물 확인
                    if(map[tmp][answer[1]] == 'X') {
                        flag = false;
                        break;
                    }
                }
                
                // S
                if(dir == 'S') {
                    int tmp = answer[0] + j;
                    
                    // 맵 범위 확인
                    if(tmp > h - 1) {
                        flag = false;
                        break;
                    }
                    
                    // 장애물 확인
                    if(map[tmp][answer[1]] == 'X') {
                        flag = false;
                        break;
                    }
                }
                
                // W
                if(dir == 'W') {
                    int tmp = answer[1] - j;
                    
                    // 맵 범위 확인
                    if(tmp < 0) {
                        flag = false;
                        break;
                    }
                    
                    // 장애물 확인
                    if(map[answer[0]][tmp] == 'X') {
                        flag = false;
                        break;
                    }
                }
                
                // E
                if(dir == 'E') {
                    int tmp = answer[1] + j;
                    
                    // 맵 범위 확인
                    if(tmp > w - 1) {
                        flag = false;
                        break;
                    }
                    
                    // 장애물 확인
                    if(map[answer[0]][tmp] == 'X') {
                        flag = false;
                        break;
                    }
                }
            }
            
            // 조건을 통과했다면 로봇 이동
            if(!flag) continue;
            
            if(dir == 'N') {
                answer = new int[] {answer[0] - dist, answer[1]};
            } else if(dir == 'S') {
                answer = new int[] {answer[0] + dist, answer[1]};
            } else if(dir == 'W') {
                answer = new int[] {answer[0], answer[1] - dist};
            } else {
                answer = new int[] {answer[0], answer[1] + dist};
            }
        }
        
        return answer;
    }
}