// Source : https://leetcode.com/problems/combination-sum/
// Author : henrytien
// Date   : 2022-02-17

/*****************************************************************************************************
 *
 * Given an array of distinct integers candidates and a target integer target, return a list of all
 * unique combinations of candidates where the chosen numbers sum to target. You may return the
 * combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are
 * unique if the frequency of at least one of the chosen numbers is different.
 *
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150
 * combinations for the given input.
 *
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 *
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 *
 * Example 3:
 *
 * Input: candidates = [2], target = 1
 * Output: []
 *
 * Constraints:
 *
 * 	1 <= candidates.length <= 30
 * 	1 <= candidates[i] <= 200
 * 	All elements of candidates are distinct.
 * 	1 <= target <= 500
 ******************************************************************************************************/

#include "../inc/ac.h"

// Let N be the number of candidates, T be the target value, and M be the minimal value among the candidates.
// Time Complexity: O(N^T/M)
// Space Complexity: O(T/M)
class Solution
{
public:
    vector<vector<int>> combinationSum(vector<int> &candidates, int target)
    {
        vector<vector<int>> res;
        vector<int> cur_res;
        backtrack(candidates,0,target,cur_res,res);
        return res;
    }

private:
    void backtrack(const vector<int> &canditates, int index, int remain,
                   vector<int> &cur_res, vector<vector<int>> &res)
    {
        if (remain == 0)
        {
            res.push_back(cur_res);
            return;
        }else if(remain < 0) {
            // exceed the scope, stop exploration.
            return;
        }

        for (int i = index; i < canditates.size(); i++)
        {
            if (remain >= canditates[i])
            {
                // Add the number into the combination
                cur_res.push_back(canditates[i]);
                backtrack(canditates, i, remain - canditates[i], cur_res, res);
                // backtrack, remove the number from the combination
                cur_res.pop_back();
            }
        }
        return;
    }
};

int main()
{

    vector<int> candidates{2, 3, 6, 7};
    int target = 7;
    vector<vector<int>> res = Solution().combinationSum(candidates, target);
    for (auto &&iter : res)
    {
        print_vec(iter);
    }

    return 0;
}