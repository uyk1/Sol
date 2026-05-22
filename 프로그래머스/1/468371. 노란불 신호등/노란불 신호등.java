class Solution {
    public int solution(int[][] signals) {
        long totalCycle = 1;

        // 전체 반복 주기 = 모든 주기의 LCM
        for (int[] s : signals) {
            int period = s[0] + s[1] + s[2];
            totalCycle = lcm(totalCycle, period);
        }
        
        // 전체 반복 주기까지만 확인하면 됨
        for(int t = 1; t <= totalCycle; t++) {
            // 현재 시간의 각 신호등의 상태 확인
            boolean flag = true;
            
            for(int[] s : signals) {
                int g = s[0];
                int y = s[1];
                int r = s[2];
                
                // 현재 주기 내 신호등 상태 확인
                int period = g + y + r;
                int state = ((t - 1) % period) + 1;
                
                if(g >= state || g + y < state) {
                    flag = false;
                }
                
            }

            if (flag) {
                return (int)t;
            }
        }

        return -1;
    }
    
    // 최대공약수
    private long gcd(long a, long b) {
        while(b != 0) {
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        
        return a;
    }
    
    // 최소공배수
    private long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
}