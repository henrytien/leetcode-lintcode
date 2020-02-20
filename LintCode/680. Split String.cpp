// https://www.lintcode.com/problem/split-string/description?_from=ladder&&fromId=1
class Solution {
public:
    /*
     * @param : a string to be split
     * @return: all possible split string array
     */
    vector<vector<string>> splitString(string& s) {
        vector<vector<string>> res;
        
        vector<string> path;
        helper(res,path,s,0);
        return res;
    }
    
    void helper(vector<vector<string>> &result, vector<string> &path, string &s, int index){
        if(index == s.length())
        {
            result.push_back(path);
            return;
        }
        
        for (int i = 1; i <= 2; ++i) {
            if(index + i > s.length()) break;
            path.push_back(s.substr(index,i));
            helper(result,path,s,index+i);
            path.pop_back();
        }
    }
};
