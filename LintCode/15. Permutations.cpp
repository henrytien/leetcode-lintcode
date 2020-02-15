// https://www.lintcode.com/problem/permutations/leaderboard?_from=ladder&&fromId=1
// dfs + visited[i]

class Solution {
public:
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    vector<vector<int>> permute(vector<int> &nums) {
        vector<vector<int>> res;
        vector<int> path;
        if(nums.size() == 0){
            res.push_back(path);
            return res;
        }
        vector<bool> visited(nums.size(),false);
        sort(nums.begin(),nums.end());
        dfs(res,path,nums,visited);
        return res;
        
    }
    
private:
     void dfs(vector<vector<int>> &result, vector<int> &path, vector<int> &nums, vector<bool> visited)
    {
        if(path.size() == nums.size()){
            result.push_back(path);
            return;
        }
        
        
        for (int i = 0; i < nums.size(); i++) {
            if(visited[i]){
                continue;
            }
            path.push_back(nums[i]);
            visited[i] = true;
            dfs(result,path,nums,visited);
            
            path.pop_back();
            visited[i] = false;
        }
    }
};