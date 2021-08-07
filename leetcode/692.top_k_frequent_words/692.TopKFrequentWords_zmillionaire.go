// Source : https://leetcode.com/problems/top-k-frequent-words/
// Author : zmillionaire
// Date   : 2020-08-11
package main

import (
	"sort"
)

/*****************************************************************************************************
 *
 * Given a non-empty list of words, return the k most frequent elements.
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same
 * frequency, then the word with the lower alphabetical order comes first.
 *
 * Example 1:
 *
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 *     Note that "i" comes before "love" due to a lower alphabetical order.
 *
 * Example 2:
 *
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 *     with the number of occurrence being 4, 3, 2 and 1 respectively.
 *
 * Note:
 *
 * You may assume k is always valid, 1 &le; k &le; number of unique elements.
 * Input words contain only lowercase letters.
 *
 * Follow up:
 *
 * Try to solve it in O(n log k) time and O(n) extra space.
 *
 ******************************************************************************************************/

// 思路1 堆 todo @zhangshilin
// 思路2 hash +sort
//time:66.67 mem:55.56
func topKFrequent(words []string, k int) []string {
	// 处理边界
	if len(words) < 1 {
		return words
	}
	type wordInfo struct {
		word  string
		times int
	}
	occo := map[string]int{}
	for _, v := range words {
		occo[v]++
	}
	sortList := []wordInfo{}
	for k, v := range occo {
		sortList = append(sortList, wordInfo{k, v})
	}
	// 排序
	sort.Slice(sortList, func(i, j int) bool {
		if sortList[i].times == sortList[j].times {
			return sortList[i].word < sortList[j].word
		}
		return sortList[i].times>sortList[j].times

	})
	minNum := func(x, y int) int {
		if x <= y {
			return x
		}
		return y
	}(len(sortList), k)
	ans := []string{}
	for i := 0; i < minNum; i++ {
		ans = append(ans, sortList[i].word)
	}
	return ans
}
func main() {
	topKFrequent([]string{
		"i", "love", "leetcode", "i", "love", "coding",
	},2)
}
