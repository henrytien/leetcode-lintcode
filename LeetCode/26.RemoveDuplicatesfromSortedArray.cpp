#include "ac.h"
//https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
class Solution {
public:
        int removeDuplicates(vector<int>& nums) {
            if(nums.size() <= 1){
                return (int)nums.size();
            }
            int slow = 0;
            for (int i = 1; i < nums.size(); i++) {
                if(nums[slow] != nums[i]){
                    nums[++slow] = nums[i];
                }
                 // equal and compare next value.
            }
            return slow + 1;
        }
};

int stringToInteger(string &input){
    return stoi(input);
}

void trimLeftTrailingSpaces(string &input) {
    input.erase(input.begin(),find_if(input.begin(), input.end(), [](int ch){
        return !isspace(ch);
    }));
}

void trimRightTrailingSpaces(string &input) {
    input.erase(find_if(input.rbegin(), input.rend(), [](int ch){
        return !isspace(ch);
    }).base(),input.end());
}

vector<int> stringToVector(string &input){
    if(input.length() == 0) return {};
    vector<int> output;
    std::stringstream iss( input );
    trimLeftTrailingSpaces(input);
    trimRightTrailingSpaces(input);
    input = input.substr(1,input.length()-2);
    
    stringstream ss;
    ss.str(input);
    string item;
    char delim = ',';
    while (getline(ss, item, delim)) {
        output.push_back(stoi(item));
    }
    return output;
}

string vectorToString(vector<int> &list,int length = -1){
    if(length == -1){
        length = static_cast<int>(list.size());
    }
    if(length == 0){
        return "[]";
    }
    
    string result;
    for (int &item : list) {
        result += to_string(item) + ",";
    }
    
    return "[" + result.substr(0, result.length() - 2) + "]";
}

int main(){
    string line;
    while (getline(cin, line)) {
        
        vector<int> nums = stringToVector(line);
        
        int ret = Solution().removeDuplicates(nums);
        
        string out = vectorToString(nums);
        cout << out << endl;
    }
    return 0;
}


