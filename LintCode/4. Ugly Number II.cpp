// https://www.lintcode.com/problem/ugly-number-ii/description?_from=ladder&&fromId=1
// priority_queue<long,vector<long>,greater<long>> pq
class Solution {
public:
    /**
     * @param n: An integer
     * @return: return a  integer as description.
     */
    int nthUglyNumber(int n) {
        if(n == 1) return 1;
        
        priority_queue<long,std::vector<long>,greater<long>> pq;
        pq.push(1);
        for (int i = 1; i < n; i++) {
            long tmp = pq.top();
            pq.push(tmp*2);
            pq.push(tmp*3);
            pq.push(tmp*5);
            while(pq.top() == tmp){
                pq.pop();
            }
        }
        return pq.top();
    }
};