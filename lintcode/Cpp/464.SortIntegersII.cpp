// https://www.lintcode.com/problem/sort-integers-ii/description?_from=ladder&&fromId=1
class Solution {
public:
    /**
     * @param A: an integer array
     * @return: nothing
     */
    void sortIntegers2(vector<int> &A) {
       quickSort(A,0,A.size()-1);
    }
    
    void quickSort(vector<int> &A, int start, int end)
    {
        if(start >= end)
            return;
        int left = start, right = end;
        int pivot = A[start + (end - start) / 2];
       
        while(left <= right){
            while(left <= right && A[left] < pivot) ++ left;
            while(left <= right && A[right] > pivot) --right;
            if(left <= right) swap(A[left++],A[right--]);
        }
        quickSort(A,start,right);
        quickSort(A,left,end);
    }
};