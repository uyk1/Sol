class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        
        int v = wallpaper.length;
        int h = wallpaper[0].length();
        
        int[] start = {v, h}; // 시작점
        int[] end = {0, 0}; // 끝점
        
        // 순회
        for(int i = 0; i < v; i++) {
            for(int j = 0; j < h; j++) {
                boolean isFile = (wallpaper[i].substring(j, j+1)).equals("#") ? true : false; 
                // 파일이 없으면 지나가기
                if(!isFile) continue;
                // 파일이 있다면 정보 갱신
                if(start[0] > i) start[0] = i;
                if(start[1] > j) start[1] = j;
                if(end[0] < i + 1) end[0] = i + 1;
                if(end[1] < j + 1) end[1] = j + 1;
            }
        }
        
        answer = new int[]{start[0], start[1], end[0], end[1]};
        
        return answer;
    }
}