class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        // 사방 탐색
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for(int i = 0; i < 4; i++) {
            int nx = h + dx[i];
            int ny = w + dy[i];
            // 범위를 벗어나지 않는 경우 색 확인
            if(nx < 0 || nx >= board[0].length || ny < 0 || ny >= board.length) continue;
            if(board[h][w].equals(board[nx][ny])) answer++;
        }
        
        return answer;
    }
}