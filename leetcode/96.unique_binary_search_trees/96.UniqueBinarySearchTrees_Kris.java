// Source : https://leetcode.com/problems/unique-binary-search-trees/
// Author : Kris
// Date   : 2020-09-25

/***************************************************************************************************** 
 *
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 * 
 * Example:
 * 
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 * 
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * 
 * Constraints:
 * 
 * 	1 <= n <= 19
 ******************************************************************************************************/

class Solution {
// n 可以拆分成求解sum: {n 为 root (都在左边)} + {n - 1 为 root (只有 n 在右边)} + ... + {1 为 root (都在右边)}
// 以 j 为 root 的场景，左边有 j 个元素，右边有 n - j - 1 个元素，count = f(j) * f(n - j - 1)

// f[1] = 1, f[2] = 2, f[3] = 5

// f(0)	-	1
// f(1)	-	1
// f(2)	-	2		= f(1) * f(0) + f(0) * f(1)
// f(3)	-	5		= f(2) * f(0) + f(1) * f(1) + f(0) * f(2)
// f(4)	-	14		= f(3) * f(0) + f(2) * f(1) + f(1) * f(2) + f(0) * f(3)
// f(5)	-	42		= f(4) * f(0) + f(3) * f(1) + f(1) * f(3) + f(0) * f(4)

//   5		   4				3					2				1					0
// f[i] = f[i - 1] * f[0] + f[i - 2] * f[1] + f[i - 3] * f[2] + f[i - 4] * f[3] + f[i - 5] * f[4]
// 				5 - 4 - 1		  5 - 3 - 1			5 - 2 - 1		  5 - 1 - 1			5 - 0 - 1

// ==> f[i] = SUM {f[j] * f[i - j - 1]} | 0 <= j < i, i >= 2
// 	f[0] = f[1] = 1
    
    public int numTrees(int n) {
        if (n < 1) {
            return 0;
        }
        
        var dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for (var i = 2; i <= n; i++) {
            for (var j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        
        return dp[n];
    }
}