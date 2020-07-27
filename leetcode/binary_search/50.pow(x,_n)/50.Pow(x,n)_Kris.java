// Source : https://leetcode.com/problems/powx-n/
// Author : Kris
// Date   : 2020-07-27

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

class Solution {
    public double myPow(double x, int n) {
        var result = helper(x, Math.abs(n));
        return n >= 0 ? result : 1 / result;
    }
    
    double helper(double x, int n) {
        if (n == 0) {
            return 1;
        }
        
        if (n == 1) {
            return x;
        }
        
        var half = helper(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}