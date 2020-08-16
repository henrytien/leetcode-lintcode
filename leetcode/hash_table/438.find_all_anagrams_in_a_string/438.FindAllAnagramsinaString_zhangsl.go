// Source : https://leetcode.com/problems/find-all-anagrams-in-a-string/
// Author : zhangsl
// Date   : 2020-08-15
package main

/*****************************************************************************************************
 *
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will not
 * be larger than 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 *
 * Input:
 * s: "cbaebabacd" p: "abc"
 *
 * Output:
 * [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 *
 * Example 2:
 *
 * Input:
 * s: "abab" p: "ab"
 *
 * Output:
 * [0, 1, 2]
 *
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 ******************************************************************************************************/
// 思路：滑动窗口
//time:71 mem:84
func findAnagrams(s string, p string) []int {
	var (
		need        = map[byte]int{} //记录需要的值
		window      = map[byte]int{} //记录窗口中的值
		left, right = 0, 0           //窗口左右指针
		valid       = 0              //窗口中合法的字符数
		ans         = []int{}
	)
	// 初始化need
	for k, _ := range p {
		need[p[k]]++
	}
	for right < len(s) {
		c := s[right]
		right++
		if _, ok := need[c]; ok {
			window[c]++
			if window[c] == need[c] {
				valid++
			}
		}
		for right-left >= len(p) {
			if valid == len(need) {
				ans = append(ans, left)
			}
			d := s[left]
			left++
			if _, ok := need[d]; ok {
				if window[d] == need[d] {
					valid--
				}
				window[d]--
			}
		}
	}
	return ans
}

func main() {
	findAnagrams(
		"cbaebabacd",
		"abc")
}
