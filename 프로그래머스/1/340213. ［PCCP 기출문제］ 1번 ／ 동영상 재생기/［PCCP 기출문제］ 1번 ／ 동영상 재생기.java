import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int len = toSec(video_len);
        int p = toSec(pos);
        int ops = toSec(op_start);
        int ope = toSec(op_end);
        
        // p(현재 시작 위치)가 오프닝 구간인지 먼저 확인
        p = opSkip(p, ops, ope);
        
        // 명령 수행
        for(String s : commands) {
            if(s.equals("prev")) {
                p = (p <= 10) ? 0 : p - 10;
            } else if(s.equals("next")) {
                p = (p >= len - 10) ? len : p + 10;
            }
            
            p = opSkip(p, ops, ope);
        }
        
        return toStr(p);
    }
    
    // 초 변환
    private int toSec(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
    
    // 포매팅
    private String toStr(int sec) {
        int m = sec / 60;
        int s = sec % 60;
        return String.format("%02d:%02d", m, s);
    }
    
    // 오프닝 구간
    private int opSkip(int p, int ops, int ope) {
        if(p >= ops && p <= ope) return ope;
        return p;
    }
}