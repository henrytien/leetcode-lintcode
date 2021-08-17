// Source : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
// Author : henrytine
// Date   : 2020-09-09

/***************************************************************************************************** 
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * 
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of 
 * the stock), design an algorithm to find the maximum profit.
 * 
 * Note that you cannot sell a stock before you buy one.
 * 
 * Example 1:
 * 
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 * 
 * Example 2:
 * 
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * 
 ******************************************************************************************************/

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        // int T_i10 = 0, T_i11 = INT_MIN;
        // for (auto price:prices) {
        //     T_i10 = max(T_i10,T_i11 + price);
        //     T_i11 = max(T_i11,-price);
        // }
        // return T_i10;
        int minPrice = INT_MAX, maxProfit = 0;
        for (auto price: prices) {
            minPrice = min(price, minPrice);
            maxProfit = max(maxProfit, price-minPrice);
        }
        return maxProfit;
    }
};

class Solution2 {
public:
    int maxProfit(vector<int>& prices) {
        if (prices.size() == 0) {
            return 0;
        }

        int buy = prices[0];
        int profit = 0;
        for (int i  = 1; i < prices.size(); i++) {
            if (buy > prices[i]) {
                buy = prices[i];
            }
            profit = max(profit,prices[i] - buy);
        }
        return profit;
    }
};
