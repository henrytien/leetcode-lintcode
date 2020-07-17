// https://www.lintcode.com/problem/sort-letters-by-case/description

// two pointer 

class Solution {
public:

    bool isLower(char c){
        return c >= 'a' && c <= 'z';
    }
    /*
     * @param chars: The letter array you should sort by Case
     * @return: nothing
     */
    void sortLetters(string &chars) {
        int i = 0, j = chars.size() - 1;
        while(i <= j){
            while(i <= j && isLower(chars[i])) i++;
            while(i <=j && !isLower(chars[j])) j--;
            if(i <= j){
                swap(chars[i++],chars[j--]);
            }
        }
    }
};