class Solution {
    public int[] solution(String s) {
        
        int chgCnt = 0; // 변환한 횟수
        int zeroCnt = 0; // 제거한 0의 개수
        
        while(!s.equals("1")) {
            int tmpCnt1 = s.length(); // 0 제거 전 길이
            s = s.replaceAll("0",""); // 0 제거
            int tmpCnt2 = s.length(); // 0 제거 후 길이
            zeroCnt += tmpCnt1 - tmpCnt2; // 제거한 0의 개수 더하기
            s = Integer.toBinaryString(tmpCnt2); // 2진수 변환
            chgCnt++;
        }
        
        return new int[] {chgCnt, zeroCnt};
    }
}