// https://www.lintcode.com/problem/work-plan/description?_from=ladder&&fromId=157
class Solution {
public:
    /**
     * @param low: the simple task
     * @param high: the complex task
     * @return: the most value
     */
    int workPlan(vector<int> &low, vector<int> &high) {
        // Write your code here.
        int dp[10500];
        int n = low.size();
        int i;
        memset(dp, 0, sizeof(dp));
        dp[1] = low[0];
        for (i = 2; i <= n; i++) {
            dp[i] = max(dp[i - 1] + low[i - 1], dp[i - 2] + high[i - 1]);
        }
        return dp[n];
    }
};