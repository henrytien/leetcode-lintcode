// https://www.lintcode.com/problem/word-pattern-ii/description?_from=ladder&&fromId=1

class Solution {
public:
    /**
     * @param pattern: a string,denote pattern string
     * @param str: a string, denote matching string
     * @return: a boolean
     */
    bool wordPatternMatch(string &pattern, string &str) {
        unordered_map<char,string> hashMap;
        unordered_set<string> hashSet;
        return dfs(pattern,str,hashMap,hashSet);
    }
    
private:

    bool checkPrefix(const string &source, const string &target)
    {
        int srclen = source.size(), tarlen = target.size();
        if(srclen >= tarlen){
            string temp = source.substr(0,tarlen);
            if(temp ==  target){
                return true;
            }
        }
        return false;
    }
    
    bool dfs(string pattern, string s, unordered_map<char,string> map, unordered_set<string> set)
    {
        if(pattern.length() == 0){
            return s.length() == 0;
        }
        
        char c = pattern[0]; // get the current char
        if(map.find(c) != map.end()){
            
            // check weather the remaining string starts with this prefix  
            if(!checkPrefix(s, map[c])){
                return false;
            }
            // check next char and remaining string.
            return dfs(pattern.substr(1),s.substr(map[c].length()),map,set);
        }
        
        // find all possible
        for (int i = 0; i < s.length(); i++) {
            string word = s.substr(0,i+1);
            
            // check weather this prefix has been linked with each other.
            if(set.find(word) != set.end()){
                continue;
            }
            
            // if they are all brandy new,recorde them
            map.insert(make_pair(c,word));
            set.insert(word);
            
            // check next char and remaining string
            if(dfs(pattern.substr(1),s.substr(i + 1),map,set)){
                std::cout << "ss" << std::endl;
                return true;
            }
            
            // backtracking
            set.erase(word);
            map.erase(c);
           
            
        }
        // std::cout << "d" << std::endl;
        return false;
        
    }
    
    
};