// https://www.lintcode.com/problem/longest-common-subsequence/description
//dp
class Solution {
public:
    /**
     * @param A: A string
     * @param B: A string
     * @return: The length of longest common subsequence of A and B
     */
    int longestCommonSubsequence(string &A, string &B) {
        int lena = A.length();
        int lenb = B.length();
        
        std::vector<vector<int>> dp(lena+1,vector<int>(lenb+1,0));
        
        for (int i = 1; i <= lena; i++) {
            for (int j = 1; j <= lenb; j++) {
                if(A[i-1]==B[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[lena][lenb];
    }
};