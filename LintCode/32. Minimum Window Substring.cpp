// https://www.lintcode.com/problem/minimum-window-substring/description

// two pointer

class Solution {
public:
    /**
     * @param source : A string
     * @param target: A string
     * @return: A string denote the minimum window, return "" if there is no such a string
     */
     
    /* double pointer*/
    string minWindow(string &source , string &target) {
        unordered_map<char, int> hashmap;
        for (char c : target) {
            hashmap[c] ++;
        }
        string res = "";
       int counter = hashmap.size();
       int j = 0;
       int ans = INT_MAX;
       for (int i = 0; i < source.size(); i++) {
           while(counter != 0 && j < source.size())
           {
               hashmap[source[j]]--;
               if(hashmap[source[j]] == 0)
               {
                   counter--;
               }
               j++;
               if(counter == 0)
               {
                   break;
               }
           }
           if(counter == 0 && ans > j - i)
           {
               ans = j - i;
               res =  source.substr(i,ans);
               
           }
           
           if(hashmap[source[i]] == 0)
           {
               counter ++;
           }
           hashmap[source[i]]++;
           
           
       }
       return res;
        
    }
};




 class Solution {
public:
    /**
     * @param source : A string
     * @param target: A string
     * @return: A string denote the minimum window, return "" if there is no such a string
     */
     
    /* double pointer and vector*/
    string minWindow(string &source , string &target) {
        string s = source;
        string t = target;
       vector<int> map(128,0);
        for(auto c: t) map[c]++;
        int counter=t.size(), begin=0, end=0, d=INT_MAX, head=0;
        while(end<s.size()){
            if(map[s[end++]]-->0) counter--; //in t
            while(counter==0){ //valid
                if(end-begin<d)  d=end-(head=begin);
                if(map[s[begin++]]++==0) counter++;  //make it invalid
            }  
        }
        return d==INT_MAX? "":s.substr(head, d);
    }
};