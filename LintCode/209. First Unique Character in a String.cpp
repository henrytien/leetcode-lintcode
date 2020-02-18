// https://www.lintcode.com/problem/first-unique-character-in-a-string/description?_from=ladder&&fromId=1

class Solution {
public:
    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    char firstUniqChar(string &str) {
        if(str.empty()){
            return '0';
        }
        
        unordered_map<char,int> map;
        int size = str.size();
        for (int i = 0; i < size; i++) {
            if(map.find(str[i]) != map.end()){
                
                map[str[i]] = 2;
            }else{
                map[str[i]] = 1;
            }
        }
        
        for (int i = 0; i < size; i++) {
            if(map[str[i]] == 1){
                return str[i];
            }
        }
        return '0';
    }
};