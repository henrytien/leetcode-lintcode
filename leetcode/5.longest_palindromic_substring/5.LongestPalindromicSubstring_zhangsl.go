// Source : https://leetcode.com/problems/longest-palindromic-substring/
// Author : zhangsl
// Date   : 2020-09-01
package main

import "fmt"

/*****************************************************************************************************
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum
 * length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 *
 ******************************************************************************************************/
// 动态规划三步骤：确定下标含义，确定状态转移方程，确定初始条件
// 思路:
//		<dp含义>       	dp[i][j] 代表代表s[i]~s[j]（闭区间）,是否为回文串(true,false)
//	    <状态转移方程>   	dp[i][j] = dp[i+1][j-1] && s[i]==s[j]
//      <初始条件>       （长度为1）当i==j dp[i][j] = true 当 (长度为2) dp[i][j] = s[i]==s[j]
//time 36 mem:42
func longestPalindrome(s string) string {
	// 构造dp
	dp := make([][]bool, len(s))
	for i := 0; i < len(s); i++ {
		dp[i] = make([]bool, len(s))
	}

	//	 开始逻辑
	var j int
	var ans string
	for l := 0; l < len(s); l++ { //确定i,j之间的距离，
		for i := 0; i+l < len(s); i++ {
			j = i+l
			if l+1 == 1 {
				dp[i][j] = true
			} else if l+1 == 2 {
				if s[i]==s[j]{
					dp[i][j] = true
				}
			} else {
				dp[i][j] = dp[i+1][j-1] && (s[i]==s[j])
			}
			if dp[i][j] && len(ans)<l+1{
				ans = s[i:j+1]
			}
		}
	}
	return ans
}
func main() {
	//
	fmt.Println(longestPalindrome("aba"))
	fmt.Println(longestPalindrome("a"))
	fmt.Println("aaaaaa")
	fmt.Println("")
}