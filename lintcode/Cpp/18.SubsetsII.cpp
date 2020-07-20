// https://www.lintcode.com/problem/subsets-ii/description?_from=ladder&&fromId=1
class Solution {
public:

    void dfs(vector<vector<int>> &result, vector<int> &path, int index, vector<int> &nums){
       
         result.push_back(path);
        
        for (int i = index; i < nums.size(); i++) {
            if(i > index && nums[i] == nums[i-1]){
                continue;
            }
            path.push_back(nums[i]);
            dfs(result,path,i+1,nums);
            path.pop_back();
        }
    }

    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    vector<vector<int>> subsetsWithDup(vector<int> &nums) {
        vector<vector<int>> res;
        vector<int> path;
        int n = nums.size();
        if(n == 0){
            res.push_back(path);
            return res;
        }
        
        sort(nums.begin(),nums.end());
        dfs(res,path,0,nums);
        return res;
        
    }
};