// https://www.lintcode.com/problem/combination-sum/description?_from=ladder&&fromId=1

class Solution {
public:

    void dfs(vector<int> &candidates, vector<vector<int>> &result, int index, int target, vector<int> path){
        if(target < 0){
            return;
        }
        
        if(target == 0){
            result.push_back(path);
            return;
        }
        for (int i = index; i < candidates.size(); i++) {
            if(i > index && candidates[i] == candidates[i-1]){
                continue;
            }
            path.push_back(candidates[i]);
            dfs(candidates,result,i,target - candidates[i],path);
            path.pop_back();
        }
        
    }

    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    vector<vector<int>> combinationSum(vector<int> &candidates, int target) {
        vector<vector<int>> res;
       if(candidates.size() == 0){
           return res;
       }
       sort(candidates.begin(),candidates.end());
       vector<int> path;
       dfs(candidates,res,0,target,path);
       return res;
       
       
    }
    
    
    
};