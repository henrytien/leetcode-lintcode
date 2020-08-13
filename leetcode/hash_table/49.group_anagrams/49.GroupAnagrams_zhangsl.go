// Source : https://leetcode.com/problems/group-anagrams/
// Author : zhangsl
// Date   : 2020-08-12
package main

import "sort"

/*****************************************************************************************************
 *
 * Given an array of strings, group anagrams together.
 * 
 * Example:
 * 
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 
 * Note:
 * 
 * 	All inputs will be in lowercase.
 * 	The order of your output does not matter.
 * 
 ******************************************************************************************************/


// 思路： 让字母相同的单词生成的值唯一


// time 49.49 mem 37.21
func groupAnagrams(strs []string) [][]string {
	// 边界检查
	ans:=[][]string{}
	if len(strs)<1{
		return ans
	}
	var (
		word string
		val string
	)
	ansRec:=map[string][]string{}
	for _,word=range strs{
		val = helper(word)
		if _,ok:=ansRec[val];ok{
			ansRec[val] = append(ansRec[val],word)
		}else{
			ansRec[val] = []string{word}
		}
	}
	for _,v:=range ansRec{
		ans = append(ans, v)
	}
	return ans
}

type bytes []byte
// 自定义排序规则
func (b bytes) Len() int {
	return len(b)
}
func (b bytes) Less(i,j int) bool {
	return b[i] < b[j]
}
func (b bytes) Swap(i, j int) {
	b[i], b[j] = b[j], b[i]
}

func helper(str string)string{
	bys:=bytes(str)
	sort.Sort(bys)

	return string(bys)
}