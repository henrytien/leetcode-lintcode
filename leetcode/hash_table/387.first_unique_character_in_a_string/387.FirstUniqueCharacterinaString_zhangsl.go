// Source : https://leetcode.com/problems/first-unique-character-in-a-string/
// Author : zhangsl
// Date   : 2020-08-14
package main

/*****************************************************************************************************
 *
 * Given a string, find the first non-repeating character in it and return its index. If it doesn't
 * exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode"
 * return 2.
 *
 * Note: You may assume the string contains only lowercase English letters.
 ******************************************************************************************************/

//思路
// map 一遍 再扫一遍
// 小优化：使用数组映射到0-25 再扫一遍
// time:40 mem:67
func firstUniqChar(s string) int {
	mp := map[byte]int{}

	for i, _ := range s {
		mp[s[i]]++
	}
	for i,_:=range s{
		if mp[s[i]] ==1{
			return i
		}
	}
	return -1
}
