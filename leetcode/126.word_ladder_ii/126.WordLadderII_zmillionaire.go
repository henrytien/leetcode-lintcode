// Source : https://leetcode.com/problems/word-ladder-ii/
// Author : zmillionaire
// Date   : 2020-08-03
package main

import (
	"fmt"
	"math"
)

/*****************************************************************************************************
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest
 * transformation sequence(s) from beginWord to endWord, such that:
 *
 * 	Only one letter can be changed at a time
 * 	Each transformed word must exist in the word list. Note that beginWord is not a transformed
 * word.
 *
 * Note:
 *
 * 	Return an empty list if there is no such transformation sequence.
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
 * Output:
 * [
 *   ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 *
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: []
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 *
 ******************************************************************************************************/
// 思路：
// 还是广度优先，修改退出条件，如果step>当前最小的step 则返回结果
// 返回值：
// 编码
// all case through and timeout
//todo @zhangshilin
func findLadders(beginWord string, endWord string, wordList []string) [][]string {
	ans:=make([][]string,0)
	mark := make(map[string]struct{})
	minPathLen:=math.MaxUint32
	//	构造状态表
	stateTable := make(map[string][]string)
	for _, v := range wordList {
		for i, _ := range v {
			statClass := v[:i] + "*" + v[i+1:]
			if _, ok := stateTable[statClass]; ok {
				stateTable[statClass] = append(stateTable[statClass], v)
			} else {
				stateTable[statClass] = []string{v}
			}
		}
	}
	//队列初始化
	que := make([][]string,0)
	que= append(que,[]string{beginWord})

	for len(que) > 0 {
		now:=que[0]
		que = que[1:]
		last:=now[len(now)-1]
		mark[last] = struct{}{}
		for i,_:=range last{
			newWord:=last[:i]+"*"+last[i+1:]
			for _,v:=range stateTable[newWord]{
				newPath:=make([]string,len(now),len(now)+1)
				copy(newPath,now)
				newPath = append(newPath,v)
				if minPathLen<len(newPath){
					return ans
				}
				if _,ok:=mark[v];ok{
					continue
				}
				if v==endWord{
					ans = append(ans,newPath)
					minPathLen = len(newPath)
				}else{
					que = append(que, newPath)
				}

			}
		}


	}
	return ans

}

func main() {
	//"hit"
	//"cog"

	fmt.Println(findLadders("red","tax",	[]string{"ted","tex","red","tax","tad","den","rex","pee"}))
}