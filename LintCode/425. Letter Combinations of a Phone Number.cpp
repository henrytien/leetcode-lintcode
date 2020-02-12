// https://www.lintcode.com/problem/letter-combinations-of-a-phone-number/description?_from=ladder&&fromId=1
class Solution {
public:
    const vector<string> keyboard{"","","abc","def","ghi","jkl","mno",
        "pqrs","tuv","wxyz"};
        
    void dfs(const string &digits, size_t cur, string path, vector<string> &result)
    {
        if(cur == digits.size())
        {
            result.push_back(path);
            return;
        }
    
        for (auto c : keyboard[digits[cur] - '0']) {
            dfs(digits,cur+1,path+c,result);
        }
    }
        
    /**
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
    vector<string> letterCombinations(string &digits) {
        vector<string> result;
        if(digits.size() == 0){
            return result;
        }
        string path ="";
        dfs(digits,0,path,result);
       return result;
       
    }
};