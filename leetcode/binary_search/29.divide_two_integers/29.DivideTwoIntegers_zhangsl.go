// Source : https://leetcode.com/problems/divide-two-integers/
// Author : zhangsl
// Date   : 2020-07-27
package main

import "fmt"

/*****************************************************************************************************
 *
 * Given two integers dividend and divisor, divide two integers without using multiplication, division 
 * and mod operator.
 * 
 * Return the quotient after dividing dividend by divisor.
 * 
 * The integer division should truncate toward zero, which means losing its fractional part. For 
 * example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
 * 
 * Example 1:
 * 
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Explanation: 10/3 = truncate(3.33333..) = 3.
 * 
 * Example 2:
 * 
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Explanation: 7/-3 = truncate(-2.33333..) = -2.
 * 
 * Note:
 * 
 * 	Both dividend and divisor will be 32-bit signed integers.
 * 	The divisor will never be 0.
 * 	Assume we are dealing with an environment which could only store integers within the 32-bit 
 * signed integer range: [&minus;231,  231 &minus; 1]. For the purpose of this problem, assume that 
 * your function returns 231 &minus; 1 when the division result overflows.
 ******************************************************************************************************/

// 思路 不断二倍逼近 dividend
// todo complete border check and  Symbolic processing @zhangshilin
func divide(dividend int, divisor int) int {
//	terminate condition
	if divisor>dividend{
		return 0
	}
//
//	cloesd to
	cnt:=1
	divisors:=divisor
	for divisors+divisors<=dividend{
		cnt+=cnt
		divisors+=divisors
	}
	return cnt+divide(dividend-divisors,divisor)
}
//func helper(dividend,divisor int)

func main() {
	fmt.Println(divide(2,-100))
	fmt.Println(divide(12,1))
	fmt.Println(divide(13,1))
	fmt.Println(divide(14,1))
	fmt.Println(divide(15,1))
}