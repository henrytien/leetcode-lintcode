// https://www.lintcode.com/problem/powx-n/description?_from=ladder&&fromId=1

class Solution {
    private:
    double pow(double x,long long n){
        if(n == 0)
            return 1.0;
        double half = pow(x, n/2);
        if(n % 2)
            return half * half * x;
        else
            return half * half;
        
    }
public:
    /**
     * @param x: the base number
     * @param n: the power number
     * @return: the result
     */
    double myPow(double x, int n) {
       return n < 0 ? 1.0/pow(x,n) : pow(x,n);
    }
};