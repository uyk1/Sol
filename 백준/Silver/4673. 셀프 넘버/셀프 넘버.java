public class Main {
	public static void main(String[] args) {
		boolean[] nums = new boolean[10001];
		int n = 1;
		while(n <= 10000) {
			int sum = n;
			char[] tmp = String.valueOf(n).toCharArray();
			for(int i = 0; i < tmp.length; i++) {
				sum += tmp[i] - '0';
			}
			if(sum <= 10000 && !nums[sum]) nums[sum] = true;
			n++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= 10000; i++) {
			if(!nums[i]) sb.append(i).append('\n');
		}
		System.out.println(sb);
	}
}