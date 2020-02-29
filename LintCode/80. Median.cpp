// https://www.lintcode.com/problem/median/description
class Solution {
public:
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the middle number of the array
     */
    int median(vector<int> &nums) {
        priority_queue<int> pq;
        for (int i = 0; i < nums.size(); i++) {
            pq.push(nums[i]);
        }
        
        for (int i = 0; i < nums.size() / 2; i++) {
            pq.pop();
        }
        return pq.top();
    }
};