// https://www.lintcode.com/problem/move-zeroes/description?_from=ladder&&fromId=1
class Solution {
public:
    /**
     * @param nums: an integer array
     * @return: nothing
     */
    void moveZeroes(vector<int> &nums) {
        int j = 0;
        for (int i = 0; i < nums.size(); i++) {
            if(nums[i] != 0){
                nums[j++] = nums[i];
            }
        }
        
        for(;j < nums.size(); ++j){
            nums[j] = 0;
        }
        return;
    }
};