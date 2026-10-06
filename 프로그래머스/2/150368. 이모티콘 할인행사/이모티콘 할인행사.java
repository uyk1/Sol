class Solution {
    static int[] discounts = {10, 20, 30, 40}; // 가능한 할인율
    static int[] selected; // 아이템별 할인율 저장용 배열
    
    static int maxSubscribers; // 이모티콘 플러스 서비스 가입자
    static int maxSales; // 판매액
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        selected = new int[emoticons.length];
        
        // 정책 적용 확인
        dfs(0, users, emoticons);
        
        return new int[] {maxSubscribers, maxSales};
    }
    
    // dfs 이코티콘별 할인율 조합 생성
    private void dfs(int depth, int[][] users, int[] emoticons) {
        // depth가 이모티콘 개수에 도달하면 확인
        if(depth == emoticons.length) {
            calculate(users, emoticons);
            return;
        }
        
        // 조합 만들기(순서, 중복 상관 없음)
        for(int d : discounts) {
            selected[depth] = d;
            dfs(depth + 1, users, emoticons);
        }
    }
    
    // 결과 확인 및 갱신
    private void calculate(int[][] users, int[] emoticons) {
        int subscribers = 0;
        int sales = 0;
        
        for(int i = 0; i < users.length; i++) {
            int chk = users[i][1]; // 플러스 전환 기준
            int s = 0; // 해당 사용자의 총 구매가
            
            for(int j = 0; j < emoticons.length; j++) {
                // emoticons의 원소는 100의 배수이므로 굳이 double 할 필요 없음
                if(users[i][0] <= selected[j]) {
                    int dcPrice = emoticons[j] * (100 - selected[j]) / 100;
                    s += dcPrice;   
                }
            }
            
            if(chk <= s) {
                subscribers++;
            } else {
                sales += s;
            }
        }
        
        if(maxSubscribers < subscribers) {
            maxSubscribers = subscribers;
            maxSales = sales;
        } else if(maxSubscribers == subscribers && maxSales < sales) {
            maxSales = sales;
        }
    }
}