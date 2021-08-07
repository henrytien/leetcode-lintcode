// Source : https://leetcode.com/problems/verifying-an-alien-dictionary/
// Author : zhangsl
// Date   : 2020-08-10
package main

/***************************************************************************************************** 
 *
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a 
 * different order. The order of the alphabet is some permutation of lowercase letters.
 * 
 * Given a sequence of words written in the alien language, and the order of the alphabet, return true 
 * if and only if the given words are sorted lexicographicaly in this alien language.
 * 
 * Example 1:
 * 
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 * 
 * Example 2:
 * 
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence 
 * is unsorted.
 * 
 * Example 3:
 * 
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is shorter (in size.) 
 * According to lexicographical rules "apple" > "app", because 'l' > '&empty;', where '&empty;' is 
 * defined as the blank character which is less than any other character (More info).
 * 
 * Constraints:
 * 
 * 	1 <= words.length <= 100
 * 	1 <= words[i].length <= 20
 * 	order.length == 26
 * 	All characters in words[i] and order are English lowercase letters.
 ******************************************************************************************************/

// 思路 ，比较words中相邻的两个，所有都符合规则 true
// time:100% mem:40%
func isAlienSorted(words []string, order string) bool {
	if len(words)<2{
		return true
	}
	mark:=map[byte]int{}
	for i:=0;i<len(order);i++{
		mark[order[i]] = i
	}
	for i:=0;i<len(words)-1;i++{
		word1:=words[i]
		word2:=words[i+1]
		pos:=0
		for {
			switch  {
			case pos>=len(word1) && pos>=len(word2): // 长度相同
				goto next
			case pos>=len(word1): // 单词1短
				goto next
			case pos>=len(word2): // 单词2短
				return false
			case word1[pos]==word2[pos]: // 相同
				pos++
			case word1[pos]!=word2[pos]: // 不同 需要比较字典序
				if mark[word1[pos]]<mark[word2[pos]]{
					goto next
				}else {
					return false
				}
			//case mark[word1[pos]]<=mark[word2[pos]]:
			//	pos++
			//case mark[word1[pos]]>mark[word2[pos]]:
			//	return false

			}
		}
		next:
	}
	return true
}