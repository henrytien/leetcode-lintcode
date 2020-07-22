class Solution {
public:
    int findPeakElement(vector<int>& A) {
        int l = 0, r = A.size()-1, end = A.size()-1, m;
        while(l <= r){
            m = l + (r - l)/2;
            if(m<end && A[m]<A[m+1]){
                l = m+1;
            }else if(m>0 && A[m]<A[m-1]){
                r = m-1;
            }else{
                break;
            }
        }
        return m;
    }
};
