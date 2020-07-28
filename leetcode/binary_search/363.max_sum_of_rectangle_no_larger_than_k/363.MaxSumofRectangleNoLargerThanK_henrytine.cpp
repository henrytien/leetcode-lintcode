// Source : https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/
// Author : henrytine
// Date   : 2020-07-28

/***************************************************************************************************** 
 *
 * Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the matrix 
 * such that its sum is no larger than k.
 * 
 * Example:
 * 
 * Input: matrix = [[1,0,1],[0,-2,3]], k = 2
 * Output: 2 
 * Explanation: Because the sum of rectangle [[0, 1], [-2, 3]] is 2,
 *              and 2 is the max number no larger than k (k = 2).
 * 
 * Note:
 * 
 * 	The rectangle inside the matrix must have an area > 0.
 * 	What if the number of rows is much larger than the number of columns?
 ******************************************************************************************************/

class Solution {
public:
    int maxSumSubmatrix(vector<vector<int>>& matrix, int k) {
        int m = matrix.size(), n = matrix[0].size();
        
        if (m == 0) return 0;
        
        int res = INT_MIN;
        
        for (int i = 0; i < n; i++) {
            vector<int> sums(m, 0);
            for (int j = i; j < n; j++) {
                for (int k = 0; k < m; ++k) {
                   sums[k] += matrix[k][j]; 
                }
                
                set<int> accuSet;
                accuSet.insert(0);
                int curSum = 0, curMax = INT_MIN;

                for (auto sum : sums) {
                    curSum += sum;
                    set<int>::iterator it = accuSet.lower_bound(curSum - k);
                    if (it != accuSet.end()) {
                        curMax = std::max(curMax, curSum - *it);
                    }
                    accuSet.insert(curSum);
                }
                
                res = std::max(res, curMax);
            }
        }
          
       return res;  
    }
};