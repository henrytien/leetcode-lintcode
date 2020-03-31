// https://www.lintcode.com/problem/triangle/description?_from=ladder&&fromId=1
class Solution {
public:
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    int minimumTotal(vector<vector<int>> &triangle) {
        int size = triangle.size();
        if(size == 0){
            return 0;
        }
        if(size == 1){
            return triangle[0][0];
        }
        
        int dp[size][size];
        dp[0][0] = triangle[0][0];
        
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < triangle[i].size(); j++) {
                // up row
                if(j == 0){
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                    continue;
                }
                // center
                if(i == j){
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                    continue;
                }
                
            dp[i][j] =  min(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j];
            }
        }
        // find the last row
        int min = dp[size-1][0];
        for (int i = 1; i < triangle[size-1].size(); i++) {
            if(dp[size-1][i] < min){
                min = dp[size-1][i];
            }
        }
        
        return min;
    }
};