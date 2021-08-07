// Source : https://leetcode.com/problems/first-bad-version/
// Author : zhangsl
// Date   : 2020-07-27
package main

import "math"

/*****************************************************************************************************
 *
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the 
 * latest version of your product fails the quality check. Since each version is developed based on 
 * the previous version, all the versions after a bad version are also bad.
 * 
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes 
 * all the following ones to be bad.
 * 
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement 
 * a function to find the first bad version. You should minimize the number of calls to the API.
 * 
 * Example:
 * 
 * Given n = 5, and version = 4 is the first bad version.
 * 
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * 
 * Then 4 is the first bad version. 
 * 
 ******************************************************************************************************/
/**
 * Forward declaration of isBadVersion API.
 * @param   version   your guess about first bad version
 * @return 	 	      true if current version is bad
 *			          false if current version is good
 * func isBadVersion(version int) bool;
 */

func min(a,b int )int{
	if a<=b{
		return a
	}
	return b
}
func isBadVersion(version int) bool{}
// 思路 最小错误节点左侧全部为正确，右侧全部为错误，
//当定位到错误的时候，保留右侧边界，继续向
// 双100
func firstBadVersion(n int) int {
	//ans:=math.MaxInt32
	l,r,mid,tmp:=1,n,0,false
	for l<=r{
		mid = l+(r-l)>>1
		tmp = isBadVersion(mid)
		if tmp{ //继续向左探索
			if mid==1||isBadVersion(mid-1)==false{
				return mid
			}
			r = mid-1
		}else{
			l = mid+1
		}
	}
	return -1
}

func main() {

}
