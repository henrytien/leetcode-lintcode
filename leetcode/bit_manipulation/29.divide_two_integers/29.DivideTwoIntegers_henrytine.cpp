// Source : https://leetcode.com/problems/divide-two-integers/
// Author : henrytine
// Date   : 2020-07-25

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
// https://leetcode.com/problems/divide-two-integers/discuss/13407/C%2B%2B-bit-manipulations
class Solution {
public:
    int divide(int dividend, int divisor) {
        if (dividend == INT_MIN && divisor == -1) return INT_MAX;
        
        long dvd = labs(dividend), dvs = labs(divisor), ans = 0;
        int sign = dividend > 0 ^ divisor > 0 ? -1 : 1;
        
        while (dvs <= dvd) {
            int m = 1;
            long temp = dvs;
            while (temp << 1 <= dvd) {
                temp <<= 1;
                m <<= 1;
            }
            dvd -= temp;
            ans += m;
        }
        return sign * ans;
    }
};