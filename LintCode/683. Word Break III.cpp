// https://www.lintcode.com/problem/word-break-iii/description?_from=ladder&&fromId=1

// dp
class Solution {
public:
    /*
     * @param : A string
     * @param : A set of word
     * @return: the number of possible sentences.
     */
    int wordBreak3(string& s, unordered_set<string>& dict) {
        if(s.length() == 0  || dict.size() == 0){
            return 0;
        }
        
        std::transform(s.begin(),s.end(),s.begin(),::tolower);
        unordered_set<string> lower_dict;
        for (auto word : dict) {
            std::transform(word.begin(),word.end(),word.begin(),::tolower);
            lower_dict.insert(word);
        }
        
        std::vector<int> dp(s.length()+1,0);
        dp[0] = 0;
        for (int i = 1; i <= s.length(); i++) {
            dp[i] = (lower_dict.count(s.substr(0,i))) ? 1:0;
            for (int j = 0; j < i; j++) {
                string tmp = s.substr(j,i-j);
                if(lower_dict.count(tmp)){
                    dp[i] += dp[j];
                }
            }
        }
        return dp[s.length()];
        
    }
};