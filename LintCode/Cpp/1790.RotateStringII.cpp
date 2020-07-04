// https://www.lintcode.com/problem/rotate-string-ii/description?_from=ladder&&fromId=1

class Solution {
public:
    /**
     * @param str: A string
     * @param left: a left offset
     * @param right: a right offset
     * @return: return a rotate string
     */
     string RotateString2(string &str, int left, int right) {
           // write your code here
           int offset = left - right;
           int len = str.length();
           int off = abs(left - right) % len;
           string result = "";
           
           if(offset > 0){
               result = str.substr(off,len) + str.substr(0,off);
           }else{
                result = str.substr(len - off,len) + str.substr(0,len - off);
           }
           return result;
       }
};



int main(){
    Solution s;
    string str ="gMJqJGPLOJIEtJJmfpLmkhdDHqiUFfaLRLeEtWplGYRcKBpQSddekiH";
    int left = 9194, right = 2274;
    cout << s.RotateString2(str, left, right) << endl;
    
}