// https://www.lintcode.com/problem/k-sum-ii/description

class Solution {
public:
    /*
     * @param A: an integer array
     * @param k: a postive integer <= length(A)
     * @param target: an integer
     * @return: A list of lists of integer
     */
    vector<vector<int>> kSumII(vector<int> &A, int k, int target) {

        vector<vector<int>> res;
        if(A.size() == 0){
            return res;
        }
        vector<int> path;
        dfs(A, path, res, 0, target, k);
        return res;
    }
private:
    void dfs(vector<int> &A, vector<int> &path, vector<vector<int>> &res,
            int index, int target, int k){
        if(k == 0 && target == 0){
            res.push_back(path);
            return;
        }
        
        for (int i = index; i < A.size(); i++) {
            if(A[i] > target){
                break;
            }
            path.push_back(A[i]);
           
            dfs(A,path,res,i+1,target - A[i],k-1);
            path.pop_back();
        }
    }
};