// https://www.lintcode.com/problem/longest-common-substring/description
// brute force
class Solution {
public:
    /**
     * @param A: A string
     * @param B: A string
     * @return: the length of the longest common substring.
     */
    int longestCommonSubstring(string &A, string &B) {
        int lena = A.size();
        int lenb = B.size();
        
    
        int maxlen = 0;
        for (int i = 0; i < lena; i++) {
            for (int j = 0; j < lenb; j++) {
                int len = 0;
                while(i + len < lena && j + len < lenb &&
                A[i+len] == B[j+len]){
                    len++;
                }
                
                if(len > maxlen){
                    maxlen = len;
                }
            }
        }
        return maxlen;
    }
};