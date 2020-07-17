//https://www.lintcode.com/problem/find-k-closest-elements/description?_from=ladder&&fromId=1

class Solution {
public:
    /**
     * @param A: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */
    vector<int> kClosestNumbers(vector<int> &A, int target, int k) {
        vector<int> res;
        int index = firstIndex(A,target);
        std::cout << index << std::endl;
        int left = index - 1, right = index;
        for (int i = 0; i < k;i++) {
           if(left < 0)
           {
               res.push_back(A[right++]);
           }
           else if(right >= A.size())
           {
               res.push_back(A[left--]);
           }
           else 
           {
               if(target - A[left] <= A[right] - target )
               {
                   res.push_back(A[left--]);
               }
               else
               {
                //   std::cout << "right: " << right << std::endl;
                   res.push_back(A[right++]);
               }
           }
        }
        return res;
       
    }
    
    private:
    int firstIndex(vector<int> &A,int target)
    {
        // use binary search find first index
        int start = 0, end = A.size() - 1;
        
        while(start + 1 < end )
        {
            int mid = start + (end - start)/2;
           
            if(A[mid] < target)
            {
                start = mid;
            }else
            {
                end = mid;
            }
        }
        if(A[start] >= target)
        {
            return start;
        }
        if(A[end] >= target)
        {
            return end;
        }
        return A.size();
    }
};