# [242. Valid Anagram](https://leetcode.com/problems/valid-anagram/)

**Hash Table**

This idea uses a hash table to record the times of appearances of each letter in the two strings `s` and `t`. For each letter in `s`, it increases the counter by `1` while for each letter in `t`, it decreases the counter by `1`. Finally, all the counters will be `0` if they two are anagrams of each other.



The first implementation uses the built-in `unordered_map` and takes 36 ms.



```c++
class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.length() != t.length()) return false;
        int n = s.length();
        unordered_map<char, int> counts;
        for (int i = 0; i < n; i++) {
            counts[s[i]]++;
            counts[t[i]]--;
        }
        for (auto count : counts)
            if (count.second) return false;
        return true;
    }
};
```



Since the problem statement says that "the string contains only lowercase alphabets", we can simply use an array to simulate the `unordered_map` and speed up the code. The following implementation takes 12 ms.



```c++
class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.length() != t.length()) return false;
        int n = s.length();
        int counts[26] = {0};
        for (int i = 0; i < n; i++) { 
            counts[s[i] - 'a']++;
            counts[t[i] - 'a']--;
        }
        for (int i = 0; i < 26; i++)
            if (counts[i]) return false;
        return true;
    }
};
```

------



**Sorting**



For two anagrams, once they are sorted in a fixed order, they will become the same. This code is much shorter (this idea can be done in just 1 line using Python as [here](https://leetcode.com/discuss/49372/python-1-line-solution-88ms)). However, it takes much longer time --- 76 ms in C++.



```c++
class Solution {
public:
    bool isAnagram(string s, string t) { 
        sort(s.begin(), s.end());
        sort(t.begin(), t.end());
        return s == t; 
    }
};
```

https://leetcode.com/problems/valid-anagram/discuss/66519/2-C%2B%2B-Solutions-with-Explanations

