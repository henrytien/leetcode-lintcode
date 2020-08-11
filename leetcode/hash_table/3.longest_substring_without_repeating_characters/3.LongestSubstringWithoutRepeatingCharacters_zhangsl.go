// Source : https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Author : zhangsl
// Date   : 2020-08-10
package main
/***************************************************************************************************** 
 *
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * Example 1:
 * 
 * Input: "abcabcbb"
 * Output: 3 
 * Explanation: The answer is "abc", with the length of 3. 
 * 
 * Example 2:
 * 
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * Example 3:
 * 
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3. 
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 ******************************************************************************************************/
// ps,pe
// 思路 滑动窗口，当首尾相同，ps向后移动，并更新最大值，移动到最后，直接返回
// time:70.24 mem:48.98
func lengthOfLongestSubstring(s string) int {
	if len(s)<=1{
		return len(s)
	}
	var (
		ans = 1
		hash=map[byte]int{}
		l,r = 0,1
	)
	max:= func(i,j int)int {
		if i>=j{
			return i
		}
		return j
	}
	hash[s[l]] = 0
	//hash[s[r]] = 1
	for r<len(s){
		if v,ok:=hash[s[r]];ok&&v>=l{
			hash[s[r]] = r //左边重复字符出窗，右边重复字符入窗，更新重复字符的最新位置
			ans = max(ans,r-l) // 更新结果
			l = v+1 //更新窗口的左边界
			r++ // 更新窗口右边界
		}else{
			ans=max(ans,r-l+1) //更新结果
			hash[s[r]] = r
			r++ //更新窗口右边界
		}
	}
	return ans


}