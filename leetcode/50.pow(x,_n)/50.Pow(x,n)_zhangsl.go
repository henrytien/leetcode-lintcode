// Source : https://leetcode.com/problems/powx-n/
// Author : zhangsl
// Date   : 2020-07-27
package main

import (
	"fmt"
	"math"
)

/*****************************************************************************************************
 *
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 *
 * Example 1:
 *
 * Input: 2.00000, 10
 * Output: 1024.00000
 *
 * Example 2:
 *
 * Input: 2.10000, 3
 * Output: 9.26100
 *
 * Example 3:
 *
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 *
 * Note:
 *
 * 	-100.0 < x < 100.0
 * 	n is a 32-bit signed integer, within the range [&minus;231, 231 &minus; 1]
 *
 ******************************************************************************************************/

func helper(x float64,n int) float64 {
	//	边界
	if n == 0 {
		return 1.0
	}
	y := helper(x, n/2)
	if n&1 == 1 {
		return y * y * x
	} else {
		return y * y
	}
}
// 思路
// 经典二分思想，双100
//在主函数中判断是不是分数，否则会丢失很多精度
// todo need to add iteration version
func myPow(x float64, n int) float64 {
	if n >= 0 {
		return helper(x, n)
	} else {
		return 1 / helper(x, n)
	}

}
func main() {
	fmt.Println(myPow(2, 3))
	fmt.Println(myPow(2, 5))
	fmt.Println(myPow(2, -1))
	fmt.Println(myPow(100, -1))
	fmt.Println(myPow(-99.999999, math.MaxInt32))
	fmt.Println(myPow(-99.999999, math.MinInt32))
}
