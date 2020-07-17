// https://www.lintcode.com/problem/median-of-two-sorted-arrays/description

class Solution {
public:
    /*
     * @param A: An integer array
     * @param B: An integer array
     * @return: a double whose format is *.5 or *.0
     */
    double findMedianSortedArrays(vector<int> &A, vector<int> &B) {
       int m = A.size();
       int n = B.size();
       if(m > n){
           findMedianSortedArrays(B,A);
       }
       
       int lMax1, rMin1, lMax2, rMin2, c1, c2, lo = 0, hi = 2 * m;
       while(lo <= hi){
           c1 = (lo + hi) / 2;
           c2 = m + n - c1;
           
           lMax1 = (c1 == 0) ? INT_MIN : A[(c1-1)/2];
           rMin1 = (c1 == 2*m) ? INT_MAX : A[c1/2];
           lMax2 = (c2 == 0) ? INT_MIN : B[(c2 - 1)/2];
           rMin2 = (c2 == 2*n) ? INT_MAX : B[c2/2];
           
           if(lMax1 > rMin2)
            hi = c1 - 1;
            else if(rMin1 < lMax2){
                lo = c1 + 1;
            }else{
                break;
            }
       }
       return (max(lMax1,lMax2) + min(rMin1,rMin2)) / 2.0;
    }
};