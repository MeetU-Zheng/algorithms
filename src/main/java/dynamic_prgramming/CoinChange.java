package dynamic_prgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//LeetCode 322
public class CoinChange {
	private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	public int solution1(int[] coins, int amount) {
		if (amount < 0)
			return -1;
		if (amount == 0)
			return 0;
		if (map.containsKey(amount))
			return map.get(amount);
		int res = Integer.MAX_VALUE;
		for (int coin : coins) {
			int subRes = solution1(coins, amount - coin);
			if (subRes == -1)
				continue;
			res = Math.min(res, subRes + 1);
		}
		map.put(amount, res == Integer.MAX_VALUE ? -1 : res);
		return map.get(amount);
	}

	public int solution2(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			int res = Integer.MAX_VALUE;
			for (int coin : coins) {
				if (i < coin)
					continue;
				dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
			}
		}
		return (dp[amount] == amount + 1) ? -1 : dp[amount];
	}

	//dfs, 剪枝
	int ans=Integer.MAX_VALUE;
	public int solution3(int[] coins, int amount) {
		dfs(coins, coins.length - 1, amount, 0);
		return ans;
	}

	private void dfs(int[] coins, int index, int amount, int num) {
		if(index<0)return;
		for (int c = amount / coins[index]; c >= 0; c--) {
			int remain = amount - c*coins[index];
			int cnt = num + c;
			if(remain == 0) {
				ans = Math.min(cnt, ans);
				break;
			}
			if(ans <= cnt + 1) break;
			dfs(coins, index-1, remain, cnt);
		}
	}
	
	
	
}
