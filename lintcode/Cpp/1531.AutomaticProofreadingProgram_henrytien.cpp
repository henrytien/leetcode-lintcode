// https://www.lintcode.com/problem/automatic-proofreading-program/
class Solution {
public:
    /**
     * @param str: The string before proofreading.
     * @return: Return the string after proofreading.
     */
    string automaticProofreadingProgram(string &str) {
        vector<char> result;
        for (char c: str) {
            result.push_back(c);
            int n = result.size();
            // 规则1
            if (n >= 3) {
                if (result[n - 1] == result[n - 2]
                    && result[n - 1] == result[n - 3]) {
                    result.pop_back();
                }
            }
            n = result.size();
            // 规则2
            if (n >= 4) {
                if (result[n - 1] == result[n - 2]
                    && result[n - 3] == result[n - 4]) {
                    
                    result.pop_back();
                }
            }
        }
        string resultStr = "";
        for (char c: result) {
            resultStr += c;
        }
        return resultStr;
    }
};