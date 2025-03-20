class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        // 초 단위로 변환
        int vs = Integer.valueOf(video_len.substring(0, 2)) * 60 + Integer.valueOf(video_len.substring(3));
        int ps = Integer.valueOf(pos.substring(0, 2)) * 60 + Integer.valueOf(pos.substring(3));
        int oss = Integer.valueOf(op_start.substring(0, 2)) * 60 + Integer.valueOf(op_start.substring(3));
        int oes = Integer.valueOf(op_end.substring(0, 2)) * 60 + Integer.valueOf(op_end.substring(3));
        
        // 현재 동영상 위치가 오프닝 시간 범위인지 확인
        if(ps >= oss && ps <= oes) ps = oes;
        
        // 커맨드 실행
        for(int i = 0; i < commands.length; i++) {
            String str = commands[i];
            if(str.equals("prev")) {
                if(ps < 10) {
                    ps = 0;
                } else {
                    ps -= 10;
                }
            } else if(str.equals("next")) {
                if(ps + 10 > vs) {
                    ps = vs;
                } else {
                    ps += 10;
                }
            }
            
            // 현재 동영상 위치가 오프닝 시간 범위인지 확인
            if(ps >= oss && ps <= oes) ps = oes;
        }
        
        // 변환
        String mm = String.format("%2s", String.valueOf(ps/60)).replace(" ", "0");
        String ss = String.format("%2s", String.valueOf(ps%60)).replace(" ", "0");
        
        answer = mm + ":" + ss;
        
        return answer;
    }
}