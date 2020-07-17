// https://www.lintcode.com/problem/two-sum-iii-data-structure-design/description?_from=ladder&&fromId=1

class TwoSum {
public:
    unordered_map<int,int> myHash;
    /**
     * @param number: An integer
     * @return: nothing
     */
    void add(int number) {
        // write your code here
        myHash[number]++;
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    bool find(int value) {
        // write your code here
        for (unordered_map<int, int>::iterator iter = myHash.begin(); iter != myHash.end(); ++iter) {
            int target = value - iter->first;
            if((target != iter->first && myHash.count(target) > 0) || (target == iter->first && iter->second > 1))
            {
                return true;
            }
        }
        return false;
    }
};