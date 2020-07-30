// Source : https://leetcode.com/problems/word-ladder/
// Author : zmillionaire
// Date   : 2020-07-29
package main

import "fmt"

/*****************************************************************************************************
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest
 * transformation sequence from beginWord to endWord, such that:
 *
 * 	Only one letter can be changed at a time.
 * 	Each transformed word must exist in the word list.
 *
 * Note:
 *
 * 	Return 0 if there is no such transformation sequence.
 * 	All words have the same length.
 * 	All words contain only lowercase alphabetic characters.
 * 	You may assume no duplicates in the word list.
 * 	You may assume beginWord and endWord are non-empty and are not the same.
 *
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 *
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 ******************************************************************************************************/
// 思路：
// 抽象成图，每个单词是节点(状态),但是建立临接表有点耗时，参考官方题解将临接表的键设置为
// h*g的形式，只需要扫一遍wordlist就能建立邻接表，太妙了。

//遇到问题或一定不要急于解决，先确定好问题！！！！
type pair struct {
	word string
	step int
}

func ladderLength(beginWord string, endWord string, wordList []string) int {
	if wordList == nil || len(wordList) == 0 {
		return 0
	}
	var (
		adj    = make(map[string][]string)
		adjKey string
		list   []string
		ok     bool
		mark = make(map[string]bool)
	)
	//生成邻接表
	for _, v := range wordList {
		for i, _ := range v {
			adjKey = v[:i] + "*" + v[i+1:]
			list, ok = adj[adjKey]
			if ok {
				list = append(list, v)
				adj[adjKey] = list
			} else {
				adj[adjKey] = append([]string{}, v)
			}
		}
	}
	//	bfs
	var (
		queue   = []pair{{word: beginWord, step: 1}}
		now     pair
		nowWord string
	)
	for len(queue) != 0 {
		now = queue[0]
		queue = queue[1:]

		nowWord = now.word
		for i, _ := range nowWord {
			adjKey = nowWord[:i] + "*" + nowWord[i+1:]
			list, ok = adj[adjKey]
			if ok {
				for _, v := range list {
					if v == endWord {
						return now.step + 1
					}
					if _,isMark:=mark[v];isMark{
						continue
					}
					mark[v] = true
					queue = append(queue, pair{
						word: v,
						step: now.step + 1,
					})
				}
			}
		}

	}
	return 0

}
func main() {
	str := "dfdfsf"
	fmt.Printf("%T", str[2:])

	for k, v := range str {
		fmt.Printf("%T ", v)
		fmt.Println(k, string(v))
	}
}
