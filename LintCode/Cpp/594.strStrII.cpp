// https://www.lintcode.com/problem/strstr-ii/description
#include "ac.h"
class Solution {
public:
   int strStr2(const char* source, const char* target) {
       // write your code here
       
       if(source == NULL || target == NULL){
           return -1;
       }
       int m = strlen(target);
       if(m == 0){
           return 0;
       }
      
       int BASE = 1000000;
       int power = 1;
       for (int i = 0; i < m; i++) {
           power = (power * 31) % BASE;
       }
       
       int targetCode = 0;
       for (int i = 0; i < m; i++) {
           targetCode = (targetCode*31 + target[i]) % BASE;
       }
       
       int hashCode = 0;
       int len = strlen(source);
       for(int i = 0; i < len; i++){
           hashCode = (hashCode * 31 + source[i]) % BASE;
           if(i < m -1){
               continue;
           }
           //   i
           //abcd -a
           if(i >= m){
               hashCode = hashCode - (source[i-m]*power) % BASE;
               if(hashCode < 0){
                   hashCode += BASE;
               }
               if(hashCode == targetCode){
                   string s = source;
                   string t = target;
                   s = s.substr(i - m + 1,m);
                   if(s.compare(t) == 0){
                       return i - m + 1;
                   }
               }
           }
       }
       return -1;
    }
};


int main(){
    Solution s;
    const char* src ="abcdef";
    const char* tar = "bcd";

    cout << s.strStr2(src, tar)<< endl;
}