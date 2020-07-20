// https://www.lintcode.com/problem/combination-sum-ii/description?_from=ladder&&fromId=1
dfs
class Solution {
public:
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    vector<vector<int>> combinationSum2(vector<int> &num, int target) {
        sort(num.begin(),num.end()); 
        vector<vector<int>> result;
        vector<int> path;
        dfs(result,path,num,0,target);
        return result;
    }
    
private:
    void dfs(vector<vector<int>> &result, vector<int> &path, vector<int> &num, 
    int index, int target){
        if(target < 0){
            return;
        }
        
        if(target == 0){
            result.push_back(path);
            return;
        }
        
        for (int i = index; i < num.size(); i++) {
            if(i > index && num[i] == num[i-1]){
                continue;
            }
            
            path.push_back(num[i]);
            dfs(result,path,num,i + 1,target-num[i]);
            path.pop_back();
        }
    }
};