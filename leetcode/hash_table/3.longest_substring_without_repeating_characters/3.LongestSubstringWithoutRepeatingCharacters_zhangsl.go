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
// todo @zhangshilin timeout
func lengthOfLongestSubstring(s string) int {
	if len(s) <=1{
		return len(s)
	}

	mark:=make(map[byte]bool)
	ans:=1
	max:=func(x,y int)int{
		if x>y{
			return x

		}
		return y
	}
	//初始化
	var ps,pe byte=0,1
	mark[s[ps]] = true
	for int(pe)<len(s){
		if ps==pe{
			pe++
		}
		_,ok:=mark[s[pe]]
		if ok{
			ps++
			pe++
		}else{
			ans = max(ans,int(pe)-int(ps)+1)
			mark[s[pe]] = true
			pe++
		}
	}
	return ans
}