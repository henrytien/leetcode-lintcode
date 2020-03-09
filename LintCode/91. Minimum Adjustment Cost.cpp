// https://www.lintcode.com/problem/minimum-adjustment-cost/description

class Solution {
public:
    /*
     * @param A: An integer array
     * @param target: An integer
     * @return: An integer
     */
    int MinAdjustmentCost(vector<int> &A, int target) {
      int len = A.size();
      vector<vector<int>> dp(2,vector<int>(101,0));
      
      int ans = INT_MAX;
      
      for (int i = 1; i <= len; i++) {
          for (int j = 0; j < 101; j++) {
              for (int k = 0; k < 101; k++) {
                  if(j == 0){
                      dp[i%2][k] = INT_MAX;
                  }
                  if(abs(j - k) > target){
                      continue;
                  }
                  
                 dp[i%2][k] = min(dp[i%2][k], dp[(i-1)%2][j] + abs(A[i-1] - k));
              }
          }
      }
      
      for (int i = 0; i < 101; i++) {
          ans = min(ans,dp[len%2][i]);
      }
      return ans;
    }
};