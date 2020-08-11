// https://www.lintcode.com/problem/regular-expression-matching/description?_from=ladder&&fromId=1

class Solution {
public:
    /**
     * @param s: A string 
     * @param p: A string includes "." and "*"
     * @return: A boolean
     */
    bool isMatch(string &s, string &p) {
        std::vector<vector<bool>> dp(p.size() + 1,std::vector<bool>(s.size()+1,false));
        dp[0][0] = true;
        if(p[1] == '*'){
            dp[2][0] = true;
        }
        
        for (int i = 1; i <= p.size(); i++) {
            for (int j = 1; j <= s.size(); j++) {
                if(p[i-1] == '.'){
                    dp[i][j] = dp[i-1][j-1];
                    continue;
                }
                if(p[i-1] == '*'){
                    dp[i][j] = (i-2 >= 0 && dp[i-2][j]) || //
                    dp[i-1][j] || // pre char used once
                    (dp[i][j-1] && (p[i-2] == s[j-1] || p[i-2] == '.')); // pre char used more than once
                    continue;
                }
                dp[i][j] = dp[i-1][j-1] && s[j-1] == p[i-1];
            }
            
        }
        
        return dp[p.size()][s.size()];
    }
    
    
    
};