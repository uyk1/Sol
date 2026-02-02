import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        // 오늘
        String[] tArr = today.split("\\.");
        int tCnt = Integer.valueOf(tArr[0]) * 12 * 28 + Integer.valueOf(tArr[1]) * 28 + Integer.valueOf(tArr[2]);
        
        // 약정과 기간을 담을 맵
        Map<String, Integer> tMap = new HashMap<>();
        for(int i = 0; i < terms.length; i++) tMap.put(terms[i].split(" ")[0], Integer.valueOf(terms[i].split(" ")[1]));
        
        // 개인 정보 확인
        for(int i = 0; i < privacies.length; i++) {
            String[] sArr = privacies[i].split(" "); // 계약 날짜 / 약정
            String[] dArr = sArr[0].split("\\.");
            int dCnt = Integer.valueOf(dArr[0]) * 12 * 28 + Integer.valueOf(dArr[1]) * 28 + Integer.valueOf(dArr[2]) + Integer.valueOf(tMap.get(sArr[1])) * 28;
            // 현재 날짜와 계약 날짜(첫날이 1일차) + 약정 비교
            if(tCnt > dCnt - 1) answer.add(i+1);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}