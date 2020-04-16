// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int len = prices.size();
        if (len < 2) {
            return 0;
        }
        vector<int> cach(len+1,0);
        vector<int> hold(len+1,0);

        cach[0] = 0;
        // first day
        hold[0] = -prices[0];
        for (int i = 1; i < len; i++) { 
            cach[i] = max(cach[i - 1], hold[i-1] + prices[i]);
            hold[i] = max(hold[i - 1], cach[i-1] - prices[i]); 
        }
        return cach[len - 1];
    }
};