// https://www.lintcode.com/problem/word-break/description?_from=ladder&&fromId=1

class Solution {
public:
    /*
     * @param s: A string
     * @param dict: A dictionary of words dict
     * @return: A boolean
     */
    bool wordBreak(string &s, unordered_set<string> &dict) {
        if(s.size() == 0){
            return true;
        }
        bool segments[s.size()];
        int maxLen = INT_MIN;
        
       
        for (auto word : dict) {
           maxLen = max(maxLen,(int)word.size());
        }
    
        
        for (int i = 0; i < s.size(); i++) {
            segments[i] = false;
            
            for (int j = i; j >= 0 && i - j + 1<= maxLen; --j) {
                if(j > 0 && segments[j-1] == false){
                    continue;
                }
                
                string word = s.substr(j,i-j+1);
                if(dict.find(word) != dict.end()){
                    segments[i] = true;
                    break;
                }
            }
        }
        
        return segments[s.size() - 1];
        
    }
};