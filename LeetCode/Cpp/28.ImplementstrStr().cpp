// https://leetcode.com/problems/implement-strstr/
// Brute force 
class Solution {
public:
    int strStr(string haystack, string needle) {
        
        int lens = haystack.size(), lent = needle.size();
        if(lent == 0 ) return 0;
        for(int i = 0; i <= lens - lent; ++i){
            for(int j = 0; j < lent;++j){
                if(haystack[i+j] != needle[j]){
                    break;
                }
                if(lent - 1 == j){
                    return i;
                }
            }
        }
        return -1;
    }
};

