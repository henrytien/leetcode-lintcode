// Source : https://leetcode.com/problems/unique-binary-search-trees/
// Author : zmillionaire
// Date   : 2020-09-03
package main
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

// 思路：
// 求n个节点的二叉搜索树的个数，令f(i)表示节点数为i时，有f(i)种二叉搜索树，令t(i)表示，当根节点为i时候，有t(i)种二叉搜索树
// f(n) = t(1)+t(2)...+t(n)
// t(i) = f(i-1)*f(n-i)
// f(n) = f(0)*f(n-1)+f(1)*f(n-2)...+f(n-1)*f(0) =>科特兰数

// 动态规划三要素：，
// dp[i]含义：        dp[i] 代表当有i个节点时，有dp[i]种二叉搜索树;dp[i] = f(1)+f(2)...+f(n);f(i) 表示当i为根节点时,有多少种二叉搜索树.
// 					  f(i) = dp[i-1]*dp(n-i);n为一共有多少节点.(此处利用了二叉搜索树的性质,即左子树的所有节点都小于根节点,右子树的所
//					  有节点都大于根节点,所以左子树有i-1个节点,右子树有n-i个节点)
// 状态转移方程：      dp[i] = dp[0]*dp[i-1]...+dp[i-1]*dp[0]   当前状态是由前n-1个状态确定
// 初始条件：         当dp[0]=1(其实dp[0]是不存在的,但是需要适应一边没有节点,另一边有节点的情况),dp[1]=1,dp[2]=2

// 复杂度
//time:O(N^2); 1+2+3...+n = n*(n-1)/2
//mem: O(n); n+1个数组空间存储状态信息.

// 代码排行
//time:100,
//mem:46
func numTrees(n int) int {
	if n<1{
		return 0
	}
	dp:=make([]int,n+1)
	dp[0] = 1;dp[1] = 1;
	for i:=2;i<=n;i++{
		for j:=1;j<=i;j++{
			dp[i]+=dp[j-1]*dp[i-j]
		}
	}
	return dp[n]

}
func main() {

}