// Source : https://leetcode.com/problems/fruit-into-baskets/
// Author : henrytine
// Date   : 2020-07-18

/***************************************************************************************************** 
 *
 * In a row of trees, the i-th tree produces fruit with type tree[i].
 * 
 * You start at any tree of your choice, then repeatedly perform the following steps:
 * 
 * 	Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
 * 	Move to the next tree to the right of the current tree.  If there is no tree to the right, 
 * stop.
 * 
 * Note that you do not have any choice after the initial choice of starting tree: you must perform 
 * step 1, then step 2, then back to step 1, then step 2, and so on until you stop.
 * 
 * You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to 
 * only carry one type of fruit each.
 * 
 * What is the total amount of fruit you can collect with this procedure?
 * 
 * Example 1:
 * 
 * Input: [1,2,1]
 * Output: 3
 * Explanation: We can collect [1,2,1].
 * 
 * Example 2:
 * 
 * Input: [0,1,2,2]
 * Output: 3
 * Explanation: We can collect [1,2,2].
 * If we started at the first tree, we would only collect [0, 1].
 * 
 * Example 3:
 * 
 * Input: [1,2,3,2,2]
 * Output: 4
 * Explanation: We can collect [2,3,2,2].
 * If we started at the first tree, we would only collect [1, 2].
 * 
 * Example 4:
 * 
 * Input: [3,3,3,1,2,1,1,2,3,3,4]
 * Output: 5
 * Explanation: We can collect [1,2,1,1,2].
 * If we started at the first tree or the eighth tree, we would only collect 4 fruits.
 * 
 * Note:
 * 
 * 	1 <= tree.length <= 40000
 * 	0 <= tree[i] < tree.length
 * 
 ******************************************************************************************************/
// Find out the longest length of subarrays with the most 2 different numbers
// Inspired by https://leetcode.com/problems/fruit-into-baskets/discuss/170745/Problem%3A-Longest-Subarray-With-2-Elements 
class Solution {
public:
    int totalFruit(vector<int>& tree) {
        int last_fruit = 0, second_last_fruit = 0;
        int last_fruit_cnt = 0, cnt = 0, max_cnt = 0;
        
        for (auto fruit : tree) {
            if (fruit == last_fruit || fruit == second_last_fruit) 
                cnt++;
            else
                cnt = last_fruit_cnt + 1;
            
            if (fruit == last_fruit)
                last_fruit_cnt++;
            else 
                last_fruit_cnt = 1;
                
            if (fruit != last_fruit) {
                second_last_fruit = last_fruit;
                last_fruit = fruit;
            }
                
            max_cnt = max(max_cnt, cnt);
        }
        
        return max_cnt;
        
    }
};