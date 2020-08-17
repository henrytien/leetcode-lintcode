// Source : https://leetcode.com/problems/4sum/solution/
// Author : zhangsl
// Date   : 2020-08-17
package main

import "sort"

/*****************************************************************************************************
 *
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums 
 * such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of 
 * target.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate quadruplets.
 * 
 * Example:
 * 
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * 
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 * 
 ******************************************************************************************************/

// 已经在三数之和中总结出n数之和
// 再写一遍

//time 45 mem 29
func fourSum(nums []int, target int) [][]int {
	if len(nums)<1{
		return nil
	}
	sort.Slice(nums, func(i, j int) bool {
		return nums[i]<nums[j]
	})
	return nSum(nums,target,0,4)
}
func nSum(nums []int,target,start,n int)[][]int{
	if n<2 || n>len(nums){
		return nil
	}
	sz:=len(nums)
	l,r:=start,sz-1
	ans:=[][]int{}
	if n==2{
		for l<r{
			left,right:=nums[l],nums[r]
			sum:=left+right
			if sum==target{
				ans = append(ans, []int{left,right})
				for l<r && nums[l]==left{l++}
				for l<r && nums[r]==right{r--}
			}else if sum<target{
				for l<r && nums[l]==left{l++}
			}else if sum>target{
				for l<r && nums[r]==right{r--}
			}
		}
	}else{
		for i:=start;i<sz;i++{
			sub:=nSum(nums,target-nums[i],i+1,n-1)
			for _,v:=range sub{
				ans = append(ans,append(v,nums[i]))
			}
			for i<sz-1&&nums[i]==nums[i+1]{i++}
		}
	}
	return ans
}