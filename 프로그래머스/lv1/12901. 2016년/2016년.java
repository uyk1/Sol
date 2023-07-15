class Solution {
    public String solution(int a, int b) {
        String[] arr = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int days = 0;
        int sign = 0;
        for(int i = 1; i <= a - 1; i++) {
            if(i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) days += 31;
            else if(i == 4 || i == 6 || i == 9 || i == 11) days += 30;
            else days += 29;
        }
        days += b;
        sign = (days + 4) % 7;
        return arr[sign];
    }
}