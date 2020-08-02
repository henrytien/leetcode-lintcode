// Source : https://leetcode.com/problems/remove-invalid-parentheses/
// Author : zmillionaire
// Date   : 2020-08-01
package main

import (
	"fmt"
)

/*****************************************************************************************************
 *
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return 
 * all possible results.
 * 
 * Note: The input string may contain letters other than the parentheses ( and ).
 * 
 * Example 1:
 * 
 * Input: "()())()"
 * Output: ["()()()", "(())()"]
 * 
 * Example 2:
 * 
 * Input: "(a)())()"
 * Output: ["(a)()()", "(a())()"]
 * 
 * Example 3:
 * 
 * Input: ")("
 * Output: [""]
 ******************************************************************************************************/

// 思路1。直接暴力，每个括号两个选择，即选择与不选，然后每次选完最后一个字符后判断是否合法，合法的话加入结果集
// 思路2。我们可以在递归的过程中，直接进行判断是否合法，如果不合法直接返回了。当遇到右括号时判断左括号数>=右括号，不成立直接返回
// (()))
// 思路2 time 6.58% mem:16.67%
//todo 优化，将去重提取到外面去，内部转用slice(map的创建开销比slice大)
func removeInvalidParentheses(s string) []string {
	//边界检查
	ans:=make([]string,0)
	pathMax:=new(int)
	mp:=make(map[string]struct{})
	helper(0,0,0,pathMax,s,"",&mp)
	for k,_:=range mp{
		ans = append(ans, k)
	}
	return ans
}
func helper(lCount,rCount ,pos int,pathMax *int,s string,path string,ans *map[string]struct{}){
	if pos==len(s){
		if lCount==rCount{
			switch  {
			case len(path)>*pathMax:
				*pathMax = len(path)
				*ans = make(map[string]struct{},0)
				(*ans)[path] = struct{}{}
			case len(path)==*pathMax:
				if _,ok:=(*ans)[path];!ok{
					(*ans)[path] = struct{}{}
				}
			}
		}
		return
	}


	//选择
	switch s[pos] {
	case '(':
		//不选择
		helper(lCount,rCount,pos+1,pathMax,s,path,ans)
		lCount++
		if rCount>lCount{
			return
		}
		path = path+string(s[pos])
		helper(lCount,rCount,pos+1,pathMax,s,path,ans)
	case ')':
		helper(lCount,rCount,pos+1,pathMax,s,path,ans)
		rCount++
		if rCount>lCount{
			return
		}
		path = path+string(s[pos])
		helper(lCount,rCount,pos+1,pathMax,s,path,ans)
	default:
		path = path+string(s[pos])
		helper(lCount,rCount,pos+1,pathMax,s,path,ans)
	}

}
func main() {
	for k,v:=range removeInvalidParentheses("()())()"){
		fmt.Println(k,v)
	}

}