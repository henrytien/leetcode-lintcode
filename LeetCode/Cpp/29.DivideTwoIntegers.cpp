#include "ac.h"
//https://leetcode.com/problems/divide-two-integers/discuss/13420/32-times-bit-shift-operation-in-C-with-O(1)-solution
//https://leetcode.com/problems/divide-two-integers/
class Solution {
public:
    int divide(int dividend, int divisor) {
        if(divisor == 0 || dividend == INT_MIN && divisor == -1){
            return INT_MAX;
        }
        
        long a = abs((long)dividend), b = abs((long)divisor), res = 0;
        for (int i = 31; i >= 0; i--) {
            if((a >> i) - b >= 0){
                res += 1 << i;
                a -= b << i;
            }
        }
        
        return (dividend > 0) == (divisor > 0) ? res : -res;
    }
};

int stringToInteger(string &input){
    return stoi(input);
}

int main(){
    string line;
    while (getline(cin, line)) {
        int dividend = stringToInteger(line);
        getline(cin, line);
        int divisor = stringToInteger(line);
        
        int ret = Solution().divide(dividend, divisor);
        
        string out = to_string(ret);
        cout << out << endl;
    }
    return 0;
}


