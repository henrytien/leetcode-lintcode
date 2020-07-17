// Source : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
// Author : henrytine
// Date   : 2020-07-11

/***************************************************************************************************** 
 *
 * Say you have an array prices for which the ith element is the price of a given stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
 * (i.e., buy one and sell one share of the stock multiple times).
 * 
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock 
 * before you buy again).
 * 
 * Example 1:
 * 
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * 
 * Example 2:
 * 
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 * 
 * Example 3:
 * 
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * 
 * Constraints:
 * 
 * 	1 <= prices.length <= 3 * 10 ^ 4
 * 	0 <= prices[i] <= 10 ^ 4
 ******************************************************************************************************/

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int T_iK0 = 0, T_iK1 = INT_MIN;
        for(auto price: prices) {
            T_iK0 = max(T_iK0, T_iK1 + price);
            T_iK1 = max(T_iK1, T_iK0 - price);
        }
        return T_iK0;
    }
};



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