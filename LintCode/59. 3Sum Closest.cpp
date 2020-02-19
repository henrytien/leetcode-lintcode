// https://www.lintcode.com/problem/3sum-closest/description

class Solution {
public:
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target: An integer
     * @return: return the sum of the three integers, the sum closest target.
     */
    int threeSumClosest(vector<int> &numbers, int target) {
        int size = numbers.size();
        if(size < 3){
            return 0;
        }
        
        sort(numbers.begin(),numbers.end());
        int result = numbers[0] + numbers[1] + numbers[2];
        
        for (int i = 0; i < size; i++) {
            int start = i + 1, end = size - 1;
            while(start < end){
                if(abs(result-target) > abs(numbers[i] + numbers[start] + numbers[end] - target)){
                    result = numbers[i] + numbers[start] + numbers[end];
                }else if(numbers[i] + numbers[start] + numbers[end] < target){
                    start++;
                }else{
                    end--;
                }
            }
        }
        return result;
    }
};