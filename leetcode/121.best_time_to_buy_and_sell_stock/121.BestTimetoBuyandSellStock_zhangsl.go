// Source : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
// Author : zhangsl
// Date   : 2020-09-08
package main
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
// 动态规划三步骤
// 确定 dp[i]含义:
// dp[i] 表示第i天卖出,最大的盈利.
// dp[i] = p[i] - minVal; minVal是0-i-1的最小值.
// 确定状态转移方程:
// dp[i-1] = p[i-1]-minVal;
// => dp[i] = p[i] +dp[i-1]-p[i-1]
//	dp[i][j] 代表第i天买入,j天卖出,dp[i][j]代表利润

// 确定初始条件
// dp[0] = 0

// 复杂度:
// time: o(n) ;只需要遍历数组一遍
// mem: o(n)  ; 需要开辟和数组相同大小的空间 记录状态,由于只需要dp[i-1] 所以,可以进行状态压缩

func maxProfit(prices []int) int {
	if len(prices)==0{
		return 0
	}

	dp:=make([]int,len(prices))
	dp[0] = 0
	ans := 0
	for i:=1;i<len(prices);i++{
		dp[i] = dp[i-1]+prices[i]-prices[i-1]
		if dp[i]<0{
			dp[i] =0
		}
		if dp[i]>ans{
			ans = dp[i]
		}
	}
	return ans
}