// Source : https://leetcode.com/problems/permutations/
// Author : zmillionaire
// Date   : 2020-07-26
package main

import "fmt"

/*****************************************************************************************************
 *
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 ******************************************************************************************************/
//双100
// 回溯 注意事项：递归调用赋值，如果不是指针，可见行只为当前上下文


func permute(nums []int) [][]int {
	if nums==nil{
		return nil
	}
	mp := make(map[int]bool)
	ans := make([][]int, 0)
	path:=make([]int,len(nums))
	helper(0,nums, mp, &ans,&path)
	return ans
}
func helper(step int,nums []int, mp map[int]bool, ans *[][]int,path *[]int) {
	if step ==len(nums){
		tmp:=make([]int,len(nums))
		copy(tmp,*path)
		*ans = append(*ans, tmp)
		return
	}
	for i:=0;i<len(nums);i++ {
		v:=nums[i]
		if !mp[v] {
			//	标记
			mp[v] = true
			(*path)[step] = v
			helper(step+1,nums,mp,ans,path)
			mp[v] = false
		}

	}
}

func main() {
	arr:=[]int{1,2,3}
	ans:=permute(arr)
	fmt.Println(ans)
}