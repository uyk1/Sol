import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // 신고받은 사용자별로 신고한 사용자들을 저장해두고, 차후 메일 보내기
        // 어떤 유저가 동일한 유저를 여러 번 신고하더라도, 1회로 처리됨(Set으로 중복 제거)
        Map<String, Set<String>> map = new HashMap<>();
        
        // id 탐색용 맵 생성(시간복잡도 감소)
        Map<String, Integer> id_map = new HashMap<>();
        for(int i = 0; i < id_list.length; i++) id_map.put(id_list[i], i);
        
        // report를 돌면서 신고 내역 저장
        for(String str : report) {
            // str 분해
            String[] arr = str.split(" ");
            String a = arr[0];
            String b = arr[1];
            
            if(!map.containsKey(b)) {
                // 신고당한 ID가 아직 map에 없는 경우 추가 및 초기화
                map.put(b, new HashSet<>());
            }
            
            // 신고자 추가
            map.get(b).add(a);
        }
        
        // map을 돌면서, 신고자가 k명 이상인 경우 해당 ID의 신고자들에 메일 보내기
        for(Map.Entry<String, Set<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            Set<String> val = entry.getValue();
            
            if(val.size() >= k) {
                for(String str : val) {
                    answer[id_map.get(str)]++;
                }
            }
        }
        
        return answer;
    }
}