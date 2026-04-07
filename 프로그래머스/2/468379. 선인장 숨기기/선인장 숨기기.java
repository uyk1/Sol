import java.util.*;

class Solution {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        // 브루트 포스 방식의 경우, 시간초과가 발생.
        // 각 행 - 열에서 구역의 최솟값을 저장하는 슬라이딩 윈도우 방식을 사용할 것
        
        // 맵 초기화
        int[][] map = new int[m][n];
        // 비를 맞지 않는 부분을 최대값으로 초기화하여, 비를 맞지 않는 구역이 최우선이 되도록.
        for(int[] arr : map) Arrays.fill(arr, Integer.MAX_VALUE);
        // drops 복사
        for(int i = 0; i < drops.length; i++)
            map[drops[i][0]][drops[i][1]] = i + 1;
        
        // 슬라이딩 윈도우 - 행
        int[][] rowMin = new int[m][n - w + 1];
        for(int i = 0; i < m; i++) {
            // deque를 이용해 최솟값 저장
            Deque<Integer> dq = new ArrayDeque<>();
            
            for(int j = 0; j < n; j++) {
                // deque가 비어있지 않은 경우, 마지막 위치 값과 비교해서 현재 값이 작거나 같을 때 값 교환
                while(!dq.isEmpty() && map[i][dq.peekLast()] >= map[i][j]) dq.pollLast();
                dq.addLast(j);
                // 다음 계산할 슬라이딩 윈도우에 포함되지 않는 인덱스는 제거
                if(dq.peekFirst() < j - w + 1) dq.pollFirst();
                // 슬라이딩 윈도우 저장(윈도우 완성된 경우)
                if(0 <= j - w + 1) rowMin[i][j - w + 1] = map[i][dq.peekFirst()];
            }
        }
        
        // 슬라이딩 윈도우 - 열
        int[][] areaMin = new int[m - h + 1][n - w + 1];
        for(int j = 0; j < n - w + 1; j++) {
            Deque<Integer> dq = new ArrayDeque<>();
            
            for(int i = 0; i < m; i++) {
                while(!dq.isEmpty() && rowMin[dq.peekLast()][j] >= rowMin[i][j]) dq.pollLast();
                dq.addLast(i);
                if(dq.peekFirst() < i - h + 1) dq.pollFirst();
                if(0 <= i - h + 1) areaMin[i - h + 1][j] = rowMin[dq.peekFirst()][j];
            }
        }
        
        // 해당 좌표 탐색
        int best = areaMin[0][0];
        int[] answer = new int[2];
        // 좌측 상단부터 우측 하단으로 탐색
        for(int i = 0; i < areaMin.length; i++) {
            for(int j = 0; j < areaMin[0].length; j++) {
                // 같은 경우, 기존 위치 유지
                if(best < areaMin[i][j]) {
                    best = areaMin[i][j];
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        
        return answer;
    }
}