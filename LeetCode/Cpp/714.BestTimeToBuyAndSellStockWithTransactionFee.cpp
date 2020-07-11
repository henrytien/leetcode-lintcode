// Source : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
// Author : henrytine
// Date   : 2020-07-11

/***************************************************************************************************** 
 *
 * Your are given an array of integers prices, for which the i-th element is the price of a given 
 * stock on day i; and a non-negative integer fee representing a transaction fee.
 * You may complete as many transactions as you like, but you need to pay the transaction fee for each 
 * transaction.  You may not buy more than 1 share of a stock at a time (ie. you must sell the stock 
 * share before you buy again.)
 * Return the maximum profit you can make.
 * 
 * Example 1:
 * 
 * Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * Output: 8
 * Explanation: The maximum profit can be achieved by:
 * Buying at prices[0] = 1Selling at prices[3] = 8Buying at prices[4] = 4Selling at prices[5] = 9The 
 * total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * 
 * Note:
 * 0 .
 * 0 .
 * 0 .
 ******************************************************************************************************/

class Solution {
public:
    int maxProfit(vector<int>& prices, int fee) {
        int T_iK0 = 0, T_iK1 = INT_MIN;
        for (auto price:prices) {
            T_iK0 = max(T_iK0, T_iK1 + price);
            T_iK1 = max(T_iK1, T_iK0 - price - fee);
        }
        return T_iK0;
    }
};