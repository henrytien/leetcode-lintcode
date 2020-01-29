//https://www.lintcode.com/problem/find-peak-element/description?_from=ladder&&fromId=1

class Solution {
public:
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    int findPeak(vector<int> &A) {
        int l = 1, r = A.size();
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(A[mid] > A[mid+1] && A[mid] > A[mid-1])
            {
                return mid;
            }
            if(A[mid] > A[mid-1])
            {
                l = mid + 1;
            }
            else 
            {
                r = mid -1;
            }
        }
        return -1;
    }
};