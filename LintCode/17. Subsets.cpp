// https://www.lintcode.com/problem/subsets/description?_from=ladder&&fromId=1
//dfs
class Solution {
public:
    void dfs(vector<vector<int>> &result, vector<int> &nums, int index, vector<int> &path){
        result.push_back(path);
        
        for (int i = index; i < nums.size(); i++) {
            path.push_back(nums[i]);
            dfs(result,nums,i+1,path);
            path.pop_back();
        }
    }


    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    vector<vector<int>> subsets(vector<int> &nums) {
        vector<vector<int>> res;
         vector<int> path;
    
        sort(nums.begin(),nums.end());
        dfs(res,nums,0,path);
        return res;
    }
};