// Source : https://leetcode.com/problems/hamming-distance/
// Author : henrytine
// Date   : 2020-08-11

/***************************************************************************************************** 
 *
 * The Hamming distance between two integers is the number of positions at which the corresponding 
 * bits are different.
 * 
 * Given two integers x and y, calculate the Hamming distance.
 * 
 * Note:
 * 0 &le; x, y < 231.
 * 
 * Example:
 * 
 * Input: x = 1, y = 4
 * 
 * Output: 2
 * 
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        &uarr;   &uarr;
 * 
 * The above arrows point to positions where the corresponding bits are different.
 * 
 ******************************************************************************************************/

class Solution {
public:
	int hammingDistance(int x, int y) {
		int cnt = 0, res = x ^ y;
		while (res) {
			++cnt;
			res &= res - 1;
		}
		return cnt;
	}
};