// https://www.lintcode.com/problem/goods-transfer/description

class Solution {
public:
    /**
     * @param n: the number of backpacks
     * @param a: the number of goods each backpack carries
     * @param b:  the maximum capacity of each backpack
     * @return: given n, ai and bi,return the minimum number of backpacks and the minimum time
     */
    vector<int> goodsTransfer(int n, vector<int> &a, vector<int> &b) {
        // write your code here
        int const INF = 0xfffffff;
        int k = INF, max_weight = 0;
        int sum_good = 0, sum_cap = 0;
        for (int i = 0; i < a.size(); i++) {
            sum_good += a[i];
            sum_cap += b[i];
        }
        vector<int> dp(sum_cap + 1, INF);
        vector<int> weight(sum_cap + 1, 0);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = sum_cap; j > 0; j--) {
                int res = max(j - b[i], 0);
                if (dp[j] < dp[res] + 1) {
                    continue;
                } else if (dp[j] > dp[res] + 1) {
                    dp[j] = dp[res] + 1;
                    weight[j] = weight[res] + a[i];
                } else {
                    weight[j] = max(weight[j], weight[res] + a[i]);
                }
            }
        }
    
        for (int i = sum_good; i <= sum_cap; i++) {
            if (dp[i] < k) {
                k = dp[i];
                max_weight = weight[i];
            } else if (dp[i] == k) {
                max_weight = max(max_weight, weight[i]);
            }
        }
    
        return vector<int>{k, sum_good - max_weight};
    }
};