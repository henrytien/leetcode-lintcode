// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int size = prices.size();
        if(size <= 1) return 0;
        
        // 你这里需要定义两种状态
        // 首先你要明白这个题的思考，每轮的做的事情
        // 考虑清楚状态转移方程 cash ->hold->cash->hold
        // 这样我们可以描述出这个方程的转移过程
        
        vector<int> cash(size+1,0);  // 这个dp状态记录手里的收益
        vector<int> hold(size+1,0);  // 这个记录当前手里的股票
        
        // dp初始状态
        cash[0] = 0;
        hold[0] = -prices[0]; // 花钱购买了一支股票
        
        for (int i = 1; i < size; ++i) {
            cash[i] = max(cash[i-1], hold[i-1] + prices[i]);
            hold[i] = max(hold[i-1], cash[i-1] - prices[i]);
        }
        return cash[size-1];
    }
};