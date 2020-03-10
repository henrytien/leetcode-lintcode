// https://www.lintcode.com/problem/backpack/description
class Solution {
public:
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    int backPack(int m, vector<int> &A) {
        if(A.size() == 0){
            return 0;
        }
        
        int rec = 0;
        int max = 0;
        
        for (int i = 0; i < A.size(); i++) {
            rec = A[i];
            if(rec <= m){
                for (int j = i+1; j < A.size(); j++) {
                   rec = A[i];
                    while(j < A.size() && A[j] + rec <= m){
                        rec += A[j];
                        j++;
                    }
                    
                    if(rec > max){
                        max = rec;
                    }
                }
            }
        }
        return max;
    }
};