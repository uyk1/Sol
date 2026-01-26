import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        
        // 돗자리 정렬
        Arrays.sort(mats);
        
        // 돗자리 별로 큰 것부터 확인
        exit1:
        for(int m = mats.length - 1; m >= 0; m--) {
            
            int len = mats[m]; // 확인할 매트 한 변 길이
            int v = park.length; // 공원 세로 길이
            int h = park[0].length; // 공원 가로 길이
            
            // 공원을 돌며 자리 확인
            for(int i = 0; i < v; i++) {
                // 만약 현재 위치에서 매트 길이만큼 세로 공간이 충분하지 않다면 브레이크
                if(i + len > v) break;
                
                exit2:
                for(int j = 0; j < h; j++) {
                    // 만약 현재 위치에서 매트 길이만큼 가로 공간이 충분하지 않다면 브레이크
                    if(j + len > h) break;
                    // 공간이 충분하다면 공간이 비어있는지 확인
                    for(int a = i; a < i + len; a++) {
                        for(int b = j; b < j + len; b++) {
                            if(!park[a][b].equals("-1")) {
                                continue exit2;
                            }
                        }
                    }
                    // 공간 확인이 끝난 경우 종료
                    answer = len;
                    break exit1;
                }
            }    
        }
        
        return answer;
    }
}