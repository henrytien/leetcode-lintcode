// Source : https://leetcode.com/problems/lru-cache/
// Author : williamgrt
// Date   : 2020-07-21

/***************************************************************************************************** 
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the 
 * following operations: get and put.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, 
 * otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached 
 * its capacity, it should invalidate the least recently used item before inserting a new item.
 * 
 * The cache is initialized with a positive capacity.
 * 
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * 
 * Example:
 * 
 * LRUCache cache = new LRUCache( 2 /* capacity */ );
**cache.put(1, 1);
*cache.put(2, 2);
*cache.get(1);    // returns 1
*cache.put(3, 3); // evicts key 2
*cache.get(2);    // returns -1 (not found)
*cache.put(4, 4); // evicts key 1
*cache.get(1);    // returns -1 (not found)
*cache.get(3);    // returns 3
*cache.get(4);    // returns 4
******************************************************************************************************* /

    class LRUCache {
public:
  LRUCache(int capacity) { this->capacity = capacity; }

  int get(int key) {
    if (mapping.count(key) == 0) {
      return -1;
    } else {
      int value = mapping[key]->second;
      elements.erase(mapping[key]);
      elements.push_front({key, value});
      mapping[key] = elements.begin();
      return value;
    }
  }

  void put(int key, int value) {
    if (mapping.count(key) != 0) {
      elements.erase(mapping[key]);
    } else {
      if (elements.size() == capacity) {
        int del = elements.back().first;
        elements.pop_back();
        mapping.erase(del);
      }
    }
    elements.push_front({key, value});
    mapping[key] = elements.begin();
  }

private:
  int capacity;
  unordered_map<int, list<pair<int, int>>::iterator> mapping;
  list<pair<int, int>> elements;
};
